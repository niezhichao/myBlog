<template>
    <div class="articleItem">

      <div style="height: 100%">
        <!--<el-container>
          <el-header>
            <router-link to="/page">
              <p>{{articleIntros.title}}</p>
              <p>{{articleIntros.intro}}</p>
            </router-link>
          </el-header>
          <el-main></el-main>
          <el-footer></el-footer>
        </el-container>-->

        <el-row>
          <el-col :span="24">
            <router-link to="/page" tag="div">
              <p class="title-style">{{articleIntros.title}}</p>
            </router-link>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <router-link to="/page" tag="div">
              <p class="intro-style">{{articleIntros.intro}}</p>
            </router-link>
          </el-col>
        </el-row>

        <el-row class="desc_intro">
           <el-col :span="24">
              <i class="el-icon-link"><span style="font-size: 5px;padding-left: 5px;color: rgba(5,9,9,0.65)">Vue</span></i>
             <svg-icon style="padding-left: 20px;" icon-class="time" class-name="card-panel-icon">
             </svg-icon>
             <span style="font-size: 5px;padding-left: 3px;color: rgba(5,9,9,0.65)">一个月前</span>
           </el-col>
        </el-row>
      </div>
    </div>
</template>

<script>
    export default {
        name: "articleItem",
      data(){
          return {
            articleIntros:{
                 title:"Vue项目开发常见问题和解决方案汇总（持续整理）",
                 intro:"Vue Cli 打包之后静态资源路径不对的解决方法"
            }
          }
      }

    }
</script>

<style scoped>
.articleItem{
  margin-top: 3px;
  min-height: 100px;
  padding-bottom: 10px;
  box-shadow:0 1px 5px  rgba(9,31,35,0.47);
}

.articleItem :hover{
  background-color: rgba(12,68,71,0.03);
}

.title-style{
  color: #409eff;
  font-size: 20px;
  font-weight: bolder;
  padding-left: 20px;
  overflow: hidden;
  text-overflow:ellipsis;
  white-space: nowrap;
}

.intro-style{
  color: rgba(5,9,9,0.65);
  font-size: 17px;
  font-weight: lighter;
  padding-left: 20px;
  overflow: hidden;
  text-overflow:ellipsis;
  white-space: nowrap;
}
  .intro-style:hover,.title-style:hover{
    cursor: pointer;
    text-decoration: underline;
  }

  .desc_intro{
    padding-left: 20px;
  }

</style>
