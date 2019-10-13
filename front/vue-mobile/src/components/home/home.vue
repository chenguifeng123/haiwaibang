<template>
  <div class="main-page">
    <!-- 轮播图 -->
    <div class="swipe">
      <mt-swipe :auto="2000">
        <mt-swipe-item v-for="(item, index) in banners" :key="index">
          <router-link
            :to="{name:'articleDetail',query:{id: item.attachId}}"
            v-if="item.attachType == 1"
          >
            <img :src="localHost + item.image.url" :alt="item.name">
          </router-link>
          <router-link
            :to="{name:'exampleDetail',query:{id: item.attachId}}"
            v-if="item.attachType == 2"
          >
            <img :src="localHost + item.image.url" :alt="item.name">
          </router-link>
          <router-link
            :to="{name:'campaignDetail',query:{id: item.attachId}}"
            v-if="item.attachType == 3"
          >
            <img :src="localHost + item.image.url" :alt="item.name">
          </router-link>
        </mt-swipe-item>
      </mt-swipe>
    </div>
    <!-- 九宫格 -->
    <div>
      <ul class="mui-table-view mui-grid-view mui-grid-9">
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
          <!-- vue-router跳转 -->
          <router-link :to="{name:'countryList'}">
            <span class="mui-icon mui-icon-home"></span>
            <div class="mui-media-body">移民国家</div>
          </router-link>
        </li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
          <router-link :to="{name:'campaignList'}">
            <span class="mui-icon mui-icon-email"></span>
            <div class="mui-media-body">热点活动</div>
          </router-link>
        </li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
          <router-link :to="{name:'custom'}">
            <span class="mui-icon mui-icon-chatbubble"></span>
            <div class="mui-media-body">移民自测</div>
          </router-link>
        </li>
        <!--li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
          <a href="#">
            <span class="mui-icon mui-icon-location"></span>
            <div class="mui-media-body">留言反馈</div>
          </a>
        </li-->
      </ul>
    </div>

    <div class="hotProject">
      <div class="header">
        <span>推荐国家</span>
      </div>
      <div class="list-content">
        <div class="mui-content">
          <div class="mui-row">
            <div class="mui-col-xs-4 mui-col-sm-3" v-for="(item, index) in countrys" :key="index">
              <router-link
                :to="{name:'country',query:{countryId: item.countryId, url:item.image.url}}"
              >
                <div class="mui-row">
                  <div class="mui-col-sm-6">
                    <img :src="localHost + item.image.url">
                  </div>
                  <div class="mui-col-sm-6">
                    <p>{{item.country.nameZh}}</p>
                    <p>{{item.country.name}}</p>
                  </div>
                </div>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="article">
      <div class="header">
        <span>移民资讯</span>
        <p>
          <router-link :to="{name:'articleList'}">
            <p class="more">【更多】</p>
          </router-link>
        </p>
      </div>
      <div class="list-content">
        <li class="article-content" v-if="articles.length > 0">
          <router-link :to="{name:'articleDetail',query:{id: articles[0].id}}">
            <div class="mui-row">
              <div class="mui-col-sm-4 article-li">
                <img :src="articles[0].imageUrl">
              </div>
              <div class="mui-col-sm-8 content-right">
                <div class="article-title">{{articles[0].title}}</div>
                <div class="article-author">{{articles[0].author}}</div>
                <div class="article-date">{{dateFormat(articles[0].createTime)}}</div>
              </div>
            </div>
          </router-link>
        </li>
        <ul>
          <li
            class="article-content"
            v-for="(item, index) in articles"
            :key="index"
            v-if="index > 0"
          >
            <span class="line-type"></span>
            <router-link :to="{name:'articleDetail',query:{id: item.id}}">{{item.title}}</router-link>
          </li>
        </ul>
      </div>
    </div>

    <div class="article">
      <div class="header">
        <span>移民案例</span>
        <p>
          <router-link :to="{name:'exampleList'}">
            <p class="more">【更多】</p>
          </router-link>
        </p>
      </div>
      <div class="list-content">
        <li class="example-content" v-if="examples.length > 0">
          <router-link :to="{name:'exampleDetail',query:{id: examples[0].id}}">
            <div class="mui-row">
              <div class="mui-col-sm-4 article-li">
                <img :src="examples[0].imageUrl">
              </div>
              <div class="mui-col-sm-8 content-right">
                <div class="article-title">{{examples[0].title}}</div>
                <div class="article-author">{{examples[0].author}}</div>
                <div class="article-date">{{dateFormat(examples[0].createTime)}}</div>
              </div>
            </div>
          </router-link>
        </li>
        <ul>
          <li
            class="example-content"
            v-for="(item, index) in examples"
            :key="index"
            v-if="index > 0"
          >
            <span class="line-type"></span>
            <router-link :to="{name:'exampleDetail',query:{id: item.id}}">{{item.title}}</router-link>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import { addTable, getTableList, getTable, getStaticReourcePath } from '../../api/api';
