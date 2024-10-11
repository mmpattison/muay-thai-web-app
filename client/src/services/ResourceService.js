
import axios from "axios";



const allResources = [
  // add objects to represent your custom application resources here
];

const tournaments = [
  {
      id: 1,
      tournamentName: "TBA Classic World Championships",
      location: "Des Moines, Iowa",
      startDate: "2024-06-19",
      endDate: "2024-06-23"
  },
  {   
      id: 2,
      tournamentName: "Tournament of Champions at The Arnold",
      location: "Columbus, Ohio",
      startDate: "2024-02-28",
      endDate: "2024-03-02"
  }
];

const fighters = [
  {
      id: 1,
      fighterName: "Rose",
      currentWeightClassId: 1,
      fighterExperienceLevel: "B Class",
      fighterAge: 23,
      fighterHeight: "5ft 2in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 1-0 Smokers 3-0",
      currentGymId: 3,
      fighterLocation: "Nashville, Tennessee",
      fighterEmail: "rboxer@yahoo.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 2,
      fighterName: "Kitana",
      currentWeightClassId: 2,
      fighterExperienceLevel: "C Class/Novice",
      fighterAge: 43,
      fighterHeight: "5ft 5in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 0",
      currentGymId: 1,
      fighterLocation: "Columbus, Ohio",
      fighterEmail: "KT@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 3,
      fighterName: "Sheeva",
      currentWeightClassId: 2,
      fighterExperienceLevel: "C Class/Novice",
      fighterAge: 38,
      fighterHeight: "5ft 3in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 0-1 MMA 1-0",
      currentGymId: 2,
      fighterLocation: "Chicago, Illinois",
      fighterEmail: "sheeev@hotmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 4,
      fighterName: "Sonya Blade",
      currentWeightClassId: 3,
      fighterExperienceLevel: "C Class/Novice",
      fighterAge: 36,
      fighterHeight: "5ft 6in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 0",
      currentGymId: 4,
      fighterLocation: "Roseville, Minnesota",
      fighterEmail: "sonya@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 5,
      fighterName: "Mileena",
      currentWeightClassId: 3,
      fighterExperienceLevel: "C Class/Novice",
      fighterAge: 38,
      fighterHeight: "5ft 8in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 0-1",
      currentGymId: 5,
      fighterLocation: "Kemptville, Ontario",
      fighterEmail: "mileena@hotmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 6,
      fighterName: "Sub-Zero",
      currentWeightClassId: 4,
      fighterExperienceLevel: "A Class/Open",
      fighterAge: 43,
      fighterHeight: "5ft 8in",
      fighterGender: "Male",
      fighterRecord: "Muay Thai 6-1 Smokers 5-1",
      currentGymId: 1,
      fighterLocation: "Columbus, Ohio",
      fighterEmail: "sz@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 7,
      fighterName: "E. Honda",
      currentWeightClassId: 5,
      fighterExperienceLevel: "B Class",
      fighterAge: 31,
      fighterHeight: "5ft 8in",
      fighterGender: "Male",
      fighterRecord: "Muay Thai 6-1",
      currentGymId: 1,
      fighterLocation: "Columbus, Ohio",
      fighterEmail: "honda.e@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 8,
      fighterName: "Ryu",
      currentWeightClassId: 5,
      fighterExperienceLevel: "B Class",
      fighterAge: 27,
      fighterHeight: "6ft 7in",
      fighterGender: "Male",
      fighterRecord: "Muay Thai 4-1",
      currentGymId: 2,
      fighterLocation: "Chicago, Illinois",
      fighterEmail: "ryu@hotmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 9,
      fighterName: "Chun Li",
      currentWeightClassId: 1,
      fighterExperienceLevel: "B Class",
      fighterAge: 43,
      fighterHeight: "4ft 10in",
      fighterGender: "Female",
      fighterRecord: "Muay Thai 3-1",
      currentGymId: 1,
      fighterLocation: "Columbus, Ohio",
      fighterEmail: "c.li@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 10,
      fighterName: "Johnny Cage",
      currentWeightClassId: 4,
      fighterExperienceLevel: "A Class/Open",
      fighterAge: 38,
      fighterHeight: "5ft 7in",
      fighterGender: "Male",
      fighterRecord: "Muay Thai 24-8 8 KO/TKO MMA 1-0",
      currentGymId: 2,
      fighterLocation: "Chicago, Illinois",
      fighterEmail: "JohnnyC@hotmail.com",
      fighterRegistrationStatus: "Confirmed"
  },
  {
      id: 11,
      fighterName: "Nina Williams",
      currentWeightClassId: 3,
      fighterExperienceLevel: "B Class",
      fighterAge: 35,
      fighterHeight: "4ft 10in",
      fighterGender: "Female",
      fighterRecord: "1-0",
      currentGymId: 1,
      fighterLocation: "Columbus, Ohio",
      fighterEmail: "fighter@gmail.com",
      fighterRegistrationStatus: "Confirmed"
  }
];


const fights = [
  {
      id: 1,
      blueCornerId: 1,
      redCornerId: 2,
      winner: "Chun Li",
      loser: "Rose",
      winType: "TKO",
      tournamentId: 1,
      fightName: "Chun Li vs Rose"
  },
  {
      id: 2,
      blueCornerId: 3,
      redCornerId: 4,
      winner: "Sheeva",
      loser: "Kitana",
      winType: "Split",
      tournamentId: 2,
      fightName: "Kitana vs Sheeva"
  },
  {
      id: 3,
      blueCornerId: 3,
      redCornerId: 4,
      winner: "Sheeva",
      loser: "Kitana",
      winType: "KO",
      tournamentId: 1,
      fightName: "Sheeva vs Kitana"
  },
  {
      id: 4,
      blueCornerId: 5,
      redCornerId: 6,
      winner: "Sonya Blade",
      loser: "Mileena",
      winType: "Unanimous",
      tournamentId: 1,
      fightName: "Mileena vs Sonya Blade"
  },
  {
      id: 5,
      blueCornerId: 7,
      redCornerId: 8,
      winner: "Johnny Cage",
      loser: "Sub-Zero",
      winType: "Split",
      tournamentId: 1,
      fightName: "Johnny Cage vs Sub-Zero"
  },
  {
      id: 6,
      blueCornerId: 8,
      redCornerId: 7,
      winner: "Sub-Zero",
      loser: "Johnny Cage",
      winType: "Split",
      tournamentId: 2,
      fightName: "Sub-Zero vs Johnny Cage"
  },
  {
      id: 7,
      blueCornerId: 9,
      redCornerId: 10,
      winner: "E. Honda",
      loser: "Ryu",
      winType: "Forfeit",
      tournamentId: 2,
      fightName: "Ryu vs E. Honda"
  }
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
    return fighters;
  },
  getFights(){
    return fights;
  },
  getWeightClasses(){
    return weightClasses;
  },
  getFightsByTournamentId(tournamentId){
    return fights.filter((fight) =>{
      return fight.tournamentId === tournamentId;
    })
  },
  getFighterById(fighterId) {
    return fighters.filter ((fighter) =>{
      if(fighter.fighterId === fighterId){
        return fighter;
      }
    })
  },

  getFightById(fightId){
    return fights.filter ( (fight) => {
      if(fight.id === fightId){
        return fight;
      }
    })
  }


};

export { ResourceService };
