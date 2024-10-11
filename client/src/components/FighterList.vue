<template>
  <section>
    <h2>Fighters</h2>
    <fighter-card />
  </section>
</template>

<script>
import FighterCard from "./FighterCard.vue";

export default {
  components: {
    FighterCard,
  },
  computed: {
    fighters() {
      return this.$store.state.fighters;
    },
  },
};
</script>

<style>

</style>