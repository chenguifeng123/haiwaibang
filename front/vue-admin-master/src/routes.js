import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'
import Main from './views/Main.vue'
import Country from './views/projectconfig/Country.vue'
import Program from './views/projectconfig/Project.vue'
import ProjectSource from './views/projectconfig/ProjectSource.vue'
import CountrySource from './views/projectconfig/CountrySource.vue'
import CountryImage from './views/projectconfig/CountryImage.vue'
import ProjectImage from './views/projectconfig/ProjectImage.vue'
import Banner from './views/pcui/Banner.vue'

import HotCountry from './views/pcui/HotCountry.vue'
import HotProject from './views/pcui/HotProject.vue'
import Article from './views/pcui/Article.vue'
import Example from './views/pcui/Example.vue'
import Campaign from './views/pcui/Campaign.vue'
import Content from './views/pcui/Content.vue'

import MobileBanner from './views/mobileui/MobileBanner.vue'
import MobileHotCountry from './views/mobileui/MobileHotCountry.vue'
import MobileCountryImage from './views/mobileui/MobileCountryImage.vue'
import MobileProjectImage from './views/mobileui/MobileProjectImage.vue'

import Permission from './views/user/Permission.vue'

import Custom from './views/other/Custom.vue'

import UeDemo from './views/ueditor_demo.vue'

let routes = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: Home,
        name: '用户配置',
        iconCls: 'el-icon-message',//图标样式class
        children: [
            { path: '/permission', component: Permission, name: '权限管理' },
        ]
    },
    {
        path: '/',
        component: Home,
        name: '项目配置',
        iconCls: 'el-icon-message',//图标样式class
        children: [
            { path: '/main', component: Main, name: '主页', hidden: true },
            { path: '/country', component: Country, name: '国家' },
            { path: '/program', component: Program, name: '项目' },
            { path: '/countrySource', component: CountrySource, name: '国家资源' },
            { path: '/projectSource', component: ProjectSource, name: '项目资源' },
            { path: '/content', component: Content, name: '内容发布器' },
            { path: '/custom', component: Custom, name: '用户定制' },
        ]
    },
    {
        path: '/',
        component: Home,
        name: '电脑设置',
        iconCls: 'fa fa-id-card-o',
        children: [
            { path: '/banner', component: Banner, name: '广告栏配置' },
            { path: '/countryImage', component: CountryImage, name: '国家图片配置' },
            { path: '/projectImage', component: ProjectImage, name: '项目图片配置' },
            { path: '/hotCountry', component: HotCountry, name: '热门国家配置' },
            { path: '/hotProject', component: HotProject, name: '热门项目配置' },
            { path: '/article', component: Article, name: '移民新闻配置' },
            { path: '/example', component: Example, name: '移民案例配置' },
            { path: '/campaign', component: Campaign, name: '活动配置' },
        ]
    },
    {
        path: '/',
        component: Home,
        name: '手机设置',
        iconCls: 'el-icon-message',
        children: [
            { path: '/mobileBanner', component: MobileBanner, name: '广告栏配置' },
            { path: '/mobileCountryImage', component: MobileCountryImage, name: '国家图片配置' },
            { path: '/mobileProjectImage', component: MobileProjectImage, name: '项目图片配置' },
            { path: '/mobileHotCountry', component: MobileHotCountry, name: '推荐国家配置' },
        ]
    },
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];

export default routes;