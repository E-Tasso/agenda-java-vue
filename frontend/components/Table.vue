<template>
  <div>
    <v-data-table class="table"
    :headers="headers"
    :items="contacts"
    >
    <template v-slot:[`item.edit`]="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="editItem(item)"
      >
        mdi-pencil
      </v-icon>
    </template>
    <template v-slot:[`item.delete`]="{ item }">
      <v-icon 
        small
        @click="deleteItem(item)"
      > 
        mdi-delete
      </v-icon>
     
    </template>
    </v-data-table>
  </div>
</template>

<script>
 export default {
    data () {
      return {
        headers: [
          { text: 'Nome', value: 'name' },
          { text: 'E-mail', value: 'email' },
          { text: 'Telefone', value: 'phone' },
          { text: '', value: 'edit' },
          { text: '', value: 'delete' },
        ],
      }
    },
    computed: {
      contacts(){
        return this.$store.state.contacts.data
      }
    },
    async fetch(){
      this.$store.commit(
        "contacts/storeData",
        (await this.$axios.get("http://localhost:8080/api/")).data
      )
    },
    methods:{
      async deleteItem(contact){
        await this.$axios.delete("http://localhost:8080/api/" + contact.id)
         this.$store.commit(
        "contacts/storeData",
        (await this.$axios.get("http://localhost:8080/api/")).data)
      },
      async editItem(contact){
        this.$store.commit("contact/storeId", contact.id)
        this.$store.commit("contact/storeName", contact.name)
        this.$store.commit("contact/storeEmail", contact.email)
        this.$store.commit("contact/storePhone", contact.phone)
        this.$router.push("/Adicionar")
      }
    }
  }  
  
</script>

<style>
  .table {
    margin-top: 50px;
  }
   .v-data-table thead th {
      font-size: 16px !important;

 }
</style>

