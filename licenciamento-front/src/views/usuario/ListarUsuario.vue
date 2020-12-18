<template>
  <div>
    <menu-principal></menu-principal>

    <pagina-base subtitulo="» Listagem de Usuários">
      <hr />
        <h5><router-link to="/Cadastro/Usuario"><img src="/img/incluir.png">Adicionar Usuário</router-link></h5>
      <br>
      <jw-pagination
        :items="usuarios"
        @changePage="onChangePage"
        :styles="customStyles"
        :labels="customLabels"
      ></jw-pagination>

      <table class="table table-striped">
        <thead>
          <tr>
            <th>Código</th>
            <th>Login</th>
            <th>Nome</th>
            <th>Nível</th>
            <th>Ativo</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="usuario in pageOfItems" :key="usuario.idUsuario">
            <td>{{ usuario.codigoUsuario }}</td>
            <td>{{ usuario.login }}</td>
            <td>{{ usuario.nome }}</td>
            <td v-if="usuario.nivel == 1">Padrão</td>
            <td v-else>Administrador</td>
            <td v-if="usuario.ativo == true">Sim</td>
            <td v-else>Não</td>
            <td>
              <router-link :to="`/Editar/Usuario/${usuario.idUsuario}`"><div class="editar"></div></router-link>
              <div class="excluir" v-on:click="excluir(usuario)"></div>
            </td>
          </tr>
        </tbody>
      </table>
    </pagina-base>
  </div>
</template>

<script>
import dadosusuario from "@/services/dadosusuario.js";

const customStyles = {
  li: {
    display: "inline-block",
    padding: 0,
    margin: 0,
  },
  a: {
    cursor: "pointer",
    padding: "6px 12px",
    display: "block",
    float: "left",
    color: "black",

    textdecoration: "none",
  },
};

const customLabels = {
  first: "«",
  last: "»",
  previous: "<",
  next: ">",
};

export default {
  name: "Usuario",
  data() {
    return {
      usuarios: [],
      pageOfItems: [],
      customStyles,
      customLabels,
    };
  },
  mounted() {
    this.listar();
  },
  methods: {
    listar() {     
      dadosusuario.listar().then((resp) => {
      
        this.usuarios = resp.data;
          
      });
    },
    excluir(usuarioExclusao){
      if(confirm("Deseja excluir o(a) " + usuarioExclusao.nome + "?")){
        dadosusuario.excluir(usuarioExclusao)
        .then(resp=> {
          console.log(resp);
          this.listar()
        })
      }
    },
    onChangePage(pageOfItems) {
      // update page of items
      this.pageOfItems = pageOfItems;
    },
  },
};
</script>

<style>
</style>