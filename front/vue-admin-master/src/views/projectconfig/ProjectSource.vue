<template>
  <section>
    <el-col :span="6" class="left-tree">
      <el-tree :data="countrys" :props="countryProps" @node-click="handleNodeClick"></el-tree>
    </el-col>
    <el-col :span="18" class="right-pannel" v-if="tableShow">
      <!--工具条-->
      <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
        <el-form :inline="true">
          <el-form-item>
            <el-button type="primary" @click="handleAdd">新增</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <!--列表-->
      <el-table
        :data="sources"
        highlight-current-row
        v-loading="listLoading"
        @selection-change="selsChange"
        style="width: 100%;"
      >
        <el-table-column prop="id" label="资源编号" v-if="false" width="150" sortable></el-table-column>
        <el-table-column prop="name" label="资源名称" width="350" sortable></el-table-column>
        <el-table-column prop="docId" label="文档编号" width="0" v-if="false"></el-table-column>
        <el-table-column prop="projectId" label="项目编号" width="0" v-if="false"></el-table-column>
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
        <el-form :model="editForm" label-width="120px" ref="editForm">
          <el-form-item label="资源编号" prop="id">
            <el-input v-model="editForm.id" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="资源名称" prop="fileList">
            <el-upload
              class="upload-demo"
              :action="action"
              :on-remove="handleRemove"
              :before-remove="beforeRemove"
              :file-list="editForm.fileList"
              :on-success="editSuccess"
            >
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click.native="editFormVisible = false">取消</el-button>
          <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
        </div>
      </el-dialog>
      <!--新增界面-->
      <el-dialog title="新增" v-model="addFormVisible" :close-on-click-modal="false">
        <el-form :model="addForm" label-width="120px" ref="addForm">
          <el-form-item label="资源名称" prop="fileList">
            <el-upload
              class="upload-demo"
              :action="action"
              :on-remove="handleRemove"
              :before-remove="beforeRemove"
              :file-list="addForm.fileList"
              :on-success="addSuccess"
            >
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click.native="addFormVisible = false">取消</el-button>
          <el-button type="primary" @click.native="addSubmit" :loading="addLoading">提交</el-button>
        </div>
      </el-dialog>
    </el-col>
  </section>
</template>

<script>
import util from '../../common/js/util'
import { getTableList, getTable, addTable, getStaticReourcePath } from '../../api/api';

export default {
  data () {
    return {
      tableShow: false,
      countryProps: {
        children: 'children',
        label: 'name'
      },

      localHost: '',
      actionRootPath: '/manage/upload/doc/project/',
      action: '',            // 上传目录

      sources: [],           // 某个项目的资源列表
      countrys: [],          // 国家项目列表
      currentProjectId: 0,    // 当前点击的树节点
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,

      //编辑界面数据
      editForm: {
        id: 0,
        name: '',
        docId: 0,
        projectId: 0,
        fileList: []
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,

      //新增界面数据
      addForm: {
        name: '',
        docId: 0,
        projectId: 0,
        fileList: []
      }

    }
  },
  methods: {
    handleNodeClick (data) {
      // 是叶子节点
      if (data.leaf == 1) {
        // 切换节点了
        if (this.currentProjectId != data.id) {
          this.getProjectDocSourceData(data.id);
          this.total = 0;
          this.page = 1;
          this.pageSize = 20;
          this.currentProjectId = data.id;
          this.action = this.localHost + this.actionRootPath + data.id;
        }
        this.tableShow = true;
      } else {
        this.tableShow = false;
      }
    },

    handleCurrentChange (val) {
      this.page = val;
    },

    handleRemove (file, fileList) {
    },

    beforeUpload (file) {

    },

    getTransferObject (object) {
      return util.fillPath(object, 'projectDocSource');
    },

    getTransferDocObject (object) {
      return util.fillPath(object, 'doc');
    },


    // 文件上传成功获取
    addDocData (res, form) {
      var result = res.data;
      addTable(this.getTransferDocObject({
        name: result.name,
        url: result.url,
      })).then((res) => {
        var doc = res.data.data;
        this.addForm.name = doc.name;
        this.addForm.docId = doc.id;
      });
    },
    editSuccess (res, file) {
      this.addDocData(res, this.editForm);
    },

    addSuccess (res, file) {
      this.addDocData(res, this.addForm);
    },

    beforeRemove (file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },


    // 获取左侧项目树
    getCountryProjectTree () {
      getTableList({ path: 'countryContinentProject' }).then((res) => {
        this.countrys = res.data.data;
      });
    },

    // 获取资源列表
    getProjectDocSourceData (id) {
      util.getRightTableData(this, {
        id: id,
        dataSetName: 'sources'
      });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getProjectDocSourceData(page.currentProjectId);
      });
    },
    //显示编辑界面
    handleEdit: function (index, row) {
      this.editForm = Object.assign({}, row);
      getTable(this.getTransferDocObject({ id: row.docId })).then((res) => {
        var doc = res.data.data;
        this.editForm.fileList = [{
          id: doc.id,
          name: doc.name,
          url: doc.url
        }]
        this.editFormVisible = true;
        console.log(this.editForm);
      });
    },
    //显示新增界面
    handleAdd: function () {
      this.addFormVisible = true;
      this.addForm = {
        name: '',
        docId: 0,
        projectId: this.currentProjectId,
        fileList: []
      };
    },
    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
      }, function () {
        page.getProjectDocSourceData(page.currentProjectId);
      });
    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
      }, function () {
        page.getProjectDocSourceData(page.currentProjectId);
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    },

  },
  mounted () {
    this.getCountryProjectTree();
    this.localHost = getStaticReourcePath();
  }
}

</script>

<style scoped>
.el-tree {
  border: none;
}
</style>