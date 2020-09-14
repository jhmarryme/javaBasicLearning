import Vue from 'vue'
import Route from 'vue-router'
// import HelloWorld from '../components/HelloWorld'
import A from '../components/A'
import B from '../components/B'
import LoginForm from '../components/LoginForm'
import SimpleForm from '../components/SimpleForm'

Vue.use(Route)
const routes = [
    { path: '/a', component: A, meta: { title: 'Custom Title A' } },
    { path: '/loginForm', component: LoginForm },
    { path: '/b', component: B, meta: { title: 'Custom Title B' } },
    { path: '/simpleForm', component: SimpleForm, meta: { title: 'Custom Title SimpleForm' } }
]

const router = new Route({
    routes
})

router.beforeEach((to, from, next) => {
    console.log('beforeEach', to, from)
    if (to.meta && to.meta.title) {
        document.title = to.meta.title
    } else {
        document.title = 'default title'
    }
    next()
})


export default router
