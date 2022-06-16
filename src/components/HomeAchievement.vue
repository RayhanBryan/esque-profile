<template>
    <div class="grid justify-content-center lg:px-8">
        <div class="col-12 text-center title">
            <h1 data-aos="zoom-in" data-aos-duration="2000">ACHIEVEMENT</h1>
            <hr>
        </div>
        <div class="grid justify-content-center">
            <div class="col-12">
                <ProgressSpinner style="width:50px;height:50px" strokeWidth="8" fill="var(--surface-ground)"
                    animationDuration=".5s" v-if="loading" />
                <Carousel :value="achWrap" :numVisible="3" :numScroll="1" :responsiveOptions="responsiveOptions"
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
        <!-- <div class="col-12 lg:col-5 text-center">
            <img src="../assets/award1.png" alt="" style="border-radius: 20px; max-width: 100%;" data-aos="zoom-in" data-aos-duration="2000">
            <h2 data-aos="zoom-in" data-aos-duration="2000">
                Shopee Super<br>Awards 2021
            </h2>
        </div>
        <div class="col-12 lg:col-5 lg:col-offset-2 text-center">
            <img src="../assets/award3.png" alt="" style="border-radius: 20px; max-width: 100%;" data-aos="zoom-in" data-aos-duration="2000">
            <h2 data-aos="zoom-in" data-aos-duration="2000">
                Sponsorship<br>PPKI 2021/2022
            </h2>
        </div>
        <div class="col-12 lg:col-6 gambar-tengah text-center">
            <img src="../assets/award2.png" alt="" style="border-radius: 20px; max-width: 100%;" data-aos="zoom-in" data-aos-duration="2000">
            <h2 data-aos="zoom-in" data-aos-duration="2000">
                Idola Baru<br>Grabfood 2021
            </h2>
        </div> -->
    </div>
</template>

<style scoped>
    .title {
        border-bottom: 100px;
        margin-bottom: 50px;
    }

    h1 {
        color: #00535B;
    }

    hr {
        border: 2px solid yellow;
        max-width: 30%;
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

    /* @media screen and (min-width: 960px) {
    .gambar-tengah {
        position: absolute;
        margin-top: 130px;
    }
} */
</style>

<script>
    import AchievementService from '../services/AchievementService';
    export default {
        data() {
            return {
                achWrap: [],
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
        mounted() {
            AOS.init();
        },
        created() {
            AchievementService.get().then((res) => {
                this.achWrap = res.data.data
                this.loading = false;
            })
        }
    }
</script>