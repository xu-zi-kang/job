import Vue from 'vue'
import VueRouter from 'vue-router'
import local from "../store/local";

Vue.use(VueRouter)

const constantRouterMap = [
    {
        path: '/',
        name: 'index',
        component: () => import('@/front/Index')
    },
    {
        path: '/list/:id',
        name: 'list',
        component: () => import('@/front/List')
    },
    {
        path: '/post_list',
        name: 'post_list',
        component: () => import('@/front/PostList')
    },
    {
        path: '/detail/:id',
        name: 'detail',
        component: () => import('@/front/Detail')
    },
    {
        path: '/detail3/:id',
        name: 'detail',
        component: () => import('@/front/Detail2')
    },

    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/Login')
    },


    {
        path: '/edit',
        name: 'edit',
        component: () => import('@/views/company/CompanyInfo2')
    },

    {
        path: '/edit2',
        name: 'edit2',
        component: () => import('@/views/student/StudentInfo2')
    },


    {
        path: '/register',
        name: 'register',
        component: () => import('@/front/Register')
    }
]

const createRouter = () => new VueRouter({
    mode: 'history',
    routes: constantRouterMap
})

const router = createRouter();
export default router

export function resetRouter() {
    const newRouter = createRouter();
    router.matcher = newRouter.matcher;
}
