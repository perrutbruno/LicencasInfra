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
  });
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
