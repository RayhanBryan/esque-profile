<template>
<link rel="stylesheet" href="https://unpkg.com/primeflex@3.1.0/primeflex.css">
  <navbar />
  <router-view />
  <footer-temp />
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
import FooterTemp from './components/FooterTemp.vue';
import Navbar from './components/Navbar.vue';

  export default {
  components: { Navbar, FooterTemp },


    mounted() {
      AOS.init();
    }
    
  }
</script>