import axios from 'axios'

import store from '@/store.js';

axios.defaults.baseURL = process.env.API_URL || 'http://localhost:5050/api/v1'

// Add a request interceptor
axios.interceptors.request.use(function (config) {
    store.commit('LOADER', true);
    return config;
}, function (error) {
    store.commit('LOADER', false);
    return Promise.reject(error);
});

// Add a response interceptor
axios.interceptors.response.use(function (response) {
    store.commit('LOADER', false);
    return response;
}, function (error) {
    return Promise.reject(error);
});

const appService = {
  
    login(email, password){
    
      let config = { 
        headers : { 'Content-Type': 'multipart/form-data'} 
      };
    
      let formData = new FormData();
      formData.append('login', email);
      formData.append('password', password);

      return new Promise((resolve) => {
        axios.post(`/login`, formData, config)
          .then(response => {
            resolve(response.data);
          })
          .catch((error) => {
            console.log('Error', error.message);
          });
      })
    }
}

export default appService