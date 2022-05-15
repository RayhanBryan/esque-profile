<template>
    <div class="grid justify-content-center">
        <div class="col-12 text-center title">
            <h1>HISTORY</h1>
            <hr>
        </div>
        <div class="col-12 lg:px-8">
            <Timeline :value="event" align="alternate" class="customized-timeline">
                <template #marker="slotProps">
                    <span class="custom-marker shadow-2" :style="{backgroundColor: slotProps.item.color}">
                    </span>
                </template>
                <template #content="slotProps">
                    <Card data-aos="zoom-in" data-aos-duration="2000" style="background-color: #00A6A9; color: white;">
                        <template #title>
                            {{slotProps.item.date}}
                        </template>
                        <template #content>
                            <p style="text-align: left; font-weight: 600">{{slotProps.item.text}}</p>
                        </template>
                    </Card>
                </template>
            </Timeline>
        </div>
    </div>
</template>

<style scoped>
    .title {
        border-bottom: 100px;
        margin-bottom: 50px;
    }

    h1 {
        color: #00535B;
    }

    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }
</style>

<style lang="scss" scoped>
    .custom-marker {
        display: flex;
        width: 2rem;
        height: 2rem;
        align-items: center;
        justify-content: center;
        color: #ffffff;
        border-radius: 50%;
        z-index: 1;
    }

    ::v-deep(.p-timeline-event-content)::v-deep(.p-timeline-event-opposite) {
        line-height: 1;
    }

    @media screen and (max-width: 960px) {
        ::v-deep(.customized-timeline) {
            .p-timeline-event:nth-child(even) {
                flex-direction: row !important;

                .p-timeline-event-content {
                    text-align: left !important;
                }
            }

            .p-timeline-event-opposite {
                flex: 0;
            }

            .p-card {
                margin-top: 1rem;
            }
        }
    }
</style>

<script>
    export default {
        data() {
            return {
                event: [
                {date: '12 Juni 2019', color: '#00A6A9', text: "Pembukaan Outlet pertama di Yogyakarta dengan brand Ngelak"},
                {date: 'Desember 2020', color: '#00A6A9', text: "Ngelak melakukan perubahan dan pengembangan, re-brending menjadi ESQUE INDONESIA"},
                {date: 'Januari 2021', color: '#00A6A9', text: "Resmi menjadi Perusahaan berbadan hukum yaitu PT Keberkahaan Tujuan Utama, Jumlah 16 Outlet di Yogyakarta "},
                {date: 'November 2021', color: '#00A6A9', text: "Pembukaan cabang pertama di Solo Raya"},
                {date: 'Juni 2021', color: '#00A6A9', text: "Pembukaan cabang pertama di Semarang Raya "},
            ],
                dates: [
                    "2020", "2021", "2022", "2023"
                ]
            }
        },
        mounted(){
        AOS.init();
    }
    }
</script>