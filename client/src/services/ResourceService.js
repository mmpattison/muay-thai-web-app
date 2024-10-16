
import axios from "axios";



const allResources = [
  // add objects to represent your custom application resources here
];




const weightClasses = [
  {
      id: 1,
      weightClassName: "Pin Weight",
      minimumWeight: 1.0,
      maximumWeight: 102.0
  },
  {
      id: 2,
      weightClassName: "Atom Weight",
      minimumWeight: 102.1,
      maximumWeight: 107.0
  },
  {
      id: 3,
      weightClassName: "Straw Weight",
      minimumWeight: 107.1,
      maximumWeight: 112.0
  },
  {
      id: 4,
      weightClassName: "Fly Weight",
      minimumWeight: 112.1,
      maximumWeight: 117.0
  },
  {
      id: 5,
      weightClassName: "Bantam Weight",
      minimumWeight: 117.1,
      maximumWeight: 122.0
  },
  {
      id: 6,
      weightClassName: "Feather Weight",
      minimumWeight: 122.1,
      maximumWeight: 127.0
  },
  {
      id: 7,
      weightClassName: "Light Weight",
      minimumWeight: 127.1,
      maximumWeight: 132.0
  },
  {
      id: 8,
      weightClassName: "Super Light Weight",
      minimumWeight: 132.1,
      maximumWeight: 137.0
  },
  {
      id: 9,
      weightClassName: "Light Welter Weight",
      minimumWeight: 137.1,
      maximumWeight: 142.0
  },
  {
      id: 10,
      weightClassName: "Welter Weight",
      minimumWeight: 142.1,
      maximumWeight: 147.0
  },
  {
      id: 11,
      weightClassName: "Super Welter Weight",
      minimumWeight: 147.1,
      maximumWeight: 153.0
  },
  {
      id: 12,
      weightClassName: "Light Middle Weight",
      minimumWeight: 153.1,
      maximumWeight: 159.0
  },
  {
      id: 13,
      weightClassName: "Middle Weight",
      minimumWeight: 159.1,
      maximumWeight: 165.0
  },
  {
      id: 14,
      weightClassName: "Super Middle Weight",
      minimumWeight: 165.1,
      maximumWeight: 172.0
  },
  {
      id: 15,
      weightClassName: "Light Heavy Weight",
      minimumWeight: 172.1,
      maximumWeight: 179.0
  },
  {
      id: 16,
      weightClassName: "Light Cruiser Weight",
      minimumWeight: 179.1,
      maximumWeight: 186.0
  },
  {
      id: 17,
      weightClassName: "Cruiser Weight",
      minimumWeight: 186.1,
      maximumWeight: 195.0
  },
  {
      id: 18,
      weightClassName: "Heavy Weight",
      minimumWeight: 195.1,
      maximumWeight: 215.0
  },
  {
      id: 19,
      weightClassName: "Super Heavy Weight",
      minimumWeight: 215.1,
      maximumWeight: 250.0
  },
  {
      id: 20,
      weightClassName: "Colossal Weight",
      minimumWeight: 250.1,
      maximumWeight: null
  }
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
