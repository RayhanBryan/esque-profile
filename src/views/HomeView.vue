<template>
  <div class="home">
    <home-jumbotron />
    <home-about />
    <home-visi-misi />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import HomeJumbotron from '@/components/HomeJumbotron.vue'
import HomeAbout from '@/components/HomeAbout.vue'
import HomeVisiMisi from '@/components/HomeVisiMisi.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    HomeJumbotron,
    HomeAbout,
    HomeVisiMisi
  }
}
</script>
