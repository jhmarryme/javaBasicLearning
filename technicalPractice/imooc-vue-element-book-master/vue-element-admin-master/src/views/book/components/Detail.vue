<template>
  <div>
    <el-form ref="postForm" :model="postForm">
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
                  <el-form-item :label-width="labelWidth" label="作者：">
                    <el-input
                      v-model="postForm.author"
                      placeholder="作者"
                      style="width: 100%"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item :label-width="labelWidth" label="出版社：">
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
                  <el-form-item :label-width="labelWidth" label="语言：">
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
                      v-model="postForm.fileName"
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

export default {
  name: 'Detail',
  components: { Warning, Sticky, EbookUpload, MDinput },
  props: {
    isEdit: Boolean
  },
  data() {
    return {
      loading: false,
      postForm: {},
      fileList: [],
      labelWidth: '120px'
    }
  },
  methods: {
    showGuide() {
      console.log('showGuide')
    },
    submitForm() {
      this.loading = true
      setTimeout(() => {
        this.loading = false
      }, 1000)
    },
    onUploadSuccess() {
      console.log('onUploadSuccess')
    },
    onUploadRemove() {
      console.log('onUploadRemove')
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
