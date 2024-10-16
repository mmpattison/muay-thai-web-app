<template>
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

export default {
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
    overflow-x: hidden;
    width: 100vw;
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
    
    /* overflow: hidden; */
  }

  li {
    list-style: none;
  }



  footer {
    grid-area: footer;
    background-color: #ddd;
    text-align: center;
    padding: 10px;
    
}
    

</style>