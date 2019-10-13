<template>
  <div>
    <!-- 头部内容 -->
    <router-view></router-view>
    <!-- 底部 -->
    <nav class="mui-bar mui-bar-tab">
      <router-link :to="{name:'home'}" class="mui-tab-item mui-active" href="#tabbar">
        <span class="mui-icon mui-icon-home"></span>
        <span class="mui-tab-label">首页</span>
      </router-link>
      <router-link :to="{name:'countryList'}" class="mui-tab-item" href="#tabbar-with-chat">
        <span class="mui-icon mui-icon-list"></span>
        <span class="mui-tab-label">移民国家</span>
      </router-link>
      <router-link :to="{name:'shopcar'}" class="mui-tab-item" href="#tabbar-with-contact">
        <span class="mui-icon mui-icon-chat"></span>
        <span class="mui-tab-label">在线咨询</span>
      </router-link>
      <router-link :to="{name:'setting'}" class="mui-tab-item" href="#tabbar-with-map">
        <span class="mui-icon mui-icon-contact"></span>
        <span class="mui-tab-label">关于我们</span>
      </router-link>
    </nav>
  </div>
</template>

<script>
export default {
}

</script>

<style scoped>
</style>