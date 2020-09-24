<template>
  <div>
    <el-form ref="postForm" :model="postForm" :rules="rules">
      <sticky :class-name="'sub-navbar'">
        <el-button v-if="!isEdit" @click="showGuide">显示帮助</el-button>
        <el-button
          v-loading="loading"
          type="success"
          style="margin-left: 10px"
          @click="submitForm"
        >
          {{ isEdit ? '编辑电子书' : '新增电子书' }}
        </el-button>
      </sticky>
      <div class="detail-container">
        <el-row>
          <warning />
          <el-col :span="24">
            <!-- 编写具体表单控件 -->
            <ebook-upload
              :file-list="fileList"
              :disabled="isEdit"
              @onSuccess="onUploadSuccess"
              @onRemove="onUploadRemove"
            />
          </el-col>
          <el-col :span="24">
            <el-form-item style="margin-bottom: 40px;" prop="title">
              <MDinput v-model="postForm.title" :maxlength="100" name="name" required>
                书名
              </MDinput>
            </el-form-item>
            <div>
              <el-row>
                <el-col :span="12" class="form-item-author">
                  <el-form-item prop="author" :label-width="labelWidth" label="作者：">
                    <el-input
                      v-model="postForm.author"
                      placeholder="作者"
                      style="width: 100%"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item prop="publisher" :label-width="labelWidth" label="出版社：">
                    <el-input
                      v-model="postForm.publisher"
                      placeholder="出版社"
                      style="width: 100%"
                    />
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item prop="language" :label-width="labelWidth" label="语言：">
                    <el-input
                      v-model="postForm.language"
                      placeholder="语言"
                      style="width: 100%"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="根文件：">
                    <el-input
                      v-model="postForm.rootFile"
                      placeholder="根文件"
                      style="width: 100%"
                      disabled
                    />
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="文件路径：">
                    <el-input
                      v-model="postForm.filePath"
                      placeholder="文件路径"
                      style="width: 100%"
                      disabled
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="解压路径：">
                    <el-input
                      v-model="postForm.unzipPath"
                      placeholder="解压路径"
                      style="width: 100%"
                      disabled
                    />
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="封面路径：">
                    <el-input
                      v-model="postForm.coverPath"
                      placeholder="封面路径"
                      style="width: 100%"
                      disabled
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="文件名称：">
                    <el-input
                      v-model="postForm.originalName"
                      placeholder="文件名称"
                      style="width: 100%"
                      disabled
                    />
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label-width="120px" label="封面：">
                    <!-- 点击查看大图 -->
                    <a v-if="postForm.cover" :href="postForm.cover" target="_blank">
                      <img :src="postForm.cover" class="preview-img">
                    </a>
                    <span v-else>无</span>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label-width="120px" label="目录：">
                    <div
                      v-if="postForm.contents && postForm.contents.length > 0"
                      class="contents-wrapper"
                    >
                      <el-tree :data="contentsTree" @node-click="onContentClick" />
                    </div>
                    <span v-else>无</span>
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-form>
  </div>
</template>

<script>
import Sticky from '@/components/Sticky/index'
import Warning from '@/views/book/components/Warning'
import EbookUpload from '@/components/EbookUpload'
import MDinput from '@/components/MDinput'
import { createBook, getBook, updateBook } from '@/api/book'

const defaultForm = {
  title: '', // 书名
  author: '', // 作者
  publisher: '', // 出版社
  language: '', // 语种
  rootFile: '', // 根文件路径
  cover: '', // 封面图片URL
  coverPath: '', // 封面图片路径
  fileName: '', // 文件名
  originalName: '', // 文件原始名称
  filePath: '', // 文件所在路径
  unzipPath: '', // 解压文件所在路径
  contents: [] // 目录
}

const fields = {
  title: '书名',
  author: '作者',
  publisher: '出版社',
  language: '语种'
}

export default {
  name: 'Detail',
  components: { Warning, Sticky, EbookUpload, MDinput },
  props: {
    isEdit: Boolean
  },
  data() {
    const commonValidate = (rule, value, callback) => {
      // console.log('rule, value', rule, value)
      if (value.length === 0) {
        callback(new Error(fields[rule.field] + '必须填写'))
      } else {
        callback()
      }
    }
    return {
      loading: false,
      postForm: {},
      fileList: [],
      labelWidth: '120px',
      contentsTree: [],
      rules: {
        title: [
          { validator: commonValidate, trigger: 'blur' }
        ],
        author: [
          { validator: commonValidate, trigger: 'blur' }
        ],
        publisher: [
          { validator: commonValidate, trigger: 'blur' }
        ],
        language: [
          { validator: commonValidate, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    if (this.isEdit) {
      const fileName = this.$route.params.fileName
      this.getBookData(fileName)
    }
  },
  methods: {
    getBookData(fileName) {
      getBook(fileName).then(res => {
        this.setData(res.data)
      })
    },
    showGuide() {
      console.log('showGuide')
    },
    submitForm() {
      const onSuccess = (res) => {
        const { msg } = res
        this.$notify({
          title: '操作成功',
          message: msg,
          type: 'success',
          duration: 2000
        })
        this.loading = false
      }
      if (!this.loading) {
        this.loading = true
        this.$refs.postForm.validate((valid, fields) => {
          this.loading = true
          if (valid) {
            const book = { ...this.postForm }
            delete book.contents
            delete book.contentsTree
            console.log(book)
            if (!this.isEdit) {
              createBook(book).then(res => {
                onSuccess(res)
                this.setDefault()
              }).catch(() => {
                this.loading = false
              })
            } else {
              updateBook(book).then(res => {
                onSuccess(res)
                this.loading = false
              }).catch(() => {
                this.loading = false
              })
            }
          } else {
            const message = fields[Object.keys(fields)[0]][0].message
            this.$message({ message, type: 'info' })
            this.loading = false
          }
        })
      }
    },
    onContentClick(data) {
      const { text } = data
      if (text) {
        window.open(text)
      }
    },
    setData(data) {
      const {
        title,
        author,
        publisher,
        language,
        rootFile,
        cover,
        originalName,
        url,
        contents,
        contentsTree,
        fileName,
        coverPath,
        filePath,
        unzipPath
      } = data
      this.postForm = {
        title,
        author,
        publisher,
        language,
        rootFile,
        cover,
        originalName,
        url,
        contents,
        contentsTree,
        fileName,
        coverPath,
        filePath,
        unzipPath
      }
      this.contentsTree = contentsTree
      this.fileList = [{ name: originalName || fileName, url }]
    },
    setDefault() {
      this.postForm = Object.assign({}, defaultForm)
      this.contentsTree = []
      this.fileList = []
    },
    onUploadSuccess(data) {
      this.setData(data)
      console.log('onUploadSuccess', data)
    },
    onUploadRemove() {
      this.setDefault()
    }
  }
}
</script>

<style lang="scss" scoped>
  .detail-container {
    padding: 40px 50px 20px;

    .preview-img {
      width: 200px;
      height: 270px;
    }
  }

</style>
