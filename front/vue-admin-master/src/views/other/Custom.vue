<template>
  <section>
    <!--列表-->
    <el-table
      :data="customs"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="编号" v-if="false" width="150" sortable></el-table-column>
      <el-table-column prop="purpose" label="移民目的" width="120" :formatter="formatPurpose" sortable></el-table-column>
      <el-table-column prop="username" label="用户名" width="120" sortable></el-table-column>
      <el-table-column prop="phone" label="电话" width="150" sortable></el-table-column>
      <el-table-column
        prop="isContact"
        label="是否联系"
        width="120"
        :formatter="formatContact"
        sortable
      ></el-table-column>
      <el-table-column prop="createTime" label="发表时间" width="180" :formatter="dateFormat" sortable></el-table-column>

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
        <el-form-item label="编号" prop="id">
          <el-input v-model="editForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="移民目的" prop="purpose">
          <el-select v-model="editForm.purpose" :disabled="true" placeholder="请选择">
            <el-option
              v-for="item in purpose"
              :key="item.value"
              :label="item.name"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="editForm.username" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="editForm.phone" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="是否联系" prop="isContact">
          <el-select v-model="editForm.isContact" placeholder="请选择">
            <el-option
              v-for="item in contact"
              :key="item.value"
              :label="item.name"
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
  </section>
</template>

<script>
import util from '../../common/js/util'

export default {
  data () {
    return {
      purpose: [{ value: "0", name: "全部" },
      { value: "1", name: "子女教育" },
      { value: "2", name: "养老福利" },
      { value: "3", name: "资产配置" },
      { value: "4", name: "海外医疗" },
      { value: "5", name: "海外置业" },
      { value: "6", name: "出入境方便" }],

      contact: [
        { value: 0, name: "否" },
        { value: 1, name: "是" }],

      customs: [],
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
        purpose: 0,
        username: '',
        phone: '',
        isContact: 0
      }

    }
  },
  methods: {
    formatPurpose: function (row, column) {
      return this.translateArray(this.purpose, row['purpose']);
    },

    formatContact: function (row, column) {
      return this.translateArray(this.contact, row['isContact']);
    },

    translateArray: function (array, data) {
      for (var index = 0; index < array.length; index++) {
        if (data == array[index].value) return array[index].name;
      }
      return data;
    },

    //性别显示转换
    dateFormat: function (row, column) {
      var date = new Date();
      date.setTime(row.createTime);
      return util.formatDate.format(date, 'yyyy-MM-dd hh:mm:ss');
    },

    getTransferObject (object) {
      return util.fillPath(object, 'custom');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getCustoms();
    },

    //获取用户列表
    getCustoms () {
      util.getRightTableData(this, { dataSetName: 'customs' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getCustoms();
      });
    },

    //显示编辑界面
    handleEdit: function (index, row) {
      this.editFormVisible = true;
      this.editForm = Object.assign({}, row);
    },

    //编辑
    editSubmit: function () {
      var page = this;
      util.editSubmit(this, function (para) {
      }, function () {
        page.getCustoms();
      });

    },

    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getCustoms();
  }
}

</script>

<style scoped>
</style>