import Vue from 'vue'
import Router from 'vue-router'
import homePage from '@/views/homePage'

Vue.use(Router)

export const RouterMapConfig=[
  {
    path: '/',
    component: homePage
  }
];


const router = new Router({
  routes: RouterMapConfig
});

export default router;
