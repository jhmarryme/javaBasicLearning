<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input
        v-model="listQuery.title"
        placeholder="书名"
        style="width: 200px"
        :clearable="true"
        class="filter-item"
        @keyup.enter.native="handleFilter"
        @clear="handleFilter"
        @blur="handleFilter"
      />
      <el-input
        v-model="listQuery.author"
        placeholder="作者"
        style="width: 200px"
        :clearable="true"
        class="filter-item"
        @keyup.enter.native="handleFilter"
        @clear="handleFilter"
        @blur="handleFilter"
      />
      <el-select
        v-model="listQuery.category"
        placeholder="分类"
        class="filter-item"
        clearable
        @change="handleFilter"
      >
        <el-option
          v-for="item in categoryList"
          :key="item.value"
          :value="item.value"
          :label="item.label + '(' + item.num + ')'"
        />
      </el-select>
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-search"
        style="margin-left: 10px"
        @click="handleFilter"
      >
        查询
      </el-button>
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-edit"
        style="margin-left: 10px"
        @click="handleCreate"
      >
        新增
      </el-button>
      <el-checkbox
        v-model="showCover"
        class="filter-item"
        style="margin-left: 10px;"
      >
        显示封面
      </el-checkbox>
    </div>
    <el-table
      :key="tableKey"
      v-loading="isLoading"
      :data="list"
      border
      fit
      highlight-current-row
    />
    <pagination :total="0" />
  </div>
</template>

<script>
import Pagination from '@/components/Pagination/index'
import { getCategory } from '@/api/book'

export default {
  name: 'List',
  components: { Pagination },
  data() {
    return {
      listQuery: {},
      categoryList: [],
      showCover: false,
      list: [],
      tableKey: 0,
      isLoading: true
    }
  },
  mounted() {
    this.getCategoryList()
  },
  methods: {
    getCategoryList() {
      getCategory().then(res => {
        this.categoryList = res.data
      })
    },
    handleFilter() {
      console.log('handleFilter')
    },
    handleCreate() {
      this.$router.push('/book/create')
    }
  }
}
</script>

<style scoped>

</style>
