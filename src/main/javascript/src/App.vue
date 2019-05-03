<template>
  <div id="app">
    <h1>
      <img alt="Vertx logo" src="./assets/logos/vertx.png" width="110" height="30">
      +
      <img alt="Vue logo" src="./assets/logos/vue.png" width="30" height="30"></h1>
    <h2>Minimal example application</h2>
    <Health msg="Is healthy:"/>
  </div>
</template>

<script>
import Health from './components/Health.vue'

export default {
  name: 'app',
  components: {
    Health
  }
}
</script>