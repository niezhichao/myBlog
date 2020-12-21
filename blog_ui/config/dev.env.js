'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  //开发环境
  GATEWAY_API: '"http://192.168.1.6:8898/"',
  ADMIN_SWAGGER_URL: '"http://localhost:8090/"'
})
