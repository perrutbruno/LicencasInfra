<template>
  <div class="div-menu-principal">
      <header>
        <h4>
          {{ titulo }}
        </h4>
      </header>
  </div>
</template>

<script>
export default {
  name: "BarraPrincipal",
  props: {
    titulo: String,
  },
};
</script>

<style>

</style>