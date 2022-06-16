<template>
    <div class="grid justify-content-center text-center">
        <div class="col-12">
            <h1 data-aos="zoom-in" data-aos-duration="2000">MEET OUR SUPER TEAM</h1>
            <hr>
        </div>
    </div>
    <div class="grid justify-content-center text-center px-4 lg:px-8" v-if="display">
        <div class="col-12 lg:col-6 lg:px-4" v-for="item in items" :key="item.name" data-aos="zoom-in"
            data-aos-duration="2000" data-aos-delay="300">
            <img :src="item.url" alt="">
            <h3>{{ item.title }}</h3>
            <hr class="hr-team">
            <p class="text-post"><i>{{item.position}}</i></p>
            <p>{{ item.textTeam }}</p>
        </div>
    </div>
    <div class="grid justify-content-center" v-if="!display">
        <div class="col-12">
            <Carousel :value="items" :numVisible="1" :numScroll="1" :responsiveOptions="responsiveOptions"
                :circular="true">
                <template #item="slotProps">
                    <div class="product-item">
                        <div class="product-item-content text-center">
                            <div>
                                <img :src="slotProps.data.url" alt="" style="border-radius: 20px; max-width: 90%;">
                                <h3 class="mb-1">{{slotProps.data.title}}</h3>
                            </div>
                        </div>
                    </div>
                </template>
            </Carousel>
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
        margin: 2% auto;
    }

    p {
        font-weight: 600;
        color: #00535B;
    }

    h3 {
        color: #00535B;
        margin-bottom: 0;
    }

    .text-post {
        color: #7A7A7A;
        font-weight: 600;
        margin-top: 0;
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
    import TeamService from '../services/TeamService';
    export default {
        data() {
            return {
            items: [],
            display: true,
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
            loading: true,
        }
        },
        methods: {
            methods: {
            onResize() {
                if (window.innerWidth > 960) {
                    this.display = true
                } else {
                    this.display = false
                }
            }
        },
        },
        created() {
            TeamService.get().then(res => {
                this.items = res.data.data
            });
            if (screen.width > 480 ){
                this.display = true;
            } else {
                this.display = false;
            }
        },
    }
</script>