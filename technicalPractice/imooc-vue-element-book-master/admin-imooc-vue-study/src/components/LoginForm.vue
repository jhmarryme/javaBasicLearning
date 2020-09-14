<template>
  <div id="loginForm">
    <el-form
      :model="data"
      style="width: 500px"
      label-position="left"
      label-width="100px"
      label-suffix="："
      :inline="false"
      :rules="rules"
      :disabled="false"
      status-icon
      validate-on-rule-change
      hide-required-asterisk
      :inline-message="false"
      ref="loginForm"
    >
      <el-form-item
        label="用户名"
        prop="user"
        :error="error"
        :validate-status="status"
      >
        <el-input v-model="data.user" placeholder="用户名" clearable></el-input>
      </el-form-item>
      <el-form-item label="活动区域" prop="region">
        <el-select v-model="data.region" placeholder="活动区域" style="width:100%">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button type="primary" @click="addRule">添加校验规则</el-button>
        <el-button type="danger" @click="showError">错误状态</el-button>
        <el-button type="success" @click="showSuccess">正确状态</el-button>
        <el-button type="warning" @click="showValidating">验证状态</el-button>
        <el-button type="primary" @click="showStore">index</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  // import {store} from './store'
  // import {mapGetters} from 'vuex'
  export default {
    name: 'LoginForm',
    // store,
    data() {
      return {
        data: {
          user: 'sam',
          region: '区域二'
        },
        error: '',
        status: '',
        rules: {
          // 这里的user需要和prop属性对应
          user: [
            {required: true, trigger: 'change', message: '用户名必须录入'}
          ]
        }
      }
    },
    // computed: {
    //     // 使用对象展开运算符将 getter 混入 computed 对象中
    //     ...mapGetters([
    //         'getCount'
    //         // ...
    //     ])
    // },
    methods: {
      /* eslint-disable */
      onSubmit() {
        // 表单校验, 可以只有isValid参数
        this.$refs.loginForm.validate((isValid, errors) => {
          if (isValid) {
            console.log(isValid, errors)
            console.log(this.data)
          } else {
            console.log('error')
          }
        })
      },
      addRule() {
        // 自定义校验规则
        const userValidator = (rule, value, callback) => {
          if (value.length > 3) {
            this.inputError = ''
            this.inputValidateStatus = ''
            callback()
          } else {
            callback(new Error('用户名长度必须大于3'))
          }
        }
        // 在原来的rules取出user的规则, 在其上添加自定义的校验
        const newRule = [
          ...this.rules.user,
          {validator: userValidator, trigger: 'change'}
        ]
        // 合并rules
        this.rules = Object.assign({}, this.rules, {user: newRule})
      },
      showError() {
        this.status = 'error'
        this.error = '用户名输入有误'
      },
      showSuccess() {
        this.status = 'success'
        this.error = ''
      },
      showValidating() {
        this.status = 'validating'
        this.error = ''
      },
      showStore() {
        this.$store.dispatch("increment")
        this.$store.dispatch("increment")
        // this.$store.commit('increment')
        // console.log(this.$store.state.count)
        console.log(this.$store.state.a);
        console.log(this.$store.state.b);
      }
    }
  }


</script>
