<template>
    <v-data-table
            :headers="mainHeaders"
            :items="items"
            class="elevation-1" hide-actions item-key="name">

        <template slot="items" slot-scope="props">
            <tr>
                <td>
                    <v-list-tile-avatar>
                        <img :src="props.item.avatar">
                    </v-list-tile-avatar>
                </td>
                <td class="text-xs">{{ props.item.name }}</td>
                <td class="text-xs">{{ props.item.star }}</td>
                <td class="text-xs">{{ props.item.forks }}</td>
            </tr>
        </template>
    </v-data-table>
</template>

<script>
    export default {
        props: ['items'],
        data() {
            return {
                mainHeaders: [
                    {text: 'Avatar', value: 'avatar'},
                    {text: 'Name', value: 'name'},
                    {text: 'Star', value: 'star'},
                    {text: 'Fork', value: 'forks'}
                ]
            }
        }
    }
</script>
