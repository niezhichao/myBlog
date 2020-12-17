import Vue from 'vue'
import Router from 'vue-router';
import home from '@/views/index';

Vue.use(Router)

export const RouterMapConfig=[
  {
    path: '/',
    component: home,
    children: [{
      path: '/',
      component: () => import('@/views/homecontent')
    }]
  },
  {
    path:"/article",
    component: home,
    children: [{
      path: 'display',
      component: () => import('@/views/showArticle')
    }]
  }
];


const router = new Router({
  routes: RouterMapConfig
});

export default router;
