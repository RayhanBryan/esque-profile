<template>
    <div class="grid row-box lg:px-8">
        <div class="col-12 lg:col-4" v-for="value in values" :key="value.title">
            <div class="circle">
                        <img src="../assets/value/1.png" contain max-height="110px">
                    </div>
                <div class="text-box">
                    <div class="title">
                        <h3 class="title-text">
                        {{ value.title }}
                        </h3>
                    </div>
                    <div>
                        {{ value.text }}
                    </div>
                </div>
        </div>
    </div>
</template>

<style scoped>
    .grid {
        background: #00A6A9;
        color: white;
    }
    .row-title {
        margin-top: 2%;
        color: white;
    }
    .row-box {
        justify-content: center;
        position: relative;
        bottom: 50px;
    }
    .title {
        text-align: center;
        height: 70px;
    }
    .title-text {
        font-weight: 800;
    }
    .text-box {
        
        color: #00535b;
        padding: 30% 10% 10% 10%;
        text-align: center;
        background: white;
        border-radius: 20px;
        height: 450px;
    }
    .circle {
        position: relative;
        top : 50px;
    }

        @media screen and (max-width: 960px) {
            .row-box {
                margin: auto;
                justify-self: center;
            }
            .text-box {
                
            }
    }
</style>

<script>
export default {
    data: () => ({
    values : [
      {
        title: "Live After Life",
        text: "Selalu melibatkan Allah SWT dalam menjalankan kehidupan personal dan pekerjaan. Menjalankan kewajiban dan sunnah yang diperintahkan/ dianjurkan oleh ajaran agama Islam yang diimplementasikan dalam bentuk perilaku, perkataan maupun perbuatan.",
        image: "../assets/value/1.png"
      },
      {
        title: "Let's Reach the top Together",
        text: "Memiliki kemampuan untuk bekerjasama seperti saling menghormati, mengajak ke dalam hal kebaikan dan siap sedia membantu siapapun yang membutuhkan demi tercapainya goals Perusahaan.",
        image: "../assets/value/2.png"
      },
      {
        title: "Growth & Learning is in Our DNA",
        text: "Memiliki keinginan belajar dan mengembangkan diri yang tinggi dengan memahami perkembangan terkini serta bagaimana menemukan peluang dari perkembangan tersebut.",
        image: "../assets/value/3.png"
      },
      {
        title: "Do It Properly & Professionally",
        text: "Memiliki dan menjalankan rasa tanggungjawab untuk menjalankan pekerjaan yang merupakan kewajibannya dan mampu bekerja secara profesional menyelesaikan pekerjaan secara maksimal, konsisten maupun sesuai harapan perusahaan serta mengikuti protokol peraturan yang ada.",
        image: "../assets/value/4.png"
      },
      {
        title: "Do It with Your Heart",
        text: "Membangun rasa bangga menjadi bagian dari perusahaan dengan menjaga nama baik dan reputasi Perusahaan serta bersedia untuk berdedikasi terhadap pengembangan dan kemajuan perusahaan.",
        image: "../assets/value/5.png"
      },
    ]
  }),
}
</script>