<template>
  <header class="header">
    <img
      id="logo1"
      alt="Thai Boxing Association"
      src="../assets/tba_logo.png"
    />
    <h1 class="header-title">
      Thai Boxing Association - Sanctioning Authority
    </h1>
    <img
      id="logo2"
      alt="Thai Boxing Association"
      src="../assets/tba_logo.png"
    />

    <nav id="nav">
      <router-link v-bind:to="{ name: 'home' }">
        <button>Home</button>
      </router-link>
      <router-link v-bind:to="{ name: 'home' }">
        <button>Contact Us</button>
      </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
        <button>Logout</button>
      </router-link>
      <router-link v-bind:to="{ name: 'login' }" v-else>
        <button>Login</button></router-link
      >
    </nav>

    <section id="socials">
      <ul class="social-icons">
        <li>
          <a href="https://www.facebook.com/TBA.Sanctioning"
            ><i class="fab fa-facebook fa-3x"></i
          ></a>
        </li>
        <li>
          <a href="https://www.instagram.com/thaiboxingassoc_sanctioning/"
            ><i class="fab fa-instagram fa-3x"></i
          ></a>
        </li>
        <li>
          <a href="https://twitter.com/pammypanda1"
            ><i class="fab fa-twitter fa-3x"></i
          ></a>
        </li>
      </ul>
    </section>
  </header>
</template>

<script>
export default {};
</script>

<style>
.header {
  grid-area: header;
  display: grid;
  grid-template-areas:
    "logo1   title    title  logo2"
    "logo1    nav    socials  logo2";
  grid-template-columns: 150px auto auto 150px;
  gap: 10px;
  font-family: "Oswald", sans-serif;
  justify-content: center;
  align-items: center;
  background-color: #8da9c4;
  width: 100%;
}
#logo1 {
  /* width: 1fr; */
  grid-area: logo1;
  height: 150px;
  padding: 10px;
}
#logo2 {
  /* width: 1fr; */
  grid-area: logo2;
  height: 150px;
  padding: 10px;
}

.header-title {
  /* background-color: #eee; */
  grid-area: title;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;

  /* width: 2fr; */
}
nav {
  grid-area: nav;
  display: flex;
  background-color: #8da9c4;
  align-items: center;
  justify-content: center;
  flex-basis: 35%;
  flex-wrap: wrap;
  border-radius: 5px;
}
nav button {
  font-family: "Oswald", sans-serif;
  font-size: 2rem;
  font-weight: 400;
  text-transform: uppercase;
  border-bottom: 1px solid #707070;
  padding: 10px;
}
.social-icons {
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  height: 100%;
  background-color: #8da9c4;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  border-radius: 5px;
  list-style: none;
}

#socials {
  grid-area: socials;
}
</style>