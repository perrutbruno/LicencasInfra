<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Editar: Setor">
    <hr>
    <br/>
    <form>
      <div class="form-group">
        <label for="codigo">Código do Setor:</label>
        <input type="text" class="form-control"  v-model="setor.codigoSetor"/>
      </div>
      <div class="form-group">
        <label for="nome">Nome do Setor:</label>
        <input type="text" class="form-control" v-model="setor.nomeSetor"/>
      </div>  
      <div class="form-group" v-if="setor.ativo == 1">
         <input type="checkbox" value = 1 v-model="setor.ativo"/>
        <span> Ativado. Desmarque e clique em 'Salvar' para desativar.</span>
      </div>   
      <div class="form-group" v-else>
        <input type="checkbox" value = 0 v-model="setor.ativo"/>
        <span> Desativado. Marque e clique em 'Salvar' para ativar.</span>
      </div>      
     
      <button type="button" class="btn btn-primary" v-on:click="atualizar">Salvar</button>
    </form>
    <br/>
    <router-link to="/Principal">« Voltar</router-link>

	
    </pagina-base>
  </div>
</template>

<script>
import dadossetor from '@/services/dadossetor';

export default {
  name: "EditarSetor",
  data() {
    return {
      setor:{
        idSetor: "",
        codigoSetor: "",
        nomeSetor: "",
        ativo: ""
      }
    };
  },
  mounted(){
    this.idSetor = this.$route.params.idSetor;//$route é a rota atual
    fetch(`http://localhost:8011/setor-ms/api/setores/${this.idSetor}`)
    .then(resp => resp.json().then(json =>{
      this.setor.codigoSetor = json.codigoSetor;
      this.setor.nomeSetor = json.nomeSetor;
      this.setor.ativo = json.ativo;
    }))

  },
  methods:{
    atualizar(){
      dadossetor.alterar(this.idSetor, this.setor)
      .then(resp=> {
        alert("O Setor "+resp.data.nomeSetor + " atualizado(a) com sucesso.");
        this.$router.push({path:"/Listar/Setor"})
      })
    }
  }
};

</script>

<style>

</style>