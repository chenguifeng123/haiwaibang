<template>
  <div class="main-page">
    <div class="one-list" v-for="(station, cindex) in continent" :key="cindex">
      <div class="header">
        <span>{{station.name}}</span>
      </div>
      <div class="list-content">
        <div class="mui-card" v-for="(item,index) in station.contents" :key="index">
          <router-link
            :to="{name:'country',query:{
              countryId: item.id,
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
      continent: [
        {
          id: 1,
          name: "美洲",
          contents: [],
        },
        {
          id: 2,
          name: "欧洲",
          contents: [],
        },
        {
          id: 3,
          name: "大洋洲",
          contents: [],
        },
        {
          id: 4,
          name: "亚洲",
          contents: [],
        },
      ],
    }
  },

  methods: {
    loadData: function (data) {
      for (var index = 0; index < data.length; index++) {
        if (data[index].continentId == 1) {
          this.continent[0].contents.push(data[index]);
        } else if (data[index].continentId == 2) {
          this.continent[1].contents.push(data[index]);
        } else if (data[index].continentId == 3) {
          this.continent[2].contents.push(data[index]);
        } else {
          this.continent[3].contents.push(data[index]);
        }
      }
    },
    getDatas () {
      getTableList({ path: 'countryWithImage' }).then((res) => {
        if (res.data.code == '00000000') {
          this.loadData(res.data.data);
        }
      });
    }
  },
  created () { // 组件初始化时期请求数据
    this.getDatas();
    this.localHost = getStaticReourcePath();

  }
}
</script>

<style>
.main-page {
  background-color: #f8f4ee;
  padding-bottom: 50px;
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
  width: 30%;
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