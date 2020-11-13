<template>
	<div class="menu-wrapper">
    <template v-for="(item,index) in items" v-if="items.length>0">
      <template v-if="item.childList">
        <el-submenu :key="index" :index="index+''">
          <template slot="title">
            <i v-if="item.icon" :class="item.icon"></i>
            <span v-if="item.name" >{{item.name}}</span>
          </template>

          <template v-for="(child,index2) in item.childList">
            <el-menu-item :index="child.url" :key="child.name" @click="goTo(child)">
              <i v-if="child.icon" :class="child.icon"></i>
              <span v-if="child.name" slot="title">{{child.name}}</span>
            </el-menu-item>
          </template>
        </el-submenu>
      </template>
      <template v-else>
         <el-menu-item  :key="index" :index="index+''" @click="goTo(item)">
           <i  v-if="item.icon" :class="item.icon"></i>
           <span slot="title">{{item.name}}</span>
         </el-menu-item>
      </template>
    </template>
	</div>
</template>

<script>

  export  default {
    name: 'SidebarItem',
    props:{
      items:{
        type:Array
      }
    },
    methods:{
      goTo: function (val) {
        this.$router.push({path:val.url});
      }
    }
  }

</script>

<style scoped>
  .shouye{
    color: #fbfdff;
  }
</style>
