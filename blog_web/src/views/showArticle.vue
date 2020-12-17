<template>
     <div class="showArticle-main">

       <div class="article-content">
         <div class="content-block"  v-html="blogContent" v-highlight>
           {{blogContent}}
         </div>
       </div>

       <div class="sideCatalog">

       </div>
     </div>
</template>

<script>
    export default {
        name: "showArticle",
      data(){
        return {
          blogContent:"<p style=\"margin-left:0px;\">&nbsp;</p><p style=\"margin-left:0px;\">&nbsp;</p><h2 style=\"margin-left:0px;text-align:center;\"><span class=\"text-big\">天天说要做性能优化，到底在优化什么？</span></h2><p style=\"margin-left:0px;\">面试过程中经常被问到：</p><ul><li>你做过性能优化吗?</li><li>优化了哪些方面？</li><li>怎么做优化的？</li><li>优化的效果如何？</li></ul><p style=\"margin-left:0px;\">连环炮问下来，对于有做过优化的老司机来说，肯定能抗住。对于没有真正做过优化的小白来说，肯定扛不住这一系列的追问，最后只能以面试失败而告终。</p><p style=\"margin-left:0px;\">那么性能优化到底在优化什么呢？我们来盘点下一些常用的优化手段。</p><h2 style=\"margin-left:0px;\"><strong>SQL 优化</strong></h2><p style=\"margin-left:0px;\">当你开发的接口响应时间超过了 200ms 的时候就得优化了，当然 200ms 不是绝对值，具体还是看应用场景。以 App 举例，进一个页面调用 5 个接口（题外话：也可以做聚合），那么总共就是 1s 的时间，对用户来说体验还算可以，当然是越快响应越好。</p><p style=\"margin-left:0px;\">接口耗时 200ms，其中占大头的还是对数据库的操作，一个接口中会有 N 次数据库操作。所以优化 SQL 的速度优先级是最高的，大量的慢 SQL 会拖垮整个系统。</p><p style=\"margin-left:0px;\">关于 SQL 的优化不是本文的重点，大部分慢 SQL 还是跟各位平时开发时的习惯有关系。大部分在写 SQL 的时候不太会去考虑性能，只要写出来就可以了，join 随手就来，也不梳理查询字段，不加索引，刚开始上线没问题，等到并发量，数据量起来的时候就凉凉了。</p><p style=\"margin-left:0px;\">关于数据库的使用规范大家可以参考下这篇文章：<a href=\"https://mp.weixin.qq.com/s/mFsK7YSKcG6T7jpPnK92tg\">https://mp.weixin.qq.com/s/mFsK7YSKcG6T7jpPnK92tg</a></p><p style=\"margin-left:0px;\">当数据量大了后肯定要做读写分离和分库分表的，这也是优化的必经之路。相关的文章也可以参考我之前写的一些：<a href=\"http://mp.weixin.qq.com/mp/homepage?__biz=MzIwMDY0Nzk2Mw==&amp;hid=4&amp;sn=1b96093ec951a5f997bdd3225e5f2fdf&amp;scene=18#wechat_redirect\">http://mp.weixin.qq.com/mp/homepage?__biz=MzIwMDY0Nzk2Mw==&amp;hid=4&amp;sn=1b96093ec951a5f997bdd3225e5f2fdf&amp;scene=18#wechat_redirect</a></p><p style=\"margin-left:0px;\">&nbsp;</p><h2 style=\"margin-left:0px;\"><span style=\"color:hsl(120,75%,60%);\"><strong>减少重复调用</strong></span></h2><p style=\"margin-left:0px;\">性能不好的另一个致命问题就是重复调用，相同的逻辑在不同的方法中重复对数据库查询，重复调用 RPC 服务等。</p><p style=\"margin-left:0px;\">比如下面的代码：</p><p style=\"margin-left:0px;\">&nbsp;</p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">skuDao</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">querySkus</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">productId</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">).</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">stream</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">().</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">map</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">sku </span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">-&gt;</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\"> </span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">{</span></p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">skuDao</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">getById</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">sku</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">getId</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">());</span></p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">})</span></p><p style=\"margin-left:0px;\">&nbsp;</p><p style=\"margin-left:0px;\">&nbsp;</p><p style=\"margin-left:0px;\">面试过程中经常被问到：</p><ul><li>你做过性能优化吗?</li><li>优化了哪些方面？</li><li>怎么做优化的？</li><li>优化的效果如何？</li></ul><p style=\"margin-left:0px;\">连环炮问下来，对于有做过优化的老司机来说，肯定能抗住。对于没有真正做过优化的小白来说，肯定扛不住这一系列的追问，最后只能以面试失败而告终。</p><p style=\"margin-left:0px;\">那么性能优化到底在优化什么呢？我们来盘点下一些常用的优化手段。</p><h3 style=\"margin-left:0px;\"><span style=\"font-family:'Courier New', Courier, monospace;\"><i><strong>SQL 优化</strong></i></span></h3><p style=\"margin-left:0px;\">当你开发的接口响应时间超过了 200ms 的时候就得优化了，当然 200ms 不是绝对值，具体还是看应用场景。以 App 举例，进一个页面调用 5 个接口（题外话：也可以做聚合），那么总共就是 1s 的时间，对用户来说体验还算可以，当然是越快响应越好。</p><p style=\"margin-left:0px;\">接口耗时 200ms，其中占大头的还是对数据库的操作，一个接口中会有 N 次数据库操作。所以优化 SQL 的速度优先级是最高的，大量的慢 SQL 会拖垮整个系统。</p><p style=\"margin-left:0px;\">关于 SQL 的优化不是本文的重点，大部分慢 SQL 还是跟各位平时开发时的习惯有关系。大部分在写 SQL 的时候不太会去考虑性能，只要写出来就可以了，join 随手就来，也不梳理查询字段，不加索引，刚开始上线没问题，等到并发量，数据量起来的时候就凉凉了。</p><p style=\"margin-left:0px;\">关于数据库的使用规范大家可以参考下这篇文章：<a href=\"https://mp.weixin.qq.com/s/mFsK7YSKcG6T7jpPnK92tg\">https://mp.weixin.qq.com/s/mFsK7YSKcG6T7jpPnK92tg</a></p><p style=\"margin-left:0px;\">当数据量大了后肯定要做读写分离和分库分表的，这也是优化的必经之路。相关的文章也可以参考我之前写的一些：<a href=\"http://mp.weixin.qq.com/mp/homepage?__biz=MzIwMDY0Nzk2Mw==&amp;hid=4&amp;sn=1b96093ec951a5f997bdd3225e5f2fdf&amp;scene=18#wechat_redirect\">http://mp.weixin.qq.com/mp/homepage?__biz=MzIwMDY0Nzk2Mw==&amp;hid=4&amp;sn=1b96093ec951a5f997bdd3225e5f2fdf&amp;scene=18#wechat_redirect</a></p><p style=\"margin-left:0px;\">&nbsp;</p><h2 style=\"margin-left:0px;\"><strong>减少重复调用</strong></h2><p style=\"margin-left:0px;\">性能不好的另一个致命问题就是重复调用，相同的逻辑在不同的方法中重复对数据库查询，重复调用 RPC 服务等。</p><p style=\"margin-left:0px;\">比如下面的代码：</p><p style=\"margin-left:0px;\">&nbsp;</p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">skuDao</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">querySkus</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">productId</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">).</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">stream</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">().</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">map</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">sku </span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">-&gt;</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\"> </span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">{</span></p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">skuDao</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">getById</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">(</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">sku</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">.</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(0,0,0);\">getId</span><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">());</span></p><p style=\"margin-left:40px;\"><span style=\"background-color:hsl(0,0%,100%);color:rgb(102,102,0);\">})</span></p><p style=\"margin-left:0px;\">&nbsp;</p>"
        }
      },
      methods:{
          initArticleContent(){

          }
      },
      mounted(){
        this.initArticleContent();
      }
    }
</script>

<style scoped>

  .showArticle-main{

  }

  .article-content{
    width: 60%;
    margin-left: 40px;
    margin-top: 10px;
    float: left;
    position: relative;
  }
  .content-block{
    background-color: white;
    padding-left: 10px;
    padding-right: 10px;
    min-height: 700px;
  }
</style>
