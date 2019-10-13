<div class="menu-container">

    <ul class="nav nav-pills ">
        <li><img src="/img/logo.png" width="150px" height="50px" alt="logo"/></li>
        <li class="first-menu-item"><a href="/">首页</a></li>
        <li class="dropdown nav-box nav-country-box">
            <a href="#" class="nav-link" target="_blank">移民国家</a>
            <i class="nav-line"></i>
            <div class="haiwaibang-country-menu">
                <i></i>
            <#list continent as item>
                <div class="country-menu clearfix">
                    <p>${item.continentName}：</p>
                    <ul>
                        <#list item.subCountrys as country>
                            <li><a href="/country/${country.name}/" target="_blank">${country.nameZh}</a></li>
                        </#list>
                    </ul>
                </div>
            </#list>
            </div>
        </li>
        <li ><a href="/">移民交流平台</a></li>
        <li ><a href="/resource/resource" >项目资源包</a></li>
        <li ><a href="/about">关于海外邦</a></li>

        <ul class="right-login">
            <img src="/img/avator.png" alt="logo" class="animated bounceInDown" />
            <a href="/corporation/login">登陆</a>
        </ul>
    </ul>


</div>
<div class="menu-line">

</div>