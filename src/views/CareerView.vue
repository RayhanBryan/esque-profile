<template>
  <div class="career">
    <career-jumbotron />
    <career-like />
    <career-get />
    <career-team />
    <career-step />
  </div>
</template>

<script>
import CareerJumbotron from '@/components/CareerJumbotron.vue'
import CareerLike from '@/components/CareerLike.vue'
import CareerGet from '@/components/CareerGet.vue'
import CareerTeam from '@/components/CareerTeam.vue'
import CareerStep from '@/components/CareerStep.vue'
// @ is an alias to /src


export default {
  name: 'CareerView',
  components: {
    CareerJumbotron,
    CareerLike,
    CareerGet,
    CareerTeam,
    CareerStep
    
  }
}
</script>