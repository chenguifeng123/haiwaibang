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
    <li><a href="/campaign/list">活动列表</a></li>
    <li class="active">${campaign.title}</li>
</ul>

<div class="main-page">
    <div class="row">
        <div class="col-md-9 article-panel">

            <div class="header-title">
            ${campaign.title}
            </div>
            <div class="header-small-tille">
                <span class="header-author">${campaign.author}</span>
                <span class="header-time">${campaign.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
            </div>
            <div class="html-contents">
            ${campaign.contents}
            </div>
        </div>
        <div class="col-md-3">
            <div class="recommend-list">
                <header><h3>为您推荐</h3></header>

                <ul>
                <#list articleRecommend as item>
                    <li>
                        <a href="/campaign/${item.id}" title="" target="_blank">${item.title}</a>
                    </li>
                </#list>
                </ul>
                <p><a href="/campaign/list" target="_blank">&gt;&gt;更多</a></p>
            </div>
        </div>
    </div>


</div>


<#include "../foot.ftl">
</body>
</html>
