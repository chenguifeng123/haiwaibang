<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>
    <!--列表-->
    <el-table
      :data="banners"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="广告栏编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="name" label="广告栏名" width="150">
        <template slot-scope="scope">
          <i class="el-icon-caret-right"></i>
          <span style="margin-left: 10px">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="imageId" label="广告栏图片" width="150" sortable>
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <img :src="localHost + scope.row.image.url" style="width:320px;height:220px;">
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.image.url }}</el-tag>
            </div>
          </el-popover>
        </template>
        <!--template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <img :src="localHost + scope.row.image.url" style="width:320px;height:220px;">
          </el-popover>
        </template-->
      </el-table-column>
      <el-table-column prop="title" label="标题" width="150" sortable></el-table-column>
      <el-table-column prop="attachType" label="素材类型" width="150" :formatter="formatType" sortable></el-table-column>
      <el-table-column prop="attachId" label="素材" v-if="false" width="150" sortable></el-table-column>

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
        <el-form-item label="导航编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="导航名" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="导航图编号" prop="fileList">
          <el-upload
            class="upload-demo"
            :action="action"
            :file-list="fileList"
            :on-success="editSuccess"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，推荐尺寸 1200 * 320</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="素材类型" prop="attachType">
          <el-select v-model="editForm.attachType" @change="attachTypeChange" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="素材" prop="attachId">
          <el-select v-model="editForm.attachId" placeholder="请选择">
            <el-option v-for="item in attaches" :key="item.id" :label="item.title" :value="item.id"></el-option>
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
        <el-form-item label="导航名" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="导航图编号" prop="fileList">
          <el-upload
            class="upload-demo"
            :action="action"
            :file-list="fileList"
            :on-success="editSuccess"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，推荐尺寸 1200 * 320</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="素材类型" prop="attachType">
          <el-select v-model="addForm.attachType" @change="attachTypeChange" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="素材" prop="attachId">
          <el-select v-model="addForm.attachId" placeholder="请选择">
            <el-option v-for="item in attaches" :key="item.id" :label="item.title" :value="item.id"></el-option>
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
import { getTableList, getTable, getUrlPath, addTable, getStaticReourcePath } from '../../api/api';

export default {
  data () {
    return {
      localHost: '',
      actionRootPath: '/upload/img/banner',
      action: '',            // 上传目录

      options: [{
        value: 0,
        path: 'campaign',
        label: '活动',
        attaches: []
      }, {
        value: 1,
        path: 'article',
        label: '文章',
        attaches: []
      }, {
        value: 2,
        path: 'example',
        label: '案例',
        attaches: []
      }],

      shows: [
        {
          value: 0,
          label: '电脑端'
        },
        {
          value: 1,
          label: '移动端'
        },
      ],

      banners: [],
      attaches: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

      editFormVisible: false,//编辑界面是否显示
      editLoading: false,
      editFormRules: {

      },
      //编辑界面数据
      fileList: [],
      editForm: {
        id: 0,
        name: '',
        imageId: 0,
        title: '',
        attachType: 0,
        attachId: 0,
        sortid: 0,
        fileList: []
      },

      addFormVisible: false,//新增界面是否显示
      addLoading: false,
      addFormRules: {

      },
      //新增界面数据
      addForm: {
        id: 0,
        name: '',
        imageId: 0,
        title: '',
        attachType: 0,
        attachId: 0,
        sortid: 0,
        fileList: []
      }

    }
  },
  methods: {
    // 获取banner关联类型
    translateType: function (array, data, value, prop) {
      for (var index = 0; index < array.length; index++) {
        if (data == array[index][value]) return array[index][prop];
      }
      return data;
    },

    //
    formatType: function (row, column) {
      return this.translateType(this.options, row.attachType, 'value', 'label');
    },

    formatShow: function (row, column) {
      return this.translateType(this.shows, row.showType, 'value', 'label');
    },

    getTransferObject (object) {
      return util.fillPath(object, 'banner');
    },

    getTransferImageObject (object) {
      return util.fillPath(object, 'image');
    },

    // 类型替换后,加载对应的信息
    attachTypeChange (data) {
      var attaches = this.translateType(this.options, data, 'value', 'attaches');
      this.attaches = attaches;
      if (attaches.length > 0) {
        console.log("已经加载,使用缓存");
        return;
      }
      var path = this.translateType(this.options, data, 'value', 'path');
      getTableList({ path: path }).then((res) => {
        this.attaches = res.data.data;
        attaches = this.attaches;
      });
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getBanners();
    },

    // 文件上传成功获取
    addImageData (res, form) {
      var result = res.data;
      addTable(this.getTransferImageObject({
        name: result.name,
        url: result.url,
      })).then((res) => {
        var image = res.data.data;
        form.imageId = image.id;
        this.fileList = [image];
      });
    },

    editSuccess (res, file) {
      this.addImageData(res, this.editForm);
    },

    addSuccess (res, file) {
      this.addImageData(res, this.addForm);
    },

    //获取Banner
    getBanners () {
      util.getRightTableData(this, { dataSetName: 'banners' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getBanners();
      });
    },

    //显示编辑界面
    handleEdit: function (index, row) {
      this.editForm = Object.assign({}, row);
      this.action = getUrlPath() + this.actionRootPath;
      this.fileList = [row.image];
      this.editFormVisible = true;

    },

    //显示新增界面
    handleAdd: function () {
      this.fileList = [];
      this.addForm = {
        id: 0,
        name: '',
        imageId: 0,
        title: '',
        attachType: 0,
        attachId: 0,
        sortid: 0,
      };
      this.action = getUrlPath() + this.actionRootPath;
      this.addFormVisible = true;
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
        para['showType'] = 0;
        para['title'] = page.translateType(page.attaches, para['attachId'], 'id', 'title');
      }, function () {
        page.getBanners();
      });

    },
    //新增
    addSubmit: function () {
      var page = this;
      util.addSubmit(this, function (para) {
        para['showType'] = 0;
        para['title'] = page.translateType(page.attaches, para['attachId'], 'title');
      }, function () {
        page.getBanners();
      });
    },
    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getBanners();
    this.localHost = getStaticReourcePath();
  }
}

</script>

<style scoped>
</style>