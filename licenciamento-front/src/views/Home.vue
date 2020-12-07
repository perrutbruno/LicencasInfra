<template>
  <div>
    <barra-principal titulo="Licenciamento de Softwares"></barra-principal>
    <div class="login">
      <img src="/img/logo.png" class="logo" width="100" height="100">
      <h3>Login</h3>
      <br>
      <form>
        <div class="form-group">
          <label for="login">Usuário:</label>
          <input type="text" class="form-control" v-model="login"/>
        </div>
        <div class="form-group">
          <label for="senha">Senha:</label>
          <input type="password" class="form-control" v-model="sobrenome"/>
        </div>
        <button type="button" class="btn btn-primary"><router-link to="/Principal">Entrar</router-link></button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home"
};


</script>

<style>

</style>