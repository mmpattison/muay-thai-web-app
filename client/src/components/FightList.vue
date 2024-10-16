<template>
  <section>
    <h2>Fighters</h2>
    <div class="fight-list">
      
    </div>
  </section>
</template>

<script>



</script>

<style>
#fights-table {
    grid-area: fights-table;
    display: block;
    background-color: #eef4ed;
    font-size: 2rem;
    font-weight: 400;
    text-align: center;
    width: 100%;
    max-width: 100%;
    overflow-x: auto;
    margin-top: 5px;
    
    
    border-radius: 5px;

}

td {
    text-align: center;
    padding: 50px;
}

.fight-item:hover {
    cursor: pointer;
    background-color: #e01e37;

    
}
</style>