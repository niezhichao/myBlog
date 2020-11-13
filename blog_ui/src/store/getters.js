const getters = {
  visitedTagViews: function (state) {
      return state.tagsView.visitedTagViews;
  },
  breadCrumbMarks: state=> state.tagsView.visitedTagViews
}
export default getters
