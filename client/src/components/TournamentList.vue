<template>
  <section>
    
    <h2 id="list-title">Tournaments</h2>
    <div class="tournament-list">
      <!-- <router-link v-bind="{name:'tournament-view', params: {tournamentId: tournament.id}}"> -->
    <tournament-card v-for="tournament in tournaments" :key="tournament.id" :tournament="tournament" />
  <!-- </router-link> -->
  </div>
    </section>
</template>

<script>
import TournamentCard from "./TournamentCard.vue"

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
/* #tournament
TournamentCards {
    grid-area: tournaments;
    
    display: flex;
    font-size: 2rem;
    font-weight: 400;
    border-radius: 5px;
} */
.tournament-list {
    display: flex;
    justify-content: center;
}

#tournament-items {
    font-weight: lighter;
}
#list-title{
  align-content: center;
  font-size: 28px;
  /* margin-bottom: 20px; */
  font-weight: bold;
}

@media (max-width: 425px) {
  .tournament-list {
    display: grid;
    justify-content: center;
}
}
</style>