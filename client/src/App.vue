<template>
  <div id="muay-thai-app">

      <header-component id="header-component" class="header"/>
    
     
    <main>
      <router-view />
      <section id="about">
      <p>
        Quality not Quantity!
        The TBA-SA was not established to eliminate other sanctioning bodies. 
        The TBA-SA is here to support the TBA-USA and promote Muay Thai, not FCR/IR Kickboxing, MMA, or Boxing. 
        By focusing exclusively on Muay Thai, it allows the TBA-SA to host professionally ran Muay Thai tournaments, and sanction Muay Thai shows in North America, 
        where the integrity of Muay Thai is upheld with qualified Muay Thai officials and rules.
    </p>
  </section>
    </main>
    <footer>&copy; 2024 All Rights Reserved</footer>
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
    grid-template-rows: 1fr .5fr 3fr .15fr;
    gap: 10px;
    height: 100vh;
    margin:5px;
    overflow-x: hidden;
    width: 100vw;
    font-family: 'Oswald', sans-serif;
    color: #0b2545;
    
}
body{
  background-color: #134074;
}

#header-component {
  grid-area: header;
}
   


  #about {
    grid-area: main;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    background-color: #8da9c4;
    justify-content: center;
    border-radius: 5px;
    padding: 10px;

}

  footer {
    grid-area: footer;
    background-color: #ddd;
    text-align: center;
    padding: 10px;
}
    

</style>