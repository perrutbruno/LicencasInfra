<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Fornecedores">
    <hr>
    <br/>
    <ValidationObserver v-slot="{ invalid }">
    <form @submit.prevent="onSubmit">
      <ValidationProvider name="Código" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="codigo">Código do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.codigoFornecedor"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Nome do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.nomeFornecedor" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="CNPJ" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="cnpj">CNPJ do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.cnpjFornecedor" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <button type="button" class="btn btn-primary" v-bind:disabled="invalid"  v-on:click="salvar">Salvar</button>
    </form>
    </ValidationObserver>
    <br/>
    <router-link to="/Listar/Fornecedor">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosFornecedor from '@/services/dadosfornecedor';

export default {
  name: "CadastrarFornecedor",
  data() {
    return {
      fornecedor:{
        codigoFornecedor: "",
        nomeFornecedor: "",
        cnpjFornecedor: ""
      }
    };
  },
  methods: {
    salvar() {
      dadosFornecedor.salvar(this.fornecedor);
      alert("Cadastrado com sucesso!");
      this.fornecedor.codigoFornecedor = "";
      this.fornecedor.nomeFornecedor = "";
      this.fornecedor.cnpjFornecedor = "";
      this.$router.push({path:"/Listar/Fornecedor"})
    }
  }
};

</script>

<style>

</style>