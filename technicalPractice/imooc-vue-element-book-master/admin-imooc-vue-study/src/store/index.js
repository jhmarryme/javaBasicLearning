import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);
/*export const store = new Vuex.Store({
    state: {
        count: 0
    },
    mutations: {
        increment (state) {
            state.count++
        }
    },
    actions: {
        increment (context) {
            context.commit('increment')
        }
    },
    getters: {
        getCount: state => {
            return state.count;
        }
    }
})*/
const moduleA = {
    state: {
        count: 0
    },
    mutations: {
        increment (state) {
            state.count++
        }
    },
    actions: {
        increment (context) {
            context.commit('increment')
        }
    },
    getters: {
        getCount: state => {
            return state.count;
        }
    }
}

const moduleB = {
    state: {
        count: 100
    },
    mutations: {
        increment (state) {
            state.count++
        }
    },
    actions: {
        increment (context) {
            context.commit('increment')
        }
    },
    getters: {
        getCount: state => {
            return state.count;
        }
    }
}

export const store = new Vuex.Store({
    modules: {
        a: moduleA,
        b: moduleB
    }
})



