<template>
  <div id="fighter-main">
    <p id="name">{{ fighter.fighterName }}</p>
    
  <div id="fighter">
    <img :src="fighter.imgUrl"  class="fighter-img" />
    <ul id="fighter-details">
      <li>Gym name but only have gym id in table</li>
      <li>{{ fighter.fighterLocation }}</li>
      <li>{{ fighter.fighterExperienceLevel }}</li>
      <li>weight class name but only have weightclass id</li>
      <li>{{ fighter.fighterHeight }}</li>
      <li>{{ fighter.fighterAge }}</li>
      <li>{{ fighter.fighterRecord }}</li>
      
    </ul>
    
  </div>
  </div>
</template>

<script>
import { ResourceService } from '../services/ResourceService';
export default {
computed: {
  fighter(){
  return this.$store.state.fighters.find((fighter) => {
    return fighter.id == this.$route.params.id;
  });
}


}
}
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

#name {
  grid-area: name;
  text-align: center;
  font-size: 28px;
  margin-bottom: 20px;
  font-weight: bold;
}

#fighter {
  display: grid;
  grid-template-columns: 1fr 1fr;
  column-gap: 40px; 
  align-items: center;
  justify-content: center;
}

#fighter-img {
  
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  max-height: 400px;
  object-fit: contain;
}

#fighter-details {
  display: flex;
  flex-direction: column;
  gap: 20px;
  text-align: center;
  
}
</style>