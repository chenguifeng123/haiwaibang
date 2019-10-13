import axios from 'axios';

//let hostPath = 'http://localhost:8081';
let hostPath = '';
let haiwaibang = hostPath + '/m';
//axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest';
//axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
//axios.defaults.headers['Access-Control-Allow-Origin'] = '*';

var qs = require('qs');
var instance = axios.create({ headers: { 'content-type': 'application/json;charset=utf-8' } });

export const getStaticReourcePath = params => {
  return hostPath;
}

export const getUrlPath = parmas => {
  return haiwaibang;
};

export const addTable = params => {
  let { path } = params;
  return instance.put(`${haiwaibang}/${path}`, JSON.stringify(params));
}

export const getTable = params => {
  let { id, path } = params;
  return instance.get(`${haiwaibang}/${path}/${id}`, {});
}

export const getTableList = params => {
  let { path } = params;
  return axios.get(`${haiwaibang}/${path}/list`, {});
};

export const getTableListAndId = params => {
  let { id, path } = params;
  return axios.get(`${haiwaibang}/${path}/list/${id}`, {});
};

export const postTableList = params => {
  let { path } = params;
  return instance.post(`${haiwaibang}/${path}/list`, JSON.stringify(params));
};

export const postTableListAndId = params => {
  let { id, path } = params;
  return instance.post(`${haiwaibang}/${path}/list/${id}`, JSON.stringify(params));
};
