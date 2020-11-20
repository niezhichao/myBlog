<template>
  <div class="app-container">
    <textarea id="editor" rows="10" cols="80"></textarea>
  </div>
</template>

<script>
  import CKEDITOR from 'CKEDITOR';
    export default {
      props:["content","height"],
        data(){
          return {
            editor: null,
          }
        },
      mounted(){
        this.initCKEditor();
      },
      watch:{
        content(){
          this.setData(this.content);
        }
      },
      methods:{
        initCKEditor() {
          var that = this;
          CKEDITOR.replace('editor',{
            language:"en",
            height: this.height,
            width: '100%',
            extraPlugins: 'easyimage',
            toolbar: 'toolbar_Full',
            codeSnippet_theme: 'zenburn',
            image_previewText:"",
            cloudServices_uploadUrl: process.env.GATEWAY_API +'file/upload1'
          });
          this.editor = CKEDITOR.instances.editor;
          this.editor.setData(this.content); //初始化内容
          /*that.editor.on('change', function( event ) {
              that.contentChange();
          });*/
        },
        getData: function() {
           return this.editor.getData();
        },
        setData:function(val) {
          this.editor.setData(val);
        },
        contentChange(){
          this.$emit("content-change","");
        }
      }
    }
</script>

<style scoped>

  #editor{
    background-color: white;
    height: 245px;
    border: solid 1px;
  }
</style>
