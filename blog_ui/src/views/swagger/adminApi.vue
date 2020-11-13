<template>
  <div class="app-container">
    <iframe id="adminFrame" :src="adminSwaggerUrl"  width="100%" height="750px;"></iframe>
  </div>
</template>

<script>
  import {Loading} from "element-ui";
    export default {
        name: "adminApi",
        data() {
          return {
            //swagger UI界面URL
            adminSwaggerUrl: process.env.ADMIN_SWAGGER_URL + "swagger-ui.html"
          }
        },
      mounted(){
          let adminFrame = document.getElementById("adminFrame");
          let loading = Loading.service({
            lock: true,
            text: '正在努力加载中……'
          });
          if (adminFrame.attachEvent){
            adminFrame.attachEvent("onload", function () {
              loading.close();
            });
          }else{
            adminFrame.onload = function () {
              loading.close();
            };
          }
      }
    }
</script>

<style scoped>

</style>
