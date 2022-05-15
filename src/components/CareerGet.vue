<template>
    <div class="grid px-0 justify-content-center" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 lg:col-4 text-center justify-content-center col-div">
            <div class="title text-center">
                <h1>WHAT WILL YOU GET</h1>
            </div>
        </div>
    </div>
    <div class="grid px-0" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 lg:col-6 p-0">
            <img src="../assets/get1.png" alt="" style="width: 100%; height: 100%;">
        </div>
        <div class="col-12 lg:col-6 px-0 text-center" style="background-color: #00A6A9; color: white;">
            <h2 data-aos="zoom-in" data-aos-duration="2000">WORK LIFE INTERGRATION</h2>
            <hr>
            <p data-aos="zoom-in" data-aos-duration="2000" class="lg:mx-8 mx-5 lg:mt-8">Work Hard, Pray Hard!
                Kinerja yang optimal memang penting, begitu juga
                kehidupan seluruh keluarga besar ESQUE INDONESIA,
                Esque menyediakan fasilitas untuk mengembangkan hobi dan
                juga fasilitas untuk meningkatkan kecerdasan spiritual. Sehingga tidak
                hanya kinerja yang optimal namun Ibadah juga maksimal,
                sehingga kehidupan menjadi lebih berkualitas.</p>
        </div>
    </div>
    <div class="grid px-0 row-2" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 lg:col-6 px-0 text-center" style="background-color: #00A6A9; color: white;">
            <h2 data-aos="zoom-in" data-aos-duration="2000">KESEHATAN</h2>
            <hr>
            <p data-aos="zoom-in" data-aos-duration="2000" class="lg:mx-8 mx-5 lg:mt-8">Kesehatan fisik dan Jiwa seluruh Esque Squad adalah prioritas perusahaan, 
terdapat asuransi Kesehatan dan Layanan Kesehatan mental sebagai 
wujud pemenuhan Kesehatan seluruh ESQUE SQUAD.
</p>
        </div>
        <div class="col-12 lg:col-6 p-0" style="background-color: #00A6A9;">
            <img src="../assets/get2.png" alt="" style="width: 100%; height: 100%;">
        </div>
    </div>
    <div class="grid px-0" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 lg:col-6 p-0">
            <img src="../assets/get3.png" alt="" style="width: 100%; height: 100%;">
        </div>
        <div class="col-12 lg:col-6 px-0 text-center" style="background-color: #00A6A9; color: white;">
            <h2 data-aos="zoom-in" data-aos-duration="2000">WORK LIFE INTERGRATION</h2>
            <hr>
            <p data-aos="zoom-in" data-aos-duration="2000" class="lg:mx-8 mx-5 lg:mt-8">Work Hard, Pray Hard!
                Kinerja yang optimal memang penting, begitu juga
                kehidupan seluruh keluarga besar ESQUE INDONESIA,
                Esque menyediakan fasilitas untuk mengembangkan hobi dan
                juga fasilitas untuk meningkatkan kecerdasan spiritual. Sehingga tidak
                hanya kinerja yang optimal namun Ibadah juga maksimal,
                sehingga kehidupan menjadi lebih berkualitas.</p>
        </div>
    </div>
</template>

<style scoped>
    .title {
        background-color: #00A6A9;
        color: white;
        width: 350px;
        border-radius: 10px;
        justify-self: center;
        margin-left: 10%;
    }

    hr {
        border: 2px solid yellow;
        max-width: 60%;
    }

    @media screen and (max-width: 480px) {
        .title {
            width: auto;
            margin: auto;
        }
        .row-2 {
            /* display: flex; */
            flex-flow: column-reverse;
        }
    }
</style>

<script>
    export default {
         mounted(){
        AOS.init();
    }
    }
</script>