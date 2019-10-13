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
    <li><a href="/example/list">案例列表</a></li>
    <li class="active">${example.title}</li>
</ul>

<div class="main-page">
    <div class="row">
        <div class="col-md-9 article-panel">

            <div class="header-title">
                ${example.title}
            </div>
            <div class="header-small-tille">
                <span class="header-author">${example.author}</span>
                <span class="header-time">${example.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
            </div>
            <div class="html-contents">
                ${example.contents}
            </div>

        </div>
        <div class="col-md-3">
            <div class="recommend-list">
                <header><h3>为您推荐</h3></header>
                <ul>
                <#list exampleRecommend as item>
                    <li>
                        <a href="/example/${item.id}" title="" target="_blank">${item.title}</a>
                    </li>
                </#list>
                </ul>
                <p><a href="/example/list" target="_blank">&gt;&gt;更多</a></p>
            </div>
        </div>
    </div>

</div>


<#include "../foot.ftl">
</body>
</html>
