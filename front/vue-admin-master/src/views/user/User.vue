<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>
    <!--列表-->
    <el-table
      :data="users"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="用户编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="username" label="登陆用户名" width="200" sortable></el-table-column>
      <el-table-column prop="password" label="登陆密码" width="200" sortable></el-table-column>
      <el-table-column prop="name_zh" label="用户名" width="160" sortable></el-table-column>
      <el-table-column prop="phone" label="电话" width="160" sortable></el-table-column>
      <el-table-column prop="company" label="公司" width="160" sortable></el-table-column>
      <el-table-column prop="address" label="地址" width="160" sortable></el-table-column>

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
        <el-form-item label="用户编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="登陆用户名" prop="username">
          <el-input v-model="editForm.username"></el-input>
        </el-form-item>
        <el-form-item label="登陆密码" prop="password">
          <el-input v-model="editForm.password"></el-input>
        </el-form-item>
        <el-form-item label="用户名" prop="name_zh">
          <el-input v-model="editForm.name_zh"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="editForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="公司" prop="company">
          <el-input v-model="editForm.company"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="editForm.address"></el-input>
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
        <el-form-item label="登陆用户名" prop="username">
          <el-input v-model="addForm.username"></el-input>
        </el-form-item>
        <el-form-item label="登陆密码" prop="password">
          <el-input v-model="addForm.password"></el-input>
        </el-form-item>
        <el-form-item label="用户名" prop="name_zh">
          <el-input v-model="addForm.name_zh"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="addForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="公司" prop="company">
          <el-input v-model="addForm.company"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="addForm.address"></el-input>
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

      users: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,
      editFormRules: {
        username: [
          { required: true, message: '请输入登陆用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入登陆密码', trigger: 'blur' }
        ]
      },
      //编辑界面数据
      editForm: {
        id: 0,
        username: '',
        password: '',
        name_zh: '',
        phone: '',
        company: '',
        address: '',
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {
        username: [
          { required: true, message: '请输入登陆用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入登陆密码', trigger: 'blur' }
        ]
      },
      //新增界面数据
      addForm: {
        id: 0,
        username: '',
        password: '',
        name_zh: '',
        phone: '',
        company: '',
        address: '',
      }

    }
  },
  methods: {

    getTransferObject (object) {
      return util.fillPath(object, 'sys_user');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getUsers();
    },

    //获取用户列表
    getUsers () {
      util.getRightTableData(this, { dataSetName: 'users' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getUsers();
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
        page.getUsers();
      });

    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
      }, function () {
        page.getUsers();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getUsers();
  }
}

</script>

<style scoped>
</style>