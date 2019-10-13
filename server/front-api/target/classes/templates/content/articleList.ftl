<!DOCTYPE html>
<html lang="en">
<head>
<#include "../header.ftl">
    <link rel="stylesheet" href="/css/content.css">
</head>
<body>
<#include "../menu.ftl">

<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li class="active">文章列表</li>
</ul>

<div class="article-panel-title">
    <h3><span class="glyphicon glyphicon-th"></span> 海外邦移民新闻</h3>
</div>


<div class="main-page">

<#list articleList as item>

    <div class="oen-element">
        <div class="row">
            <div class="col-md-3">
                <a href="/article/${item.id}">
                <img src="${item.imageUrl}" >
                </a>
            </div>
            <div class="col-md-8 one-element-content-panel">
                <div class="one-element-title">
                    <a href="/article/${item.id}">${item.title}</a>
                </div>
                <div class="one-element-sub-title">
                    <span class="one-element-author">${item.author}</span>
                    <span class="one-element-time">${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="one-element-content">
                ${item.summary}
                </div>
                <a href="/article/${item.id}" class="more" target="_blank">阅读全文&gt;&gt;</a>
            </div>
        </div>
    </div>

</#list>

</div>

<div class="list-page">
    <ul class="pagination">
        <li><a href="/article/list/1">首页</a></li>
        <li><a href="/article/list/${prev}">&laquo;</a></li>
        <#list 1..pageNum as i>
        <li><a href="/article/list/${i}">${i}</a></li>
        </#list>
        <li><a href="/article/list/${next}">&raquo;</a></li>
        <li><a href="/article/list/${pageNum}">末页</a></li>
    </ul>
</div>

<#include "../foot.ftl">
</body>
</html>
