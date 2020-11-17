<template>
  <div class="app-container">
    <textarea id="editor" rows="10" cols="80"></textarea>
  </div>
</template>

<script>
  import CKEDITOR from 'CKEDITOR';
  export default {
      name:"ckEditor",
      data(){
        return {
          editor: null,
        }
      },
        methods:{
          initEditor(){
            CKEDITOR.replace('editor',{
              language:"en",
              height: this.height,
              width: '100%',
              toolbar: 'toolbar_Full',
              extraPlugins: 'codesnippet',
              codeSnippet_theme: 'zenburn'
            });
            this.editor = CKEDITOR.instances.editor;
            this.editor.setData(this.content); //初始化内容
          }
        },
      mounted(){
          this.initEditor();
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
