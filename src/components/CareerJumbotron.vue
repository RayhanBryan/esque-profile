<template>
    <div class="grid">
        <div class="col-12 px-0">
        <img src="../assets/jumbotron-career.png" alt="" style="width: 100%;">
        <div class="grid justify-content-center text-center"></div>
        <div class="col-12 p-0">
            <div class="text">
            <h1 class="text-center my-0">JOIN US<br>ESQUE SQUAD</h1>
            <h2 class="my-0">FINDING YOUR HAPPINES</h2>
            </div>
        </div>
        </div>
    </div>
    <div class="grid">
        <div class="col-12 py-0 join-us text-center justify-content-center" v-if="!mobile">
            <Button data-aos="zoom-in" data-aos-duration="2000" data-aos-delay="300" label="JOIN US" style="background-color: #FFC800; width: 300px; height: 100px" onclick="window.open('https://forms.gle/Tag41jUryUT8XamM8')" />
        </div>
        <div class="col-12 py-0 join-us text-center justify-content-center" v-if="mobile">
            <Button data-aos="zoom-in" data-aos-duration="2000" data-aos-delay="300" label="JOIN US" style="background-color: #FFC800; width: 200px; height: 50px" onclick="window.open('https://forms.gle/Tag41jUryUT8XamM8')" />
        </div>
    </div>
</template>

<style scoped>
    img {
        filter: brightness(80%);
        z-index: -1;
    }
    h1 {
        font-size: 60px;
        color: #FFC800;
    }
    h2 {
        font-size: 40px;
        color: white;
    }
    .text {
        position: absolute;
        bottom: 0;
        margin-left: auto;
        margin-right: auto;
        left: 0;
        right: 0;
        text-align: center;
    }
    .join-us {
        height: 250px;
        background-color: #00A6A9;
    }
    .p-button {
        margin-top: 5%;
        color: #00535B;
        font-weight: 700;
        border: none;
    }
    @media screen and (max-width: 480px) {
        .text {
        position: absolute;
        bottom: 450px;
        }
        h1 {
        font-size: 15px;
        color: #FFC800;
        }

        h2 {
        font-size: 10px;
        color: white;
        }

        .join-us {
            height: 100px;
        }

        .p-button{
            margin-top: 35px;
        }
    }
</style>

<script>
export default {
    data() {
            return {
                mobile : true
            }
    },
    methods: {
    toForm(){
        window.location.assign("https://www.w3schools.com")
    },
    onResize() {
                if (window.innerWidth < 960) {
                    this.mobile = true
                } else {
                    this.mobile = false
                }
            }
  },
  created() {
    if (screen.width < 480 ){
                this.mobile = true;
            } else {
                this.mobile = false;
            }
  }
}
</script>