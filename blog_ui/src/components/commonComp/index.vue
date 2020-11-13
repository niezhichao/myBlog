<template>
  <div class="commonCmp">
    <el-row :class="tableHead">
      <el-col :span="20">
        <span class="overTableInfo">{{compName}}</span>
      </el-col>
      <el-col :span="4">
        <el-button class="overTableBtn" @click="dialogVisibleChange" type="info" size="mini" round>添加
        </el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <el-table
          :data="typeTableData.data"
          border
          height="350" style="width:100%"
          highlight-current-row
        >
          <el-table-column type="selection"></el-table-column>
          <el-table-column type="index" width="50" label="序号"></el-table-column>
          <el-table-column v-for="(item,index) in tableCols"
                           :key="item.prop+''+index"
                           show-overflow-tooltip
                           :prop="item.prop"
                           :label="item.label"
                           min-width="25%"
                           header-align="center"
          ></el-table-column>
          <el-table-column label="操作" min-width="40%" header-align="center">
            <template slot-scope="scope">
              <el-button size="mini" icon="el-icon-delete" type="danger" @click="deleteRow(scope.row)">删除</el-button>
              <el-button size="mini" icon="el-icon-edit" type="warning" @click="editRow(scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <el-row class="paginationBlock">
      <el-col :span="24">
        <el-pagination
          small
          :current-page="typeTableData.currentPage"
          :page-sizes="pageSizes"
          :page-size="typeTableData.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="typeTableData.total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
      </el-col>
    </el-row>

    <el-dialog
      center
      :visible.sync="dialogVisible"
      :title="compName"
    >

      `
      <el-form :model="editData" ref="editDataForm" :rules="rules">
        <el-row v-for="(item,index) in tableCols" :key="index">
          <el-col :span="3">
            <div class="prefix_input"><span style="color: red">*</span><span>{{item.label}}</span></div>
          </el-col>
          <el-col :span="21">
            <el-form-item :prop="item.prop">
              <el-input v-model="editData[item.prop]"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <el-row class="btnPanel">
        <el-col :span="24">
          <el-button @click="cancelDialog">取 消</el-button>
          <el-button type="primary" @click="submitData('editDataForm')">确 定</el-button>
        </el-col>
      </el-row>
    </el-dialog>

  </div>
</template>

<script>
  export default {
    name: "commonComp",
    /**
     * tableHead:不同用途 用不同的class。比如分类列表用classificationList
     * compName 列表名称
     * */
    props: ["tableHead",
      "compName",
      "tableCols",
      "dialogComponent",
      "typeTableData",
      "validateRules"
    ],
    data() {
      return {
        dialogVisible: false,
        dispatchFlag:false,//判断提交添加 还是编辑的数据
        editData: {},
        pageSizes: [5, 10, 20, 50, 100],
        currentPage: 1,
        pageSize: 10,
        total: 0,
        rules:this.validateRules
      }
    },
    methods: {
      dialogVisibleChange: function () {
        this.dispatchFlag = false;
        this.editData = {};
        this.dialogVisible = true;
      },
      editRow(val) {
        this.dispatchFlag = true;
        var temp = {};
        for (var item of this.tableCols) {//将选中行的值取出，赋值给编辑dialog的editData（直接赋值会传递引用导致改变列表的值）
          temp[item.prop] = val[item.prop];
          temp.pid = val.pid;
        }
        this.editData = temp;
        this.dialogVisible = true;
      },
      deleteRow(val){
        let id = val.pid;
         this.$emit("deleteData",id);
      },
      handleSizeChange(val) {
        this.$emit("pageSize-change", val)
      },
      handleCurrentChange(val) {
        this.$emit("pageNum-change", val);
      },
      submitData(val) {
        this.$refs[val].validate(valid =>{
          if (valid){
            if (this.dispatchFlag){
              this.$emit("updateData",this.editData);
              return
            }
            this.$emit("insertData",this.editData);
          }else {
            this.$message({
              message: '必输项不能为空',
              type: 'warning'
            });
            return false;
          }
        })
      },
      cancelDialog() {
        this.editData = {};
        this.dialogVisible = false;
      }
    }
  }
</script>

<style scoped>
  .blueHead {
    margin-top: 20px;
    min-height: 36px;
    background-color: #409EFF;
  }

  .redHead {
    margin-top: 20px;
    min-height: 36px;
    background-color: #F56C6C;
  }

  .prefix_input{
    margin-top: 5px;
  }

  .overTableInfo {
    color: white;
    font-family: DFKai-SB;
    margin-top: 9px;
    margin-left: 10px;
    display: inline-block;
  }

  .overTableBtn {
    margin-top: 4px;
  }

  .paginationBlock {
    margin-top: 20px;
  }

  .btnPanel {
    text-align: center;
    margin-top: 20px;
  }
</style>

