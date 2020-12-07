<template>

  <div>
    <h4>
      {{ subtitulo }}
    </h4>
    <div class="card-body">
      <p class="card-text">
        <slot></slot>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "PaginaBase",
  props: {
    subtitulo: String
  }
}
</script>

<style>

</style>