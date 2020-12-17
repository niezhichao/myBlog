<template>
  <div class="app-homecontent">
    <div class="leftSideBar">

    </div>
    <div class="app-article-content">
      <article-item v-for="item,index in intros" :intro="item" v-bind:key="item.title"/>
    </div>
    <div class="rightSideBar">
      <right-side :data-list="intros"/>
    </div>
  </div>
</template>

<script>
  import articleItem from "../components/articleItem";
  import rightSide from "../components/rightSide";
  import {getHomePageIntros} from "../api/blogIntro";
    export default {
        name: "homecontent",
        components:{
        articleItem,
        rightSide
      },
      data(){
          return {
            intros:[]
          }
      },
      mounted(){
        getHomePageIntros().then(response=>{
          if (response.resCode == this.$COMMON_CODE.RESULT_CODE.SUCCESS) {
            this.intros = response.response;
          }
        });
      }
    }

</script>

<style scoped>
  .app-article-content{
   /* background-color: white;*/
    width: 50%;
    margin-left: 40px;
    float: left;
    position: relative;
  }
  .app-homecontent-header{
    background-color: white;
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
