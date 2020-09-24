import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

Vue.use(Vuex)

// https://webpack.js.org/guides/dependency-management/#requirecontext
const modulesFiles = require.context('./modules', true, /\.js$/)

// you do not need `import app from './modules/app'`
// it will auto require all vuex module from modules file
const modules = modulesFiles.keys().reduce((modules, modulePath) => {
  // set './app.js' => 'app'
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1')
  const value = modulesFiles(modulePath)
  modules[moduleName] = value.default
  // console.log(typeof modulesFiles)
  // console.log('moduleName', moduleName)
  // console.log('value', value)
  // console.log('modules[moduleName]', modules[moduleName])
  // console.log('modules', modules)
  // console.log('modules', typeof modules)
  // console.log('======================')
  // console.log('\n')
  return modules
}, {})

const store = new Vuex.Store({
  modules,
  getters
})

export default store
