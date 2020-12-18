<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Cadastro: Setores">
    <hr>
    <br/>
    <ValidationObserver v-slot="{ invalid }">
    <form @submit.prevent="onSubmit">
      <ValidationProvider name="Código" rules="required|numeric|max:4" v-slot= "{ errors }">
      <div class="form-group">
        <label for="codigo">Código do Setor:</label>
        <input type="text" class="form-control" v-model="setor.codigoSetor"/>
        <span class="erro">{{errors[0]}}</span>
      </div>
      </ValidationProvider>

      <ValidationProvider name="Nome" rules="required|min:2|max:50" v-slot= "{ errors }">
      <div class="form-group">
        <label for="nome">Nome do Setor:</label>
        <input type="text" class="form-control" v-model="setor.nomeSetor" maxlength="50"/>
        <span class="erro">{{errors[0]}}</span>
      </div>      
      </ValidationProvider>

      <button type="button" class="btn btn-primary" v-bind:disabled="invalid"  v-on:click="salvar">Salvar</button>
    </form>
    </ValidationObserver>
    <br/>
    <router-link to="/Principal">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadossetor from '@/services/dadossetor';

export default {
  name: "CadastrarSetor",
  data() {
    return {
      setor:{
        codigoSetor: "",
        nomeSetor: ""
      }
    };
  },
  methods: {
    salvar() {
      dadossetor.salvar(this.setor);
      alert("Cadastrado com sucesso!");
      this.setor.codigoSetor = "";
      this.setor.nomeSetor = "";
      this.$router.push({path:"/Listar/Setor"})
    }
  }
};

</script>

<style>

</style>