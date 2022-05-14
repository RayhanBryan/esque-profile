<template>
    <div class="grid justify-content-center lg:px-8">
        <div class="col-12 text-center">
            <h1 data-aos="zoom-in" data-aos-duration="2000">WHAT IS IT LIKE TO WORK IN ESQUE</h1>
        </div>
        <div class="col-12 lg:col-4" v-for="item in items" :key="item.photo" data-aos="zoom-in" data-aos-duration="2000">
            <img :src="item.photo" alt="" style="width: 100%">
            <h2 class="text-center m-0">{{ item.text }}</h2>
        </div>
    </div>
    <div class="grid justify-content-center lg:px-8" v-if="seeMore">
        <div class="col-12 lg:col-4" v-for="item in moreItems" :key="item.photo"  data-aos="zoom-in" data-aos-duration="2000">
            <img :src="item.photo" alt="" style="width: 100%">
            <h2 class="text-center m-0">{{ item.text }}</h2>
        </div>
    </div>
    <div class="grid" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 text-center">
            <Button label="SEE MORE" v-if="!seeMore" @click="isSeeMore()" />
            <Button label="SEE LESS" v-if="seeMore" @click="isSeeMore()" />
        </div>
    </div>
</template>

<style scoped>
    h1 {
        color: #00535B;
    }

    .p-button {
        color: #00535B; 
        background-color: #FFC800; 
        border: none;
        font-weight: 700;
    }
</style>

<script>
import image1 from "../assets/like1.png"

export default {
    data: () => ({
    items: [
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
    ],
    moreItems: [
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
        {
            photo: image1,
            text: "Lorem"
        },
    ],

    seeMore: false
    }),

    methods: {
        isSeeMore(){
            this.seeMore = !this.seeMore
        }
    }
}
</script>