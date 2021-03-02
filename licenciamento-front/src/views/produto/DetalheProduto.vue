<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Detalhe: Produto">
    <hr>
    <br/>
    <form>
      <div class="form-group">
        <label class="labelLegenda">Código do Produto: </label>
        <label class="labelDetalhe">{{ produto.codigoProduto }}</label>
      </div>
      <div class="form-group">
       <label class="labelLegenda">Nome do Produto: </label>
       <label class="labelDetalhe">{{ produto.nomeProduto }}</label>
      </div>  
      <div class="form-group">
       <label class="labelLegenda">Versão:</label>
       <label class="labelDetalhe">{{ produto.versaoProduto }}</label>
      </div>  
      <div class="form-group">
       <label class="labelLegenda">Modelo:</label>
       <label class="labelDetalhe">{{ produto.modeloProduto }}</label>
      </div>  
      <div class="form-group">
       <label class="labelLegenda">Descrição:</label>
       <label class="labelDetalhe" >{{ produto.descricaoProduto }}</label>
      </div> 
      <div class="form-group">
       <label class="labelLegenda">Observação:</label>
       <label class="labelDetalhe">{{ produto.observacaoProduto }}</label>
      </div>        
      <div class="form-group" v-if="produto.ativo == 1">
        <label class="labelLegenda">Ativado:</label>
        <label class="labelDetalhe">Sim</label>
      </div>   
      <div class="form-group" v-else>
        <label class="labelLegenda">Ativado:</label>
        <label class="labelDetalhe">Não</label>
      </div>      
     
     
    </form>
    <br/>
    <router-link to="/Listar/Produto">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>

export default {
  name: "DetalheProduto",
  data() {
    return {
      produto: {
        codigoProduto: "",
        nomeProduto: "",
        versaoProduto: "",
        modeloProduto: "",
        descricaoProduto: "",
        observacaoProduto: "",
        ativo: ""
      }
    };
  },
  mounted() {
    this.idProduto = this.$route.params.idProduto;//$route é a rota atual
    fetch(`http://localhost:8011/produto-ms/api/produtos/${this.idProduto}`)
    .then(resp => resp.json().then(json =>{
      this.produto.codigoProduto = json.codigoProduto;
      this.produto.nomeProduto = json.nomeProduto;
      this.produto.versaoProduto = json.versaoProduto;
      this.produto.modeloProduto = json.modeloProduto;
      this.produto.descricaoProduto = json.descricaoProduto;
      this.produto.observacaoProduto = json.observacaoProduto;
      this.produto.ativo = json.ativo;  
    }))
  }
};

</script>

<style>

</style>