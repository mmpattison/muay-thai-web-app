<template>
  <head><title>Thai Boxing Association</title></head>
  
  <div id="muay-thai-app">
   
      <header-component class="header"/>
    
     
    <main id="main">
      <router-view />
      
    </main>
    <footer id="footer">&copy; 2024 All Rights Reserved</footer>
  </div>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue';
import { ResourceService } from './services/ResourceService';

export default {
  created(){

this.isLoading = true;

// Promise.all([
//   ResourceService.getGyms(),
//   ResourceService.getFights(),
//   ResourceService.getFighters()
  // ResourceService.getFightersByTournamentId(this.$route.params.id)
// ]).then(([gymResponse, fightResponse, fighterResponse]) => {
//   this.$store.commit("SET_GYMS", gymResponse.data);
//   this.$store.commit("SET_FIGHTS", fightResponse.data);
//   this.$store.commit("SET_FIGHTERS", fighterResponse.data);
  // alert(fighterResponse.data[0].fighterName);
//   this.isLoading = false;
// });

// SINGLE PROMISE
// ResourceService.getGyms()
// .then(response => {
//   this.$store.commit("SET_GYMS", response.data)
// });

},
  components: {
  
    HeaderComponent
  },

}
</script>

<style>
    #muay-thai-app {
    display: grid;
    grid-template-areas: 
    "header         header        header"
    "main           main           main"
    "footer         footer        footer";
    
    grid-template-columns: 1fr 3fr 1.5fr;
    grid-template-rows: 1fr 3fr .15fr;
    gap: 10px;
    /* height: 100vh; */
    margin:5px;
    overflow: hidden;
    width: 99%;
    height: 96vh;
    font-family: 'Oswald', sans-serif;
    color: #0b2545;
    
}
body{
  background-color: #134074;
}

main, header, footer {
    border-radius: 5px;
    padding: 5px;
}

header {
  grid-area: header;
}
  main{
    grid-area:main;
    background-color: #8da9c4;
    overflow: hidden;
    overflow-y: auto;
  }

  li {
    list-style: none;
  }

  a:link {
    color:#0b2545;
    text-decoration: none;
  }

  a:visited {
    color:#0b2545;

  }


  footer {
    grid-area: footer;
    background-color: #ddd;
    text-align: center;
    padding: 10px;
}

form {
  max-width: 500px;
  margin: 2rem auto;
  padding: 2rem;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  font-family: Arial, sans-serif;
}

form label {
  font-size: 1rem;
  color: #333;
  margin-bottom: 0.5rem;
  display: block;
}

form input[type="text"],
form input[type="password"],
form input[type="number"],
form select,
form textarea {
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fff;
  transition: border-color 0.3s ease;
  margin-bottom: 1rem;
}

form input[type="text"]:focus,
form input[type="password"]:focus,
form input[type="number"]:focus,
form select:focus,
form textarea:focus {
  border-color: lightsteelblue;
  outline: none;
}

form textarea {
  resize: vertical;
  height: 120px;
}

form div {
  margin-bottom: 1.5rem;
}
@media (max-width:425px) {

header {
    /* flex-direction: column; */
    flex-wrap: wrap;
}

nav {
    align-self: stretch;
}
}
</style>