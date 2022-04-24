<template>
    <div class="grid px-0">
        <div class="col-12 px-0">
        <img src="../assets/jumbotron.png" alt="" style="width: 100%;">
        <div class="grid"></div>
            <h1>We Take Every Chance <br> We Drop Every Fear. <br> Are you in?</h1>
        </div>
    </div>
</template>

<style scoped>
    img {
        filter: brightness(65%);
        z-index: -1;
    }

    h1 {
        font-size: 60px;
        position: absolute;
        top: 570px;
        left: 25px;
        color: #FFC800;
    }

    @media screen and (max-width: 480px) {
        h1 {
        font-size: 15px;
        position: absolute;
        top: 180px;
        left: 12px;
        color: #FFC800;
    }
    }
</style>

<script>
    export default {

    }
</script>