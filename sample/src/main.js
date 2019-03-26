import Vue from 'vue'

import Vuetify from 'vuetify'
import './plugins/vuetify'
import App from './App.vue'

import router from "./router";
import store from "./store";

import VueAxios from 'vue-axios'
import axios from 'axios'

Vue.use(VueAxios, axios)

Vue.config.productionTip = false

Vue.use(Vuetify, { theme: {
  primary: '#6978D2',
  secondary: '#424242',
  accent: '#82B1FF',
  error: '#F04B2F',
  info: '#F8CE7C',
  success: '#4CAF50',
  warning: '#FFC107'
}})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");

