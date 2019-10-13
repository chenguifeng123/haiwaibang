<template>
  <div class="main-page">
    <div class="banner-top">
      <img :src="localHost + url">
    </div>

    <div class="project">
      <div class="header">
        <span>{{projectName}}</span>
      </div>
      <div class="list-content">{{projectDetail}}</div>
    </div>

    <div class="one-list">
      <div class="header">
        <span>项目文档</span>
      </div>
      <div class="list-content">
        <ul>
          <li class v-for="(item, index) in projectDocs" :key="index">
            <router-link
              :to="{name:'detail',query:{name:item.name,
              url: item.url}}"
            >{{item.name}}</router-link>
          </li>
        </ul>
      </div>
    </div>

    <div class="one-list">
      <div class="header">
        <span>国家介绍</span>
      </div>
      <div class="list-content">
        <ul>
          <li class v-for="(item, index) in countryDocs" :key="index">
            <router-link
              :to="{name:'detail',query:{name:item.name,
              url: item.url}}"
            >{{item.name}}</router-link>
          </li>
        </ul>
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
      projectId: 0,
      countryId: 0,
      projectName: '',
      projectDetail: '',
      url: '',

      countryDocs: [],
      projectDocs: []
    }
  },
  methods: {
    getDatas (countryId, projectId) {
      getTable({ path: 'project', id: projectId }).then((res) => {
        if (res.data.code = '00000000') {
          var project = res.data.data;
          if (!!project) {
            this.projectName = project.nameZh;
            this.projectDetail = project.detail;
          }
        }
      });
      getTableListAndId({ path: 'country/doc', id: countryId }).then((res) => {
        this.countryDocs = res.data.data;
      });
      getTableListAndId({ path: 'project/doc', id: projectId }).then((res) => {
        this.projectDocs = res.data.data;
      });
    }
  },
  created () { // 组件初始化时期请求数据
    this.countryId = this.$route.query.countryId;
    this.projectId = this.$route.query.projectId;
    this.url = this.$route.query.url;
    this.getDatas(this.countryId, this.projectId);
    this.localHost = getStaticReourcePath();
  }
}
</script>

<style>
.main-page {
  background-color: #eee;
}

.project {
  margin-top: 20px;
  background-color: white;
}

.project .header {
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