// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'font-awesome/css/font-awesome.min.css'
import './assets/theme/index.css'
import Element from 'element-ui'
import  'element-ui/lib/theme-chalk/index.css'
import '@/styles/index.scss'
import '@/icons' // icon
import store from './store'
import commCodeUtils from './utils/commCodeUtils';

import CKEditor from 'ckeditor4-vue';

Vue.use( CKEditor );

//引入highlight.js
import hljs from 'highlight.js';
import 'highlight.js/styles/atom-one-dark.css'	//样式
Vue.config.productionTip = false

Vue.use(Element);
Vue.use(commCodeUtils);

/**
 * 自定义指令
 * 指令写在new Vue之前
 */
Vue.directive('highlight',function (el) {
  let blocks = el.querySelectorAll('pre code');
  blocks.forEach((block)=>{
    hljs.highlightBlock(block)
  })
})

new Vue({
  el: '#app',
  store,
  router,
  render: h => h(App)
})
