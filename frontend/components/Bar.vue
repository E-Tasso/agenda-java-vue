<template>
  <v-card class="overflow-hidden">
    <v-app-bar
      absolute
      color="#6A76AB"
      dark
      shrink-on-scroll
      prominent
      src="https://picsum.photos/1920/1080?random"
      fade-img-on-scroll
      scroll-target="#scrolling-techniques-3"
    >
      <template v-slot:img="{ props }">
        <v-img
          v-bind="props"
          gradient="to top right, rgba(100,115,201,.7), rgba(25,32,72,.7)"
        ></v-img>
      </template>
      <v-app-bar-title class="text-center">Minha Agenda</v-app-bar-title>
      <v-spacer></v-spacer>
      <template v-slot:extension>
        <v-tabs align-with-title>
          <v-tab to="/">Início</v-tab>
          <v-tab to="/Adicionar">Adicionar</v-tab>
          <v-tab to="/Lista">Lista </v-tab>
        </v-tabs>
      </template>
    </v-app-bar>
    <v-col>
      <v-sheet
        id="scrolling-techniques-3"
        class="overflow-y-auto"
        max-height="600"
      >
      <v-container style="height: 200px">
      </v-container>
      </v-sheet>
    </v-col>
  </v-card>
</template>

<script>

</script>

<style>

</style>