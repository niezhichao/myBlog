import { Message } from 'element-ui';
const COMMON_CODE={
  /**
   * 是否发布
   * @type {{}}
   */
  IF_PUBLIC: {
    YES: "1",
    NO: "0"
  },
  /**
   * 请求结果 码值
   * @type {{SUCCESS: string}}
   */
  RESULT_CODE:{
    SUCCESS :"0000",
    ERROR:"0001",
    SYSTEM_ERROR:"0002",
    FILE_UPLOAD_SUCCESS:"FU000",
    FILE_UPLOAD_FAILED:"FU001",
    FILE_UPLOAD_EMPTY:"FU002"
  },
  KEY_UTILS:{
    TRACEID_KEY:"X-B3-TraceId",
    REQUEST_ID_KEY:"requestId",
    ERQUEST_URI_KEY:"requestUri",
    RESULT_EXCEPTION_KEY:"exception"
  }
}


const FUNCTION_UTILS={
  /**
   * 通用提示信息
   * @type {{success: message.success, warning: message.warning, error: message.error, info: message.info}}
   */
  message: {
    success: function(message) {
      Message({
        showClose: true,
        message: message || '成功',
        type: 'success'
      })
    },
    warning: function(message) {
      Message({
        showClose: true,
        message: message || '警告',
        type: 'warning'
      })
    },
    info: function(message) {
      Message({
        showClose: true,
        message: message || '提示'
      })
    },
    error: function(message) {
      Message({
        showClose: true,
        message: message || '异常',
        type: 'error',
        duration:0
      })
    }
  }
}

export default {
  install(Vue,options){
    Vue.prototype.$COMMON_CODE = COMMON_CODE;
    Vue.prototype.$FUCTION_UTILS = FUNCTION_UTILS;
  }
}
