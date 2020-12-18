<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Usuários">
    <hr>
    <br/>
    <ValidationObserver v-slot="{ invalid }">
    <form @submit.prevent="onSubmit">
      <ValidationProvider name="Codigo" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Codigo">Código do Usuário:</label>
        <input type="text" class="form-control" v-model="usuario.codigoUsuario"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required|min:2|max:100" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Nome">Nome do Usuário:</label>
        <input type="text" class="form-control" v-model="usuario.nome" maxlength="100"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Nivel" rules="required|min:1|max:1|number" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Nivel">Nível do Usuário:</label>
        <input type="text" class="form-control" v-model="usuario.nivel" maxlength="100"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>      

      <ValidationProvider name="Login" rules="required|min:6|max:20" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Login">Login:</label>
        <input type="text" class="form-control" v-model="usuario.login" maxlength="20"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <ValidationProvider name="Senha" rules="required|min:6|max:20|upCase|number|especial" v-slot= "{ errors }">
      <div class="form-group">
        <label for="Senha">Senha:</label>
        <input class="form-control" v-validate="'required'" name="password" type="password" ref="password" v-model="usuario.senha" >  
        <span class="erro">{{errors[0]}} </span>
      </div>      
      </ValidationProvider>
      

     <ValidationProvider name="ConfirmaSenha" rules="required|min:6|max:20|confirmed:Senha" v-slot= "{ errors }">
      <div class="form-group">
        <label for="ConfirmaSenha">Confirme a Senha:</label>
        <input class="form-control" v-validate="'required'" name="ConfirmaSenha" type="password" v-model="password">
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <button type="button" class="btn btn-primary" v-bind:disabled="invalid"  v-on:click="salvar">Salvar</button>
    </form>
    </ValidationObserver>
    <br/>
    <router-link to="/Listar/Usuario">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosusuario from "@/services/dadosusuario.js";

export default {
  name: "CadastrarUsuario",
  data() {
    return {
      usuario:{
        codigoUsuario: "",
        nome: "",
        login: "",
        senha: "",
        nivel: ""
      }
    };
  },

  methods: {
    salvar() {
      dadosusuario.salvar(this.usuario);
      this.usuario.codigoUsuario = "";
      this.usuario.nome = "";
      this.usuario.login = "";
      this.usuario.senha = "";
      this.usuario.nivel = "";
      alert("Cadastrado com sucesso!");
      this.$router.push({path:"/Listar/Usuario"})
    }
  }
};

</script>

<style>

</style>