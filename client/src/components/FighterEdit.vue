<template>
  <div id="edit-div">
    <form @:submit.stop.prevent="submitFighter">
      <div>
        <label for="fighterName">Name</label>
        <input
          type="text"
          id="fighterName"
          name="fighterName"
          v-model="fighter.fighterName"
        />
      </div>

      <div>
        <label for="gym">Gym</label>
        <select
          id="gym"
          name="gym"
          v-model="fighter.currentGymId"
        >
          <option
            v-for="gym in gyms"
            :key="gym.id"
            :value="gym.id"
          >
            {{ gym.gymName }}
          </option>
        </select>
      </div>
      <div>
        <label for="fighterLocation">Location (City, State)</label>
        <input
          type="text"
          id="fighterLocation"
          name="fighterLocation"
          v-model="fighter.fighterLocation"
        />
      </div>
      <div>
        <label for="weightClass">Weight Class</label>
        <select
          id="weightClass"
          name="weightClass"
          v-model="fighter.currentWeightClassId"
        >
          <option
            v-for="weightClass in weightClasses"
            :key="weightClass.id"
            :value="weightClass.id"
          >
            {{ weightClass.weightClassName }}
          </option>
        </select>
      </div>
      <div>
        <label for="fighterAge">Age</label>
        <input
          type="text"
          id="fighterAge"
          name="fighterAge"
          v-model="fighter.fighterAge"
        />
      </div>
      <div>
        <label for="fighterHeigh">Height</label>
        <input
          type="text"
          id="fighterHeigh"
          name="fighterHeight"
          v-model="fighter.fighterHeight"
        />
      </div>

      <div>
        <label for="fighterImgUrl">Image URL</label>
        <input
          type="text"
          id="imgUrl"
          name="imgUrl"
          v-model="fighter.imgUrl"
        />
      </div>
      <div class="button-container">
        <button @click="cancel">Cancel</button>
        <button type="submit">Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import { ResourceService } from "../services/ResourceService.js";
export default {
  props: ["fighterId", "gymId", "weightClassId"],
  data() {
    return {
      fighter: {
        fighterName: "",
        currentGymId: this.gymId,
        fighterLocation: "",
        fighterExperienceLevel: "",
        currentWeightClassId: this.weightClassId,
        fighterHeight: "",
        fighterAge: "",
        fighterRecord: "",
        imageUrl: "",
        fighterEmail: "",
        fighterRegistrationStatus: "",

        
      },
    };
  },
  methods: {
    submitFighter() {
      if (this.fighterId) {
        //update
        ResourceService.updateFighter(this.fighterId, this.fighter).then( (response) => {
          this.$router.push({ name: "home" });
        });
      } else {
        //add
        ResourceService.addFighter(this.fighter).then( (response) => {
          this.$router.push({ name: "home" });
        });
      }
    },
    cancel() {
      this.$router.push({ name: "home" });
    },
  },
  created() {
    if (this.fighterId) {
      this.fighter = this.$store.state.fighters.find((fighter) => {
        return fighter.id == this.fighterId;
      });
    }
  
    ResourceService.getGyms()
    .then(response => {
      this.$store.commit("SET_GYMS", response.data)
    });

    ResourceService.getWeightClasses()
    .then(response => {
      this.$store.commit("SET_WEIGHT_CLASSES", response.data)
    });
  },
  computed: {
    gyms(){
      return this.$store.state.gyms;
    },
  }

}
</script>

<style>

</style>