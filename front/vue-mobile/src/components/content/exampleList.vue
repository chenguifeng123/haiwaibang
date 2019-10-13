<template>
  <div class="tmpl">
    <div class="main-body" ref="wrapper" :style="{ height: (wrapperHeight-50) + 'px' }">
      <mt-loadmore
        :top-method="loadTop"
        :bottom-method="loadBottom"
        :bottom-all-loaded="allLoaded"
        ref="loadmore"
        :autoFill="isAutoFill"
      >
        <ul class="mui-table-view">
          <li class="mui-table-view-cell mui-media" v-for="(item,index) in examples" :key="index">
            <router-link :to="{name:'exampleDetail',query:{
              id: item.id}}">
              <img class="mui-media-object mui-pull-left" :src="item.imageUrl">
              <div class="mui-media-body">
                <span class="title">{{item.title}}</span>
                <div class="news-desc clearfix">
                  <p>{{item.author}}</p>
                  <p>{{dateFormat(item.createTime)}}</p>
                </div>
              </div>
            </router-link>
          </li>
        </ul>
      </mt-loadmore>
    </div>
  </div>
</template>

<script>
import { getTableList, getTable, getStaticReourcePath, postTableList } from '../../api/api';
import util from '../../common/js/util';

export default {
  data () {
    return {
      examples: [], // 新闻列表数据
      total: 0,
      page: 1,
      pageSize: 10,
      //可以进行上拉
      allLoaded: false,
      //是否自动触发上拉函数
      isAutoFill: false,
      wrapperHeight: 0,
    }
  },
  methods: {

    //   下拉刷新
    loadTop () {
      this.loadFrist();
    },
    // 上拉加载
    loadBottom () {
      this.loadMore();
    },

    // 下来刷新加载
    loadFrist () {
      postTableList({
        pageNo: 1,
        pageSize: this.pageSize,
        path: 'example'
      }).then((res) => {
        this.examples = res.data.data;
        this.allLoaded = false; // 可以进行上拉
        this.total = res.data.totalCount;
        this.page = this.page + 1;
        this.$refs.loadmore.onTopLoaded();
      });
    },

    // 加载更多
    loadMore () {
      postTableList({
        pageNo: this.page,
        pageSize: this.pageSize,
        path: 'example'
      }).then((res) => {
        var data = res.data.data;
        this.examples = this.examples.concat(data);
        if (this.examples.length >= this.total) {
          this.allLoaded = true; // 若数据已全部获取完毕

        }
        this.page = this.page + 1;
        this.$refs.loadmore.onBottomLoaded();

      });

    },

    dateFormat: function (time) {
      var date = new Date();
      date.setTime(time);
      return util.formatDate.format(date, 'yyyy-MM-dd hh:mm:ss');
    },

    getDatas () {

      getTableList({ path: 'example' }).then((res) => {
        this.examples = res.data.data;
      });

    },
  },
  created () {
    //this.getDatas();
    this.loadFrist();
  },
  mounted () {
    // 父控件要加上高度，否则会出现上拉不动的情况
    this.wrapperHeight =
      document.documentElement.clientHeight -
      this.$refs.wrapper.getBoundingClientRect().top;
  }
}
</script>

<style scoped>
.main-body {
  /* 加上这个才会有当数据充满整个屏幕，可以进行上拉加载更多的操作 */
  overflow: scroll;
}

/*scoped作用是css只作用于当前组件，不会影响其他组件样式*/
.mui-media-body p {
  color: #0bb0f5;
}
.mui-table-view {
  margin-bottom: 70px;
}
.news-desc p:nth-child(1) {
  float: left;
}

.news-desc p:nth-child(2) {
  float: right;
}
.title {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 17em;
  display: block;
}
</style>