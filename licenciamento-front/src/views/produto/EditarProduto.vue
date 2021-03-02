<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Editar: produto">
    <hr>
    <br/>
    <ValidationObserver >
    <form @submit.prevent="onSubmit">
     <ValidationProvider name="Codigo" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Codigo">Código do Produto:</label>
        <input type="text" class="form-control" v-model="produto.codigoProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required|min:2|max:100" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Nome">Nome do Produto:</label>
        <input type="text" class="form-control" v-model="produto.nomeProduto" maxlength="100"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>  

      <ValidationProvider name="Versao" rules="required" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Versao">Versão do produto:</label>
        <input type="text" class="form-control" v-model="produto.versaoProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div>  
      </ValidationProvider> 

      <ValidationProvider name="Modelo" rules="required" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Modelo">Modelo do produto:</label>
        <input type="text" class="form-control" v-model="produto.modeloProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div> 
      </ValidationProvider>  

      <ValidationProvider name="Descricao" rules="max:100" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Descricao">Descrição do produto:</label>
        <input type="text" class="form-control" v-model="produto.descricaoProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div>   
      </ValidationProvider>   

      <ValidationProvider name="Observacao" rules="max:200" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Observacao">Observação do produto:</label>
        <input type="text" class="form-control" v-model="produto.observacaoProduto"/>
        <span class="erro">{{errors[0]}}</span>
      </div> 
      </ValidationProvider>                 

      <ValidationProvider name="ativo" v-slot= "{ errors }">
      <div class="form-group" v-if="produto.ativo == 1">
         <input type="checkbox" value = 1 v-model="produto.ativo" name="ativo"/>
        <span> Ativado. Desmarque e clique em 'Salvar' para desativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>   
      <div class="form-group" v-else >
        <input type="checkbox" value = 0 v-model="produto.ativo" name="ativo"/>
        <span> Desativado. Marque e clique em 'Salvar' para ativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>  
      </ValidationProvider>     
     
      <button type="button" class="btn btn-primary" v-on:click="atualizar">Salvar</button>
    </form>
    </ValidationObserver>
    <br/>
    <router-link to="/Principal">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosproduto from '@/services/dadosproduto';

export default {
  name: "EditarProduto",
  data() {
    return {
      produto:{
        idpPoduto: "",
        codigoProduto: "",
        nomeProduto: "",
        modeloProduto: "",
        versaoProduto: "",
        descricaoProduto: "",
        observacaoProduto: "",
        ativo: ""
      }
    };
  },
  mounted(){
    this.idProduto = this.$route.params.idProduto;
    fetch(`http://localhost:8011/produto-ms/api/produtos/${this.idProduto}`)
    .then(resp => resp.json().then(json =>{
      this.produto.codigoProduto = json.codigoProduto;
      this.produto.nomeProduto = json.nomeProduto;
      this.produto.modeloProduto = json.modeloProduto;
      this.produto.versaoProduto = json.versaoProduto;
      this.produto.descricaoProduto = json.descricaoProduto;
      this.produto.observacaoProduto = json.observacaoProduto;
      this.produto.ativo = json.ativo;
    }))

  },
  methods:{
    atualizar(){
      dadosproduto.alterar(this.idProduto, this.produto)
      .then(resp=> {
        alert("O produto "+resp.data.nomeProduto + " atualizado(a) com sucesso.");
        this.$router.push({path:"/Listar/produto"})
      })
    }
  }
};

</script>

<style>

</style>