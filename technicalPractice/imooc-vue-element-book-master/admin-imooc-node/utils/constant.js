module.exports = {
    CODE_ERROR: -1,
    CODE_SUCCESS: 0,
    debug: true, // 是否打印日志信息
    PWD_SALT: 'admin_imooc_node', // md5加密盐值
    PRIVATE_KEY: 'admin_imooc_node_test_youbaobao_xyz', // jwt秘钥
    JWT_EXPIRED: 60 * 60, // token失效时间
}
