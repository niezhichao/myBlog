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
    FILE_UPLOAD_SUCCESS:"FU000",
    FILE_UPLOAD_FAILED:"FU001",
    FILE_UPLOAD_EMPTY:"FU002"
  }
}

export default {
  install(Vue,options){
    Vue.prototype.$COMMON_CODE = COMMON_CODE;
  }
}
