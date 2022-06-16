<template>
    <div class="grid grid-1 pt-4 lg:px-8">
        <div class="col-12 lg:col-4">
            <img src="../assets/logo-pt.png" alt="" style="display: inline">
            <p style="display: inline-block">PT. KEBERKAHAN<br>TUJUAN<br>UTAMA</p>
            <br>
            <img src="../assets/logo-esque-full.png" alt="">
        </div>
        <div class="col-12 lg:col-4 tengah">
            <div class="grid">
                <div class="col-2 icon">
                    <img src="../assets/logo-phone.png" alt="" class="my-3" style="display: block">
                    <img src="../assets/logo-mail.png" alt="" class="my-3" style="display: block">
                    <img src="../assets/logo-privacy.png" alt="" class="my-3" style="display: block">
                </div>
                <div class="col">
                    <p class="my-3">+62 89507860001</p>
                    <p class="my-4">info.esque@gmail.com</p>
                    <p class="my-3">Kebijakan privasi</p>
                </div>
            </div>
        </div>
        <div class="col-12 lg:col-4">
            <p class="lg:mt-4">Jl. Anggajaya 2 No.108b,<br>
Sanggrahan, Condongcatur,<br>
Kec. Depok, Kabupaten Sleman,<br> 
Daerah Istimewa Yogyakarta 55281</p>
        </div>
    </div>
    <div class="grid justify-content-center">
        <div class="col-12 lg:col-6 justify-content-center text-center">
            <img src="../assets/logo-tiktok.png" alt="">
            <img src="../assets/logo-ig.png" alt="" class="lg:mx-8 mx-2">
            <img src="../assets/logo-linkedin.png" alt="">
        </div>
    </div>
</template>

<style scoped>
    .grid {
        background-color: #00A6A9;
        color: white;
        text-align: center;
    }

    @media screen and (max-width: 480px) {
        .icon {
            display: none;
        }
    }

    @media screen and (min-width: 480px) {
         
    .tengah {
        border-left: 2px solid white;
        border-right: 2px solid white;
        padding-left: 30px;
    }  

    .grid-1 {
        border-bottom: 2px solid white;
    }

    .grid {
        text-align: left;
        margin-top: 0 !important;
    }
    }
</style>

<script>
export default {
    
}
</script>