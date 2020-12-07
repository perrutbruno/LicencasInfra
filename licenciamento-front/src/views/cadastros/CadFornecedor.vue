<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Fornecedores">
    <hr>
    <br/>    
    <form>
      <div class="form-group">
        <label for="codigo">Código do Fornecedor:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="razao">Razão Social:</label>
        <input type="text" class="form-control" />
      </div>      
      <div class="form-group">
        <label for="fantasia">Nome Fantasia:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="cnpj">CNPJ:</label>
        <input type="text" class="form-control" />
      </div>
      <button type="button" class="btn btn-primary" >Salvar</button>
    </form>
    <br/>
    <router-link to="/Principal">« Voltar</router-link>

    
	
    </pagina-base>
  </div>
</template>

<script>
 export default {
  name: "Fornecedores"
};

</script>

<style>

</style>