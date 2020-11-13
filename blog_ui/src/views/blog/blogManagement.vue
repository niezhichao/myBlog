<template>
  <div class="blogManagementWrapper">
    <page-header :headerText="headerText"></page-header>
    <el-container>
      <el-header>
        <el-row :gutter="3" class="mainRow">
          <el-col :span="9">
            <el-button @click="toAddBlogPage" size="mini" type="primary"><i class="el-icon-plus"></i>新增</el-button>
            <el-button disabled size="mini" type="primary" plain><i class="el-icon-edit"></i>编辑</el-button>
            <el-button size="mini" type="danger" plain @click="deleteSelections"><i class="el-icon-delete"></i>删除
            </el-button>
            <el-button @click="refreshTable" size="mini"><i class="el-icon-refresh"></i>刷新</el-button>
          </el-col>
          <el-col :span="4">
            <el-input size="mini" placeholder="请输入文章标题" v-model="blogQuery.title" clearable></el-input>
          </el-col>
          <el-col :span="4">
            <el-select size="mini"
                       placeholder="选择分类名称"
                       clearable
                       @change="blogSortSelected"
                       v-model="blogQuery.blogSort.pid">
              <el-option
                v-for="item in blogSortOptions"
                :key="item.pid"
                :label="item.typeName"
                :value="item.pid"
              >
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="7">
            <el-button size="mini" type="primary" icon="el-icon-search" @click="searchBlog">搜索</el-button>
          </el-col>
        </el-row>
        <el-row class="mainRow">
          <el-col :span="12">
            <i class="el-icon-info" style="color: #409eff"></i><span class="promptText">当前表格已选择</span><span
            class="spectialText">{{this.ids.length}}</span><span class="promptText">项</span><span
            class="spectialText clearTableChoose" @click="toggleSelection">清空</span>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <div class="loadingWrapper">
          <el-table :data="blogList"
                    border height="390" style="width:100%"
                    highlight-current-row
                    v-loading="loading"
                    ref="blogListTable"
                    @selection-change="selectionChange"
                    element-loading-text="博客列表加载中">
            <el-table-column type="selection" width="50" fixed></el-table-column>
            <el-table-column type="index" width="50" label="序号" fixed></el-table-column>
            <el-table-column prop="title" show-overflow-tooltip fixed header-align="center" label="文章标题"
                             width="245"></el-table-column>
            <el-table-column prop="author" label="文章作者" width="100" header-align="center"></el-table-column>
            <el-table-column prop="createTime" show-overflow-tooltip label="创建时间" width="100"
                             header-align="center"></el-table-column>
            <el-table-column prop="updateTime" show-overflow-tooltip label="最后编辑时间" width="150"
                             header-align="center"></el-table-column>
            <el-table-column prop="publicTime" show-overflow-tooltip label="发布时间" width="100"
                             header-align="center"></el-table-column>
            <el-table-column label="文章分类" width="140" header-align="center">
              <template slot-scope="scope">
                <el-select disabled placeholder="无数据"
                           v-model="blogList[scope.$index].blogSort == null?'':blogList[scope.$index].blogSort.pid">
                  <el-option
                    v-for="item in blogSortOptions"
                    :key="item.pid"
                    :label="item.typeName"
                    :value="item.pid"
                  >
                  </el-option>
                </el-select>
              </template>
            </el-table-column>
            <el-table-column prop="ifPublish" label="是否发布" width="100" header-align="center">
              <template slot-scope="scope">
                <el-tag type="success" v-if="scope.row.ifPublish == '1'">已发布</el-tag>
                <el-tag type="danger" v-else>未发布</el-tag>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="270" fixed="right" header-align="center">
              <template slot-scope="scope">
                <el-button @click="deleteRow(scope.row)" size="mini" icon="el-icon-delete" type="danger">删除</el-button>
                <el-button @click="editRow(scope.row)" size="mini" icon="el-icon-edit" type="warning">编辑</el-button>
                <el-button size="mini" icon="el-icon-view" type="primary" disabled>预览</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-main>
      <el-footer>
        <template>
          <div class="paginationBlock">
            <el-pagination
              @current-change="handleCurrentChange"
              @size-change="handleSizeChange"
              :current-page="currentPage"
              :page-sizes="pageSizes"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="pageTotal"
            ></el-pagination>
          </div>
        </template>
      </el-footer>
    </el-container>

    <el-dialog
      title="编辑博客"
      :visible.sync="editBlogDialogVisible"
      width="800px"
      center
    >
      <el-form>
        <el-row>
          <el-col :span="24">
            <el-form-item prop="wzjj">
              <el-input v-model="editBlogData.title">
                <template slot="prepend">
                  <span style="color:#606266;">文章标题</span>
                </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item prop="wzjj">
              <el-input disabled>
                <template slot="prepend">
                  <span style="color:#606266;">文章简介</span>
                </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item prop="wzjj" >
              <el-input v-model="editBlogData.author" :disabled="disabledChange">
                <template slot="prepend">
                  <span style="color:#606266;">文章作者</span>
                </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item prop="wzjj" >
              <el-input v-model="editBlogData.articlesQuoted" :disabled="disabledChange">
                <template slot="prepend">
                  <span style="color:#606266;">文章来源</span>
                </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item>
              <span style="color: red">*</span><span>分类</span>
              <el-select
                @change="changeBlogSortOfEdit"
               v-model="editBlogData.blogSort.pid"
                size="mini"
               clearable
              >
              <el-option
                v-for="(item,index) in blogSortOptions"
                :key="index"
                :label="item.typeName"
                :value="item.pid"
              >
              </el-option>

            </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item>
              <span style="color: red">*</span><span>标签</span>
              <el-tag
                v-for="(item,index) in editBlogData.tags"
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
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <span style="color: red">*</span><span>是否发布</span>
            <el-radio size="mini"  v-model="editBlogData.ifPublish" label="1" >发布</el-radio>
            <el-radio size="mini"  v-model="editBlogData.ifPublish" label="0" >未发布</el-radio>
          </el-col>
          <el-col :span="12">
            <span style="color: red">*</span><span>是否原创</span>
            <el-radio size="mini"  v-model="editBlogData.ifOriginal" label="1" @change="radioChange">原创</el-radio>
            <el-radio size="mini"  v-model="editBlogData.ifOriginal" label="0" @change="radioChange">转载</el-radio>
          </el-col>
        </el-row>

        <el-row>
          <CKEditor ref="ckeditor" @content-change="eiditorChange"  :content="editBlogData.content"></CKEditor>
        </el-row>

      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="editBlogDialogVisible = false">关闭</el-button>
    <el-button type="primary" @click="editDataCommit">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import pageHeader from "../../components/pageHeader";
  import {getBlogLst, delBlogLst, delBlogById,updateBlog} from "../../api/blog";
  import {getBlogSortList} from "../../api/blogSort";
  import {getTagList} from "../../api/tag";
  import CKEditor from "../../components/CKEditor";

  export default {
    name: "blogManagement",
    components: {pageHeader, CKEditor},
    data() {
      return {
        disabledChange:true,
        editBlogDialogVisible: false,
        editBlogData: {
          blogSort:{}
        },
        ids: [],
        blogSortOptions: [],
        blogSortList: [],
        headerText: "文章管理|",
        blogList: [],
        artTags:[],
        blogQuery: {
          title: "",
          blogSort: {},
          pageSize: null,
          pageNum: null
        },
        pageSizes: [5, 10, 20, 50, 100],
        pageTotal: 0,
        pageSize: 10,
        currentPage: 1,
        loading: true
      }
    },
    methods: {
      eiditorChange(val){//子组件通知内容改变
        this.editBlogData.content= this.$refs.ckeditor.getData();
      },
      radioChange(val){
        if ("1" == val){
          this.disabledChange = true;
          return
        }
        this.disabledChange = false;
      },
      editDataCommit(){
        updateBlog(this.editBlogData).then(res => {
          if (res.data.resCode == "00") {
            this.$message({
              type: "success",
              message: res.data.resMsg
            });
          }
        }).catch(error => {
          this.$message({
            type: "error",
            message: error
          })
        });
      },
      handleArtTag:function (command) {
        var that = this;
        var item = that.artTags[command];
        var tagsArr = that.editBlogData.tags;
        if (tagsArr.some(val=> val.pid == item.pid))return //重复选择的标签 不新增
        item = {
          pid:item.pid,
          tagContent: item.tagContent
        }
        that.editBlogData.tags.push(item);
      },
      handleTagClose:function(tag){
        let tags = this.editBlogData.tags;
        tags.splice(tags.indexOf(tag),1);
      },
      changeBlogSortOfEdit(selection){
        var blogSort = {
          pid: selection
        };
        this.editBlogData.blogSort = blogSort;
      },
      refreshTable() {
        this.getBlogList();
      },
      toggleSelection() {

        this.$refs.blogListTable.clearSelection();
      },
      editRow(row) {
        console.log(row)
        this.editBlogDialogVisible = true;
        if ("0" == row.ifOriginal){
          this.disabledChange = false;
        }else{
          this.disabledChange = true;
        }
        let temp={};
        for (var key in row){
           temp[key] = row[key];
        }
        let blogSort= temp.blogSort;
        if (null == blogSort){
          temp.blogSort={};
        }
        this.editBlogData = temp;

      },
      deleteRow(row) {
        var param = {
          id: row.pid
        }
        delBlogById(param).then(res => {
          if (res.data.resCode == "00") {
            this.$message({
              type: "success",
              message: res.data.resMsg
            });
          }
        }).catch(error => {
          this.$message({
            type: "error",
            message: error
          })
        });
      },
      deleteSelections() {
        var ids = this.ids;
        if (ids.length < 1) {
          this.$message({
            type: "warning",
            message: "选择要删除的行"
          });
          return
        }
        var param = {
          ids: ids + ''
        }
        delBlogLst(param).then(res => {
          if (res.data.resCode == "00") {
            this.$message({
              type: "success",
              message: res.data.resMsg
            });
          }
        }).catch(error => {
          this.$message({
            type: "error",
            message: error
          })
        })
      },
      selectionChange(selection) {
        this.ids = [];
        for (var index in selection) {
          let item = selection[index];
          this.ids.push(item.pid);
        }
      },
      blogSortSelected(select) {
        var blogSort = {
          pid: select
        };
        this.blogQuery.blogSort = blogSort;
        this.getBlogList();
      },
      searchBlog() {
        this.getBlogList();
      },
      toAddBlogPage() {
        this.$router.push("/blog/add");
      },
      getBlogList: function () {
        this.blogQuery.pageSize = this.pageSize;
        this.blogQuery.pageNum = this.currentPage;
        getBlogLst(this.blogQuery).then(response => {
          if (response.data.resCode == "00") {
            this.loading = false;
            var page = response.data.page;
            this.blogList = page.data;
            this.pageTotal = page.total;
            this.pageSize = page.pageSize;
            this.currentPage = page.pageNum;
          }
        }).catch(error => {
          this.loading = false;
          this.$message({
            type: "error",
            message: error
          });
        });
      },
      getAllBlogSort() {
        getBlogSortList().then(httpResult => {
          if (httpResult.data.resCode == "00") {
            var resData = httpResult.data.response;
            this.blogSortOptions = resData;
          }
        }).catch(error => {
          this.loading = false;
          this.$message({
            type: "error",
            message: error
          });
        });
      },
      handleCurrentChange: function (val) {
        this.currentPage = val;
        this.getBlogList();
      },
      handleSizeChange: function (val) {
        this.pageSize = val;
        this.getBlogList();
      }
    },
    created() {
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
      this.getAllBlogSort();
      this.getBlogList();

    }
  }
</script>

<style scoped>
  .blogManagementWrapper {
    margin-top: 10px;
    height: 570px;
    border-bottom: 1px solid #d9ecff;
    background-color: ghostwhite;
    box-shadow: 5px 5px 3px white, 0 0 3px 0 whitesmoke;
  }

  .loadingWrapper {
    margin-top: 20px;
  }

  .promptText {
    font-family: "微软雅黑";
    font-size: small;
  }

  .spectialText {
    color: #409eff;
    font-size: small;
  }

  .clearTableChoose:hover {
    cursor: pointer;
  }

  .mainRow {
    margin-top: 20px;
  }
</style>
