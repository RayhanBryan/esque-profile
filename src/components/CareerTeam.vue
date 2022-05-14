<template>
    <div class="grid justify-content-center text-center">
        <div class="col-12">
            <h1 data-aos="zoom-in" data-aos-duration="2000">MEET OUR SUPER TEAM</h1>
            <hr>
        </div>
    </div>
    <div class="grid justify-content-center text-center px-4 lg:px-8">
        <div class="col-12 lg:col-6 lg:px-4" v-for="item in items" :key="item.name" data-aos="zoom-in" data-aos-duration="2000" data-aos-delay="300">
            <img :src="item.photo" alt="">
            <h3>{{ item.name }}</h3>
            <hr class="hr-team">
            <p class="text-post"><i>{{item.pos}}</i></p>
            <p>{{ item.text }}</p>
        </div>
    </div>
</template>

<style scoped>
    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }
    .hr-team {
        border: 2px solid #00535B;
        max-width: 60%;
        margin: 2% auto;
    }
    p {
        font-weight: 600;
        color: #00535B;
    }
    h3 {
        color: #00535B;
        margin-bottom: 0;
    }
    .text-post {
        color: #7A7A7A;
        font-weight: 600;
        margin-top: 0;
    }
</style>

<script>
import image1 from "../assets/team1.png"
import image2 from "../assets/team2.png"
import image3 from "../assets/team3.png"
import image4 from "../assets/team4.png"
import image5 from "../assets/team5.png"
import image6 from "../assets/team6.png"
export default {
    data: () => ({
        items: [
            {
                name: 'Muhamad Riyadi',
                photo: image1,
                pos: 'Human Capital Officer',
                text: 'ESQUE memberikan kesempatan untuk memaksimalkan skill. Tim yang agile dan penuh dengan kolaborasi positif.'
            },
            {
                name: 'Lalu Dwiki Anggara Putra',
                photo: image2,
                pos: 'Marketing Officer',
                text: 'Kerja di Esque itu Gokil! Tempat kerja yang nyaman, temannya muda dan seru, memberikan kesempempatan buat mengembangkan diri. Tempat yang dimana diajarkan untuk mengejar akhirat.'
            },
            {
                name: 'Msy Siti Devinda',
                photo: image3,
                pos: 'Supervisor Finance',
                text: 'Seru banget kerja di ESQUE!! Gak Cuma kerja tapi juga seimbang antara Dunia dan Akhirat!'
            },
            {
                name: 'Reshi Timur',
                photo: image4,
                pos: 'Human Capital General Affair',
                text: 'Tidak sekedar bekerja, ESQUE juga merubah diri saya menjadi pribadi yang lebih baik. Lingkungan yang sangat mendukung perubahan ke arah yang positif.'
            },
            {
                name: 'Richard Riowani',
                photo: image5,
                pos: 'Supervisor Operasional',
                text: 'Kerja di ESQUE yang memberikan kesempatan untuk belajar dan berkembang. Yang terpenting, kerja di Esque bikin Happy'
            },
            {
                name: 'Siti Muska',
                photo: image6,
                pos: 'Finance Officer',
                text: 'Teman kerjanya seru dan sportif. Punya Velue yang sama dan loyalitas kerja yang tinggi'
            },
        ]
    })
}
</script>