<template>
  <div class="dashboard-editor-container">
    <el-row style="margin-bottom: 10px">
      <el-col :span="6">
        <span>仪表盘</span>
      </el-col>
    </el-row>
    <el-row class="panel-line">
      <el-col :span="4">
        <el-card shadow="always" style="background-color: #8896b3">
          <div align="center">
            <svg-icon  icon-class="eye" style="color: white" class-name="card-panel-icon"/>
          </div>
          <span style="font-family: DFKai-SB;">
            友链数量
          </span>
          <count-to  style="font-family: DFKai-SB;" class="card-panel-num" :startVal="0" :endVal="visitAddTotal" :duration="3200"></count-to>
        </el-card>
      </el-col>

      <el-col :span="4" class="panel-col">
        <el-card shadow="always" style="background-color: #909399">
          <div align="center">
            <svg-icon  icon-class="eye" style="color: red" class-name="card-panel-icon"/>
          </div>
          <span style="font-family: DFKai-SB;">
            用户数
          </span>
          <count-to style="font-family: DFKai-SB;" class="card-panel-num" :startVal="0" :endVal="visitAddTotal" :duration="3200"></count-to>
        </el-card>
      </el-col>

      <el-col :span="4" class="panel-col">
        <el-card shadow="always" style="background-color: #c0c4cc">
          <div align="center">
            <svg-icon style="color: #5cb87a" icon-class="message" class-name="card-panel-icon"/>
          </div>
          <span style="font-family: DFKai-SB;">
            评论数
          </span>
          <count-to style="font-family: DFKai-SB;" class="card-panel-num" :startVal="0" :endVal="visitAddTotal" :duration="3200"></count-to>
        </el-card>
      </el-col>

      <el-col :span="4" class="panel-col">
        <el-card shadow="always" style="background-color: #DCDFE6">
          <div align="center">
            <svg-icon  style="color: #409eff" icon-class="form" class-name="card-panel-icon"/>
          </div>
          <span style="font-family: DFKai-SB;">
            文章数
          </span>
          <count-to style="font-family: DFKai-SB;" class="card-panel-num" :startVal="0" :endVal="visitAddTotal" :duration="3200"></count-to>
        </el-card>
      </el-col>
    </el-row>


    <el-row style="margin-top: 100px;" >
      <el-col :span="6">
        <span>最新发布文章:</span>
      </el-col>
    </el-row>
    <el-row style="margin-top: 10px">
      <el-col>
        <div class="block">
          <el-carousel height="300px">
            <el-carousel-item v-for="item,index in newArticles" :key="index">
              <div>
               <el-link  @click="preView(item.content)" style="margin-bottom: 40px;margin-top: 10px;" >{{item.title}}</el-link>
                <div
                  class="blogContentDiv"
                  v-html="item.content"
                  v-highlight
                >
                  {{item.content}}
                </div>
              </div>

            </el-carousel-item>
          </el-carousel>
        </div>
      </el-col>
    </el-row>

    <!------------------------------------ 博客预览dislog-------------------------------------->
    <el-dialog
      title="博客预览"
      :visible.sync="blogContentPreviewVisible"
      width="800px"
    >
      <div
        class="blogContentDiv"
        v-html="blogContent"
        v-highlight
      >
        {{blogContent}}
      </div>
    </el-dialog>
  </div>
</template>

<script>
import CountTo from "vue-count-to";
import {getCarousalBlog} from"../../api/blog"
export default {
  name: "dashboard",
  components: {
    CountTo,
  },
  data() {
    return {
      blogContentPreviewVisible:false,
      blogContent:"",
      visitAddTotal: 0,
      userTotal: 0,
      commentTotal: 0,
      blogTotal: 0,
      newArticles:[]
    };
  },
  methods:{
    preView(val){
      this.blogContent = val;
      this.blogContentPreviewVisible = true;
    }
  },
  mounted(){
    var param = {
      len:10
    }
    getCarousalBlog(param).then(res=>{
      this.newArticles = res.data.response;
    }).catch(error=>{
      this.$notify.error({
        title:"服务器响应失败",
        message:"服务器遇到错误，无法完成请求： "+error
      });
    })
  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  //background-color: rgb(240, 242, 245);
  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

.panel-col{
  margin-left: 40px;
}

.el-carousel__item{
  font-size: 14px;
  text-align:center;
  opacity: 0.75;
  margin: 0;
}

.el-carousel__item a{
  color: blue;
}

.el-carousel__item:nth-child(2n){
  background-color: #F2F6FC;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #8896b3;
}
</style>
