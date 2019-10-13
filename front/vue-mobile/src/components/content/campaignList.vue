<template>
  <div class="tmpl">
    <div class="photo-list">
      <ul>
        <li v-for="item in imgs" v-bind:key="item.imageUrl">
          <router-link :to="{name:'campaignDetail',query:{
              id: item.id}}">
            <a>
              <img :src="item.imageUrl">
              <p>
                <span>{{item.title}}</span>
                <br>
                <!--span>{{item.detail}}</span-->
              </p>
            </a>
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { getTableList, getTable, getStaticReourcePath, postTableList } from '../../api/api';
import util from '../../common/js/util';

export default {
  data () {
    return {
      imgs: [], // 每个类别的数据
    }
  },
  methods: {
    getDatas () {
      getTableList({ path: 'campaign' }).then((res) => {
        this.imgs = res.data.data;
      });

    },
  },
  created () {
    this.getDatas();
  }

}
</script>

<style scoped>
/*下面的图片*/
.photo-list li {
  list-style: none;
  position: relative;
  margin-top: 10px;
}

.photo-list li img {
  width: 100%;
  height: 230px;
  vertical-align: top;
}

.photo-list ul {
  padding-left: 0;
  margin: 0;
  padding-bottom: 60px;
}

.photo-list p {
  position: absolute;
  bottom: 0;
  color: white;
  background-color: rgba(0, 0, 0, 0.3);
  margin-bottom: 0;
}

.photo-list p span:nth-child(1) {
  font-weight: bold;
  font-size: 16px;
}
</style>