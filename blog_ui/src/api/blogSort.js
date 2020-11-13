import request from "../utils/request";

/**
 * 获取所有分类  不含分页
 * @param param
 */
export function getBlogSortList() {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blogSort/all',
    method: 'get',
    params: null
  });
}


export function addBlogSort(param) {
  return request({
    url: process.env.GATEWAY_API + 'admin-api/blogSort/add',
    method: 'post',
    data: param
  });
}

/**
 * 获取所有分类  含分页
 * @param param
 * get 方式传第参数 要用params
 * json 方式 用data
 */
export function getAllBlogSortWithPage(param) {
  return request({
    url: process.env.GATEWAY_API + 'admin-api/blogSort/page/all',
    method: 'get',
    params: param
  });
}

export function updateBlogSort(param) {
  return request({
    url: process.env.GATEWAY_API + 'admin-api/blogSort/update',
    method: 'post',
    data: param
  });
}

export function delBlogSort(param) {
  return request({
    url: process.env.GATEWAY_API + 'admin-api/blogSort/delete',
    method: 'post',
    params: param
  });
}
