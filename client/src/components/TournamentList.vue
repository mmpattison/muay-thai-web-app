<template>
  <section>
    <h2>Tournaments</h2>
      <!-- <router-link:to="'/tournament' + tournament.id"> -->
    <tournament-card v-for="tournament in tournaments" :key="tournament.id" :tournament="tournament" />
  <!-- </router-link> -->
    </section>
</template>

<script>
import TournamentCard from './TournamentCard.vue';
export default {

  components: {
    TournamentCard
  },
  computed: {
    tournaments(){
      return this.$store.state.tournaments;
    }
  }
}
</script>

<style>
#tournament
TournamentCards {
    grid-area: tournaments;
    
    display: flex;
    font-size: 2rem;
    font-weight: 400;
    border-radius: 5px;
}
#tournament-list {
    font-weight: bold;
}

#tournament-items {
    font-weight: lighter;
}
</style>