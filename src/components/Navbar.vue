<template>
      <div class="grid">
          <div class="col-12 p-0">
    <Menubar :model="items" class="menu" style="float: inline-end;">
      <template #start>
        <img alt="logo" src="../assets/logo-navbar.png" height="40"
          class="m-2">
      </template>
      <template #end>
  
      </template>
    </Menubar>
  </div>
  </div>
</template>

<style scoped>
    .p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link .p-menuitem-text {
    color: #00A6A9 !important;
    font-weight: 700;
}

  ::v-deep(.p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link .p-menuitem-icon) {
    color: #6c757d;
    display: none !important;
    margin-right: 0;
  }

  ::v-deep(.p-menubar .p-menuitem-link .p-menuitem-icon) {
    color: #6c757d;
    margin-right: 0;
}

::v-deep(.p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link) {
    float: right;
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
    padding: 0;
    background: #f8f9fa;
    color: #00A6A9 !important;
    border: none !important;
    border-radius: 3px;
    width: 100%;
}

::v-deep .p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link .p-menuitem-text {
    color: #00A6A9 !important;
    font-weight: 700;
}

.p-menubar .p-menubar-root-list > .p-menuitem > .p-menuitem-link {
    float: right !important;
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
    },
}
</script>