import babelpolyfill from 'babel-polyfill'
import Vue from 'vue'
import App from './App'

import Mint from 'mint-ui';
import 'mint-ui/lib/style.css';
import './assets/mui/css/mui.css'
import './assets/css/style.css';

import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
import routes from './routes'

import 'font-awesome/css/font-awesome.min.css'

Vue.use(Mint)
Vue.use(VueRouter)
Vue.use(Vuex)


const router = new VueRouter({
  routes
})


new Vue({
  //el: '#app',
  //template: '<App/>',
  router,
  store,
  //components: { App }
  render: h => h(App)
}).$mount('#app')

