<template>
  <div class="breadcrumb-wrapper">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :key="122" class="active">首页</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item,index) in breadCrumbs" :key="item.routePath"><span :class="item.routePath== route.path?'active':''">{{item.tabName}}</span></el-breadcrumb-item>
    </el-breadcrumb>
  </div>

</template>

<script>
  export default {
    name: "Breadcrumb",
    data() {
      return {

      }
      },
      computed:{
        breadCrumbs(){
          return this.$store.getters.breadCrumbMarks
        },
        route(){
          return this.$route;
        }
      }
    }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .active{
        color: #409eff;
  }
</style>
