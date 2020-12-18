import request from "../utils/request";

export function getArticleInfoById(param) {
    return request({
      url: process.env.GATEWAY_API + 'web-api/art/info',
      method: "get",
      params: param
    });
}
