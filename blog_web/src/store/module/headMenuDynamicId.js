const headMenuDynamicId ={
  state:{
    /*点击首页顶部菜单 传递分类的id */
    dynamicSortId:""
  },
  mutations:{
    CHANGE_MENU_ID(state,id){
      state.dynamicSortId = id;
    }
  },
  actions:{
     changeMenuId(context,id){
       context.commit("CHANGE_MENU_ID",id);
     }
  }
}

export default headMenuDynamicId;
