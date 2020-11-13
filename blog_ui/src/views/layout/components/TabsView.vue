<template>
  <div class="tags-view-container">
    <!--<el-button @click="test">1234</el-button>-->
    <el-tabs
      v-model="activeName"
      closable
      @tab-remove="removeTab"
      @tab-click="handleTabClick"
    >
      <el-tab-pane
        v-for="(item,index) in tabs"
        :key="index+item.tabName"
        :label="item.tabName"
        :name="item.routePath"
      ></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default {
    name: "tabsview",
    data() {
      return {
        activeName: "",
      }
    },
    computed: {
      tabs() {
        let tabViews = this.$store.getters.visitedTagViews;
        return tabViews;
      }
    },
    methods: {
      test: function () {

      },
      removeTab: function (targetName) {
        if (targetName == this.activeName){
          this.delVisitedTagView(targetName);
          return
        }
        this.delOtherTagView(targetName);
      },
      handleTabClick: function (tab) {

        let path = tab.name;
        if (path == this.$route.path)return
        this.$router.push(path);
      },
      delVisitedTagView(targetName){
        let that = this;
        /**
         * 删除当前页面tab标签后
         * 取最后一个tab标签  并跳转到该标签的页面
         */
        this.$store.dispatch("delVisitedView",targetName).then(function (result) {
           const lastTab = result.slice(-1)[0];
           if (lastTab){
             that.$router.push(lastTab.routePath);
           }else {
             that.$router.push("/");
           }

        });
      },
      delOtherTagView(targetName){

        this.$store.dispatch("delVisitedView",targetName);
      },
      addTagView() {

        var route = this.getRoute();
        if (!route) {
          return false
        }
        this.$store.dispatch("addVisitedViews", route);
        this.activeName = route.path;
      },
      getRoute: function () {
        if (this.$route.name) {
          return this.$route;
        } else {
          return false
        }
      }
    },
    mounted() {

    },
    watch: {
     $route() {
        if (this.$route.path == '/dashboard') {
          this.$store.dispatch("delAllViews");
          return
        }
        this.addTagView();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .tags-view-container {

  }
</style>
