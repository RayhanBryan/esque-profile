<template>
    <div class="grid">
        <div class="col-12 lg:px-8 px-4 justify-content-center">
            <div class="text-center">
            <ProgressSpinner style="width:50px;height:50px" strokeWidth="8" fill="var(--surface-ground)" animationDuration=".5s" v-if="loading"/>
            </div>
            <div class="grid content mb-4" data-aos="zoom-in" data-aos-duration="2000" v-for="(i, index) in actWrap" :key="i.title" :class="(((index+1) % 2) == 0) ? 'act-even' : 'act-odd'">
                <div class="col-12 lg:col-4">
                    <img :src="i.url" alt="" style="width: 100%;">
                </div>
                <div class="col-12 lg:col-8">
                    <h3>{{index+1}}. {{i.title}}</h3>
                    <hr>
                    <p>{{i.textActivity}}</p>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .content {
        border-radius: 20px;
        box-shadow: 5px 5px gainsboro;
        padding: 20px;
        color: #00535B;
    }
    hr {
        border: 2px solid yellow;
        width: 20%;
        margin-left: 0;
    }
    p {
        font-weight: 600;
    }

    .act-even {
        text-align: right;
        display: flex;
        flex-direction: row-reverse;
    }

    .act-even hr {
        margin-left: auto;
        margin-right: 0;
    }

    .act-even img {
        float: right;
    }
    
    @media screen and (max-width: 480px) {
        .act-even {
            text-align: left;
        }
        .act-even hr {
            margin-left: 0;
        }
    }
</style>

<script>
import ActivityService from '../services/ActivityService'
export default {
    data() {
        return {
            actWrap: [{}],
            loading: true,
        }
    },
    methods: {
        getAct(){
            ActivityService.getActivity().then((res) => {
                this.actWrap = res.data.data;
                this.loading = false;
            })
        }
    },
    created(){
        this.getAct()
    }
}
</script>