<template>
    <div class="articleItem">

      <div style="height: 100%">
        <el-container>
          <el-header>
              
          </el-header>
          <el-main></el-main>
          <el-footer></el-footer>
        </el-container>
      </div>
    </div>
</template>

<script>
    export default {
        name: "articleItem",
      data(){
          return {
            articleIntros:[{
                 title:"Vue项目开发常见问题和解决方案汇总（持续整理）",
                 intro:"Vue Cli 打包之后静态资源路径不对的解决方法"
            }]
          }
      }

    }
</script>

<style scoped>
.articleItem{
  margin-top: 3px;
  height: 150px;
  box-shadow:0 1px 5px  rgba(9,31,35,0.47);
}

.articleItem :hover{
  background-color: rgba(12,68,71,0.03);
}
</style>
