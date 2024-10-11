<template>
    <div class="fighter-card">
        <img :src="fighter.imgUrl"/>
        <h2 class="fighter-name">{{ fighter.tournamentName }}</h2>
    </div>
</template>

<script>
export default {
props: [
    "fighter"
]
}
</script>

<style>
.fighter-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  background-color: #eef4ed;
}
</style>