<template>
    <div class="grid" data-aos="zoom-in" data-aos-duration="2000">
        <div class="col-12 text-center title">
            <h1>WILAYAH EKSPANSI ESQUE</h1>
            <hr>
        </div>
        <div class="col-12 lg:px-8">
            <img src="../assets/map-gif.gif" alt="" style="max-width: 100%">
        </div>
        <div class="col-12">
            <div class="lg:ml-8 pl-2 keterangan">
                <img src="../assets/loc-merah.png" alt="" class="mr-3">
                <p style="display: inline">Sudah menjadi wilayah expensi esque</p>
                <br>
                <img src="../assets/loc-biru.png" alt="" class="mr-3">
                <p style="display: inline">Akan menjadi wilayah expensi esque</p>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .grid {
        background: rgb(255,255,255);
background: linear-gradient(180deg, rgba(255,255,255,1) 62%, rgba(198,217,219,1) 84%, rgba(0,166,169,1) 100%);
padding-bottom: 200px;
    }
    .title {
        border-bottom: 100px;
        margin-bottom: 50px;
        margin-top: 10%;
    }

    h1 {
        color: #00535B;
    }

    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }

    .keterangan {
        border-left: 10px solid yellow;
    }

    p {
        position: relative;
        bottom: 20px;
        color: #00535B;
        font-weight: 600;
    }
</style>

<script>
    export default {
        mounted(){
        AOS.init();
    }
    }
</script>