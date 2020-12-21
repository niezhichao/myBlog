<template>
  <div class="homePage">
    <div id="homePageContainer">
      <home-page-header :headerMenu="headerMenu"/>
      <div class="nav-line" style="display: flex">

        <div class="nav-home" style="width:100px;height: 50px;background-color: rgba(68,99,198,0.74)">
          <div style="display: block;padding-top: 15px;padding-left: 5px;color: whitesmoke;">
              <div>
                <span @click="homeTabClick" class="nav-hover" >网站首页</span>
              </div>
          </div>
        </div>
        <div style="min-width:100px;height: 50px;background-color: rgba(30,101,62,0.36)">
          <div style="padding-top: 15px;padding-left: 5px;padding-right:5px;color: whitesmoke">
            <span class="nav-location">当前位置:{{tabName}}</span>
          </div>

        </div>
      </div>
    <!--  <el-divider></el-divider>-->
      <div class="app-content">
        <app-main/>
      </div>
    </div>

    <footer class="footer">
      <p>IT Blog record of NieZhiChao</p>
    </footer>

  </div>
</template>

<script>
  import homePageHeader from "../components/homePageHeader";
  import {getHomeHeaderMenu} from "../api/home";
  import appMain from "./appMain";

  export default {
    name: "home",
    components: {
      homePageHeader,
      appMain
    },
    data() {
      return {
        headerMenu: [],
      }
    },
    methods:{
      homeTabClick(){
        this.$store.dispatch("changeMenuId", "");
        this.$store.dispatch("changeTabName", "HOME");
        var path = this.$route.path;
        if (path != "/home"){
          this.$router.push("/home");
        }
      }
    },computed:{
      tabName(){
        let tabName = this.$store.getters.dynamicSortName;
        return tabName;
      }
    },
    watch:{
      tabName(){

      }
    },
    mounted() {
      getHomeHeaderMenu().then(response => {
        if (response.resCode == this.$COMMON_CODE.RESULT_CODE.SUCCESS) {
          this.headerMenu = response.response;
        }
      })
    }
  }
</script>

<style scoped>
  .app-content {
   /* margin-top: 10px;*/
    height: 100%;
  }

  .homePage {
    height: 100%;
    background-color:#f6f6f6;
    overflow-y: auto;
  }

  /*保持底部内容都在最下面*/
  #homePageContainer {
    min-height: 100%;
    height: auto !important;
    height: 100%;
    margin: 0 auto -30px; /*margin-bottom的负值等于footer高度*/
  }

  .footer {
padding-top: 10px;
    height: 30px;
    clear: both;
    text-align: center;
  }

  .nav-hover:hover{
    text-decoration: underline;
    color: #409eff;
    cursor: pointer;
  }
  .nav-location:hover{
    color: rgba(39,17,111,0.58);
  }
</style>
