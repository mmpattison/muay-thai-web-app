<template>
  <div id="fighter-main">
    <p id="fighter-name">{{ fighter.fighterName }}
      <span class="icon-container" v-if="isAdmin">
          <router-link
                  v-bind:to="{
                    name: 'edit-fighter',
                    params: {
                      id: fighter.id,
                    },
                  }"
                >
                  <font-awesome-icon
                    :icon="['fas', 'edit']"
                    class="icon"
                    title="edit fighter"
                  />
                </router-link>
        </span>
      </p>

    <div id="fighter">
      <div id="fighter-img-box">
        <img :src="fighter.imgUrl" class="fighter-img" />
        
      </div>
      <ul id="fighter-details">
       
        <li v-for="gym in gyms"
            :key="gym.id"
            :value="gym.id">
          {{ gym.gymName }}
        </li>
        <li>Location: {{ fighter.fighterLocation }}</li>
        <li>{{ fighter.fighterExperienceLevel }}</li>
        <li v-for="weightClass in weightClasses" :key="weightClass.id"
        :value="weightClass.id">
        {{ weightClass.weightClassName }}
      </li>
        <li>Height: {{ fighter.fighterHeight }}</li>
        <li>Age: {{ fighter.fighterAge }}</li>
        <li>Record: {{ fighter.fighterRecord }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import { ResourceService } from "../services/ResourceService";
export default {
  created() {
    this.isLoading = true;

Promise.all([
  ResourceService.getGyms(),
  ResourceService.getWeightClasses(),
  
]).then(([gymResponse, weightClassResponse]) => {
  this.$store.commit("SET_GYMS", gymResponse.data);
  this.$store.commit("SET_WEIGHT_CLASSES", weightClassResponse.data);
  
  this.isLoading = false;
});
  },
  computed: {

    isAdmin() {
      return (
        this.$store.state.user &&
        this.$store.state.user.role &&
        this.$store.state.user.role.includes("ROLE_ADMIN")
      );
    },
    fighter() {
      return this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.$route.params.id;
      });
    },
    gyms(){
      return this.$store.state.gyms.filter((gym) => {
        let currentFighter = this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.$route.params.id;
        });
         return gym.id == currentFighter.currentGymId;
      });
    },
    weightClasses(){
      return this.$store.state.weightClasses.filter((weightClass) => {
        let currentFighter = this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.$route.params.id;
        });
         return weightClass.id == currentFighter.currentWeightClassId;
      });
    },
    
  },
};
</script>

<style>
#fighter-main {
  display: grid;
  grid-template-areas:
    "name"
    "fighter";
  justify-items: center;
  row-gap: 20px;
}

#fighter-name {
  grid-area: name;
  text-align: center;
  font-size: 28px;
  margin-bottom: 20px;
  font-weight: bold;
}

#fighter {
  display: flex;
  /* grid-template-columns: 1fr 1fr; */
  column-gap: 40px;
  align-items: center;
  justify-content: space-between;
}

#fighter-img-box {
  /* border: 2px solid ; */
  display:flex;
  border-radius: 10px;
  width: 400px;
  height: 450px;
  text-align: center;
  padding: 10px;
  margin: 20px;
  background-color: #eef4ed;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
}


.fighter-img {
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  /* width: 100%; */
    
    justify-content: center;
    /* object-fit: contain; */
  
}

#fighter-details {
  /* border: 2px solid black; */
  border-radius: 10px;
  width: 400px;
  height: 450px;
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 10px;
  /* text-align: center; */
  background-color: #eef4ed;
  justify-content: center;
  align-items: center;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  font-weight: bold;
  
}

.icon {
  padding: 2px;
  width: 1em;
  cursor: pointer;
  color: red;
}


@media (max-width: 425px) {

  
  #fighter {
  display: grid;
  grid-template-columns: 1fr;
  align-items: center;
  justify-content: center;
}
#fighter-img-box {
    width: 100%; 
    max-width: 300px; 
    height: auto; 
  }

  #fighter-img {
    width: 100%; 
    height: auto;
    object-fit: contain; 
  }

  #fighter-details {
    width: 100%; 
    max-width: 300px; 
    text-align: center; 
    margin-top: 10px; 
  }

  #fighter-name {
    font-size: 22px; 
    text-align: center;
  }

  .icon-container {
    display: inline-block;
    margin-left: 10px; 
  }
}

</style>