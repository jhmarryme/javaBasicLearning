const express = require('express')
const multer = require('multer')
const Result = require('../models/Result')
const { UPLOAD_PATH } = require('../utils/constant')
const Book = require('../models/Book')
const boom = require('boom')
const { decode } = require('../utils')
const bookService = require('../services/book')

const router = express.Router()

router.post(
  '/upload',
  multer({ dest: `${UPLOAD_PATH}/book` }).single('file'),
  function (req, res, next) {
    if (!req.file || req.file.length === 0) {
      new Result('上传电子书失败').fail(res)
    } else {
      const book = new Book(req.file)
      console.log(book);
      book.parse()
        .then(book => {
          // console.log(book);
          new Result(book, '上传电子书成功').success(res)
        })
        .catch(err => {
          console.log('/book/upload', err)
          next(boom.badImplementation(err))
        })
    }
  })

router.post(
  '/create',
  function (req, res, next) {
    const decoded = decode(req)
    if (decoded && decoded.username) {
      req.body.username = decoded.username
    }
    const book = new Book(null, req.body);
    console.log(book);
    bookService.insertBook(book).then(() => {
      new Result().success(res)
    }).catch(err => {
      next(boom.badImplementation(err))
    })
  }
)
module.exports = router
