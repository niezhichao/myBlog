<template>
  <div class="tagListDialog">
    <el-form :model="tagVoEdit" ref="tagVoEdit" :rules="rules">
    <el-row>
      <el-col :span="3">
        <div class="prefix_input"><span style="color: red">*</span><span>标签名称</span></div>
      </el-col>
      <el-col :span="21">
        <el-form-item prop="tagContent">
        <el-input v-model="tagVoEdit.tagContent"></el-input>
        </el-form-item>
      </el-col>
    </el-row>

    <el-row class="btnPanel">
      <el-col :span="24">
        <el-button @click="cancelDialog">取 消</el-button>
        <el-button type="primary" @click="submitTagObj('tagVoEdit')">确 定</el-button>
      </el-col>
    </el-row>
    </el-form>
  </div>
</template>

<script>
  import {addTag} from '../../api/tag'
    export default {
        name: "tagListDialog",
        props:["tagVoEdit"],
       data(){
          return {
              tagVo:{},
            rules:{
              tagContent:{
                required: true, message: '请输入标签名称', trigger: 'blur'
              }
            }
          }
       },
      methods:{
        cancelDialog:function () {
          this.$emit("cancel-dialog");
        },
        submitTagObj(val){
          this.$refs[val].validate(valid =>{

            if (valid){
              var param =this.tagVoEdit;
              addTag(param).then(res=>{
                if (res.data.resCode=="00"){
                  this.$message({
                    type: "success",
                    message: res.data.resMsg
                  })
                }
              }).catch(error=>{
                this.$message({
                  type: "error",
                  message: error
                });
              })
            }else {
              this.$message({
                message: '必输项不能为空',
                type: 'warning'
              });
              return false;
            }
          })
        }
      }
    }
</script>

<style scoped>
  .prefix_input{
    margin-top: 10px;
  }
  .btnPanel{
    text-align: center;
    margin-top: 20px;
  }
</style>
