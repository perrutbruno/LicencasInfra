<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Editar: Fornecedor">
    <hr>
    <br/>
    <ValidationObserver >
    <form @submit.prevent="onSubmit">
      <ValidationProvider name="Codigo" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Codigo">Código do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.codigoFornecedor"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Nome">Nome do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.nomeFornecedor"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="CNPJ" rules="required|numeric" v-slot= "{ errors }">
      <div class="form-group">
        <label for="CNPJ">CNPJ do Fornecedor:</label>
        <input type="text" class="form-control" v-model="fornecedor.cnpjFornecedor"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

     <ValidationProvider name="ativo" v-slot= "{ errors }">
      <div class="form-group" v-if="fornecedor.ativo == 1">
         <input type="checkbox" value = 1 v-model="fornecedor.ativo" name="ativo"/>
        <span> Ativado. Desmarque e clique em 'Salvar' para desativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>   
      <div class="form-group" v-else >
        <input type="checkbox" value = 0 v-model="fornecedor.ativo" name="ativo"/>
        <span> Desativado. Marque e clique em 'Salvar' para ativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>  
      </ValidationProvider> 


      <button type="button" class="btn btn-primary"  v-on:click="atualizar">Salvar</button>
    </form>
    </ValidationObserver>

    <br/>
    <router-link to="/Listar/Fornecedor">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosfornecedor from '@/services/dadosfornecedor';

export default {
  name: "EditarFornecedor",
  data() {
    return {
      fornecedor:{
        idFornecedor: "",
        codigoFornecedor: "",
        nomeFornecedor: "",
        cnpjFornecedor: "",
        ativo: ""
      }
    };
  },
  mounted(){
    this.idFornecedor = this.$route.params.idFornecedor;
    fetch(`http://localhost:8011/fornecedor-ms/api/fornecedores/${this.idFornecedor}`)
    .then(resp => resp.json().then(json =>{
      this.fornecedor.codigoFornecedor = json.codigoFornecedor;
      this.fornecedor.nomeFornecedor = json.nomeFornecedor;
      this.fornecedor.cnpjFornecedor = json.cnpjFornecedor;
      this.fornecedor.ativo = json.ativo;
      
    }))

  },
  methods:{
    atualizar(){
      dadosfornecedor.alterar(this.idFornecedor, this.fornecedor)
      .then(resp=> {
        alert("O Fornecedor "+resp.data.nomeFornecedor + " atualizado(a) com sucesso.");
        this.$router.push({path:"/Listar/Fornecedor"})
      })
    }
  }
};

</script>

<style>

</style>