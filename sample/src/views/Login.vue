<template>

    <v-container fluid grid-list-xl fill-height>

        <v-layout align-center justify-center>

            <v-flex d-flex md8 sm8 xs8>
                <v-card elevation-3>
                    <v-toolbar dark color="primary">
                        <v-toolbar-title>Login</v-toolbar-title>
                    </v-toolbar>
                    <v-card-text>

                        <v-form ref="form" v-model="valid">
                            <v-container>

                                <v-layout row>
                                    <v-flex xs12>
                                        <v-text-field
                                                :rules="emailRules"
                                                data-cy="signinEmailField"
                                                label="Email"
                                                name="email"
                                                prepend-icon="person"
                                                required
                                                type="email"
                                                v-model="email">
                                        </v-text-field>
                                    </v-flex>
                                </v-layout>
                                <v-layout row>
                                    <v-flex xs12>
                                        <v-text-field
                                                :rules="passwordRules"
                                                data-cy="signinPasswordField"
                                                label="Password"
                                                name="password"
                                                prepend-icon="lock"
                                                required
                                                type="password" v-model="password">
                                        </v-text-field>
                                    </v-flex>
                                </v-layout>

                            </v-container>
                        </v-form>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn :disabled="!valid" @click="submit" color="primary" data-cy="signinSubmitBtn">Login
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>

            <loader></loader>
        </v-layout>


    </v-container>
</template>

<script>

    import Loader from '@/components/Loader';

    export default {
        name: 'Signin',
        components : {
            Loader
        },
        data() {
            return {
                valid: false,
                email: '',
                password: '',
                emailRules: [
                    v => !!v || 'E-mail is required'
                    // v => /.+@.+/.test(v) || 'E-mail must be valid'
                ],
                passwordRules: [
                    v => !!v || 'Password is required',
                    v =>
                        v.length >= 5 ||
                        'Password must be greater than 6 characters'
                ]
            };
        },
        methods: {
            submit() {
                if (this.$refs.form.validate()) {
                    this.$store.dispatch('userLogin', {
                        email: this.email,
                        password: this.password
                    });
                }
            }
        }
    };
</script>