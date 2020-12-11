<template>
     <div class="homePageHeader">
         <el-row class="headerBgClr">
           <el-col :span="24" >
           </el-col>
         </el-row>
     </div>
</template>

<script>
    export default {
        name: "homePageHeader"
    }
</script>

<style scoped>
.headerBgClr{
  background-color: blue;
}
  .el-row{
    height: 40px;
  }
</style>
