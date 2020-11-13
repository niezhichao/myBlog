<template>
  <div class="dashboard-editor-container">
    <el-menu class="navbar" mode="horizontal">
      <el-row>
        <el-col :span="1" style="padding-left: 20px">
          <!--首页 图标-->
          <template>
            <router-link to="/">
              <i class="el-icon-menu" style="color: #304156;"></i>
            </router-link>
          </template>
        </el-col>
        <el-col :span="20">
          <breadcrumb/>
        </el-col>
        <el-col :span="3">
          <i class="el-icon-user-solid"></i>
          <el-dropdown class="avatar-container" trigger="click">
            <span class="el-dropdown-link">
             121414
              <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
            <el-dropdown-menu slot="dropdown" class="user-dropdown">
              <el-dropdown-item>
                <span style="display:block;">关于我</span>
              </el-dropdown-item>
              <el-dropdown-item divided>
                <span style="display:block;">更新日志</span>
              </el-dropdown-item>
              <el-dropdown-item divided>
                <span style="display:block;">退出</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-menu>
  </div>
</template>

<script>
  import ThemePicker from "@/components/ThemePicker";
  import Breadcrumb from "@/components/Breadcrumb"

  export default {
    components: {
      ThemePicker,
      Breadcrumb
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .el-row{
    height: 25px;
  }
  .navbar{
    margin-top: 15px;
  }
</style>
