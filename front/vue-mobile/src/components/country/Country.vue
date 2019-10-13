<template>
  <div class="main-page">
    <div class="banner-top">
      <img :src="localHost + url">
    </div>

    <div class="country">
      <div class="header">
        <span>{{countryName}}</span>
      </div>
      <div class="list-content">{{countryDetail}}</div>
    </div>

    <div class="one-list">
      <div class="header">
        <span>推荐项目</span>
      </div>
      <div class="list-content">
        <div class="mui-card" v-for="(item, index) in projects" :key="index">
          <router-link
            :to="{name:'project',query:{
              projectId: item.id,
              countryId: item.countryId,
              url:item.url}}"
          >
            <!--内容区-->
            <div class="mui-card-content">
              <img :src="localHost + item.url">
            </div>
            <!--页脚，放置补充信息或支持的操作-->
            <div class="mui-card-footer">{{item.nameZh}}</div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { addTable, getTableList, getTable, getStaticReourcePath, getTableListAndId } from '../../api/api';
import util from '../../common/js/util';


export default {
  data () {
    return {
      localHost: '',

      countryId: 0,
      countryName: '',
      countryDetail: '',
      url: '',

      projects: [],
    }
  },
  methods: {
    getDatas (countryId) {
      getTable({ path: 'country', id: countryId }).then((res) => {
        if (res.data.code = '00000000') {
          var country = res.data.data;
          if (!!country) {
            // 此处改接口了,调用的是 数组接口
            //this.countryName = country.nameZh;
            //this.countryDetail = country.detail;
            //this.url = country.url;
            this.countryName = country[0].nameZh;
            this.countryDetail = country[0].detail;
            this.url = country[0].url;
          }
        }
      });
      getTableListAndId({ path: 'country', id: countryId }).then((res) => {
        this.projects = res.data.data;
      });
    }
  },
  created () { // 组件初始化时期请求数据
    this.countryId = this.$route.query.countryId;
    //this.url = this.$route.query.url;
    this.getDatas(this.countryId);
    this.localHost = getStaticReourcePath();

  }
}
</script>

<style>
.main-page {
  background-color: #eee;
  padding-bottom: 50px;
}

.country {
  margin-top: 20px;
  background-color: white;
}

.country .header {
  padding: 5px;
  border-bottom: 1px solid #efeae4;
}

.one-list {
  margin-bottom: 10px;
  margin-top: 10px;
  background-color: white;
}

.one-list .header {
  padding: 5px;
  border-bottom: 1px solid #efeae4;
}

.list-content {
  text-align: left;
  padding: 5px;
}

.list-content .mui-card {
  margin: 5px;
  display: inline-block;
}

.list-content .mui-card-footer {
  text-align: center;
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.header span {
  margin: 10px;
  padding-left: 5px;
  border-left: 5px solid #d3a768;
  font-size: 15px;
  font-weight: bold;
  color: #474843;
}
</style>