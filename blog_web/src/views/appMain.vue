<template>
     <div class="app-main">
        <div class="app-main-header">
          <span class="font-desc-breadCrumb">当前位置：首页</span>
        </div>
         <article-item></article-item>
     </div>
</template>

<script>
  import articleItem from "../components/articleItem";
    export default {
        name: "appMain",
        components:{
          articleItem
        }
    }
</script>

<style scoped>
.app-main{
  background-color: white;
  width: 50%;
  margin-left: 40px;
}
  .app-main-header{
    height: 40px;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
  }
  .font-desc-breadCrumb{
    color: rgba(7,7,35,0.47);
    margin-top: 10px;
    margin-left: 10px;
    position: fixed;
  }
</style>
