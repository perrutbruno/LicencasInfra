import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "@/views/Home.vue";
import Principal from "@/views/Principal.vue";
import CadSetor from "@/views/setor/CadSetor.vue";
import ListarSetor from "@/views/setor/ListarSetor.vue";
import EditarSetor from "@/views/setor/EditarSetor.vue";
import Fornecedores from "@/views/cadastros/CadFornecedor.vue";
import Produtos from "@/views/cadastros/CadProduto.vue";
import ListagemNF from "@/views/notafiscal/ListagemNF.vue";
import CadastroNF from "@/views/notafiscal/CadastroNF.vue";
import ListarUsuario from "@/views/usuario/ListarUsuario.vue";
import EditarUsuario from "@/views/usuario/EditarUsuario.vue";
import CadUsuario from "@/views/usuario/CadUsuario.vue";
import ListarProduto from "@/views/produto/ListarProduto.vue";
import EditarProduto from "@/views/produto/EditarProduto.vue";
import CadProduto from "@/views/produto/CadProduto.vue";

Vue.use(VueRouter);

export default new VueRouter({
    base: '/',
    mode: 'history',
    routes: [
        { path: '/', component: Home },
        { path: '/Principal', component: Principal },
        { path: '/Cadastro/Fornecedores', component: Fornecedores },
        { path: '/Cadastro/Produtos', component: Produtos },
        { path: '/NotaFiscal/Listagem', component: ListagemNF },
        { path: '/NotaFiscal/Cadastro', component: CadastroNF },
        { path: '/Cadastro/Setor', component: CadSetor },
        { path: '/Listar/Setor', component: ListarSetor },
        { path: '/Editar/Setor/:idSetor', component: EditarSetor },
        { path: '/Cadastro/Usuario', component: CadUsuario },
        { path: '/Listar/Usuario', component: ListarUsuario },
        { path: '/Editar/Usuario/:idUsuario', component: EditarUsuario },
        { path: '/Cadastro/Produto', component: CadProduto },
        { path: '/Listar/Produto', component: ListarProduto },
        { path: '/Editar/Produto/:idProduto', component: EditarProduto }        

    ]
});