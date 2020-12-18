import Vue from 'vue';
import Vuex from 'vuex';
import  getters from './getters'
import  headMenuDynamicId from './module/headMenuDynamicId'
Vue.use(Vuex);

const store =  new Vuex.Store({
  modules:{
    headMenuDynamicId
  },
  getters
});

export default store;
