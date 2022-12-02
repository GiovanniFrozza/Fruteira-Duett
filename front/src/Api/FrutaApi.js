import axios from 'axios';

const get = axios.create({
    baseURL: 'http://localhost:8080/api/listAll'
});


export default get;