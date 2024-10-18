<template>
  <div><tournament-list id="tournament-list"/>
  <section id="about">
      <p>
        Quality not Quantity!
        The TBA-SA was not established to eliminate other sanctioning bodies. 
        The TBA-SA is here to support the TBA-USA and promote Muay Thai, not FCR/IR Kickboxing, MMA, or Boxing. 
        By focusing exclusively on Muay Thai, it allows the TBA-SA to host professionally ran Muay Thai tournaments, and sanction Muay Thai shows in North America, 
        where the integrity of Muay Thai is upheld with qualified Muay Thai officials and rules.
    </p>
  </section>
</div>
</template>

<script>
import TournamentList from "../components/TournamentList.vue";
import {ResourceService} from "../services/ResourceService.js";
export default {
  components: { TournamentList },
  created() {
    ResourceService.getTournaments()
    .then(response => {
      this.$store.commit("SET_TOURNAMENTS", response.data );
    });
    
  },
};
</script>

<style>

#main-div {
   display: grid;
   grid-template-rows: auto auto;
   grid-template-areas: 
    "tournaments"
    "about";
    height: 100%;
}

#about {
    grid-area: main;
    /* width: 500px; */
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: center;
    background-color: #eef4ed;
    justify-content: center;
    border-radius: 5px;
    padding: 10px;
    overflow-y: hidden;
}

#tournament-list {
  grid-area: tournaments;
  overflow-y: auto;
  max-height: 100%; 
}
</style>