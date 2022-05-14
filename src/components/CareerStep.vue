<template>
    <div class="grid px-6">
        <div class="col-12 lg:col-5 lg:text-left text-center" data-aos="zoom-in" data-aos-duration="2000">
            <h1>We’ll Be There Every Step<br>of the Way</h1>
            <hr>
        </div>
    </div>
    <div class="grid px-6">
        <div class="col-12 lg:col-6 lg:text-left text-center" data-aos="zoom-in" data-aos-duration="2000">
            <p>Calling all passionate characters who have value, willingness to learn and develop<br>
                together in a good vibes environtment. Are you the ‘one’? Enjoy all every proses here</p>
        </div>
    </div>
    <div class="grid justify-content-center">
        <hr class="dashed justify-content-start">
        <div class="col-12 px-4 lg:px-0 lg:col-2 mx-3 text-center lg:mb-8" data-aos="zoom-in" data-aos-duration="2000" v-for="step in steps" :key="step.title">
            <img :src="step.logo" alt="">
            <h2>{{ step.title }}</h2>
            <p>{{ step.text }}</p>
        </div>
    </div>
    <div class="grid last px-4 lg:px-8">
        <div class="col-12">
            <hr class="last-hr">
        </div>
    </div>
</template>

<style scoped>
    .grid {
        background-color: #00A6A9;
        color: white;
    }

    hr {
        border: 2px solid yellow;
        width: 30%;
    }

    .dashed{
        border: 2px dashed white;
        position: absolute;
        width: 90%;
        z-index: 0;
        margin-top: 2%;
    }

    img {
        position: relative;
        z-index: 1;
    }

    .last {
        background-color: white;
    }

    .last-hr {
        border: 2px dashed yellow;
        width: 80%;
    }

    @media screen and (max-width: 960px) {
        .dashed {
            display: none;
        }
    }
</style>

<script>
    import image1 from "../assets/step1.png"
    import image2 from "../assets/step2.png"
    import image3 from "../assets/step3.png"
    import image4 from "../assets/step4.png"
    import image5 from "../assets/step5.png"
    export default {
        data() {
            return {
                steps: [{
                        title: 'Submit Application',
                        text: 'The baby step you need to follow first is, of course, you need to send your newest  application such as a resume or even portfolio. Don’t skip this process.',
                        logo: image1
                    },
                    {
                        title: 'Submit Application',
                        text: 'The baby step you need to follow first is, of course, you need to send your newest  application such as a resume or even portfolio. Don’t skip this process.',
                        logo: image2
                    },
                    {
                        title: 'Submit Application',
                        text: 'The baby step you need to follow first is, of course, you need to send your newest  application such as a resume or even portfolio. Don’t skip this process.',
                        logo: image3
                    },
                    {
                        title: 'Submit Application',
                        text: 'The baby step you need to follow first is, of course, you need to send your newest  application such as a resume or even portfolio. Don’t skip this process.',
                        logo: image4
                    },
                    {
                        title: 'Submit Application',
                        text: 'The baby step you need to follow first is, of course, you need to send your newest  application such as a resume or even portfolio. Don’t skip this process.',
                        logo: image5
                    },
                ]
            }
        }
    }
</script>