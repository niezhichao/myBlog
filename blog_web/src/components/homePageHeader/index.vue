<template>
     <div class="homePageHeader">
       <div class="nav-wrap">
         <div class="nav-logo-block" style="float: left">
           <span class="logo-place">ABCDFDFSDFJSDF</span>
         </div>
         <div class="navCtent" style="  float: right">
           <ul class="navHeader">
             <li class="navItem">首页</li>
             <li class="navItem">后端</li>
             <li class="navItem">前端</li>
             <li class="navItem">linux</li>
             <li class="navItem">数据库</li>
             <li class="navItem">其他</li>
           </ul>
         </div>
       </div>
     </div>
</template>

<script>
    export default {
        name: "homePageHeader"
    }
</script>

<style scoped>
.homePageHeader{
  height: 50px;
  margin: auto;
  background-color: white;
  box-shadow:0 1px 5px #e9e9e9;
}

.navCtent{
  height: 100%;
  margin-right: 20px;
}

.nav-logo-block{
  margin-top: 10px;
  margin-left: 20px;
}

.navItem{
  vertical-align: middle;
  display:inline-block;
  vertical-align:top;
  font-size: 14px;
 margin-right: 20px;
}

.logo-place,.navItem{
  color: rgba(0,0,0,0.68);
}

.logo-place{
  font-size: 20px;
}
</style>
