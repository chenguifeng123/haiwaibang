<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>
    <!--列表-->
    <el-table
      :data="roles"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="角色编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="name" label="角色编码" width="200" sortable></el-table-column>
      <el-table-column prop="name_zh" label="角色名称" width="200" sortable></el-table-column>

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
        <el-form-item label="角色编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="角色编码" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="角色名称" prop="name_zh">
          <el-input v-model="editForm.name_zh"></el-input>
        </el-form-item>
        <el-form-item label="权限列表" prop="permission">
          <el-select v-model="editForm.permissions" multiple placeholder="请选择">
            <el-option
              v-for="item in permissions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
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
        <el-form-item label="角色编码" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="角色名称" prop="name_zh">
          <el-input v-model="addForm.name_zh"></el-input>
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
import { addTable, getTableList, getTable, getUrlPath, getStaticReourcePath } from '../../api/api';

export default {
  data () {
    return {

      roles: [],
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
          { required: true, message: '请输入角色编码', trigger: 'blur' }
        ]
      },
      //编辑界面数据
      editForm: {
        id: 0,
        name: '',
        name_zh: '',
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {
        name: [
          { required: true, message: '请输入角色编码', trigger: 'blur' }
        ]
      },
      //新增界面数据
      addForm: {
        id: 0,
        name: '',
        name_zh: '',
      }

    }
  },
  methods: {

    getTransferObject (object) {
      return util.fillPath(object, 'sys_role');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getRoles();
    },

    //获取用户列表
    getRoles () {
      util.getRightTableData(this, { dataSetName: 'roles' });
    },

    getPermissions () {
      getTableList({ path: 'sys_permission' }).then((res) => {
        this.permissions = res.data.data;
      });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getRoles();
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
        name_zh: '',
      };
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
      }, function () {
        page.getRoles();
      });

    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
      }, function () {
        page.getRoles();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getPermissions();
    this.getRoles();
  }
}

</script>

<style scoped>
</style>