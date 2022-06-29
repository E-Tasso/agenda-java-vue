<template>
 <v-col>
    <h2>Agenda</h2>
    
    <p class="text-justify">
    API Crud de Agenda feita com backend em Java, Spring Boot, Banco de dados H2, JPA.
    O backend pode ser acessado através do endereço <a href="http://localhost:8080/api">Localhost</a> ou para checagem melhor dos dados e métodos por intermédio do <a href="http://localhost:8080/swagger-ui/index.html">Swagger</a>.
    O frontend foi desenvolvido em Vue.js, utilizando Nuxt.js e Vuetify. 
    </p>
    <p class="text-justify">
    Abaixo segue uma demonstração de uso do sistema: 
    </p>
  <v-card
    elevation="24"
    max-width="680"
    class="mx-auto"
  >  
  <v-carousel>
    <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      :src="item.src"
      reverse-transition="fade-transition"
      transition="fade-transition"
      contain
    ></v-carousel-item>
  </v-carousel>
</v-card>
    </v-col>    
 </template>

<script>
   export default {
    data () {
      return {
        items: [
          {
            src: require('~/assets/Adicionar.png'),
          },
          {
            src: require('~/assets/ErroAdicionar.png'),
          },
          {
            src: require('~/assets/CamposInvalidos.png'),
          },
          {
            src: require('~/assets/Lista.png'),
          },
        ],
      }
    },
  }
</script>

<style >
   h2 {
     margin-block: 20px;
   }
</style>