<template>
  <div class="home">
    <home-jumbotron />
    <home-about />
    <home-visi-misi />
    <home-value />
    <home-achievement />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import HomeJumbotron from '@/components/HomeJumbotron.vue'
import HomeAbout from '@/components/HomeAbout.vue'
import HomeVisiMisi from '@/components/HomeVisiMisi.vue'
import HomeValue from '@/components/HomeValue.vue'
import HomeAchievement from '@/components/HomeAchievement.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    HomeJumbotron,
    HomeAbout,
    HomeVisiMisi,
    HomeValue,
    HomeAchievement
  }
}
</script>
