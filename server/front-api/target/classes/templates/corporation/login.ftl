<!DOCTYPE html>
<html lang="en">
<head>
<#include "../header.ftl">
    <link rel="stylesheet" href="/css/login.css">
    <script src="/login.js"></script>
    <script src="/js/common.js"></script>
</head>
<body>
<#include "../menu.ftl">

<div>

</div>

<div class="center-panel">

<div class="panel panel-primary login-form">
    <div class="panel-heading">
        <h3 class="panel-title">合作登陆</h3>
    </div>
    <div class="panel-body">
        <form class="bs-example bs-example-form" role="form">
        <div class="input-group input-group-lg">
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-user"></span>
            </span>
            <input id="username" type="text" class="form-control" placeholder="用户">
        </div>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
            <input id="password" type="password" class="form-control" placeholder="密码">
        </div>
        </form>
        <div id="submit" class="bs-example">
            <button type="button" class="btn btn-primary submit-btn"
                    data-loading-text="Loading...">提交
            </button>
        </div>
    </div>
</div>

</div>

<div>

</div>


<#include "../foot.ftl">
</body>
</html>