/**
 * Created by chenguifeng on 2019/1/31.
 */

function saveToken(token) {
    var storage=window.localStorage;
    storage['token'] = token;
}

function getToken() {
    var storage=window.localStorage;
    return storage['token'];
}