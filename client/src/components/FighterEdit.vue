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
            {{ weightClass.weightClassName }} ({{ weightClass. minimumWeight}} - {{ weightClass.maximumWeight }})
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
        <label for="fighterHeight">Height</label>
        <input
          type="text"
          id="fighterHeight"
          name="fighterHeight"
          v-model="fighter.fighterHeight"
        />
      </div>
      <div>
        <label for="fighterRecord">Overall Record</label>
        <input
          type="text"
          id="fighterRecord"
          name="fighterRecord"
          v-model="fighter.fighterRecord"
        />
      </div>
      <div>
        <label for="fighterExperienceLevel">Class</label>
        <select
          id="fighterExperienceLevel"
          name="fighterExperienceLevel"
          v-model="fighter.fighterExperienceLevel">
        <option value="C Class">Class C/Novice (0-3 Combined Fight Record)</option>
        <option value="B Class">Class B (4-12 Combined Fight Record)</option>
        <option value="">Class A/Open (13+ Combined Fight Record) </option>
        </select>
      </div>
      <div>
        <label for="fighterGender">Gender You Will Fight Under</label>
        <input
          type="text"
          id="fighterGender"
          name="fighterGender"
          v-model="fighter.fighterGender"
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
        <div>
        <label for="fighterRegistrationStatus">RegistrationStatus</label>
        <select
          id="fighterRegistrationStatus"
          name="fighterRegistrationStatus"
          v-model="fighter.fighterRegistrationStatus">
        <option value="incomplete">Incomplete</option>
        <option value="complete">Complete</option>
        </select>
      </div>
      </div>
      <div class="button-container">
        <button @click="cancel">Cancel</button>
        <button type="submit">Submit</button>
        <button v-if="fighterId" @click="deleteFighter" class="delete-button">Delete</button>
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
        fighterGender: "",
        fighterHeight: "",
        fighterAge: "",
        fighterRecord: "",
        imgUrl: "",
        fighterEmail: "",
        fighterRegistrationStatus: "",

        
      },
    };
  },
  methods: {
    submitFighter() {
      if (this.fighterId) {
        // Update existing fighter
        ResourceService.updateFighter(this.fighterId, this.fighter).then(response => {
          this.$router.push({ name: "home" });
        });
      } else {
        // Add new fighter
        ResourceService.addFighter(this.fighter).then(response => {
          this.$router.push({ name: "home" });
        });
      }
    },
    cancel() {
      this.$router.push({ name: "home" });
    },
    deleteFighter() {
      if (confirm("Are you sure you want to delete this fighter?")) {
        ResourceService.deleteFighter(this.fighterId).then(response => {
          this.$router.push({ name: "home" });
        });
      }
    },
  },
  created() {
    console.log(this.fighterId)
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
    weightClasses(){
      return this.$store.state.weightClasses;
    },
  }

}
</script>

<style>
#edit-div {
  height: 100%; 
  overflow-y: auto; 
}

.button-container {
  display:flex;
  justify-content: space-evenly;
}
</style>