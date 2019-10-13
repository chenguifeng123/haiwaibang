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
    <li><a href="/article/list">文章列表</a></li>
    <li class="active">${article.title}</li>
</ul>

<div class="main-page">
    <div class="row">
        <div class="col-md-9 article-panel">

            <div class="header-title">
                ${article.title}
             </div>
            <div class="header-small-tille">
                <span class="header-author">${article.author}</span>
                <span class="header-time">${article.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
            </div>
            <div class="html-contents">
                ${article.contents}
            </div>
        </div>
        <div class="col-md-3">
            <div class="recommend-list">
                <header><h3>为您推荐</h3></header>

                <ul>
                <#list articleRecommend as item>
                    <li>
                        <a href="/article/${item.id}" title="" target="_blank">${item.title}</a>
                    </li>
                </#list>
                </ul>
                <p><a href="/article/list" target="_blank">&gt;&gt;更多</a></p>
            </div>
        </div>
    </div>


</div>


<#include "../foot.ftl">
</body>
</html>
