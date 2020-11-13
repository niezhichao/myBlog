<template>
    <el-scrollbar wrapClass="scrollbar-wrapper">
    <el-menu mode="vertical"
             background-color="#304156"
             text-color="#bfcbd9"
             active-text-color="#409EFF"
    >
      <!--<router-link to="/">
      <el-menu-item>
          <i class="el-icon-s-home"></i>
          <span slot="title">首页</span>
      </el-menu-item>
      </router-link>-->
      <sidebar-item :items="items"></sidebar-item>
    </el-menu>
    </el-scrollbar>
</template>

<script>
  import SidebarItem from './SidebarItem'
    export default {
      components: {SidebarItem},
      props:{
          items:{
            type: Array
          }
      },
      methods:{

      }
    }
</script>

<style scoped>

</style>
