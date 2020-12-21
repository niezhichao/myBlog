<template>
     <div class="showArticle-main">

       <div class="article-content">
         <div style="text-align: center;"><h1>{{articleInfo.title}}</h1></div>
         <div style="text-align: center">
           <i @click="clickTypeName(articleInfo.sortId,articleInfo.sortName)" class="el-icon-link style_pointer"><span class="style_underline" style="font-size: 5px;padding-left: 5px;color: rgba(5,9,9,0.65)">{{articleInfo.sortName}}</span></i>
           <svg-icon style="padding-left: 20px;" icon-class="time" class-name="card-panel-icon">
           </svg-icon>
           <span style="font-size: 5px;padding-left: 3px;color: rgba(5,9,9,0.65)">{{articleInfo.publicTime}}</span>
         </div>
         <el-divider></el-divider>
         <div class="content-block"  v-html="articleInfo.content" v-highlight>
           {{articleInfo.content}}
         </div>
       </div>

       <div class="sideCatalog">

       </div>
     </div>
</template>

<script>
  import {getArticleInfoById} from "../api/articleInfo";
    export default {
        name: "showArticle",
      data(){
        return {
          blogContent:"",
          articleInfo:{}
        }
      },
      methods:{
          initArticleContent(){
            var id = this.$route.query.id;//router-link 传递参数
            var param={
              id:id
            }
            getArticleInfoById(param).then(response=>{
              if (response.resCode == this.$COMMON_CODE.RESULT_CODE.SUCCESS) {
                this.articleInfo = response.response;
              }
            });
          },
        clickTypeName(id,name){
          this.$store.dispatch("changeMenuId", id);
          this.$store.dispatch("changeTabName", name);
          this.$router.push("/home");
        }
      },
      mounted(){
          console.log();
        this.initArticleContent();
      }
    }
</script>

<style scoped>

  .showArticle-main{

  }

  .article-content{
    background-color: rgba(23,146,4,0.4);
    width: 60%;
    margin-left: 40px;
    margin-top: 10px;
    float: left;
    position: relative;
    box-shadow:3px 3px 10px  rgba(9,31,35,0.47);
    min-height: 700px;
  }
  .content-block{

    padding-left: 10px;
    padding-right: 10px;
  }

  .style_pointer:hover{
    cursor: pointer;
  }

  .style_underline:hover{
    text-decoration: underline;
  }
</style>
