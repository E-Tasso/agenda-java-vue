export const state = () => ({
  id: 0,
  name: "",
  email: "",
  phone:""
})

export const mutations = {
  storeId: (state, data) => {
    state.id = data
  },
  storeName: (state, data) => {
    state.name = data
  },
  storeEmail: (state, data) => {
    state.email = data
  },
  storePhone: (state, data) => {
    state.phone = data
  }
}