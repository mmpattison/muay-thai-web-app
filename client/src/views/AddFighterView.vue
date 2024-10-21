<template>
  <fighter-edit :tournamentId = "$route.params.id"/>
</template>

<script>
import FighterEdit from '../components/FighterEdit.vue'
export default {
  components: { FighterEdit },

}
</script>

<style>

</style>