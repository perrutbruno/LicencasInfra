<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Produtos">
    <hr>
   <br/>    
    <form>
      <div class="form-group">
        <label for="codigo">Código do Produto:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="nome">Nome do Produto:</label>
        <input type="text" class="form-control" />
      </div>      
      <div class="form-group">
        <label for="modelo">Modelo:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="versao">Versão:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="descricao">Descrição:</label>
        <input type="text" class="form-control" />
      </div>    
      <div class="form-group">
        <label for="observacao">Observação:</label>
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
  name: "Produtos"
};

</script>

<style>

</style>