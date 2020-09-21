const fs = require('fs')
const Epub = require('../utils/epub')

const {
  MIME_TYPE_EPUB,
  UPLOAD_URL,
  UPLOAD_PATH } = require("../utils/constant");

class Book {
  constructor(file, data) {
    if (file) {
      this.createBookFromFile(file)
    } else if (data) {
      this.createBookFromData(data)
    }
  }

  createBookFromFile(file) {
    console.log('createBookFromData', file)
    const {
      destination, // 文件本地存储目录
      filename, // 文件名称
      mimetype = MIME_TYPE_EPUB, // 文件资源类型
      path,
      originalname
    } = file
    // 电子书的文件后缀名
    const suffix = mimetype === MIME_TYPE_EPUB ? '.epub' : ''
    // 电子书的猿猴路径
    const oldBookPath = path
    // 电子书的新路径
    const bookPath = `${destination}/${filename}${suffix}`
    // 电子书的下载url
    const url = `${UPLOAD_URL}/book/${filename}${suffix}`
    // 电子书解压后的文件夹路径
    const unzipPath = `${UPLOAD_PATH}/unzip/${filename}`
    // 电子书解压后的文件夹url, 末尾加上/, 解决本地开发浏览器自动映射端口问题
    const unzipUrl = `${UPLOAD_URL}/unzip/${filename}/`

    if (!fs.existsSync(unzipPath)) {
      fs.mkdirSync(unzipPath, { recursive: true }) // 创建电子书解压后的目录
    }

    if (fs.existsSync(oldBookPath) && !fs.existsSync(bookPath)) {
      fs.renameSync(oldBookPath, bookPath) // 重命名文件
    }
    this.fileName = filename // 文件名
    this.path = `/book/${filename}${suffix}` // epub文件相对路径
    this.filePath = this.path // epub文件路径
    this.url = url // epub文件瞎子啊的url
    this.title = '' // 标题
    this.author = '' // 作者
    this.publisher = '' // 出版社
    this.contents = [] // 目录
    this.cover = '' // 封面图片URL
    this.coverPath = '' // 封面图片路径
    this.category = -1 // 分类ID
    this.categoryText = '' // 分类名称
    this.language = '' // 语种
    this.unzipPath = `/unzip/${filename}` // 解压后的电子书相对路径
    this.unzipUrl = unzipUrl // 解压后的电子书链接
    this.originalName = originalname // 电子书文件的原名
  }

  createBookFromData(data) {

  }

  parse() {
    return new Promise((resolve, reject) => {
      const bookPath = `${UPLOAD_PATH}${this.filePath}`
      if (!this.path || !fs.existsSync(bookPath)) {
        reject(new Error('电子书路径不存在'))
      }
      const epub = new Epub(bookPath)
      epub.on('error', err => {
        reject(err)
      })
      epub.on('end', err => {
        if (err) {
          reject(err)
        } else {
          console.log('epub end', epub)
          const {
            title,
            language,
            creator,
            creatorFileAs,
            publisher,
            cover
          } = epub.metadata
          if (!title) {
            reject(new Error('图书标题为空'))
          } else {
            this.title = title
            this.language = language || 'en'
            this.author = creator || creatorFileAs || 'unknown'
            this.publisher = publisher || 'unknown'
            this.rootFile = epub.rootFile
            // 获取电子书的封面
            // 函数内部需要使用this的情况, 用()=>解决, 这样this将正确的指向Book
            // const handleGetImage = function (error, imgBuffer, mimeType) {
            const handleGetImage = (error, imgBuffer, mimeType) => {
              if (err) {
                reject(err)
              } else {
                const suffix = mimeType.split('/')[1]
                const coverPath = `${UPLOAD_PATH}/img/${this.fileName}${suffix}`
                const coverUrl = `${UPLOAD_URL}/img/${this.fileName}${suffix}`
                fs.writeFileSync(coverPath, imgBuffer, 'binary')
                this.coverPath = `/img/${this.fileName}.${suffix}`
                this.cover = coverUrl
                resolve(this)
              }
            }
            epub.getImage(cover, handleGetImage) // 获取封面图片
          }
        }
      })
      epub.parse()
    })
  }
}

module.exports = Book
