<template>
  <div>

    <menu-principal></menu-principal>
    
    <pagina-base subtitulo="» Licenças Aplicadas">
    <hr>
    
   <mdb-datatable
    :data="data"
    striped
    bordered
  />
    
	
    </pagina-base>
  </div>
</template>

<script>
 import { mdbDatatable } from 'mdbvue';
  export default {
    name: 'DatatablePage',
    components: {
      mdbDatatable
    },
    data() {
      return {
        data: {
          columns: [
            {
              label: 'Usuario',
              field: 'usuario',
              sort: 'asc'
            },
            {
              label: 'Produto',
              field: 'produto',
              sort: 'asc'
            },
            {
              label: 'Máquina',
              field: 'maquina',
              sort: 'asc'
            },
            {
              label: 'Data Ativação',
              field: 'data',
              sort: 'asc'
            },
            {
              label: 'Opções',
              field: 'opcoes',
              sort: 'asc'
            }
          ],
          rows: [
            {
              usuario: 'mauro.infra',
              produto: 'Microsoft Office 2019 Standard',
              maquina: 'PAT2465',
              data: '01/01/2020',
              opcoes: '####'
            },
           
          ]
        }
      }
    }
  }

</script>

<style>

</style>