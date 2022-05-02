<template>
  <div class="career">
    <career-jumbotron />
    <career-like />
  </div>
</template>

<script>
import CareerJumbotron from '@/components/CareerJumbotron.vue'
import CareerLike from '@/components/CareerLike.vue'
// @ is an alias to /src


export default {
  name: 'CareerView',
  components: {
    CareerJumbotron,
    CareerLike
    
  }
}
</script>