import axios from 'axios';

let hostPath = 'http://localhost:8081';
//let hostPath = '';
let haiwaibang = hostPath + '/manage';
let haiwaibangMobile = hostPath + '/m';
//axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest';
//axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
//axios.defaults.headers['Access-Control-Allow-Origin'] = '*';

var qs = require('qs');
var instance = axios.create({ headers: { 'content-type': 'application/json;charset=utf-8' } });

/* 请求拦截器 */

axios.interceptors.request.use(function (config) { // 每次请求时会从localStorage中获取token
  let token = localStorage.getItem("access_token")
  if (token) {
    token = 'Bearer ' + token; // 把token加入到默认请求参数中
    config.headers.common['Authorization'] = token;
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});

/* 响应拦截器 */

axios.interceptors.response.use(function (response) { // ①10010 token过期（30天） ②10011 token无效
  console.log(response);
  return response;
}, function (error) {
  return Promise.reject(error)
});

export const getStaticReourcePath = params => {
  return hostPath;
}

export const getUrlPath = parmas => {
  return haiwaibang;
};

// 登陆
export const requestLogin = params => {
  var req = axios.create({ headers: { 'content-type': 'application/x-www-form-urlencoded' } });
  return req.post(`${hostPath}/login`, params);
  // return instance.post(`${haiwaibang}/login`, JSON.stringify(params));
  //  return instance.post(`${base}/manage/login`, params).then(res => res.data); 
};

// 通用 CURD 处理
export const addTable = params => {
  let { path } = params;
  return instance.put(`${haiwaibang}/${path}`, JSON.stringify(params));
}

export const updateTable = params => {
  let { id, path } = params;
  return instance.post(`${haiwaibang}/${path}/${id}`, JSON.stringify(params));
}

export const deleteTable = params => {
  let { id, path } = params;
  return instance.delete(`${haiwaibang}/${path}/${id}`, {});
}

// 管理查询
export const getTable = params => {
  let { id, path } = params;
  return instance.get(`${haiwaibang}/${path}/${id}`, {});
}

export const getTableList = params => {
  let { path } = params;
  return axios.get(`${haiwaibang}/${path}/list`, {});
};

export const postTableList = params => {
  let { path } = params;
  return instance.post(`${haiwaibang}/${path}/list`, JSON.stringify(params));
};

export const postTableListAndId = params => {
  let { id, path } = params;
  return instance.post(`${haiwaibang}/${path}/list/${id}`, JSON.stringify(params));
};

// 移动端查询 -- 只使用查询
export const getMobileTableList = params => {
  let { path } = params;
  return axios.get(`${haiwaibangMobile}/${path}/list`, {});
};

export const postMobileTableList = params => {
  let { path } = params;
  return instance.post(`${haiwaibangMobile}/${path}/list`, JSON.stringify(params));
};

export const postMobileTableListAndId = params => {
  let { id, path } = params;
  return instance.post(`${haiwaibangMobile}/${path}/list/${id}`, JSON.stringify(params));
};