
import axios from "axios";



const allResources = [
  // add objects to represent your custom application resources here
];


const ResourceService = {
  getResources() {
    return allResources;
  },
  getTournaments(){
    return axios.get("/tournaments");
  },
  getFighters(){
    return axios.get('/fighters');
  },
  getFights(){
    return axios.get('/fights');
  },
  getWeightClasses(){
    return axios.get('/weightClasses');
  },
  getGyms(){
    return axios.get('/gyms');
  },
  getFightsByTournamentId(tournamentId){
    return axios.get(`/tournaments/${tournamentId}/fights`);
  },
  getFightersByGymId(gymId){
    return axios.get(`/gyms/${gymId}/fighters`)
  },
  getFightersByTournamentId(tournamentId){
    // alert ("getFightersByTournamentId-"+ tournamentId );
    return axios.get(`/tournaments/${tournamentId}/fighters`);
  },
  getFightersByFightId(fightId){
    return axios.get(`/tournaments/${fightId}/fighters`);
  },
  getFighterById(fighterId) {

    return axios.get(`/fighters/${fighterId}`);
    
  },

  getFightById(fightId){
    return axios.get(`/fights/${fightId}`)
   
  },

  addFighter(fighter) {
    return axios.post('/fighters', fighter)
  },

  updateFighter(fighterId, fighter){
    return axios.put(`/fighters/${fighterId}`, fighter)
  }


};

export { ResourceService };
