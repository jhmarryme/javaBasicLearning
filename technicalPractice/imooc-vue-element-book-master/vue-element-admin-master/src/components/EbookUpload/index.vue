<template>
  <div class="upload-container">
    <el-upload
      :action="action"
    >
      请上传
    </el-upload>
  </div>
</template>

<script>
export default {
  name: 'Index',
  data() {
    return {
      action: `${process.env.VUE_APP_BASE_API}/book/upload`
    }
  }
}
</script>

<style scoped>

</style>
