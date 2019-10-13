<template>
  <div class="tmpl">
    <div class="news-title">
      <p>{{title}}</p>
      <div class="detail clearfix">
        <span>{{author}}</span>
        <span>{{createTime}}</span>
        <!--span>{{createTime}}</span-->
      </div>
    </div>
    <!--div class="news-content">{{contents}}</div-->
    <div v-html="contents"></div>
  </div>
</template>

<script>
import { getTable } from '../../api/api';
import util from '../../common/js/util';

export default {
  data () {
    return {
      article: {}, // 新闻详情数据

      id: 0,
      title: '',
      author: '',
      createTime: '',
      contents: ''
    }
  },
  methods: {
    dateFormat: function (time) {
      var date = new Date();
      date.setTime(time);
      return util.formatDate.format(date, 'yyyy-MM-dd hh:mm:ss');
    },

    getDatas: function (id) {
      getTable({ path: 'campaign', id: id }).then((res) => {
        if (res.data.code = '00000000') {
          var campaign = res.data.data;
          if (!!campaign) {
            this.title = campaign.title;
            this.author = campaign.author;
            this.createTime = this.dateFormat(campaign.createTime);
            this.contents = campaign.contents;
          }
        }
      });
    }
  },
  created () {
    //this.id = this.$route.params.id;
    this.id = this.$route.query.id;
    this.getDatas(this.id);
  }
}
</script>

<style scoped>
.tmpl {
  margin-bottom: 50px;
}
/*scoped作用是css只作用于当前组件，不会影响其他组件样式*/
.news-title p {
  padding-left: 5px;
  font-size: 20px;
  font-weight: 700;
  color: #0a87f8;
}
.news-title span {
  width: 45%;
  margin: 2px 3px 2px 0;
  float: left;
}
.news-title span:last-child {
  width: 100%;
}
.news-title {
  margin-top: 5px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
}
.detail {
  padding: 4px 5px;
}
.news-content {
  padding: 10px 5px;
  text-indent: 2em;
}
</style>