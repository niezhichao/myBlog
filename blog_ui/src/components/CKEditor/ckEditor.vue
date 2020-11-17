<template>
  <div class="app-container">

    <!-- 工具栏容器 -->
    <div id="toolbar-container"></div>

    <!-- 编辑器容器 -->
    <div id="editor" ref="editor">
    </div>
  </div>
</template>

<script>
  /*import DecoupledEditor from '@ckeditor/ckeditor5-editor-decoupled/src/decouplededitor';*/
  export default {
      name:"ckEditor",
      data(){
        return {
          editor: null,
        }
      },
        methods:{
          initEditor(){
            /*DecoupledEditor.create(document.querySelector( '#editor'),{
              toolbar:{
                items:[
                  "heading",
                  "|",
                  "bold",
                  "italic",
                  "link",
                  "bulletedList",
                  "numberedList",
                  "imageUpload",
                  "blockQuote",
                  "insertTable",
                  "mediaEmbed"
                ]
              }
            }).then(
              editor =>{
                this.editor = editor;
                console.log(Array.from( editor.ui.componentFactory.names() ));
              }
            ).catch(error=>{
              console.log(error);
            })*/
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
