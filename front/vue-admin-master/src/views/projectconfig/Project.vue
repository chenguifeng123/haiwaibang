<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.name" placeholder="国家"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getProjects">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <!--列表-->
    <el-table
      :data="projects"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="项目编号" v-if="false" width="120" sortable></el-table-column>
      <el-table-column prop="name" label="项目英文名" width="160" sortable></el-table-column>
      <el-table-column prop="nameZh" label="项目中文名" width="160" sortable></el-table-column>
      <el-table-column prop="detail" label="项目简介" width="160" sortable></el-table-column>
      <el-table-column prop="countryId" label="国家" width="120" :formatter="country" sortable></el-table-column>
      <el-table-column prop="type" label="项目类型" width="120" :formatter="type" sortable></el-table-column>
      <el-table-column label="操作" width="150">
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
        <el-form-item label="项目编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="项目英文名" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="项目中文名" prop="nameZh">
          <el-input v-model="editForm.nameZh"></el-input>
        </el-form-item>
        <el-form-item label="项目简介" prop="detail">
          <el-input type="textarea" v-model="editForm.detail"></el-input>
        </el-form-item>
        <el-form-item label="国家" prop="countryId">
          <el-select v-model="editForm.countryId" placeholder="请选择">
            <el-option
              v-for="item in countrys"
              :key="item.id"
              :label="item.nameZh"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目类型" prop="type">
          <el-select v-model="editForm.type" placeholder="请选择">
            <el-option
              v-for="item in options"
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
        <el-form-item label="项目英文名" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="项目中文名" prop="nameZh">
          <el-input v-model="addForm.nameZh"></el-input>
        </el-form-item>
        <el-form-item label="项目简介" prop="detail">
          <el-input type="textarea" v-model="addForm.detail"></el-input>
        </el-form-item>
        <el-form-item label="国家" prop="countryId">
          <el-select v-model="addForm.countryId" placeholder="请选择">
            <el-option
              v-for="item in countrys"
              :key="item.id"
              :label="item.nameZh"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目类型" prop="type">
          <el-select v-model="addForm.type" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
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
import { getTableList } from '../../api/api';

export default {
  data () {
    return {
      options: [{
        value: 1,
        label: '优才移民'
      }, {
        value: 2,
        label: '投资移民'
      }],

      filters: {
        name: ''
      },

      projects: [],
      countrys: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,
      editFormRules: {
        name: [
          { required: true, message: '请输入项目名', trigger: 'blur' }
        ],
        detail: [
          { required: true, message: '请输入项目描述', trigger: 'blur' }
        ]
      },
      //编辑界面数据
      editForm: {
        id: 0,
        name: '',
        detail: '',
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {
        name: [
          { required: true, message: '请输入项目名', trigger: 'blur' }
        ],
        detail: [
          { required: true, message: '请输入项目描述', trigger: 'blur' }
        ]
      },
      //新增界面数据
      addForm: {
        id: 0,
        name: '',
        detail: '',
      }

    }
  },
  methods: {
    //性别显示转换
    country: function (row, column) {
      for (var index = 0; index < this.countrys.length; index++) {
        if (row.countryId == this.countrys[index].id) return this.countrys[index].nameZh;
      }
      return row.countryId;
    },

    translateType: function (data) {
      for (var index = 0; index < this.options.length; index++) {
        if (data == this.options[index].value) return this.options[index].label;
      }
      return data;
    },

    type: function (row, column) {
      return this.translateType(row.type);
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getProjects();
    },

    getTransferObject (object) {
      return util.fillPath(object, 'project');
    },

    getCountrys () {
      getTableList({ path: 'country' }).then((res) => {
        this.countrys = res.data.data;
      });
    },

    //获取项目列表
    getProjects () {
      util.getRightTableData(this, {
        searchName: 'name',
        dataSetName: 'projects'
      });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getProjects();
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
        detail: '',
      };
    },
    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
        para['typeName'] = page.translateType(para.type);
      }, function () {
        page.getProjects();
      });
    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
        para['typeName'] = page.translateType(para.type);
      }, function () {
        page.getProjects();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    },

  },
  mounted () {
    this.getCountrys();
    this.getProjects();
  }
}

</script>

<style scoped>
</style>