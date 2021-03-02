<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Produtos">
    <hr>
    <br/>
    <ValidationObserver v-slot="{ invalid }">
    <form @submit.prevent="onSubmit">
      <ValidationProvider name="Código" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="codigo">Código do Produto:</label>
        <input type="text" class="form-control" v-model="produto.codigoProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Nome do Produto:</label>
        <input type="text" class="form-control" v-model="produto.nomeProduto" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Versão" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Versão do Produto:</label>
        <input type="text" class="form-control" v-model="produto.versaoProduto" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Modelo" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Modelo do Produto:</label>
        <input type="text" class="form-control" v-model="produto.modeloProduto" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Descricao" rules="min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Descrição do Produto:</label>
        <input type="text" class="form-control" v-model="produto.descricaoProduto" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Observacao" rules="min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Observação do Produto:</label>
        <input type="text" class="form-control" v-model="produto.observacaoProduto" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>                  

      <button type="button" class="btn btn-primary" v-bind:disabled="invalid"  v-on:click="salvar">Salvar</button>
    </form>
    </ValidationObserver>
    <br/>
    <router-link to="/Listar/Produto">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosproduto from '@/services/dadosproduto';

export default {
  name: "Cadastrarproduto",
  data() {
    return {
      produto:{
        codigoProduto: "",
        nomeProduto: "",
        modeloProduto: "",
        versaoProduto: "",
        descricaoProduto: "",
        observacaoProduto: ""

      }
    };
  },
  methods: {
    salvar() {
      dadosproduto.salvar(this.produto);
      alert("Cadastrado com sucesso!");
      this.produto.codigoProduto = "";
      this.produto.nomeProduto = "";
      this.produto.modeloProduto = "";
      this.produto.versaoProduto = "";
      this.produto.descricaoProduto = "";
      this.produto.observacaoProduto = "";
      this.$router.push({path:"/Listar/produto"})
    }
  }
};


</script>

<style>

</style>