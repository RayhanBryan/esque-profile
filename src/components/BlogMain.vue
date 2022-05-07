<template>
    <div class="grid justify-content-center">
        <div class="col-12 text-center">
            <h1>BLOG</h1>
            <hr>
        </div>
        <div class="col-12 lg:px-8">
            <div class="grid content mb-4" v-for="i in blogWrap" :key="i.title">
                <div class="col-12 lg:col-4">
                    <img :src="i.url" alt="" style="width: 100%;">
                </div>
                <div class="col-12 lg:col-8">
                    <h1 class="my-0">{{ i.title }}</h1>
                    <p>{{ i.textBlog }}</p>
                    <Button label="Read More" @click="openDialog(i)" class="p-button-rounded p-button-outlined" style="float: right; color: #00535B; font-weight: 600"/>
                </div>
            </div>
        </div>
    </div>
    <Dialog :header="row.title" v-model:visible="display" :style="{width: '50vw'}" :maximizable="true" :modal="true">
            <img :src="row.url" alt="" style="float: left" class="mr-2">
            <p class="m-0 dialog" v-html="row.textBlog"></p>
        </Dialog>
</template>

<style scoped>
    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }
    h1 {
        display: -webkit-box;
        overflow: hidden;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
        color: #00535B;
    }
    .content {
        border-radius: 20px;
        box-shadow: 5px 5px gainsboro;
        padding: 20px;
    }
    .content p {
        display: -webkit-box;
        overflow: hidden;
        -webkit-line-clamp: 9;
        -webkit-box-orient: vertical;
        font-weight: 500;
        color: #00535B;
        text-align: justify;
    }
    .dialog {
        text-align: justify;
        color: #00535B;
    }

    .dialog::first-letter {
        font-size: 200%;
    }
    .p-dialog .p-dialog-header {
        color: #00535B !important;
}
</style>

<script>
import BlogService from '../services/BlogService'
export default {
    data() {
        return {
            blogWrap: [{}],
            display: false,
            row: {},
            regex: '\n',
            parser: new DOMParser(),
        }
    },
    methods: {
        getBlog() {
            BlogService.getBlog().then((res) => {
                this.blogWrap = res.data.data
                console.log(res)
                console.log(this.blogWrap)
            })
        },
        openDialog(isi) {
            this.row = {...isi}
            this.row.textBlog = this.row.textBlog.replace(/(?:\r\n|\r|\n)/g, '<br>');
            // this.row.textBlog = this.parser.parseFromString(this.row.textBlog, 'text/html');
            console.log(this.row.textBlog, 'ini row')
            this.display = true;
        },
    },
    created() {
        this.getBlog()
    }
}
</script>