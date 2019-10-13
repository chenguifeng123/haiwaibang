import NotFound from './views/404.vue'
import App from './App.vue';
import Home from './components/home/home.vue';
import About from './components/home/About.vue';
import CountryList from './components/country/CountryList.vue';
import ArticleList from './components/content/articleList.vue';
import ExampleList from './components/content/exampleList.vue';
import CampaignList from './components/content/campaignList.vue';
import ArticleDetail from './components/content/articleDetail.vue';
import ExampleDetail from './components/content/exampleDetail.vue';
import CampaignDetail from './components/content/campaignDetail.vue';

import Country from './components/country/Country.vue';
import Project from './components/country/Project.vue';
import Detail from './components/country/Detail.vue';

import Custom from './components/custom/Custom.vue';

let routes = [
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: App,
        name: '项目配置',
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home,
        name: 'home',
    },
    {
        path: '/about',
        component: About,
        name: 'about',
    },
    {
        path: '/custom',
        component: Custom,
        name: 'custom',
    },
    {
        path: '/countryList',
        component: CountryList,
        name: 'countryList',
    },
    {
        path: '/articleList',
        component: ArticleList,
        name: 'articleList',
    },
    {
        path: '/exampleList',
        component: ExampleList,
        name: 'exampleList',
    },
    {
        path: '/campaignList',
        component: CampaignList,
        name: 'campaignList',
    },
    {
        path: '/exampleDetail',
        component: ExampleDetail,
        name: 'exampleDetail',
    },
    {
        path: '/articleDetail',
        component: ArticleDetail,
        name: 'articleDetail',
    },
    {
        path: '/campaignDetail',
        component: CampaignDetail,
        name: 'campaignDetail',
    },
    {
        path: '/country',
        component: Country,
        name: 'country',
    },
    {
        path: '/project',
        component: Project,
        name: 'project',
    },
    {
        path: '/detail',
        component: Detail,
        name: 'detail',
    },
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];

export default routes;