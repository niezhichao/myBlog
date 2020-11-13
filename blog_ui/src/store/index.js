import Vue from 'vue'
import Vuex from 'vuex'
import tagsView from './modules/tagsView'
import breadCrumb from './modules/breadCrumbs'
import  getters from './getters'
Vue.use(Vuex);

const store =  new Vuex.Store({
	modules:{
		tagsView,
    breadCrumb
	},
	getters
});

export default store;
