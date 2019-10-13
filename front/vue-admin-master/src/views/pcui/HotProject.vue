<template>
  <section>
    <!--工具条-->
    <!--el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col-->
    <!--列表-->
    <el-table
      :data="hotProjects"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="热门项目编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column
        prop="projectId"
        label="热门项目"
        width="200"
        :formatter="formatProject"
        sortable
      ></el-table-column>
      <el-table-column prop="imageId" label="图片编号" width="150">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <img :src="localHost + scope.row.image.url" style="width:320px;height:220px;">
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.image.url }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
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
      <el-form :model="editForm" label-width="120px" ref="editForm">
        <el-form-item label="热门项目编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="热门项目" prop="projectId">
          <el-select v-model="editForm.projectId" filterable placeholder="请选择">
            <el-option
              v-for="item in projects"
              :key="item.id"
              :label="item.nameZh"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="图片" prop="fileList">
          <el-upload
            class="upload-demo"
            :action="action"
            :file-list="fileList"
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
  </section>
</template>

<script>
import util from '../../common/js/util'
import { addTable, getTableList, getTable, getUrlPath, getStaticReourcePath } from '../../api/api';

export default {
  data () {
    return {
      localHost: '',
      actionRootPath: '/upload/img/project/',
      action: '',            // 上传目录
      projects: [],
      hotProjects: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,

      //编辑界面数据
      fileList: [],
      editForm: {
        id: 0,
        name: '',
        projectId: 0,
        imageId: 0,
      },

    }
  },
  methods: {

    getProjectPropertyById (projectId, property) {
      for (var index = 0; index < this.hotProjects.length; index++) {
        if (projectId == this.hotProjects[index].projectId)
          return this.hotProjects[index].project[property];
      }
      return projectId;
    },

    //国家显示转换
    formatProject: function (row, column) {
      return this.getProjectPropertyById(row.projectId, 'nameZh');
    },

    getUrl: function (projectId) {
      return '/project/' + projectId;
    },

    getTransferObject (object) {
      return util.fillPath(object, 'hotProject');
    },

    getTransferImageObject (object) {
      return util.fillPath(object, 'image');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getHotProjects();
    },

    handleRemove (file, fileList) {
    },

    beforeRemove (file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },

    // 文件上传成功获取
    addImageData (res, form) {
      var result = res.data;
      addTable(this.getTransferImageObject({
        name: result.name,
        url: result.url,
      })).then((res) => {
        var image = res.data.data;
        this.editForm.name = image.name;
        this.editForm.imageId = image.id;
        this.fileList = [result];
      });
    },

    editSuccess (res, file) {
      this.addImageData(res, this.editForm);
    },

    // 获取项目
    getProjects () {
      getTableList({ path: 'project' }).then((res) => {
        this.projects = res.data.data;
      });
    },

    //获取热点项目
    getHotProjects () {
      getTableList({ path: 'hotProject' }).then((res) => {
        this.hotProjects = res.data.data;
      });
      //util.getRightTableData(this, { dataSetName: 'hotProjects' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getHotProjects();
      });
    },

    //显示编辑界面
    handleEdit: function (index, row) {
      this.editForm = Object.assign({}, row);
      this.action = getUrlPath() + this.actionRootPath + row.projectId;
      this.fileList = [row.image];
      this.editFormVisible = true;
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
        para['url'] = page.getUrl(para.projectId);
      }, function () {
        page.getHotProjects();
      });

    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getProjects();
    this.getHotProjects();
    this.localHost = getStaticReourcePath();
  }
}

</script>

<style scoped>
</style>