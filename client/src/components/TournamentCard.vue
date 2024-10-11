<template>
<div class="tournament-card">
    <img :src="tournament.imgUrl"/>
    <h2 class="tournament-name">{{ tournament.tournamentName }}</h2>
    <h3 class="location">{{ tournament.location }}</h3>
    <h3 class="dates">{{ tournament.startDate }} - {{ tournament.endDate }}</h3>
</div>
</template>

<script>
export default {
props: [
  "tournament"
]
}
</script>

<style>
.tournament-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  background-color: #eef4ed;
}


.tournament-card .book-title {
  font-size: 1.5rem;
}

.tournament-card .location {
  font-size: 1rem;
}
.tournament-card .dates {
  font-size: 1rem;
}
</style>