<template>
    <div class="grid justify-content-center lg:px-8">
        <div class="col-12 text-center">
            <h1 data-aos="zoom-in" data-aos-duration="2000">WHAT IS IT LIKE TO WORK IN ESQUE</h1>
        </div>
        <!-- <div class="col-12 lg:col-4" v-for="item in items" :key="item.photo" data-aos="zoom-in" data-aos-duration="2000">
            <img :src="item.photo" alt="" style="width: 100%">
            <h2 class="text-center m-0">{{ item.text }}</h2>
        </div>
    </div>
    <div class="grid justify-content-center lg:px-8" v-if="seeMore">
        <div class="col-12 lg:col-4" v-for="item in moreItems" :key="item.photo">
            <img :src="item.photo" alt="" style="width: 100%">
            <h2 class="text-center m-0">{{ item.text }}</h2>
        </div>
    </div> -->
    <Carousel :value="items" :numVisible="3" :numScroll="1" :responsiveOptions="responsiveOptions"
                :circular="true"  style="max-width: 90%;">
                <template #item="slotProps">
                    <div class="product-item">
                        <div class="product-item-content text-center">
                            <div>
                                <img :src="slotProps.data.photo" alt="" style="border-radius: 20px; max-height: 200px;">
                                <h3 class="mb-1">{{slotProps.data.text}}</h3>
                            </div>
                        </div>
                    </div>
                </template>
            </Carousel>
    <!-- <div class="grid" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 text-center">
            <Button label="SEE MORE" v-if="!seeMore" @click="isSeeMore()" />
            <Button label="SEE LESS" v-if="seeMore" @click="isSeeMore()" />
        </div>
    </div> -->
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

    ::v-deep(.p-carousel .p-carousel-indicators .p-carousel-indicator.p-highlight button) {
        background-color: #00A6A9 !important;
    }

    ::v-deep(.p-carousel .p-carousel-indicators .p-carousel-indicator button) {
        background-color: gray;
        width: 2rem;
        height: 0.5rem;
        transition: background-color 0.2s, color 0.2s, box-shadow 0.2s;
        border-radius: 0;
    }
</style>

<script>
import image1 from "../assets/career/1.jpg"
import image2 from "../assets/career/2.jpg"
import image3 from "../assets/career/3.jpg"
import image4 from "../assets/career/4.jpg"
import image5 from "../assets/career/5.jpg"
import image6 from "../assets/career/6.jpg"
import image7 from "../assets/career/7.jpg"
import image8 from "../assets/career/8.jpg"
import image9 from "../assets/career/9.jpg"
import image10 from "../assets/career/10.jpg"
import image11 from "../assets/career/11.jpg"
import image12 from "../assets/career/12.jpg"

export default {
    data: () => ({
    items: [
        {
            photo: image1,
            text: "Active & Energic"
        },
        {
            photo: image2,
            text: "Trendy & Up To Date"
        },
        {
            photo: image3,
            text: "Growth Learning"
        },
        {
            photo: image4,
            text: "Creative & Innovative"
        },
        {
            photo: image5,
            text: "Helping others & Spread kindness"
        },
        {
            photo: image6,
            text: "Helping others"
        },
        {
            photo: image7,
            text: "Joy & Positive"
        },
        {
            photo: image8,
            text: "Loyal & Dedicated"
        },
        {
            photo: image9,
            text: "Prayhard, Workhard"
        },
        {
            photo: image10,
            text: "Proffesional & Intergrity"
        },
        {
            photo: image11,
            text: "Respect "
        },
        {
            photo: image12,
            text: "Responsible & Consistent"
        },
    ],
    responsiveOptions: [{
                    breakpoint: '1024px',
                    numVisible: 3,
                    numScroll: 3
                },
                {
                    breakpoint: '600px',
                    numVisible: 2,
                    numScroll: 2
                },
                {
                    breakpoint: '480px',
                    numVisible: 1,
                    numScroll: 1
                }
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