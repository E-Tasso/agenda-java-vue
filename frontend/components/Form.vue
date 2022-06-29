<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <br />
    <h2>Contato</h2>
    <br />
    <v-text-field v-if="id" v-model="id" label="Id"></v-text-field>
    <v-text-field
      v-model="name"
      :rules="nameRules"
      label="Nome"
      required
      ></v-text-field>
    <v-text-field 
      v-model="email"
      :rules="emailRules"
      label="E-mail"
      required
    ></v-text-field>
    <v-text-field 
      v-model.number="phone"
      :rules="phoneRules"
      label="Telefone"
      required
    ></v-text-field>
    <v-btn :disabled="!valid" @click="add({ id, name, email, phone })">{{id ? 'Editar' : 'Adicionar'}}</v-btn>
  </v-form>
</template>

<script>

  export default {
    
    data: () => ({
      valid: true,
      nameRules: [
        v => !!v || 'O campo esta vazio',
      ],
      emailRules: [
        v => !!v || 'O campo esta vazio',
        v => /.+@.+/.test(v) || 'E-mail inválido',
      ],
      phoneRules: [
        v => !!v || 'O campo esta vazio',
        v => !isNaN(v) || 'Não é um número',
      ],
    }),
      
    computed: {
    id:{
      get(){
        return this.$store.state.contact.id;
      },
      set(value){
        this.$store.commit("contact/storeId", value)
      }
    },
    name:{
      get(){
        return this.$store.state.contact.name;
      },
      set(value){
        this.$store.commit("contact/storeName", value)
      }
    },
    email:{
      get(){
        return this.$store.state.contact.email;
      },
      set(value){
        this.$store.commit("contact/storeEmail", value)
      }    
    },
    phone:{
      get(){
        return this.$store.state.contact.phone;
      },
      set(value){
        this.$store.commit("contact/storePhone", value)
      }
    },
  },
  methods:{
    async add(contact){
      if(this.$refs.form.validate()){
        if(contact.id){
          await this.$axios.put("http://localhost:8080/api/" + contact.id, contact)
        }else {
          await this.$axios.post("http://localhost:8080/api/", contact)
        }
        this.resetForm({ id:0, name:"", email:"", phone:"" })
        this.$store.commit(
          "contacts/storeData",
          (await this.$axios.get("http://localhost:8080/api/")).data)
          this.$refs.form.resetValidation()
      }else{
        alert("Existem campos inválidos")
      }
    },
    resetForm(contact){
      this.$store.commit("contact/storeId", contact.id)
      this.$store.commit("contact/storeName", contact.name)
      this.$store.commit("contact/storeEmail", contact.email)
      this.$store.commit("contact/storePhone", contact.phone)
    },
  }
}
</script>

<style>
  
  
</style>