import Vue from 'vue';
import App from './App.vue';
import JwPagination from 'jw-vue-pagination';
import PaginaBase from "@/components/PaginaBase.vue";
import MenuPrincipal from "@/components/MenuPrincipal.vue";
import BarraPrincipal from "@/components/BarraPrincipal.vue";
import router from "@/router.js";
import {  ValidationProvider, extend, ValidationObserver } from 'vee-validate';
import * as rules from 'vee-validate/dist/rules';
import { messages } from 'vee-validate/dist/locale/pt_BR.json';


Object.keys(rules).forEach(rule => {
  extend(rule, {
    ...rules[rule], // copies rule configuration
    message: messages[rule] // assign message
  }),
  extend('velho', {
    validate(value, {password}){
      return{
        valid: (value < password)
      }
    },
    params: ['password'],
    message: 'Esse cara é muito velho.'
  }),

  extend('upCase',{
    validate(value){
      return{
        valid: (value.match(/[A-Z]/g) !== null)
      }
    },
    params: ['password'],
    message: 'É necessário uma letra em maiusculo.'
  }),

  extend('number',{
    validate(value){
      return{
        valid: (value.match(/[0-9]/g) !== null)
      }
    },
    params: ['password'],
    message: 'É necessário um número.'
  }),

  extend('especial',{
    validate(value){
      return{
        valid: (value.match(/[!@#$%^&*?]/g) !== null)
      }
    },
    params: ['password'],
    message: 'É necessário um caractere especial.'
  })


});



Vue.config.productionTip = false

Vue.component('jw-pagination', JwPagination);
Vue.component("PaginaBase", PaginaBase);
Vue.component("MenuPrincipal", MenuPrincipal);
Vue.component("BarraPrincipal", BarraPrincipal);
Vue.component("ValidationProvider", ValidationProvider);
Vue.component("ValidationObserver", ValidationObserver);

new Vue({
  el: "#app",
  render: h => h(App),
  router
}).$mount('#app')
