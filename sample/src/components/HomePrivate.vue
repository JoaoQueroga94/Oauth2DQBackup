<template>
    <v-container class="teal darken-1 darken-2 home-hero" fill-height fluid style="max-height: 100vh;">
        <v-layout align-center column justify-center pa-5>
            <div class="display-4 font-weight-black white--text text-xs-center">VUE JS</div>
            <div class="display-3 font-weight-black white--text text-xs-center mb-3">Uma aplicação simples em Vuejs
            </div>
            <div class="display-1 font-weight-bold white--text text-xs-center">Vamos entender alguns funcionamentos
                básicos de uma aplicação em Vuejs.
            </div>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        name: 'HomeHero'
    };
</script>

<style scoped>
    .home-hero {
        width: 100%;
        height: 100%;
    }
</style>