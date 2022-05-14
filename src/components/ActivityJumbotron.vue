<template>
    <div class="grid justify-content-center px-0">
        <div class="col-12 text-center px-0">
            <h1  data-aos="zoom-in" data-aos-duration="2000">ESQUE ACTIVITY</h1>
            <img src="../assets/activity-jumbotron.png" alt="" style="width: 100%;">
        </div>
    </div>
</template>

<style scoped>

    img {
        filter: brightness(80%);
        z-index: -99;
    }
    h1 {
        position: absolute;
        margin-left: auto;
        margin-right: auto;
        left: 0;
        right: 0;
        margin-top: 30%;
        font-size: 60px;
        color: #FFC800;
        z-index: 1;
    }

    @media screen and (max-width: 480px) {
        h1 {
            font-size: 15px;
        }
    }
</style>

<script>
export default {
    
}
</script>