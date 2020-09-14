<template>
  <div id="simpleForm">
    <el-form :inline="true" :model="login" class="demo-form-inline" :rules="rules">
      <el-form-item label="审批人" prop="user">
        <el-input v-model="login.user" placeholder="审批人"></el-input>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-select v-model="login.region" placeholder="活动区域">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "SimpleForm",
    data() {
      var checkUser = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('不能为空'));
        } else if (value.length < 3) {
          return callback(new Error('长度不能小微三'))
        } else {
          callback();
        }
      };
      return {
        login: {
          user: '',
          region: ''
        },
        rules: {
          user: [
            { validator: checkUser, trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>

<style scoped>

</style>
