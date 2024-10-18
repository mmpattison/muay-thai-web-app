<template>
  <div id="fight-main">
    <div>
      <fighter-list
        :blueCornerFighter="blueCornerFighter"
        :redCornerFighter="redCornerFighter"
      />
    </div>
    <section>
      <div id="fight-information">
        <h3>Winner: {{ fight.winner }}</h3>
        <h3>Loser: {{ fight.loser }}</h3>
        <h3>Win Type: {{ fight.winType }}</h3>
      </div>
    </section>
  </div>
</template>

<script>
import FighterList from "../components/FighterList.vue";
import { ResourceService } from "../services/ResourceService";
export default {
  components: { FighterList },
  data() {
    return {
      fight: {
        winner: "",
        loser: "",
        blueCornerId: "",
        redCornerId: "",
        winType: "",
        fightName: "",
        tournamentId: "",
        id: "",
      },
      redCornerFighter: {},
      blueCornerFighter: {},
    };
  },
  created() {
    ResourceService.getFighters().then((response) => {
      this.$store.commit("SET_FIGHTERS", response.data);

      this.fight = this.$store.state.fights.find((fight) => {
        return fight.id == this.$route.params.id;
      });
      this.redCornerFighter = this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.fight.redCornerId;
      });
      this.blueCornerFighter = this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.fight.blueCornerId;
      });
    });
  },
};
</script>

<style>
#fight-main{
  display: grid;
  justify-items: center;
}



#fight-information {
  background-color: #eef4ed;
  border: 2px solid black;
  border-radius: 10px;
  justify-content: center;
  align-content: center;
  width: 200px;
  text-align: center;
}
</style>