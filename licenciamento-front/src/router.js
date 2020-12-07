import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "@/views/Home.vue";
import Principal from "@/views/Principal.vue";
import Setores from "@/views/setor/CadSetor.vue";
import ListarSetor from "@/views/setor/ListarSetor.vue";
import EditarSetor from "@/views/setor/EditarSetor.vue";
import Fornecedores from "@/views/cadastros/CadFornecedor.vue";
import Produtos from "@/views/cadastros/CadProduto.vue";
import Usuarios from "@/views/cadastros/CadUsuario.vue";
import ListagemNF from "@/views/notafiscal/ListagemNF.vue";
import CadastroNF from "@/views/notafiscal/CadastroNF.vue";

Vue.use(VueRouter);

export default new VueRouter({
    base: '/',
    mode: 'history',
    routes: [
        { path: '/', component: Home },
        { path: '/Principal', component: Principal },
        { path: '/Cadastro/Setores', component: Setores },
        { path: '/Cadastro/Fornecedores', component: Fornecedores },
        { path: '/Cadastro/Produtos', component: Produtos },
        { path: '/Cadastro/Usuarios', component: Usuarios },
        { path: '/NotaFiscal/Listagem', component: ListagemNF },
        { path: '/NotaFiscal/Cadastro', component: CadastroNF },
        { path: '/Listar/Setor', component: ListarSetor },
        { path: '/Editar/Setor/:idSetor', component: EditarSetor }

    ]
});