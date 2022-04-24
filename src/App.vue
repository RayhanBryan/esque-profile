<template>
<link rel="stylesheet" href="https://unpkg.com/primeflex@3.1.0/primeflex.css">
  <div>
    <Menubar :model="items" class="menu">
      <template #start>
        <img alt="logo" src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png" height="40"
          class="mr-2">
      </template>
      <template #end>
  
      </template>
    </Menubar>
  </div>
  <router-view />
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

  .p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link .p-menuitem-text {
    color: #00A6A9 !important;
    font-weight: 700;
}

  .p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link .p-menuitem-icon {
    color: #6c757d;
    display: none;
  }
  .p-menubar ul {
    margin: 0;
    padding: 0;
    list-style: none;
    width: 100%;
    text-align: center;
    border: none;
}
.p-menubar {
    padding: 0.5rem;
    background: #f8f9fa;
    color: #00A6A9 !important;
    border: none !important;
    border-radius: 3px;
}

.p-menubar ul li{
    display: inline;
    float: right;
    width: auto;
    justify-content: center;
    padding: 0;
}

.p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link {
    padding: 0;
    color: #00A6A9 !important;
    border-radius: 3px;
    transition: box-shadow 0.2s;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
}
</style>

<script>
  export default {
    data() {
      return {
        items: [
          {
            separator: false,
            disabled: true,
            style: 'width: 45%'
          },
          {
            label: 'HOME',
            to: '/',
          },
          {
            label: 'CAREER',
            to: '/career'
          },
          {
            label: 'ESQUE ACTIVITY',
            to: '/activity'
          },
          {
            label: 'BLOG',
            to: '/blog'
          },
          {
            label: 'CONTACT',
            to: '/contact'
          },
          {
            label: 'PRIVACY & POLICY',
            to: '/privacy'
          },
        ]
      }
    }
  }
</script>