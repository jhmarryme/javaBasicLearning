const express = require('express')
const router = require('./router')
const bodyParser = require('body-parser')
const cors = require('cors')

const app = express();

// 解决跨域 需要使用域名访问, 配合switch host实现
app.use(cors())
// 必须在路由之前
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())
app.use('/vue-element-admin', router)


const server = app.listen(5000, function () {
    const { address, port} = server.address();
    console.log('Http Server is running on http://%s:%s', address, port);
})
