<template>
  <div>
    <fighter-edit :fighterId = "$route.params.id"/>
  </div>

</template>

<script>
import FighterEdit from '../components/FighterEdit.vue'
export default {
    
    components: {
        FighterEdit},
    
}
</script>

<style>

</style>