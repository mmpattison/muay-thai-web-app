<template>
  <router-link
    v-bind:to="{
      name: 'tournament-view',
      params: { id: tournament.id },
    }"
  >
    <div class="tournament-card">
      <img class="tournament-card-img" :src="tournament.imgUrl" />
      <h2 class="tournament-name">
        {{ tournament.tournamentName }}
      </h2>
      <h3 class="location">{{ tournament.location }}</h3>
      <h3 class="dates">
        {{ tournament.startDate }} - {{ tournament.endDate }}
      </h3>
    </div>
  </router-link>
</template>

<script>
export default {
  props: ["tournament"],
};
</script>

<style>
.tournament-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  background-color: #eef4ed;
  align-content: center;
}

.tournament-card-img {
  padding: 5px;
}

.tournament-card .tournament-name {
  font-size: 1.5rem;
  /* align-content: center; */
  text-align: center;
}

.tournament-card .location {
  font-size: 1rem;
  
  text-align: center;
}
.tournament-card .dates {
  font-size: 1rem;
  /* align-content: center; */
  justify-items: center;
  text-align: center;
}
</style>