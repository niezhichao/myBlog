import request from "../utils/request";

/*首页博客简介*/
export function getHomePageIntros() {
  return request({
    url: process.env.GATEWAY_API + 'web-api/intro/home',
    method: "get",
    data: null
  })
}

/*首页博客简介 分类名称查询*/
export function getHomePageIntrosBySortId(param) {
  return request({
    url: process.env.GATEWAY_API + 'web-api/intro/sort',
    method: "get",
    params: param
  })
}
