import request from "../utils/request"

export function addBlog(param) {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blog/add',
    method: "post",
    data: param
  })
}

export function getBlogLst(param) {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blog/list',
    method: "post",
    data: param
  })
}

export function delBlogLst(param) {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blog/delete/list',
    method: "post",
    params: param
  })
}

export function delBlogById(param) {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blog/delete/one',
    method: "post",
    params: param
  })
}

export function updateBlog(param) {

  return request({
    url: process.env.GATEWAY_API + 'admin-api/blog/update',
    method: "post",
    data: param
  })
}
