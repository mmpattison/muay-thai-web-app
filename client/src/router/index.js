import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LogoutView from '../views/LogoutView.vue'
import RegisterView from '../views/RegisterView.vue'
import TournamentView from '../views/TournamentView.vue'
import GymView from '../views/GymView.vue'
import FightView from '../views/FightView.vue'
import FighterView from '../views/FighterView.vue'
import EditFighterView from '../views/EditFighterView.vue'
import AddFighterView from '../views/AddFighterView.vue'



/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/tournament/:id',
      name: 'tournament-view',
      component: TournamentView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/gym/:id',
      name: 'gym-view',
      component: GymView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/fight/:id',
      name: 'fight-view',
      component: FightView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/fighter/:id',
      name: 'fighter-view',
      component: FighterView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/fighter/:id",
      name: "edit-fighter",
      component: EditFighterView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/tournament/:id/fighter/",
      name: "add-fighter",
      component: AddFighterView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: LogoutView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: RegisterView,
      meta: {
        requiresAuth: false
      }
    }
  ];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
