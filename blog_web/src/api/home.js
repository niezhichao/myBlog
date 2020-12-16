import request from "../utils/request";

/**
 * 获取顶部菜单
 */
export function getHomeHeaderMenu() {
  return request({
    url: process.env.GATEWAY_API + 'web-api/home/header',
    method: "get",
    data: null
  })
}
