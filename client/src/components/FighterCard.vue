<template>
     <router-link
    v-bind:to="{
      name: 'fighter-view',
      params: { id: fighter.id },
    }"
  >
    <div class="fighter-card">
        <img class="fighter-img" :src="fighter.imgUrl"/>
        <h2 class="fighter-name">{{ fighter.fighterName }}</h2>
        
    </div>
     </router-link>
</template>

<script>
export default {
props: [
    "fighter", "blueCornerFighter", "redCornerFighter"
]
}
</script>

<style scoped>
.fighter-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 200px;
  height: 250px;
  text-align: center;
  padding: 10px;
  margin: 20px;
  background-color: #eef4ed;
  justify-content: center;
  align-content: center;
}

.fighter-img {
    padding: 3px;
    width: auto;
    height: 200px;
    justify-content: center;
    align-items: center;
    object-fit: contain;
}
</style>