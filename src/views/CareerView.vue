<template>
  <div class="career">
    <career-jumbotron />
    <career-like />
    <career-get />
    <career-team />
  </div>
</template>

<script>
import CareerJumbotron from '@/components/CareerJumbotron.vue'
import CareerLike from '@/components/CareerLike.vue'
import CareerGet from '@/components/CareerGet.vue'
import CareerTeam from '@/components/CareerTeam.vue'
// @ is an alias to /src


export default {
  name: 'CareerView',
  components: {
    CareerJumbotron,
    CareerLike,
    CareerGet,
    CareerTeam
    
  }
}
</script>