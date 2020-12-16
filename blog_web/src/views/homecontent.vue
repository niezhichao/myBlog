<template>
  <div class="app-homecontent">
    <div class="leftSideBar">

    </div>
    <div class="app-article-content">
      <div class="app-homecontent-header">
        <span class="font-desc-breadCrumb">当前位置：首页</span>
      </div>
      <article-item></article-item>
    </div>
    <div class="rightSideBar">
      <right-side/>
    </div>
  </div>
</template>

<script>
  import articleItem from "../components/articleItem";
  import rightSide from "../components/rightSide";
    export default {
        name: "homecontent",
        components:{
        articleItem,
        rightSide
      }
    }
</script>

<style scoped>
  .app-article-content{
    background-color: white;
    width: 50%;
    margin-left: 40px;
    float: left;
    position: relative;
  }
  .app-homecontent-header{
    height: 40px;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
  }
  .font-desc-breadCrumb{
    display: block;
    padding-top: 10px;
    padding-left: 20px;
    color: rgba(7,7,35,0.47);
  }

  .rightSideBar{
    float: right;
  }
  .leftSideBar{
    float: left;
    width: 10%;
  }

  .box-card{
    width: 100px;
    background-color: white;
  }
</style>
