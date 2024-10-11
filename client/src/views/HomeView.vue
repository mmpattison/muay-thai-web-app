<template>
  <div><tournament-list /></div>
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
</style>