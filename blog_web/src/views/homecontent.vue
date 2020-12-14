<template>
  <div class="app-homecontent">
    <div class="app-homecontent-header">
      <span class="font-desc-breadCrumb">当前位置：首页</span>
    </div>
    <article-item></article-item>

  </div>
</template>

<script>
  import articleItem from "../components/articleItem"
    export default {
        name: "homecontent",
      components:{
        articleItem
      }
    }
</script>

<style scoped>
  .app-homecontent{
    background-color: white;
    width: 50%;
    margin-left: 40px;
  }
  .app-homecontent-header{
    height: 40px;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
    position: relative;
  }
  .font-desc-breadCrumb{
    color: rgba(7,7,35,0.47);
  }
</style>
