<template>
    <div class="fighter-card">
        <img :src="fighter.imgUrl "/>
        <h2 class="fighter-name">{{ fighter.tournamentName }}</h2>
    </div>
</template>

<script>
export default {
props: [
    "fighter"
]
}
</script>

<style>

</style>