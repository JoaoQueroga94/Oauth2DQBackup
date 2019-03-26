<template>
    <v-content>
        <v-navigation-drawer
                :mini-variant="miniVariant"
                app
                enable-resize-watcher
                fixed
                stateless
                v-model="drawer"
                width="180px">

            <v-btn @click.stop="miniVariant = !miniVariant" icon>
                <v-icon v-html="miniVariant ? 'chevron_right' : 'chevron_left'"></v-icon>
            </v-btn>

            <v-list>
                <v-list-tile
                        :key="i"
                        :to="item.to" v-for="(item, i) in items" value="true">

                    <v-list-tile-action>
                        <v-icon v-html="item.icon"></v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title v-text="item.title"></v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>

        </v-navigation-drawer>

        <v-toolbar app color="#F9F9FC" height="40">

            <v-toolbar-side-icon @click.stop="drawer = !drawer" v-if="isAuthenticated"></v-toolbar-side-icon>
            <v-toolbar-title v-text="title"></v-toolbar-title>

            <v-spacer></v-spacer>

            <div class="hidden-sm-and-down" v-if="!isAuthenticated">
                <v-btn flat to="/sign-in">SIGN IN</v-btn>
            </div>

            <div v-else>
                <v-btn @click="logout" data-cy="logout">Logout</v-btn>
            </div>
        </v-toolbar>

        <router-view></router-view>

    </v-content>

</template>

<script>
    export default {
        data() {
            return {
                title: "Vue",
                drawer: false,
                fixed: true,
                items: [
                    {
                        icon: 'bubble_chart',
                        title: 'Home',
                        to: '/'
                    },
                    {
                        icon: 'bubble_chart',
                        title: 'Repositórios',
                        to: '/repor'
                    },
                    {
                        icon: 'bubble_chart',
                        title: 'Agendas',
                        to: '/agendas'
                    }
                ],
                miniVariant: false,
                right: true,
                rightDrawer: true,
            }
        },
        computed: {
            isAuthenticated() {
                return this.$store.getters.isAuthenticated;
            }
        },
        methods: {
            logout() {
                this.$store.dispatch('userSignOut');
            }
        },
    }
</script>