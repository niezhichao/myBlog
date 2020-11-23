<template>
  <div class="app-container">
    <ckeditor id="editor"  v-model="editorData" :config="editorConfig"></ckeditor>
  </div>
</template>

<script>
    export default {
      props:["content","height"],
        data(){
          return {
            editor: null,
            editorData:"",
            editorConfig:{
              extraPlugins:"uploadimage,button,panelbutton,colorbutton",
              uploadUrl: process.env.GATEWAY_API+'file/upload1',
              language:"en",
              height :this.height,
              toolbarGroups:[
                { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
                { name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
                { name: 'links', groups: [ 'links' ] },
                { name: 'insert', groups: [ 'insert' ] },
                { name: 'forms', groups: [ 'forms' ] },
                { name: 'tools', groups: [ 'tools' ] },
                { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
                { name: 'others', groups: [ 'others' ] },
                '/',
                { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
                { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
                { name: 'styles', groups: [ 'styles' ] },
                { name: 'colors', groups: [ 'colors' ] },
                { name: 'about', groups: [ 'about' ] }
              ]
            }
          }
        },
      mounted(){

      },
      watch: {
        content() {
          this.editorData = this.content;
        }
      },
      methods:{
        getData: function() {
          return this.editorData;
        },
        setData:function(val) {
          this.editorData = val;
        },
        }
    }
</script>

<style scoped>

</style>
