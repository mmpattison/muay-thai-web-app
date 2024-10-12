<template>
  <p>{{ tournament.tournamentName }}</p>
  <button>Gyms</button>
  <button>Fights</button>
  <button>Fighters</button>
</template>

<script>
export default {
  components: {},

  computed: {
    tournament() {
      return this.$store.state.tournaments.find((tournament) => {
        return tournament.id == this.$route.params.id;
      });
    },
  },
};
</script>

<style>
</style>