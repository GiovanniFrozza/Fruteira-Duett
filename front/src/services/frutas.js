import api from '../Api/api.js'

export const findAll = () => {
  return api.get('/listAll')
}

export const findById = (id) => {
  return api.get(`/${id}`)
}

export const divisao = (id) => {
  return api.post(`/divisao/${id}`)
}

export const multiplicacao = (id) => {
  return api.post(`/multiplicacao/${id}`)
}