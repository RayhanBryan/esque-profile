<template>
<link rel="stylesheet" href="https://unpkg.com/primeflex@3.1.0/primeflex.css">
  <navbar />
  <router-view />
</template>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    /* text-align: center; */
    color: #2c3e50;
    width: 100% !important;
  }

  
</style>

<script>
import Navbar from './components/Navbar.vue';

  export default {
  components: { Navbar },


    mounted() {
      AOS.init();
    }
    
  }
</script>