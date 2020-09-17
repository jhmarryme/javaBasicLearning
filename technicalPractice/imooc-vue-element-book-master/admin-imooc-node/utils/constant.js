const { env } = require('./env')
const UPLOAD_PATH = env === 'dev' ?
  'D:\\dev\\imooc-vue-element\\upload' :
  '/root/upload/admin-upload-ebook'
module.exports = {
  CODE_ERROR: -1,
  CODE_SUCCESS: 0,
  CODE_TOKEN_EXPIRED: -2,
  debug: true, // 是否打印日志信息
  PWD_SALT: 'admin_imooc_node', // md5加密盐值
  PRIVATE_KEY: 'admin_imooc_node_test_youbaobao_xyz', // jwt秘钥
  JWT_EXPIRED: 60 * 60, // token失效时间
  UPLOAD_PATH
}
