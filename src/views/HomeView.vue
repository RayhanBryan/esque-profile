<template>
  <div class="home">
    <home-jumbotron />
    <home-about />
    <home-visi-misi />
    <home-value />
    <home-achievement />
    <home-history />
    <home-expansion />
  </div>
</template>

<script>
// @ is an alias to /src
import HomeJumbotron from '@/components/HomeJumbotron.vue'
import HomeAbout from '@/components/HomeAbout.vue'
import HomeVisiMisi from '@/components/HomeVisiMisi.vue'
import HomeValue from '@/components/HomeValue.vue'
import HomeAchievement from '@/components/HomeAchievement.vue'
import HomeHistory from '@/components/HomeHistory.vue'
import HomeExpansion from '@/components/HomeExpansion.vue'

export default {
  name: 'HomeView',
  components: {
    HomeJumbotron,
    HomeAbout,
    HomeVisiMisi,
    HomeValue,
    HomeAchievement,
    HomeHistory,
    HomeExpansion
  }
}
</script>