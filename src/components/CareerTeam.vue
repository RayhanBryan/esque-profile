<template>
    <div class="grid justify-content-center text-center">
        <div class="col-12">
            <h1>MEET OUR SUPER TEAM</h1>
            <hr>
        </div>
    </div>
    <div class="grid justify-content-center text-center px-4 lg:px-8">
        <div class="col-12 lg:col-6 lg:px-4" v-for="item in items" :key="item.name">
            <img :src="item.photo" alt="">
            <h3>{{ item.name }}</h3>
            <hr class="hr-team">
            <p class="lg:text-left">{{ item.text }}</p>
        </div>
    </div>
</template>

<style scoped>
    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }
    .hr-team {
        border: 2px solid #00535B;
        max-width: 60%;
    }
    p {
        font-weight: 500;
        color: #00535B;
    }
    h3 {
        color: #00535B;
    }
</style>

<script>
import image1 from "../assets/team1.png"
export default {
    data: () => ({
        items: [
            {
                name: 'AKBAR',
                photo: image1,
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam lobortis faucibus facilisis. Aenean commodo nec magna ac vehicula. Nam eleifend ultrices felis, eu laoreet mi porttitor id. Donec bibendum posuere felis eu consequat. Integer sed lacus suscipit, dignissim dui in, pulvinar ligula. Morbi dignissim facilisis ullamcorper. In hac habitasse platea dictumst. Nullam venenatis orci sed dui cursus, non fringilla tellus interdum. Nullam sed porttitor mauris. Aenean placerat finibus ex dictum accumsan. Morbi tempus, purus sed sollicitudin porta, quam felis aliquet libero, eu mollis mi arcu et purus.'
            },
            {
                name: 'AKBAR',
                photo: image1,
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam lobortis faucibus facilisis. Aenean commodo nec magna ac vehicula. Nam eleifend ultrices felis, eu laoreet mi porttitor id. Donec bibendum posuere felis eu consequat. Integer sed lacus suscipit, dignissim dui in, pulvinar ligula. Morbi dignissim facilisis ullamcorper. In hac habitasse platea dictumst. Nullam venenatis orci sed dui cursus, non fringilla tellus interdum. Nullam sed porttitor mauris. Aenean placerat finibus ex dictum accumsan. Morbi tempus, purus sed sollicitudin porta, quam felis aliquet libero, eu mollis mi arcu et purus.'
            },
            {
                name: 'AKBAR',
                photo: image1,
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam lobortis faucibus facilisis. Aenean commodo nec magna ac vehicula. Nam eleifend ultrices felis, eu laoreet mi porttitor id. Donec bibendum posuere felis eu consequat. Integer sed lacus suscipit, dignissim dui in, pulvinar ligula. Morbi dignissim facilisis ullamcorper. In hac habitasse platea dictumst. Nullam venenatis orci sed dui cursus, non fringilla tellus interdum. Nullam sed porttitor mauris. Aenean placerat finibus ex dictum accumsan. Morbi tempus, purus sed sollicitudin porta, quam felis aliquet libero, eu mollis mi arcu et purus.'
            },
            {
                name: 'AKBAR',
                photo: image1,
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam lobortis faucibus facilisis. Aenean commodo nec magna ac vehicula. Nam eleifend ultrices felis, eu laoreet mi porttitor id. Donec bibendum posuere felis eu consequat. Integer sed lacus suscipit, dignissim dui in, pulvinar ligula. Morbi dignissim facilisis ullamcorper. In hac habitasse platea dictumst. Nullam venenatis orci sed dui cursus, non fringilla tellus interdum. Nullam sed porttitor mauris. Aenean placerat finibus ex dictum accumsan. Morbi tempus, purus sed sollicitudin porta, quam felis aliquet libero, eu mollis mi arcu et purus.'
            },
        ]
    })
}
</script>