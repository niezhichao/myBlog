

/**
 * 是否发布
 * @type {{}}
 */
const IfPublic = {
  YES: "1",
  NO: "0"
}

/**
 * 请求结果 码值
 * @type {{SUCCESS: string}}
 */
const RESULTCODE = {
    SUCCESS :"00"
}

export default {
  install(Vue,options){
    Vue.prototype.$IfPublic = IfPublic;
  }
}
