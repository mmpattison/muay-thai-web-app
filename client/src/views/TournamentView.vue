<template>
  <div id="tournament-main">
    <p id="title">{{ tournament.tournamentName }}</p>
    <div id="tournament-details">
      <div id="details">
        <img :src="tournament.imgUrl" alt="Tournament Logo" class="logo" />
        <h3 class="date">{{ tournament.startDate }} - {{ tournament.endDate }}</h3>
        <h3 class="location">{{ tournament.location }}</h3>
      </div>
      <section id="buttons">
        <details name="tournament-info">
          <summary>Gyms</summary>
          <ul >
            <router-link v-for="gym in gyms" :key="gym.id"
            v-bind:to="{
              name:'gym-view', 
              params: {id: gym.id},
              }">
            <li >
              {{ gym.gymName }}
            
            </li>
          </router-link>
          </ul>
        </details>
        <details name="tournament-info">
          <summary>Fights</summary>
          <ul >
            <router-link v-for="fight in fights" :key="fight.id"
            v-bind:to="{
              name:'fight-view', 
              params: {id: fight.id},
              }">
            <li >
              {{ fight.winner }} vs {{ fight.loser }}
            </li>
          </router-link>
          </ul>
        </details>
        <details name="tournament-info">
          <summary>Fighters
          <span class="icon-container" v-if="isAdmin">
            <router-link
              v-bind:to="{
                name: 'add-fighter',
                params: { id: tournament.id },
              }"
            >
              <font-awesome-icon
                :icon="['fas', 'circle-plus']"
                class="icon"
                title="Add fighter"
              />
            </router-link>
          </span>
        </summary>
          <ul >
            <router-link v-for="fighter in fighters" :key="fighter.id"
            v-bind:to="{
              name:'fighter-view', 
              params: {id: fighter.id},
              }">
            <li >
              {{ fighter.fighterName }}
            </li>
          </router-link>
          </ul>
        </details>
      </section>
    </div>
  </div>
</template>

<script>
import {ResourceService} from "../services/ResourceService.js"

export default {
  // components: {ResourceService },
  created(){

    this.isLoading = true;

    Promise.all([
      ResourceService.getGyms(),
      ResourceService.getFights(),
      // ResourceService.getFighters()
      ResourceService.getFightersByTournamentId(this.$route.params.id)
    ]).then(([gymResponse, fightResponse, fighterResponse]) => {
      this.$store.commit("SET_GYMS", gymResponse.data);
      this.$store.commit("SET_FIGHTS", fightResponse.data);
      this.$store.commit("SET_FIGHTERS", fighterResponse.data);
      // alert(fighterResponse.data[0].fighterName);
      this.isLoading = false;
    });

    // SINGLE PROMISE
    // ResourceService.getGyms()
    // .then(response => {
    //   this.$store.commit("SET_GYMS", response.data)
    // });

  },
  computed: {
    isAdmin() {
      return (
        this.$store.state.user &&
        this.$store.state.user.role &&
        this.$store.state.user.role.includes("ROLE_ADMIN")
      );
    },
    tournament() {
      return this.$store.state.tournaments.find((tournament) => {
        return tournament.id == this.$route.params.id;
      });
    },
    gyms(){
      return this.$store.state.gyms;
    },
    fights(){
      return this.$store.state.fights.filter((fight)=> {
        return fight.tournamentId == this.$route.params.id;
      })
    },
     fighters(){

      // return this.$store.state.fighters;
      return this.$store.state.fighters;
    },
  },
  

  
};
</script>

<style scoped>


#tournament-main {
  display: grid;
  grid-template-areas:
    "title"
    "tournament-details";
  justify-items: center;
  row-gap: 20px; 
}


#title {
  grid-area: title;
  text-align: center;
  font-size: 28px;
  margin-bottom: 20px;
  font-weight: bold;
}

#tournament-details {
  display: grid;
  grid-template-columns: 2fr 1fr;
  column-gap: 40px; 
  align-items: center;
  justify-content: center;
}

#details {
  
  /* padding: 20px; */
  display: flex;
  flex-direction: column;
  align-items: center;
  /* gap: 10px; */
  
}

.logo {
 
  max-height: 400px;
  object-fit: contain;
}

.date, .location {
  
  /* padding: 20px; */
  width: 200px;
  text-align: center;
}



#buttons {
  display: flex;
  flex-direction: column;
  gap: 20px;
  
}

details  > summary {
  width: 150px;
  padding: 15px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  background-color: #ddd;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  font-weight: bold;
}

details[open] > summary {
  background-color: #CE2029;
}

details > ul{
  background-color: #16166B;
  border-radius: 5px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  width: 270px;
  font-weight:bold;
  padding-top: 5px;
  padding-bottom: 5px;

}


li {
  color:#ddd
}

li:hover{
  background-color: #E6A817;
  color: #16166B;
}
.icon {
  padding: 2px;
  width: 1em;
  cursor: pointer;
  color: red;
  justify-content: right;
}
@media (max-width: 425px) {
  #tournament-details {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  #buttons {
    margin-top: 20px; 
  }

  details > summary {
    width: 100%; 
    text-align: center;
  }

  .logo {
    max-height: 250px; 
  }
}
</style>
