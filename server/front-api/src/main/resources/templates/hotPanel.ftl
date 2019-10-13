<div class="hot-country-center">
    <h3 class="index-common_title">热门国家</h3>
    <h4 class="index-common_title_desc text-center">
        <span class="index-common_title_span inblock"></span>
        <span class="index-common_title_mid inblock">最优秀,最有前景国家优势介绍</span>
        <span class="index-common_title_span inblock"></span>
    </h4>

    <#list hotCountry as item>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">${item.country.nameZh}</h3>
            </div>
            <div class="panel-body">
                <a href="${item.url}">
                    <img src="${item.image.url}">
                </a>
            </div>
        </div>
    </#list>
</div>

<div class="hot-project-center">
    <h3 class="index-common_title text-center">
        <span class="relative">热点项目<img src="/img/icon-hot.png" class="inblock index_project_icon">
        </span>
    </h3>
    <h4 class="index-common_title_desc text-center">
        <span class="index-common_title_span inblock"></span>
        <span class="index-common_title_mid inblock">最新最热门的项目</span>
        <span class="index-common_title_span inblock"></span>
    </h4>

<#list hotProject as item>
    <div class="panel panel-warning">
        <div class="panel-heading">
            <h3 class="panel-title">${item.project.nameZh}</h3>
        </div>
        <div class="panel-body">
            <a href="${item.url}">
                <img src="${item.image.url}">
            </a>
        </div>
    </div>
</#list>

</div>