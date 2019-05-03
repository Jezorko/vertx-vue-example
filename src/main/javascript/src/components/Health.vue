<template>
    <div class="health">
        <p>{{ msg }} {{ isHealthy }}</p>
    </div>
</template>

<script>
    import axios from 'axios'
    import getApiUrl from '../utils';

    export default {
        name: 'Health',
        data() {
            return {
                isHealthy: false
            }
        },
        props: {
            msg: String
        },
        mounted() {
            axios.get(`${getApiUrl()}/health`).then(response => (this.isHealthy = response.data.isHealthy))
        }
    }
</script>