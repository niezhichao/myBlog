<template>
    <div class="rightSide-main">
          <!------------------------右边栏 登录信息框---------->
          <div class="login-info">
            <div class="userIcon">
              <svg-icon  icon-class="user1" class-name="card-panel-icon"></svg-icon>
            </div>
              <span style="display: block;margin-top:10px;padding-left:102px;font-family: 黑体;font-weight: bold;font-size: 18px;">Api Caller</span>

            <ul class="userInfoList">
              <li>
                <i class="el-icon-star-off"></i>
                <span style="font-family: 楷体;">Java开发从业者</span>
              </li>
              <li>
                <i class="el-icon-chat-line-round"></i>
                <span style="font-family: 楷体;">Java/Linux/数据库....</span>
              </li>
            </ul>
          </div>

      <!------------------------右边栏 最近更新提示---------->
      <div class="recentlyUpdate">
        <span style="display:block;padding-top:10px;padding-left: 10px;font-family: 黑体;font-weight: bold;font-size: 18px;">最近更新</span>
        <el-divider></el-divider>
            <ul class="recentlyUpdateUl">
              <li class="textOverflowStyle" v-for="item,index in dataList">
               <span class="circleIndex">{{index+1}}</span>
                <span @click="skipToDetailPage(item.pid)" class="style_title">{{item.title}}</span>
              </li>
            </ul>
      </div>
    </div>
</template>

<script>
    export default {
        name: "rightSide",
        props:["dataList"],
        data(){
          return {

          }
        },
      methods:{
        skipToDetailPage(val){
          console.log(val);
        }
      }
    }
</script>

<style scoped>
  .rightSide-main{
    width: 300px;
    margin-right: 100px;
    }

  .login-info{
    height: 300px;
    background-color: white;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
  }
  .userIcon{
    padding-left: 125px;
    padding-top: 50px;
  }
  .card-panel-icon{
    font-size: 48px;
  }

  .userInfoList{
    list-style-type:none;
    margin-left: 40px;
  }

  .userInfoList li{
    margin-top: 10px;
  }

  .recentlyUpdate{
    margin-top: 30px;
    min-height: 200px;
    background-color: white;
    box-shadow:0 1px 5px  rgba(9,31,35,0.47);
  }

  ul.recentlyUpdateUl{
    padding-left:10px;
    padding-bottom: 15px;
  }

  /*超出的文字用...*/
  ul.recentlyUpdateUl li{
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
    margin-bottom: 10px;
  }


  /*圆圈数字效果*/
  .circleIndex{
    color: rgba(13,25,31,0.5);
    display: inline-block;
    border-radius: 20px;
    width: 20px;
    height: 20px;
    text-align: center;
    vertical-align: middle;
    border: rgba(13,25,31,0.5) solid 1px;
  }

  span.style_title:hover{
    cursor: pointer;
    color: #409eff;
  }
</style>
