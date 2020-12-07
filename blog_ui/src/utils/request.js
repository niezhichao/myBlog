import axios from 'axios';

import { Message, MessageBox, Loading } from 'element-ui';
import Vue from 'vue';

const COMMON_CODE=Vue.prototype.$COMMON_CODE;
const FUCTION_UTILS = Vue.prototype.$FUCTION_UTILS;

const service = axios.create({
  baseURL: '',
  withCredentials: true,
  timeout: 100000 // 请求超时时间
});

var loading = null;

// request拦截器
service.interceptors.request.use(
  function (config) {

    if(loading == null) {
      loading = Loading.service({ fullscreen: true, text:'正在努力加载中~' });
    } else if (loading != null) {
      loading = Loading.service({ fullscreen: true, text:'正在努力加载中~' });
    }
    return config
  },
  function (error) {
    Promise.reject(error);
    // 出错了直接关闭loading
    if(loading) {
      loading.close();
    }
    FUCTION_UTILS.message.error(errorMsg);
  }
);

// response 拦截器
service.interceptors.response.use(
  function (response) {
    const res = response.data;
    loading.close();

    if (res){
     var code = res.resCode;
     if (code === COMMON_CODE.RESULT_CODE.SUCCESS || code === COMMON_CODE.RESULT_CODE.FILE_UPLOAD_SUCCESS){//成功直接返回结果
       return res;
     }

      var msg = res.response;
      var traceId = msg[COMMON_CODE.KEY_UTILS.TRACEID_KEY];
      var requestId = msg[COMMON_CODE.KEY_UTILS.REQUEST_ID_KEY];
      var requestURI = msg[COMMON_CODE.KEY_UTILS.ERQUEST_URI_KEY];
      var exceptionDesc = msg[COMMON_CODE.KEY_UTILS.RESULT_EXCEPTION_KEY];
      var errorMsg = res.resMsg+":      "+"[Zipkin TraceId: "+traceId+"]  "+
        "[Request Id: "+requestId+"] "+"[Request URI: "+requestURI+"] ";

      if (code === COMMON_CODE.RESULT_CODE.ERROR){//自定义异常要提示自定义异常信息 和相关Id
        FUCTION_UTILS.message.error(errorMsg+" ["+exceptionDesc+"]");
      }else {//其他异常只提示相关的id
        FUCTION_UTILS.message.error(errorMsg);
      }

      return res;
    }else{
      loading.close();
      return Promise.reject('error')
    }
  },
  function (error) {

    loading.close();
    Message({
      message: error,
      type: 'error',
      duration: 0
    })
    return Promise.reject(error)
  }
);

export default service
