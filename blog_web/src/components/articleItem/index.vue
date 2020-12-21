<template>
    <div class="articleItem">

      <div class="art-content">
        <router-link :to="{path:'/article/display',query:{id:intro.pid}}" tag="div">
          <div class="art-title">{{intro.title}}</div>
         <div class="art-intro">{{intro.introDesc}}</div>
        </router-link>
        <div class="art-footer">
            <i @click="clickTypeName(intro.sortId,intro.sortName)" class="el-icon-link style_pointer"><span class="style_underline" style="font-size: 5px;padding-left: 5px;color: rgba(5,9,9,0.65)">{{intro.sortName}}</span></i>
          <svg-icon style="padding-left: 20px;" icon-class="time" class-name="card-panel-icon">
          </svg-icon>
          <span style="font-size: 5px;padding-left: 3px;color: rgba(5,9,9,0.65)">{{intro.publicTime}}</span>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
        name: "articleItem",
       props:["intro"],
      data(){
          return {

          }
      },
      methods:{
        clickTypeName(id,name){
          this.$store.dispatch("changeMenuId", id);
          this.$store.dispatch("changeTabName", name);
        }
      }

    }
</script>

<style scoped>
  .art-content{
    background-color: white;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
  }

  .art-content:hover{
    background-color: rgba(75,88,84,0.26);
  }

  .art-title{
    color: #409eff;
    font-size: 17px;
    font-weight: bolder;
    padding-left: 20px;
    padding-top: 10px;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
    height: 30px;
  }

  .art-intro{
    height: 30px;
    padding-left: 20px;
    color: rgba(5,9,9,0.65);
    font-size: 10px;
    font-weight: lighter;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .art-title:hover,.art-intro:hover{
    cursor: pointer;
  }

  .art-title:hover{
    text-decoration: underline;
  }

  .art-footer{
    padding-left: 20px;
    padding-bottom: 10px;
  }

  .style_pointer:hover{
    cursor: pointer;
  }

  .style_underline:hover{
    text-decoration: underline;
  }
</style>
