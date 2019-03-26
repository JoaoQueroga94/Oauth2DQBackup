<template>
    <v-container fluid grid-list-xl>
        <v-layout column>
            <v-flex>
                <v-layout>
                    <v-flex d-flex md12 sm12 xs12>
                        <schedules :items="data"></schedules>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>

    import Schedules from '@/components/Schedules';

    export default {
        components: {
            'schedules': Schedules
        },
        data() {
            return {
                data: [
                    {name: 'Vue 1', star: '30', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 2', star: '31', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 3', star: '45', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 4', star: '23', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 5', star: '29', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 6', star: '28', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 7', star: '15', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 8', star: '17', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue 9', star: '23', forks: '2', avatar: 'https://vuejs.org/images/logo.png'},
                    {name: 'Vue	10', star: '28', forks: '2', avatar: 'https://vuejs.org/images/logo.png'}
                ]
            }
        }
    }
</script>
