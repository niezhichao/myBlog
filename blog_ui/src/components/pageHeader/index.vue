<template>
  <el-row class="col-style font-bg-bk">
    <el-col :span="23">
      <span
        style="display:inline-block; margin-top: 9px;margin-left: 50px;font-family: DFKai-SB; ">{{headerText}}</span>
    </el-col>
    <el-col   :span="1">
      <i class="el-icon-close" style="margin-top:9px;margin-left: 24px;rgba(55,71,63,0.76)" @click="closePage()"></i>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "pageHeader",
    props:["headerText"],
    data(){
          return{
            header:""
          }

    },
    methods: {
      closePage: function () {
        /*this.$router.go(-1);*/
        let that = this;
        /**
         * 删除当前页面tab标签后
         * 取最后一个tab标签  并跳转到该标签的页面
         */
        this.$store.dispatch("delVisitedView",that.$route.path).then(function (result) {
          const lastTab = result.slice(-1)[0];
          if (lastTab){
            that.$router.push(lastTab.routePath);
          }else {
            that.$router.push("/");
          }

        });
      }
    }
  }
</script>

<style scoped>

  .col-style {
    border-radius: 4px;
    min-height: 36px;
  }

  .font-bg-bk {
    background: rgba(51,189,126,0.31);
  }
 .el-icon-close{
   font-weight: bold;
 }
  .el-icon-close:hover{
    cursor: pointer;
  }
</style>
