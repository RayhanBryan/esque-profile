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
        <div class="col-12 py-0 join-us text-center justify-content-center">
            <Button label="JOIN US" style="background-color: #FFC800" onclick="window.open('https://www.w3schools.com/js/tryit.asp?filename=tryjs_loc_assign')" />
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
        left: 32%;
    }
    .join-us {
        height: 250px;
        background-color: #00A6A9;
    }
    .p-button {
        margin-top: 120px;
        color: #00535B;
        font-weight: 700;
        border: none;
        width: 120px;
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
    methods: {
    toForm(){
        window.location.assign("https://www.w3schools.com")
    }
  },
}
</script>