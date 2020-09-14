<template>
  <div id="app">
    app
    <router-link to="/a">to A</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
  }
</script>
