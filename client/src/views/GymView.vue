<template>
  <div><fighter-list /></div>
</template>

<script>
import FighterList from "../components/FighterList.vue";
import { ResourceService } from '../services/ResourceService';
export default {
  components: { FighterList,},
    created() {
        ResourceService.getFighters()
        .then(response => {
            this.$store.commit("SET_FIGHTERS", response.data);
        });
    }
};
</script>

<style>
</style>