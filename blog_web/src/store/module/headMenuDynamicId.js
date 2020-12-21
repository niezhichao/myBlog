const headMenuDynamicId ={
  state:{
    /*点击首页顶部菜单 传递分类的id */
    dynamicSortId:"",
    dynamicSortName:"HOME"
  },
  mutations:{
    CHANGE_MENU_ID(state,id){
      state.dynamicSortId = id;
    },
    CHANGE_TAB_NAME(state,sortName){
      state.dynamicSortName = sortName;
    }
  },
  actions:{
     changeMenuId(context,id){
       context.commit("CHANGE_MENU_ID",id);
     },
    changeTabName(context,sortName){
      context.commit("CHANGE_TAB_NAME",sortName);
    }
  }
}

export default headMenuDynamicId;
