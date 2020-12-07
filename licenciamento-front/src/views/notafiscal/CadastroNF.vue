<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Nota Fiscal">
    <hr>
   <br/>    
    <form>
      <div class="form-group">
        <label for="codigo">Código da Nota Fiscal:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="data">Data da Emissão:</label>
        <input type="text" class="form-control" />
      </div>      
      <div class="form-group">
        <label for="arquivo">Nome do Arquivo:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="pasta">Caminho do Arquivo:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="atendimento">Atendimento:</label>
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
      <div class="form-group">
        <label for="fornecedor">Fornecedor:</label>
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
  name: "CadastroNF"
};

</script>

<style>

</style>