const tagsView ={
  state:{
    /**
     * assign object of visitedViews: {
     *      tabName tab标签名
     *      routePath  tab标签的name属性值 使用路由path
     * }
     * */
      visitedTagViews:[]
  },
  mutations:{
    ADD_VISITED_VIEWS(state,view){
          if (state.visitedTagViews.some(item=>item.routePath==view.path)) return
          state.visitedTagViews.push(Object.assign({},{
            tabName:view.name,
            routePath:view.path
          }));
    },
    DEL_OTHER_VIEW(state,targetName){
      state.visitedTagViews.some(function (item,index) {
        if (item.routePath == targetName){
          state.visitedTagViews.splice(index,1);
          return true;
        }
      });
    },
    DEL_VISITED_VIEWS(state,targetName){
      state.visitedTagViews.some(function (item,index) {
        if (item.routePath == targetName){
          state.visitedTagViews.splice(index,1);
          return true;
        }
      });
    },
    DEL_ALL_VIES(state){
      state.visitedTagViews=[];
    }
  },
  actions:{
    addVisitedViews(context,view){
      context.commit("ADD_VISITED_VIEWS",view);
    },
    delVisitedView({commit,state},targetName){
      return new Promise(function (resolve,reject) {
        commit("DEL_VISITED_VIEWS",targetName);
        resolve(state.visitedTagViews);
      })

    },
    delOtherView({commit,state},targetName){
      commit("DEL_OTHER_VIEW",targetName);
    },
    delAllViews({commit}){
      commit("DEL_ALL_VIES");
    }
  }
};

export default tagsView;
