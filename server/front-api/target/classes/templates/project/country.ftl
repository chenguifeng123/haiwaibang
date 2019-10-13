<!DOCTYPE html>
<html lang="en">
<head>
<#include "../header.ftl">
    <link rel="stylesheet" href="/css/country.css">
</head>
<body>
<#include "../menu.ftl">

<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li class="active">国家</li>
    <li class="active">${country.nameZh}</li>
</ul>

<div class="investmentContrast countryProjectContrast">
    <div class="project-section">
        <span class="project-section_title"><span class="glyphicon glyphicon-globe"></span>海外邦${country.nameZh}热门项目</span>
    </div>
    <div class="countryProjectContrast-list">
        <#list project as item>
        <div class="countryProjectContrast-list_view">
            <p class="projectType">${item.typeName}</p>
            <p class="title">${item.name}</p>
            <div class="desc" >
                <span>${item.detail}</span>
            </div>
            <div class="btnGroup">
                <a href="/project/${item.id}">查看详细</a>
            </div>
        </div>
        </#list>

    </div>

</div>


<#include "../foot.ftl">
</body>
</html>
