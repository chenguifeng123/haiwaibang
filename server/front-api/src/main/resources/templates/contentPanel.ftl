<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="artile-part">
                <div class="ptitle">
                    <h3><a href="/article/list" target="_blank">移民新闻</a>
                        <p><a href="/article/list" target="_blank">&gt;&gt;更多</a></p>
                    </h3>
                </div>

                <#list articleRecommend as item>
                <#if item_index == 0>

                <div class="row element-content" >
                    <div class="col-md-5">
                        <a href="/article/${item.id}">
                            <img src="${item.imageUrl}">
                        </a>
                    </div>
                    <div class="col-md-6 element-content-panel">
                        <div class="element-title">
                            <a href="/article/${item.id}">${item.title}</a>
                        </div>
                        <div class="element-sub-title">
                            <span class="element-author">${item.author}</span>
                            <span class="element-time">${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
                        </div>
                        <div class="element-content-desc">
                        ${item.summary}
                        </div>
                        <a class="read-more" href="/article/${item.id}" target="_blank">阅读全文&gt;&gt;</a>
                    </div>
                </div>
                <#else >
                <li>
                    <span>
                    <a href="/article/${item.id}" title="" target="_blank">${item.title}</a>
                    </span>
                    <samp>${item.createTime?string('yyyy-MM-dd HH:mm:ss')} </samp>
                </li>

                </#if>
                </#list>
            </div>

        </div>
        <div class="col-md-3">

            <div class="recommend">
                <h3>经典案例</h3>
                <ul>
                    <#list exampleRecommend as item>
                        <#if item_index < 3>
                            <li><span class="num active">${item_index + 1}</span>
                                <a href="/example/${item.id}" title="" target="_blank">${item.title}</a>
                            </li>
                        <#else>
                            <li><span class="num">${item_index + 1}</span>
                                <a href="/example/${item.id}" title="" target="_blank">${item.title}</a>
                             </li>
                        </#if>
                    </#list>
                </ul>
                <p><a href="/example/list" target="_blank">&gt;&gt;更多</a></p>
            </div>


        </div>
    </div>

   </div>