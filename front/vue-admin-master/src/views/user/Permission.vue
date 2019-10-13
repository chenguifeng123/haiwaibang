<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>
    <!--列表-->
    <el-table
      :data="permissions"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="权限编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="name" label="权限编码" width="200" sortable></el-table-column>
      <el-table-column prop="description" label="权限描述" width="200" sortable></el-table-column>
      <el-table-column prop="url" label="权限路径" width="160" sortable></el-table-column>

      <el-table-column label="操作" min-width="200">
        <template scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-pagination
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="total"
        style="float:right;"
      ></el-pagination>
    </el-col>
    <!--编辑界面-->
    <el-dialog title="编辑" v-model="editFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="120px" :rules="editFormRules" ref="editForm">
        <el-form-item label="权限编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="权限编码" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="权限描述" prop="description">
          <el-input v-model="editForm.description"></el-input>
        </el-form-item>
        <el-form-item label="权限路径" prop="url">
          <el-input v-model="editForm.url"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
      </div>
    </el-dialog>
    <!--新增界面-->
    <el-dialog title="新增" v-model="addFormVisible" :close-on-click-modal="false">
      <el-form :model="addForm" label-width="120px" :rules="addFormRules" ref="addForm">
        <el-form-item label="权限编码" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="权限描述" prop="description">
          <el-input v-model="addForm.description"></el-input>
        </el-form-item>
        <el-form-item label="权限路径" prop="url">
          <el-input v-model="addForm.url"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" :loading="addLoading">提交</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import util from '../../common/js/util'

export default {
  data () {
    return {

      permissions: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,
      editFormRules: {
        name: [
          { required: true, message: '请输入权限编码', trigger: 'blur' }
        ],
        url: [
          { required: true, message: '请输入权限路径', trigger: 'blur' }
        ]
      },
      //编辑界面数据
      editForm: {
        id: 0,
        name: '',
        description: '',
        url: ''
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {
        name: [
          { required: true, message: '请输入权限编码', trigger: 'blur' }
        ],
        url: [
          { required: true, message: '请输入权限路径', trigger: 'blur' }
        ]
      },
      //新增界面数据
      addForm: {
        id: 0,
        name: '',
        description: '',
        url: ''
      }

    }
  },
  methods: {

    getTransferObject (object) {
      return util.fillPath(object, 'sys_permission');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getpermissions();
    },

    //获取用户列表
    getPermissions () {
      util.getRightTableData(this, { dataSetName: 'permissions' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getPermissions();
      });
    },

    //显示编辑界面
    handleEdit: function (index, row) {
      this.editFormVisible = true;
      this.editForm = Object.assign({}, row);
    },

    //显示新增界面
    handleAdd: function () {
      this.addFormVisible = true;
      this.addForm = {
        id: 0,
        name: '',
        description: '',
        url: ''
      };
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
      }, function () {
        page.getPermissions();
      });

    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
      }, function () {
        page.getPermissions();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getPermissions();
  }
}

</script>

<style scoped>
</style>