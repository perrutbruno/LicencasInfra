<template>
  <div>
    <menu-principal></menu-principal>

    <pagina-base subtitulo="» Listagem de Produtos">
      <hr />
        <h5><router-link to="/Cadastro/Produto"><img src="/img/incluir.png">Adicionar Produto</router-link></h5>
      <br>
      <jw-pagination
        :items="produtos"
        @changePage="onChangePage"
        :styles="customStyles"
        :labels="customLabels"
      ></jw-pagination>

      <table class="table table-striped">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Versão</th>
            <th>Ativo</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <!-- <tr v-for="s in setores" :key="s.idSetor">-->
          <tr v-for="produto in pageOfItems" :key="produto.idProduto">
            <td>{{ produto.codigoProduto }}</td>
            <td><router-link :to="`/Detalhe/Produto/${produto.idProduto}`">{{ produto.nomeProduto }}</router-link></td>
            <td>{{ produto.versaoProduto }}</td>
            <td v-if="produto.ativo == true">Sim</td>
            <td v-else>Não</td>
            <td>
              <router-link :to="`/Editar/Produto/${produto.idProduto}`"><div class="editar"></div></router-link>
              <div class="excluir" v-on:click="excluir(produto)"></div>
            </td>
          </tr>
        </tbody>
      </table>
    </pagina-base>
  </div>
</template>

<script>
import dadosproduto from "@/services/dadosproduto.js";

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
  name: "Produto",
  data() {
    return {
      produtos: [],
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
      dadosproduto.listar().then((resp) => {
        this.produtos = resp.data;
      });
    },
    excluir(produtoExclusao){
      if(confirm("Deseja excluir o(a) " + produtoExclusao.nomeProduto + "?")){
        dadosproduto.excluir(produtoExclusao)
        .then(resp=> {
          console.log(resp);
          this.listar()
        })
      }
    },
    onChangePage(pageOfItems) {
      this.pageOfItems = pageOfItems;
    },
  },
};
</script>

<style>
</style>