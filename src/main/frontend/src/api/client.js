import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
});

export const getCountries = () => api.get(`/countries`);
export const calculateNetPrice = (gross, country)=> api.get(`/net_price?price=${gross}&country=${country}`);


const apis = {
    getCountries,
    calculateNetPrice,
};

export default apis;