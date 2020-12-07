import axios from 'axios';

export const http = axios.create({
baseURL: 'http://localhost:8011/setor-ms/api/',
withCredentials: false,
Headers: {
"Access-Control-Allow-Origin" : "*",
"Access-Control-Allow-Headers": "Authorization",
"Acces-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
"Content-type" : "application/json;charset=UTF-8"
}
}
)