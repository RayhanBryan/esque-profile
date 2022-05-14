<template>
    <div class="grid justify-content-center">
        <div class="col-12 lg:col-3 text-center lg:my-8">
            <h1 data-aos="zoom-in" data-aos-duration="2000">VISI</h1>
            <p data-aos="zoom-in" data-aos-duration="2000">“Menebarkan Kebahagiaan dengan Menjadi Business Opportunity yang Menguntungkan bagi Semua Stakeholder”</p>
            <h1 data-aos="zoom-in" data-aos-duration="2000">MISI</h1>
            <ol  data-aos="zoom-in" data-aos-duration="2000" class="text-left">
                <li>Mengutamakan pelayanan service excellent dan memudahkan Customer dalam menikmati/mendapatkan produk ESQUE.</li>
                <li>Menciptakan produk yang bervariatif dan berkualitas dengan harga yang terjangkau.</li>
                <li>Menebarkan kebahagiaan dengan memberikan dukungan/support kepada lingkungan masyarakat yang membutuhkan.</li>
                <li>Menyediakan dan mensupport seluruh Karyawan untuk bertumbuh dari segi Knowledge & Spiritual.</li>
                <li>Memastikan dana Investasi dikelola dengan Amanah dan Profesional.</li>
            </ol>
        </div>
    </div>
</template>

<style scoped>
    .grid {
        color: #00535B;
    }
     /* @media screen and (max-width: 480px) {
        p {
            font-size: 10px;
        }

        li {
            font-size: 10px;
        }

        h1 {
            font-size: 20px;
        }
    } */
</style>

<script>
export default {
    mounted(){
        AOS.init();
    }
}
</script>