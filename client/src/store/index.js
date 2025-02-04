import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      tournaments: [],
      token: currentToken || '',
      user: currentUser || {},
      fighters:[],
      fights: [],
      gyms: [],
      weightClasses: [],
    },
    
    mutations: {
      SET_FIGHTERS(state, fighters){
        state.fighters = fighters;
      },
      SET_TOURNAMENTS(state, tournaments){
        state.tournaments = tournaments;
      },
      SET_FIGHTS(state, fights){
        state.fights = fights;
      },
      SET_GYMS(state, gyms){
        state.gyms = gyms;
      },
      SET_WEIGHT_CLASSES(state, weightClasses){
        state.weightClasses = weightClasses;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },

  })
  return store;
}