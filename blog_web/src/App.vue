<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  html,body{
    height: 100%;
    width: 100%;
    overflow-x: hidden;
    padding:0;
    margin:0;
    font: 14px Helvetica Neue, Helvetica, PingFang SC, Tahoma, Arial, sans-serif;
  }

  #app{
    height: 100%;
    width: 100%;
  }

  #app .homePage{
    height: 100%;
    width: 100%;
    background-color: rgba(26,71,60,0.15);
  }
</style>
