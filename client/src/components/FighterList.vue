<template>
  <section class="fighter-list-main">
    <h2 id="list-title">Fighters</h2>
    <div class="fighter-list">
    <fighter-card v-for="fighter in fighters" :key="fighter.id" :fighter="fighter"/>
  </div>
  </section>
</template>

<script>
import FighterCard from "./FighterCard.vue";

export default {
  props: [
  "blueCornerFighter", "redCornerFighter"
  ],
  components: {
    FighterCard,
  },
  computed: {
    fighters() {
      if(this.blueCornerFighter && this.redCornerFighter){
        return this.$store.state.fighters.filter((fighter)=>{
          return fighter.id == this.blueCornerFighter.id || fighter.id == this.redCornerFighter.id;
        });
      }
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


#list-title{
 align-content: center;
  
}

@media (max-width: 425px) {
  .fighter-list {
    display: grid;
    justify-content: center;
}
}


</style>