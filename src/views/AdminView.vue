<template>
  <div class="admin">
    <blog-post />
  </div>
</template>

<script>
import BlogPost from '@/components/BlogPost.vue'

// @ is an alias to /src


export default {
  name: 'AdminView',
  components: {
    BlogPost
    
  }
}
</script>