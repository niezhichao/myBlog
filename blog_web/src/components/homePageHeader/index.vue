<template>
     <div class="homePageHeader">
       <div class="nav-wrap">
         <div class="nav-logo-block" style="float: left">
           <span class="logo-place">Coding What You See,Creating What You want</span>
         </div>
         <div class="navCtent" style="  float: right">
           <ul class="navHeader">
             <li class="navItem">首页</li>
             <li class="navItem" v-for="item,index in headerMenu">{{item.typeName}}</li>
             <li class="navItem">其他</li>
             <li class="search_style">
               <el-input size="mini" v-model="s_test">
                 <el-button class="search_btn" slot="append" icon="el-icon-search">搜索</el-button>
             </el-input></li>
           </ul>
         </div>
       </div>
     </div>
</template>

<script>
    export default {
        name: "homePageHeader",
       props:["headerMenu"],
      data(){
          return {
            s_test:""
          }
      }
    }
</script>

<style scoped>
.homePageHeader{
  height: 50px;
  margin: auto;
  background-color: white;
  box-shadow:0 1px 5px #e9e9e9;
}
.search_style{
  display:inline-block;
  margin-right: 50px;
}

.search_btn:hover{
  color: rgba(66,110,92,0.22);
}

.el-input{
  width: 200px;
}

ul.navHeader{
  list-style: none;
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
  display:inline-block;
  font-size: 14px;
 margin-right: 20px;
}

.navItem:hover{
  cursor: pointer;
  text-decoration: underline;
}

.logo-place,.navItem{
  color: rgba(0,0,0,0.68);
}

.logo-place{
  font-size: 20px;
}
</style>
