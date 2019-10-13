<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-button type="primary" @click="handleAdd">新增</el-button>
    </el-col>

    <!--列表-->
    <el-table
      :data="campaigns"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 100%;"
    >
      <el-table-column prop="id" label="活动编号" v-if="false" width="150" v-show="false" sortable></el-table-column>
      <el-table-column prop="title" label="标题" width="200" sortable></el-table-column>
      <el-table-column prop="author" label="作者" width="120" sortable></el-table-column>
      <el-table-column prop="createTime" label="发表时间" width="180" :formatter="dateFormat" sortable></el-table-column>
      <el-table-column label="操作" min-width="160">
        <template scope="scope">
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
  </section>
</template>

<script>

import util from '../../common/js/util'

export default {

  data () {
    return {

      campaigns: [],
      total: 0,
      page: 1,
      pageSize: 20,
      listLoading: false,
      sels: [],//列表选中列

    }
  },
  methods: {
    getTransferObject (object) {
      return util.fillPath(object, 'campaign');
    },

    handleCurrentChange (val) {
      this.page = val;
      this.getCampaigns();
    },

    dateFormat: function (row, column) {
      var date = new Date();
      date.setTime(row.createTime);
      return util.formatDate.format(date, 'yyyy-MM-dd hh:mm:ss');
    },

    //获取用户列表
    getCampaigns () {
      util.getRightTableData(this, { dataSetName: 'campaigns' });
    },

    //删除
    handleDel: function (index, row) {
      var page = this;
      util.handleDel(this, index, row, function () {
        page.getCampaigns();
      });
    },

    //显示新增界面
    handleAdd: function () {
      this.$router.push({ path: '/content', query: { type: 'campaign' } });

    },

    selsChange: function (sels) {
      this.sels = sels;
    }
  },
  mounted () {
    this.getCampaigns();
  }
}

</script>

<style scoped>
</style>