import util from '../../common/js/util';

export default {
  data () {
    return {
      localHost: '',
      banners: [],
      countrys: [],
      articles: [],
      examples: [],

      bannerData: [], // 轮播图数据
    }
  },
  methods: {
    dateFormat: function (time) {
      var date = new Date();
      date.setTime(time);
      return util.formatDate.format(date, 'yyyy-MM-dd hh:mm:ss');
    },

    getDatas () {
      getTableList({ path: 'banner' }).then((res) => {
        this.banners = res.data.data;
      });
      getTableList({ path: 'hotCountry' }).then((res) => {
        this.countrys = res.data.data;
      });
      getTableList({ path: 'article' }).then((res) => {
        this.articles = res.data.data;
      });
      getTableList({ path: 'example' }).then((res) => {
        this.examples = res.data.data;
      });
    }
  },
  created () { // 组件初始化时期请求数据
    this.getDatas();
    this.localHost = getStaticReourcePath();
  }
}
</script>

<style scoped>
/*scoped作用是css只作用于当前组件，不会影响其他组件样式*/
.swipe {
  height: 190px;
}
.mui-table-view.mui-grid-view.mui-grid-9 {
  border: none;
  background: #fff;
}
.mui-table-view.mui-grid-view.mui-grid-9:after {
  height: 0;
}
.mui-table-view-cell.mui-media.mui-col-xs-4.mui-col-sm-3 {
  border: none;
  background-color: #fff;
}
.mui-icon {
  width: 50px;
  height: 50px;
}
.mui-icon-home:before,
.mui-icon-email:before,
.mui-icon-chatbubble:before,
.mui-icon-location:before,
.mui-icon-search:before,
.mui-icon-phone:before {
  content: "";
}
.mui-icon-home {
  background: url("../../assets/home/news.png") no-repeat center;
  background-size: 100%;
}
.mui-icon-email {
  background: url("../../assets/home/picShare.png") no-repeat center;
  background-size: 100%;
}
.mui-icon-chatbubble {
  background: url("../../assets/home/goodShow.png") no-repeat center;
  background-size: 100%;
}
/*
.mui-icon-location {
  background: url("../../assets/home/feedback.png") no-repeat center;
  background-size: 100%;
}
.mui-icon-search {
  background: url("../../assets/home/search.png") no-repeat center;
  background-size: 100%;
}
.mui-icon-phone {
  background: url("../../assets/home/callme.png") no-repeat center;
  background-size: 100%;
}
*/

.main-page {
  background-color: #eee;
  margin-bottom: 50px;
}

.article,
.hotProject {
  margin-top: 20px;
  background-color: white;
}

.hotProject .header,
.article .header {
  padding: 5px;
  border-bottom: 1px solid #efeae4;
}

.header span {
  margin: 10px;
  padding-left: 5px;
  border-left: 5px solid #d3a768;
  font-size: 15px;
  font-weight: bold;
  color: #474843;
}

.header p {
  float: right;
  font-size: 14px;
}

.header .more {
  color: #d3a768;
}

.article-title {
  font-size: 18px;
  line-height: 24px;
  color: #d3a768;
}

/*
.article-author {
  font-size: 15px;
  color: #8f8f94;
}

.article-date {
  font-size: 15px;
  color: #808080;
}
*/

.article-content,
.example-content {
  margin-left: 10px;
  padding: 5px;
  border-bottom: 1px dashed #e5ddd2;
}

.list-content .mui-content {
  background-color: white;
}

.list-content .mui-col-sm-4 {
  padding-top: 5px;
  border-right: 1px solid #e5ddd2;
  border-bottom: 1px solid #e5ddd2;
}

.list-content .mui-col-sm-6 {
  padding: 2px;
}

.content-right {
  padding-left: 5px;
}

.line-type {
  width: 5px;
  height: 5px;
  margin: 7px 7px 3px 9px;
  border-radius: 50%;
  display: inline-block;
  background-color: #d3a768;
}
</style>