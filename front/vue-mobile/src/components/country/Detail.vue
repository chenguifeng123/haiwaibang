<template>
  <div class="main-page">
    <div class="project">
      <div class="header">
        <span>{{name}}</span>
      </div>
      <div class="list-content">
        <iframe :src="url" width="100%" height="800"></iframe>
      </div>
    </div>
  </div>
</template>

<script>
import { getStaticReourcePath } from '../../api/api';
import util from '../../common/js/util';

export default {
  data () {
    return {
      localHost: '',
      name: '',
      url: '',

    }
  },
  methods: {
    getDatas () {
    }
  },
  created () { // 组件初始化时期请求数据
    this.localHost = getStaticReourcePath();
    this.name = this.$route.query.name;
    var url = this.localHost + this.$route.query.url;
    this.url = "../../../static/pdfjs/web/viewer.html?file=" + url;
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

.header span {
  margin: 10px;
  padding-left: 5px;
  border-left: 5px solid #d3a768;
  font-size: 15px;
  font-weight: bold;
  color: #474843;
}
</style>