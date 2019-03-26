import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import router from '@/router';

import VuexPersistence from 'vuex-persist'
import appService from './app.service'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        isAuthenticated: false,
        repositories: [],
        loader : false
    },
    plugins: [new VuexPersistence().plugin],
    mutations: {
        setIsAuthenticated(state, payload) {
            state.isAuthenticated = payload;
        },
        setRepositories(state, payload){
            state.repositories = payload;
        },
        LOADER(state, payload){
            state.loader = payload;
        }
    },
    actions: {
        userLogin({ commit }, { email, password }) {
            
            appService.login(email,password)
                .then(response => {
                    localStorage.setItem('token', response.access_token);
                    commit('setIsAuthenticated', true);
                    router.push('/');
                })
        },
        userSignOut({ commit }) {
            commit('setIsAuthenticated', false);
            commit('setRepositories', []);
            localStorage.setItem('token', null);
            router.push('/');
        },
        getRespositories({ commit }){
            const baseURI = 'https://api.github.com/search/repositories?q=javascript+language:javascript&sort=stars&order=desc'
            axios.get(baseURI)
                .then(response => {
                    commit('setRepositories', response.data)
                })
                .catch(() => {
                    commit('setRepositories', []);
                })
        }
    },
    getters: {
        isAuthenticated(state) {
            return state.isAuthenticated;
        }
    }
});