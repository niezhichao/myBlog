<template>
    <div class="blogCreatedWrapper">
          <page-header :headerText="headerText"></page-header>
      <el-form>
        <el-row :gutter="20">
            <el-col :span="10">
              <el-input v-model="blogInfo.title">
                <template slot="prepend">
                  <span style="color:#606266;" >文章标题</span>
                </template>
              </el-input>
            </el-col>
          <el-col :span="10">
            <el-input v-model="blogInfo.author" :disabled="disabledChange">
              <template slot="prepend">
                <span style="color:#606266">文章作者</span>
              </template>
            </el-input>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="10">
              <el-select size="small" v-model="blogInfo.blogSort.pid" style="width: 150px"  placeholder="请选择文章分类">
                <el-option
                  v-for="item,index in blogTypes"
                  :key="index"
                  :label="item.typeName"
                  :value="item.pid"
                >

                </el-option>
              </el-select>

            <el-tag
              v-for="(item,index) in blogInfo.tags"
            :key="item.pid"
              closable
              @close="handleTagClose"
            >
              {{item.tagContent}}
            </el-tag>
            <el-dropdown @command="handleArtTag">
              <el-button round size="small"  style="border-color: rgba(145,157,198,0.49);">
                <i class="el-icon-plus" style="color: #1f2d3d"></i>
                <span>文章标签</span>
              </el-button>
              <el-dropdown-menu slot="dropdown" size="medium" >
                <template v-for="(item,index) in artTags">
                  <el-dropdown-item :command="index" >{{item.tagContent}}</el-dropdown-item>
                </template>
              </el-dropdown-menu>
            </el-dropdown>
          </el-col>
          <el-col :span="10">
            <el-input v-model="blogInfo.articlesQuoted" :disabled="disabledChange">
              <template slot="prepend">
                <span style="color:#606266 ">文章来源</span>
              </template>
            </el-input>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6" >
               <span style="color: red">*</span><span>是否原创</span>
               <el-radio size="mini"  v-model="blogInfo.ifOriginal" @change="redioChange"  label="1" >原创</el-radio>
               <el-radio size="mini"  v-model="blogInfo.ifOriginal"  label="0" @change="redioChange" >转载</el-radio>
          </el-col>
        </el-row>

        <el-row>
          <CKEditor ref="ckeditor"></CKEditor>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="18">
            <el-button @click="draftArticle">草稿</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="success" @click="publishArticle">发布</el-button>
          </el-col>
        </el-row>
      </el-form>
    </div>
</template>

<script>
  import CKEditor from "../../components/CKEditor";
  import {addBlog} from "../../api/blog";
  import {getBlogSortList} from "../../api/blogSort";
  import {getTagList} from "../../api/tag";
  import pageHeader from "../../components/pageHeader";
  export default {
        name: "blogcreated",
      components:{
        CKEditor,
        pageHeader
      },
      data(){
          return {
            headerText: "文章发布|",
            disabledChange:true,
            blogInfo:{
              ifOriginal:"1",
              title: null,
              author: null,
              blogSort: {},
              tags: [],
              articlesQuoted: null,
              content: null,
              ifPublish: null
            },
            blogTypes:[],
            artTag:"",
            artTags:[]
          }
      },
      methods:{
        redioChange(val){
          if ("1" == val){
            this.disabledChange = true;
            return
          }
          this.disabledChange = false;
        },
        handleArtTag:function (command) {
          var that = this;
          var item = that.artTags[command];
          var tagsArr = that.blogInfo.tags;
          if (tagsArr.some(val=> val.pid == item.pid))return //重复选择的标签 不新增
          item = {
            pid:item.pid,
            tagContent: item.tagContent
          }
          that.blogInfo.tags.push(item);
        },
        handleTagClose:function(tag){
         let tags = this.blogInfo.tags;
          tags.splice(tags.indexOf(tag),1);
        },
        publishArticle: function () {
          this.blogInfo.content = this.$refs.ckeditor.getData();
          this.blogInfo.ifPublish = this.$IfPublic.YES;

         addBlog(this.blogInfo).then(response => {
            if (response.data.resCode == "00"){
              this.$message({
                type: "success",
                message: response.data.resMsg
              })
            }
          }).catch(error=>{
           this.$message({
             type:"warning",
             message:error
           });
         })
        },
        draftArticle:function () {
          this.blogInfo.content = this.$refs.ckeditor.getData();
          this.blogInfo.ifPublish = this.$IfPublic.NO;
          addBlog(this.blogInfo).then(response => {
            if (response.data.resCode == "00"){
              this.$message({
                type: "success",
                message: response.data.resMsg
              })
            }
          }).catch(error=>{
            this.$message({
              type:"warning",
              message:error
            });
          })
        }
      },
      mounted() {

          /*获取博客类型列表*/
        getBlogSortList().then(response =>{

          if (response.data.resCode == "00") {
            this.blogTypes = response.data.response;
          }
        }).catch(error =>{
          this.$message({
            type: "error",
            message: error
          });
        });

        /*获取标签列表*/
        getTagList().then(response =>{
          if (response.data.resCode == "00") {
            this.artTags = response.data.response;
          }
        }).catch(error =>{
          this.$message({
            type: "error",
            message: error
          });
        });
      }
    }
</script>

<style scoped>
 .blogCreatedWrapper{
   margin-top: 20px;
   height: 570px;
   border-bottom: 1px solid #d9ecff;
   background-color: rgba(193,226,161,0.25);
   box-shadow: 5px 5px 3px 0 rgba(0, 0, 0, .12), 0 0 3px 0 rgba(0, 0, 0, .04);
 }

  .el-row{
    margin-bottom:10px;
  }

  .col-style{
    border-radius: 4px;
    min-height: 36px;
  }

 .el-icon-close:hover{
   cursor: pointer;
 }

  .font-bg{
    background: #909399;
  }

 .el-tag {
   margin-left: 5px;
 }
</style>
