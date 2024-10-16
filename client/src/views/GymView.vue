<template>
  <div id="gym-main">
    <p id="title">{{ gym.gymName }}</p>
    <p id="location">{{ gym.gymLocation }}</p>
    <div>
    <fighter-list id="fighter-list"/>
  </div>
    </div>
</template>

<script>
import FighterList from "../components/FighterList.vue";
import { ResourceService } from '../services/ResourceService';
export default {
  components: { FighterList,},
    created() {
        ResourceService.getFightersByGymId(this.$route.params.id)
        .then(response => {
            this.$store.commit("SET_FIGHTERS", response.data);
        });
    },
    computed: {
      gym(){
        return this.$store.state.gyms.find((gym) => {
          return gym.id == this.$route.params.id;
        })
      },
      fighters(){
        return this.$store.state.fighters;
      }
    }
};
</script>

<style>
#gym-main {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  width: 100%;
}

#title {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 10px;
  text-align: center;
  display: block;
}

#location {
  font-size: 1.2rem;
  margin-bottom: 30px;
  text-align: center;
  width: 100%;
}

#fighter-list {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;
}
</style>