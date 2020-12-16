// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/theme/index.css'
import Element from 'element-ui'
import  'element-ui/lib/theme-chalk/index.css'
import '@/icons'
import commCodeUtils from './utils/commCodeUtils';

Vue.config.productionTip = false

Vue.use(Element);
Vue.use(commCodeUtils);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App),
})
