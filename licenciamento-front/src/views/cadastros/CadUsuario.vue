<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Usuários">
    <hr> 
    <br/>    
    <form>
      <div class="form-group">
        <label for="codigo">Código do Usuário:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="nome">Nome do Usuário:</label>
        <input type="text" class="form-control" />
      </div>      
      <div class="form-group">
        <label for="login">Login:</label>
        <input type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="senha">Senha:</label>
        <input type="password" class="form-control" />
      </div>
      <div class="form-group">
        <label for="confirme">Confirme a Senha:</label>
        <input type="password" class="form-control" />
      </div>    
      <div class="form-group">
        <label for="nivel">Nível:</label>
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
  name: "Usuarios"
};

</script>

<style>

</style>