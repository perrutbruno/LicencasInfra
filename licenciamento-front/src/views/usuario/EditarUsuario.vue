<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Editar: Usuário">
    <hr>
    <br/>
    <ValidationObserver >
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

      <ValidationProvider name="ativo" v-slot= "{ errors }">
      <div class="form-group" v-if="usuario.ativo == 1">
         <input type="checkbox" value = 1 v-model="usuario.ativo" name="ativo"/>
        <span> Ativado. Desmarque e clique em 'Salvar' para desativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>   
      <div class="form-group" v-else >
        <input type="checkbox" value = 0 v-model="usuario.ativo" name="ativo"/>
        <span> Desativado. Marque e clique em 'Salvar' para ativar.</span>
        <span class="erro">{{errors[0]}}</span>
      </div>  
      </ValidationProvider>

      <button type="button" class="btn btn-primary"  v-on:click="atualizar">Salvar</button>
    </form>
    </ValidationObserver>

    
     
    <br/>
    <router-link to="/Principal">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadosusuario from '@/services/dadosusuario';

export default {
  name: "EditarUsuario",
  data() {
    return {
      usuario:{
        codigoUsuario: "",
        nome: "",
        login: "",
        senha: "",
        nivel: "",
        ativo: ""
      }
    };
  },
  mounted(){
    this.idUsuario = this.$route.params.idUsuario;
    fetch(`http://localhost:8011/usuario-ms/api/usuarios/${this.idUsuario}`)
    .then(resp => resp.json().then(json =>{
      this.usuario.codigoUsuario = json.codigoUsuario;
      this.usuario.nome = json.nome;
      this.usuario.login = json.login;
      this.usuario.senha = json.senha;
      this.usuario.nivel = json.nivel;
      this.usuario.ativo = json.ativo;
    }))

  },
  methods:{
    atualizar(){
      dadosusuario.alterar(this.idUsuario, this.usuario)
      .then(resp=> {
        alert("O Usuario "+resp.data.nome + " atualizado(a) com sucesso.");
        this.$router.push({path:"/Listar/Usuario"})
      })
    }
  }
};

</script>

<style>

</style>