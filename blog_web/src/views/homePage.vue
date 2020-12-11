<template>
    <div class="homePage">
        <home-page-header/>
    </div>
</template>

<script>
  import homePageHeader from "../components/homePageHeader"
  import HomePageHeader from "../components/homePageHeader/index";
    export default {
        name: "homePage",
      components: {HomePageHeader},
      comments:{
          homePageHeader
        }
    }
</script>

<style scoped>

</style>
