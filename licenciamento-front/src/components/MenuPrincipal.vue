<template>
  <div>
    <div><barra-principal titulo="Licenciamento de Softwares"></barra-principal></div>
    <div class="div-menu-principal">
        <nav class="navbar navbar-expand-lg navbar-dark primary-color">
          <!-- Collapse button -->
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#basicExampleNav"
            aria-controls="basicExampleNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>

          <!-- Collapsible content -->
          <div class="collapse navbar-collapse" id="basicExampleNav">
            <!-- Links -->
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <router-link to="/Principal" class="nav-link"> » Home</router-link>
                  <span class="sr-only">(current)</span>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >» Cadastros Básicos</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                  <router-link to="/Listar/Setor" class="dropdown-item">- Setores</router-link>
                  <router-link to="/Cadastro/Fornecedores" class="dropdown-item">- Fornecedores</router-link>
                  <router-link to="/Cadastro/Produtos" class="dropdown-item">- Produtos</router-link>
                  <router-link to="/Cadastro/Usuarios" class="dropdown-item">- Usuários</router-link>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >» Nota Fiscal</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                  <router-link to="/NotaFiscal/Listagem" class="dropdown-item">- Listagem</router-link>
                  <router-link to="/NotaFiscal/Cadastro" class="dropdown-item">- Cadastro</router-link>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >» Licenças</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">- Listagem</a>
                  <a class="dropdown-item" href="#">- Atribuir Licença</a>
                </div>
              </li>
            </ul>
            <!-- Links -->

            <form class="form-inline">
              <div class="md-form my-0">
                <button class="btn btn-info">:: Sair ::</button>
              </div>
            </form>
          </div>
          <!-- Collapsible content -->
        </nav>
    </div>
  </div>
</template>

<script>
export default {
  name: "Menu"
};
</script>

<style>
</style>