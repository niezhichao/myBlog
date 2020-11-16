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
  import CKEditor from '@ckeditor/ckeditor5-build-decoupled-document';
  import CodeBlock from '@ckeditor/ckeditor5-code-block/src/codeblock';

  export default {
      name:"ckEditor",
      data(){
        return {
          editor: null,
        }
      },
        methods:{
          initEditor(){
            CKEditor.create(document.querySelector( '#editor'),{
              plugins:[CodeBlock],
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
                  "mediaEmbed",
                  "codeBlock"
                ]
              }
            }).then(
              editor =>{
                this.editor = editor;
                const toolbarContainer = document.querySelector( '#toolbar-container');
                toolbarContainer.appendChild( editor.ui.view.toolbar.element);
              }
            ).catch(error=>{
              console.log(error);
            })
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
