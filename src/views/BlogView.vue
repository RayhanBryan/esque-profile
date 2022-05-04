<template>
  <div class="blog">
    <blog-main />
  </div>
</template>

<script>
import BlogMain from '@/components/BlogMain.vue'

// @ is an alias to /src


export default {
  name: 'BlogView',
  components: {
    BlogMain
    
  }
}
</script>