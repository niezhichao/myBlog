<template>
	<div class="app-wrapper">
		<sidebar class="sidebar-container" :items="items"></sidebar>
    <div class="main-container">
      <navbar/>
      <tabsview/>
      <appmain/>
    </div>
	</div>
</template>

<script>
	import {Sidebar,Navbar} from "./components";
  import appmain from "./components/AppMain";
  import tabsview from  "./components/TabsView"

	export default {
		name: "Layout",
		components:{
      appmain,
      Sidebar,
      Navbar,
      tabsview
		},
		data(){
			return {
				items:[
          {
            name:"首页",
            icon:"el-icon-s-home",
            url:"/dashboard"
          },
				  {
              name:"发布文章",
              icon:"el-icon-edit",
              url:"/blog/add"
        },
          {
            name:"文章管理",
            icon:"el-icon-document",
            url:"/blog/mananger"
          },{
            name:"分类/标签",
            icon:"el-icon-price-tag",
            url:"/typeAndTags/manager"
          },
          {
            name:"接口管理",
            icon:"el-icon-stopwatch",
            childList:[{
              name:"Admin模块接口",
              icon:"el-icon-menu",
              url:"/swagger/adminApi"
            }]
          }]
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import "../../styles/mixin.scss";
.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;
  &.mobile.openSidebar {
    position: fixed;
    top: 0;
  }
}
.drawer-bg {
  background: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}
</style>
