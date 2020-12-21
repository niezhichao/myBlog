<template>
  <div class="app-homecontent">
    <div class="leftSideBar">

    </div>
    <div class="app-article-content">
      <article-item  v-if="intros.length" v-for="item,index in intros" :intro="item" v-bind:key="item.title"/>
    </div>

    <div v-if="notEmpty" >
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
            notEmpty:false
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
              /*this.intros = response.response;*/
              var result = response.response;
              if (result.length>0){
                this.notEmpty =false;
              }else{
                this.notEmpty =true;
              }
              this.intros = result;
            }
          });
        },
        getHomeIntros(){
          getHomePageIntros().then(response=>{
            if (response.resCode == this.$COMMON_CODE.RESULT_CODE.SUCCESS) {
              /*this.intros = response.response;*/
              var result = response.response;
              if (result.length>0){
                this.notEmpty =false;
              }else{
                this.notEmpty =true;
              }
              this.intros = result;
            }
          });
        }
      },
      computed:{
        dynamicSortId(){
          let dynamicSortId = this.$store.getters.dynamicSortId;
          return dynamicSortId;
        }
      },
      watch:{
        dynamicSortId(){
          if (this.dynamicSortId == ""){
            return this.getHomeIntros();
          }
          this.getIntrosBySortId(this.dynamicSortId);
        }
      },
      mounted(){
        var id = this.$store.getters.dynamicSortId;//点击顶部菜单
        if (id !="" && id !=undefined){
          return this.getIntrosBySortId(id);
        }
        this.getHomeIntros();
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
