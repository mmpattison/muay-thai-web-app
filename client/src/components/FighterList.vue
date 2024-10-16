<template>
  <section>
    <h2>Fighters</h2>
    <div class="fighter-list">
    <fighter-card v-for="fighter in fighters" :key="fighter.id" :fighter="fighter"/>
  </div>
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
.fighter-list {
  display: flex;
  justify-content: space-evenly;
}
</style>