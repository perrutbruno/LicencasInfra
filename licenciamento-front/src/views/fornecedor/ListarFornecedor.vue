<template>
  <div>
    <menu-principal></menu-principal>

    <pagina-base subtitulo="» Listagem de Fornecedores">
      <hr />
        <h5><router-link to="/Cadastro/Fornecedor"><img src="/img/incluir.png">Adicionar Fornecedor</router-link></h5>
      <br>
      <jw-pagination
        :items="fornecedores"
        @changePage="onChangePage"
        :styles="customStyles"
        :labels="customLabels"
      ></jw-pagination>

      <table class="table table-striped">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>CNPJ</th>
            <th>Ativo</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <!-- <tr v-for="s in Fornecedores" :key="s.idFornecedor">-->
          <tr v-for="fornecedor in pageOfItems" :key="fornecedor.idFornecedor">
            <td>{{ fornecedor.codigoFornecedor }}</td>
            <td>{{ fornecedor.nomeFornecedor }}</td>
            <td>{{ fornecedor.cnpjFornecedor }}</td>
            <td v-if="fornecedor.ativo == true">Sim</td>
            <td v-else>Não</td>
            <td>
              <router-link :to="`/Editar/Fornecedor/${fornecedor.idFornecedor}`"><div class="editar"></div></router-link>
              <div class="excluir" v-on:click="excluir(fornecedor)"></div>
            </td>
          </tr>
        </tbody>
      </table>
    </pagina-base>
  </div>
</template>

<script>
import dadosfornecedor from "@/services/dadosfornecedor.js";

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
  name: "Fornecedor",
  data() {
    return {
      fornecedores: [],
      pageOfItems: [],
      customStyles,
      customLabels,
    };
  },
  mounted() {
    this.listar();
    //fetch("http://localhost:8002/api/pessoas")
    //.then(resp => resp.json().then(json => this.pessoas = json)).catch(a => alert(a));
  },
  methods: {
    listar() {
      dadosfornecedor.listar().then((resp) => {
        this.fornecedores = resp.data;
      });
    },
    excluir(fornecedorExclusao){
      if(confirm("Deseja excluir o(a) " + fornecedorExclusao.nomeFornecedor + "?")){
        dadosfornecedor.excluir(fornecedorExclusao)
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