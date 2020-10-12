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
          :value="item.label"
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
      :default-sort="defaultSort"
      @sort-change="sortChange"
    >
      <el-table-column
        prop="id"
        label="ID"
        sortable="custom"
        width="80"
        align="center"
      />
      <el-table-column
        label="书名"
        width="150"
        align="center"
      >
        <template v-slot="{ row : {titleWrapper} }">
          <span v-html="titleWrapper" />
        </template>
      </el-table-column>
      <el-table-column
        label="作者"
        width="150"
        align="center"
      >
        <template v-slot="{ row : {authorWrapper} }">
          <span v-html="authorWrapper" />
        </template>
      </el-table-column>
      <el-table-column
        label="作者"
        width="150"
        align="center"
        prop="publisher"
      />
      <el-table-column
        label="分类"
        width="150"
        align="center"
        prop="categoryText"
      />
      <el-table-column
        label="语言"
        align="center"
        prop="language"
      />
      <el-table-column
        v-if="showCover"
        label="封面"
        align="center"
      >
        <template v-slot="{ row: { cover } }">
          <a :href="cover" target="_blank">
            <img :src="cover" style="width: 120px;height: 180px">
          </a>
        </template>
      </el-table-column>
      <el-table-column
        width="120"
        label="文件名"
        prop="fileName"
        align="center"
      />
      <el-table-column
        width="120"
        label="文件路径"
        prop="filePath"
        align="center"
      >
        <template v-slot="{ row : { filePath } }">
          {{ filePath | valueFilter }}
        </template>
      </el-table-column>
      <el-table-column
        width="120"
        label="封面路径"
        prop="coverPath"
        align="center"
      />
      <el-table-column
        width="120"
        label="解压路径"
        prop="unzipPath"
        align="center"
      />
      <el-table-column
        width="120"
        label="上传人"
        prop="createUser"
        align="center"
      />
      <el-table-column
        width="120"
        label="上传时间"
        prop="createDt"
        align="center"
      >
        <template v-slot="{ row : { createDt } }">
          {{ createDt | timeFilter }}
        </template>
      </el-table-column>
      <el-table-column
        width="120"
        label="操作"
        align="center"
        fixed="right"
      >
        <template v-slot="{ row }">
          <el-button type="text" icon="el-icon-edit" @click="handleUpdate(row)" />
          <el-button type="text" icon="el-icon-delete" @click="handleDelete(row)" />
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="listQuery.page"
      :limit.sync="listQuery.pageSize"
      :auto-scroll="false"
      @pagination="refresh"
    />
  </div>
</template>

<script>
import Pagination from '@/components/Pagination/index'
import { deleteBook, getCategory, getList } from '@/api/book'
import { parseTime } from '@/utils'

export default {
  name: 'List',
  components: { Pagination },
  filters: {
    valueFilter(value) {
      return value || '/'
    },
    timeFilter(time) {
      return time ? parseTime(time, '') : '/'
    }
  },
  data() {
    return {
      listQuery: {},
      categoryList: [],
      showCover: false,
      list: [],
      tableKey: 0,
      isLoading: false,
      total: 0,
      defaultSort: {}
    }
  },
  created() {
    this.parseQuery()
  },
  beforeRouteUpdate(to, from, next) {
    console.log(to, from)
    if (to.path === from.path) {
      const newQuery = Object.assign({}, to.query)
      const oldQuery = Object.assign({}, from.query)
      if (JSON.stringify(newQuery) !== JSON.stringify(oldQuery)) {
        this.getList()
      }
    }
    next()
  },
  mounted() {
    this.getList()
    this.getCategoryList()
  },
  methods: {
    parseQuery() {
      const query = Object.assign({}, this.$route.query)
      let sort = '+id'
      const listQuery = {
        page: 1,
        pageSize: 20,
        sort
      }
      if (query) {
        query.page && (query.page = +query.page)
        query.pageSize && (query.pageSize = +query.pageSize)
        query.sort && (sort = query.sort)
      }
      const sortSymbol = sort[0]
      const sortColumn = sort.slice(1, sort.length)
      this.defaultSort = {
        prop: sortColumn,
        order: sortSymbol === '+' ? 'ascending' : 'descending'
      }
      this.listQuery = { ...listQuery, ...query }
    },
    /**
       * 对listQuery里的查询内容 在结果中 进行 高亮显示
       * @param k
       * @param v
       * @returns {*}
       */
    wrapperKeyword(k, v) {
      // 高亮显示, 包装一层 带颜色的span
      function highlight(value) {
        return `<span style="color: #0a76a4">${value}</span>`
      }

      // 查询条件不为空时
      if (!this.listQuery[k]) {
        return v
      } else {
        // 从查询结果中找到 查询内容, 将其替换为 高亮显示
        return v.replace(new RegExp(this.listQuery[k], 'ig'), v => highlight(v))
      }
    },
    getList() {
      this.loading = true
      getList(this.listQuery).then(res => {
        console.log('res.data', res.data)
        this.list = res.data
        this.total = res.total
        this.loading = false
        this.list.forEach(book => {
          // 包装后的title 和 author, k 为 listQuery中的title, v 为 查询结果中的title字段
          book.titleWrapper = this.wrapperKeyword('title', book.title)
          book.authorWrapper = this.wrapperKeyword('author', book.author)
        })
      }).catch(() => {
        this.loading = false
      })
    },
    sortBy(prop, order) {
      if (order === 'descending') {
        this.listQuery.sort = `-${prop}`
      } else {
        this.listQuery.sort = `+${prop}`
      }
    },
    sortChange(data) {
      console.log('sortChange', data)

      const { prop, order } = data
      this.sortBy(prop, order)
      this.handleFilter()
    },
    getCategoryList() {
      getCategory().then(res => {
        this.categoryList = res.data
      })
    },
    refresh() {
      this.$router.push({
        path: '/book/list',
        query: this.listQuery
      })
    },
    handleFilter() {
      console.log('handleFilter')
      this.listQuery.page = 1
      this.refresh()
      // this.getList()
    },
    handleCreate() {
      this.$router.push('/book/create')
    },
    handleUpdate(row) {
      console.log('handleUpdate', row)
      this.$router.push(`/book/edit/${row.fileName}`)
    },
    handleDelete(row) {
      console.log('handleDelete', row)
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBook(row.fileName).then(res => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
