<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>
    <!--列表-->
    <el-table
      :data="countrys"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="国家编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="name" label="国家英文名" width="200" sortable></el-table-column>
      <el-table-column prop="nameZh" label="国家中文名" width="200" sortable></el-table-column>
      <el-table-column
        prop="continentId"
        label="大洲名称"
        width="120"
        :formatter="formatContinent"
        sortable
      ></el-table-column>
      <el-table-column prop="detail" label="国家简介" width="160" sortable></el-table-column>

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
        <el-form-item label="国家编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="国家英文名" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="国家中文名" prop="nameZh">
          <el-input v-model="editForm.nameZh"></el-input>
        </el-form-item>
        <el-form-item label="大洲" prop="continentId">
          <el-select v-model="editForm.continentId" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="国家简介" prop="detail">
          <el-input type="textarea" v-model="editForm.detail"></el-input>
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
        <el-form-item label="国家英文名" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="国家中文名" prop="nameZh">
          <el-input v-model="addForm.nameZh"></el-input>
        </el-form-item>
        <el-form-item label="大洲" prop="continentId">
          <el-select v-model="addForm.continentId" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="国家简介" prop="detail">
          <el-input type="textarea" v-model="addForm.detail"></el-input>
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
      options: [{
        value: 1,
        label: '美洲'
      }, {
        value: 2,
        label: '欧洲'
      }, {
        value: 3,
        label: '大洋洲'
      }, {
        value: 4,
        label: '亚洲'
      }],

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
          { required: true, message: '请输入国家英文名', trigger: 'blur' }
        ],
        nameZh: [
          { required: true, message: '请输入国家中文名', trigger: 'blur' }
        ]
      },
      //编辑界面数据
      editForm: {
        id: 0,
        name: '',
        nameZh: '',
        continentId: 0,
        detail: ''
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {
        name: [
          { required: true, message: '请输入国家英文名', trigger: 'blur' }
        ],
        nameZh: [
          { required: true, message: '请输入国家中文名', trigger: 'blur' }
        ]
      },
      //新增界面数据
      addForm: {
        id: 0,
        name: '',
        nameZh: '',
        continentId: 0,
        detail: ''
      }

    }
  },
  methods: {
    translateContinent: function (data) {
      for (var index = 0; index < this.options.length; index++) {
        if (data == this.options[index].value) return this.options[index].label;
      }
      return data;
    },
    //性别显示转换
    formatContinent: function (row, column) {
      return this.translateContinent(row.continentId);
    },

    getTransferObject (object) {
      return util.fillPath(object, 'country');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getCountrys();
    },

    //获取用户列表
    getCountrys () {
      util.getRightTableData(this, { dataSetName: 'countrys' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getCountrys();
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
        nameZh: '',
        continentId: 0,
        detail: ''
      };
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
        para['continentName'] = page.translateContinent(para.continentId);
      }, function () {
        page.getCountrys();
      });

    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
        para['continentName'] = page.translateContinent(para.continentId);
      }, function () {
        page.getCountrys();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getCountrys();
  }
}

</script>

<style scoped>
</style>