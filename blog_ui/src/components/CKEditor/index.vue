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
            toolbar: 'toolbar_Full',
            extraPlugins: 'codesnippet',
            codeSnippet_theme: 'zenburn',
            image_previewText:"",
            pasteUploadFileApi: "",

            extraAllowedContent: 'h3{clear};h2{line-height};h2 h3{margin-left,margin-top}',

            uploadUrl: process.env.GATEWAY_API + 'file-api/file/upload1'+'?command=QuickUpload&type=Files&responseType=json',

            // Configure your file manager integration. This example uses CKFinder 3 for PHP.
            filebrowserBrowseUrl: '/apps/ckfinder/3.4.5/ckfinder.html',
            filebrowserImageBrowseUrl: '/apps/ckfinder/3.4.5/ckfinder.html?type=Images',
           filebrowserUploadUrl: process.env.GATEWAY_API + 'file-api/file/upload1'+'?command=QuickUpload&type=Files',
            filebrowserImageUploadUrl: process.env.GATEWAY_API + 'file-api/file/upload1'+'?command=QuickUpload&type=Images',
            removeDialogTabs: 'image:advanced;link:advanced'
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
