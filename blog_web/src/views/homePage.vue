<template>
    <div class="homePage">
        <home-page-header/>
      <div class="app-content">
          
      </div>
    </div>
</template>

<script>
  import homePageHeader from "../components/homePageHeader";
  import appMain from "./appMain";
    export default {
        name: "homePage",
      components:{
          homePageHeader,
          appMain
        }
    }
</script>

<style scoped>
  .app-content{
    margin-top: 10px;
  }
</style>
