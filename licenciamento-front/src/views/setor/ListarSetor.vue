<template>
  <div>
    <menu-principal></menu-principal>

    <pagina-base subtitulo="» Listagem de Setores">
      <hr />
        <h5><router-link to="/Cadastro/Setor"><img src="/img/incluir.png">Adicionar Setor</router-link></h5>
      <br>
      <jw-pagination
        :items="setores"
        @changePage="onChangePage"
        :styles="customStyles"
        :labels="customLabels"
      ></jw-pagination>

      <table class="table table-striped">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Ativo</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <!-- <tr v-for="s in setores" :key="s.idSetor">-->
          <tr v-for="setor in pageOfItems" :key="setor.idSetor">
            <td>{{ setor.codigoSetor }}</td>
            <td>{{ setor.nomeSetor }}</td>
            <td v-if="setor.ativo == true">Sim</td>
            <td v-else>Não</td>
            <td>
              <router-link :to="`/Editar/Setor/${setor.idSetor}`"><div class="editar"></div></router-link>
              <div class="excluir" v-on:click="excluir(setor)"></div>
            </td>
          </tr>
        </tbody>
      </table>
    </pagina-base>
  </div>
</template>

<script>
import dadossetor from "@/services/dadossetor.js";

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
  name: "Setor",
  data() {
    return {
      setores: [],
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
      dadossetor.listar().then((resp) => {
        this.setores = resp.data;
      });
    },
    excluir(setorExclusao){
      if(confirm("Deseja excluir o(a) " + setorExclusao.nomeSetor + "?")){
        dadossetor.excluir(setorExclusao)
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