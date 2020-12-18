<template>
  <div class="app-homecontent">
    <div class="leftSideBar">

    </div>
    <div v-if="intros.length>0" class="app-article-content">
      <article-item  v-if="intros.length" v-for="item,index in intros" :intro="item" v-bind:key="item.title"/>
    </div>

    <div v-else >
        <h2  class="warning-msg" style="color: rgba(226,92,95,0.84)">很抱歉本次查询无结果，请联系管理员~~~~~</h2>
        <i class=""></i>
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
  import {getHomePageIntrosBySortId} from "../api/blogIntro"
    export default {
        name: "homecontent",
        components:{
        articleItem,
        rightSide
      },
      data(){
          return {
            intros:[],
          }
      },
      methods:{
        getIntrosBySortId(id){
          var res;
          var param={
            id:id
          };
          getHomePageIntrosBySortId(param).then(response => {
            if (response.resCode == this.$COMMON_CODE.RESULT_CODE.SUCCESS) {
              this.intros = response.response;
            }
          });
        }
      },
      computed:{
        /*dynamicSortId(){
          console.log(1234)
          let dynamicSortId = this.$store.getters.dynamicSortId;
          return dynamicSortId;
        }*/
      },
      watch:{
        /*dynamicSortId(){
          this.getIntrosBySortId(this.dynamicSortId);
        }*/
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

  .app-homecontent{
    margin-top: 10px;
  }

  .app-article-content{
    background-color: white;
    width: 50%;
    margin-left: 40px;
    float: left;
    position: relative;
  }

  .rightSideBar{
    float: right;
  }
  .leftSideBar{
    float: left;
    width: 10%;
  }

  .warning-msg{
      position: absolute;
    margin-top: 300px;
    margin-left: 200px;
  }

</style>
