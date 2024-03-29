import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CareerView from '../views/CareerView.vue'
import BlogView from '../views/BlogView.vue'
import AdminView from '../views/AdminView.vue'
import ActivityView from '../views/ActivityView.vue'
import LoginView from '../views/LoginView.vue'
function guardMyroute(to, from, next)
{
//this is just an example. You will have to find a better or 
// centralised way to handle you localstorage data handling 
if(localStorage.getItem('LoggedUser'))
  next();
 else
  next('/loginesqueadmin2023');
}

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/career',
    name: 'career',
    component: CareerView
  },
  {
    path: '/blog',
    name: 'blog',
    component: BlogView
  },
  {
    path: '/adminesqueadmin2023',
    name: 'adminesqueadmin2023',
    beforeEnter : guardMyroute,
    component: AdminView
  },
  {
    path: '/activity',
    name: 'activity',
    component: ActivityView
  },
  {
    path: '/loginesqueadmin2023',
    name: 'loginesqueadmin2023',
    component: LoginView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
