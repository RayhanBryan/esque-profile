<template>
  <div class="activity">
    <activity-jumbotron />
    <activity-content />
  </div>
</template>

<script>
import ActivityJumbotron from '@/components/ActivityJumbotron.vue'
import ActivityContent from '@/components/ActivityContent.vue'
export default {
  components: { ActivityJumbotron, ActivityContent },
  
}
</script>