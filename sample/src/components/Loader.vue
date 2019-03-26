<template>
    <div class="text-xs-center">

        <v-dialog
                hide-overlay
                persistent
                v-model="$store.state.loader"
                width="300"
        >
            <v-card
                    color="primary"
                    dark
            >
                <v-card-text>
                    Carregando...
                    <v-progress-linear
                            class="mb-0"
                            color="white"
                            indeterminate
                    ></v-progress-linear>
                </v-card-text>
            </v-card>
        </v-dialog>
    </div>
</template>
