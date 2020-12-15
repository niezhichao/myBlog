<template>
    <div class="homePage">
      <div id="homePageContainer">
        <home-page-header/>
        <div class="app-content">
          <app-main/>
        </div>
      </div>

      <footer class="footer">
        <p>IT Blog  record of NieZhiChao</p>
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

  /*保持底部内容都在最下面*/
  #homePageContainer{
    min-height: 100%;
    height: auto !important;
    height: 100%;
    margin: 0 auto -30px;/*margin-bottom的负值等于footer高度*/
  }

  .footer {
    height: 30px;
    clear:both;
    text-align: center;
    }
</style>
