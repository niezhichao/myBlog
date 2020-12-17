import request from "../utils/request";

export function getHomePageIntros() {
  return request({
    url: process.env.GATEWAY_API + 'web-api/intro/home',
    method: "get",
    data: null
  })
}
