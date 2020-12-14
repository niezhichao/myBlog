<template>
    <div class="homePage">
        <home-page-header/>
      <div class="app-content">
         <app-main/>
      </div>
      <footer class="footer">
        <p>IT Blog  recod of NieZhiChao</p>
      </footer>
    </div>
</template>

<script>
  import homePageHeader from "../components/homePageHeader";
  import appMain from "./appMain";
    export default {
        name: "home",
      components:{
          homePageHeader,
          appMain
        }
    }
</script>

<style scoped>
  .app-content{
    margin-top: 10px;
    height: 100%;
  }

  .homePage{
    height: 100%;
    background-color: rgba(26,71,60,0.15);
    overflow-y: auto;
  }

  .footer {
    width: 100%;
    height: 50px;
    text-align: center;
  }
</style>
