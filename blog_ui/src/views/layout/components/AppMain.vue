<template>
  <div class="app-main">
    <router-view/>
  </div>

</template>

<script>
    export default {
        name: "appmain"
    }
</script>

<style scoped>
  .app-main {
    min-height: calc(100vh - 50px);
    position: relative;
    overflow: hidden;
  }
</style>
