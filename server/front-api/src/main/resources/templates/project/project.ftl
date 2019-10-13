<!DOCTYPE html>
<html lang="en">
<head>
<#include "../header.ftl">
    <link rel="stylesheet" href="/css/project.css">
</head>
<body>
<#include "../menu.ftl">

<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li class="active">项目</li>
    <li class="active">${project.nameZh}</li>
</ul>

<div class="project-main">
    <div class="row">
    <div class="col-md-4" >
                <div class="img">
                    <#if img?? && (img?size > 0) >
                        <img src="${img[0].url}">
                    <#else >
                        <img src="${defaultImg}">
                    </#if>
                </div>
    </div>
    <div class="col-md-7">
        <h4 class="media-heading"> <b>${project.nameZh}</b> </h4>

        <p class="text-left m20"><b>项目介绍：</b>
            ${project.detail}
        </p>

        <div class="col-md-12 p0">
            <em>移民热度：<span>★★★★★</span></em>
            <em>社会福利：<span>★★★★★</span></em>
        </div>

        <div class="col-md-12 p0 m20">
            <em>投资教育：<span>★★★★★</span></em>
            <em>居住环境：<span>★★★★★</span></em>
        </div>

        <div class="column-action">
            <a href="/" class="btn-inline btn-light">评估</a>
            <a href="/" onclick="/" class="btn-preorder btn-inline btn-primary">咨询预约</a>
        </div>

    </div>

    <div class="col-md-1">
    </div>

    </div>
</div>


<section class="nry_center">
    <header class="nry_header">
        <em>移民资料</em>
    </header>

    <dl class="jxbd clearfix" style="margin-bottom: 30px;">
        <dd class="item jxbd_left">
            <header>
                <em>项目资料</em>
            </header>
            <ul>
                <#if doc?? && (doc?size > 0) >
                <#list doc as item>
                <li>
                    <a href="/detail?url=${item.url}" target="_blank">
                        ${item.name}
                    </a>
                </li>
                </#list>
                </#if>
            </ul>
        </dd>

        <dd class="item jxbd_right">
            <header>
                <em>国家资料</em>
            </header>

            <ul>
            <#if country_doc?? && (country_doc?size > 0) >
            <#list country_doc as item>
                <li>
                    <a href="/detail?url=${item.url}" target="_blank">
                    ${item.name}
                    </a>
                </li>
            </#list>
            </#if>
            </ul>
        </dd>
    </dl>
</section>


<#include "../foot.ftl">
</body>
</html>