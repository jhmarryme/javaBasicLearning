<template>
  <div class="A">
    component A
    <br>
    <router-link to="/b">to B</router-link>
    <br>
    <router-link to="/loginForm">to loginForm</router-link>
    <br>
    <router-link to="/simpleForm">to simpleForm</router-link>
    <br>
    <button @click="addRoute">addRoutes</button>
  </div>
</template>

<script>
  import B from '../components/B'
  import axios from 'axios'
  /* eslint-disable */
  export default {
    props: {},
    created() {
      const url = '/book/home/v2';
      const whiteUrl = ['login'];
      const request = axios.create({
        baseURL: 'https://test.youbaobao.xyz:18081',
        timeout: 5000
      });
      request.interceptors.request.use(
        config => {
          // config 中包含 baseURL, timeout, headers, params 等参数
          console.log("request-config", config);
          // 删除url中的baseURL部分
          const url = config.url.replace(config.baseURL, '')
          // 如果请求的url 处于白名单中
          if (whiteUrl.some(value => url === value)) {
            return config;
          }
          // 这里抛出的异常会通过下面的error处理返回用户
          // throw new Error("异常信息")

          // 请求的url 不在白名单中, 需要在header中设置token
          config.headers['token'] = 'abcd'
          return config
        },
        error => {
          // 将异常返回给用户进行处理
          Promise.reject(error)
        }
      )

      request.interceptors.response.use(
        response => {
          // 包含 返回的data信息.. config, headers, request
          console.log("response-response", response);

          // 判断返回结果是否正常
          if (response.data && response.data.error_code === 0) {
            return response.data
          } else {
            // 弹出错误信息
            alert(response.data.msg)
            // 异常交给用户处理
            Promise.reject(response.data.msg)
          }
        },
        error => {
          Promise.reject(error)
        }
      )


      request({
        url,
        method: 'get',
        params: {
          openId: '1111'
        }
      }).catch(err => {
        console.log(err)
      })

    },
    methods: {
      addRoute() {
        this.$router.addRoutes([{
          path: '/b', component: B, meta: {title: 'Custom Title B'},
        }])
      }
    }
  };
</script>
