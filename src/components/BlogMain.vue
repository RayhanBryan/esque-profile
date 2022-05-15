<template>
    <div class="grid justify-content-center">
        <div class="col-12 text-center">
            <h1 style="color: #00535B" data-aos="zoom-in" data-aos-duration="2000">BLOG</h1>
            <hr>
        </div>
        <ProgressSpinner style="width:50px;height:50px" strokeWidth="8" fill="var(--surface-ground)" animationDuration=".5s" v-if="loading"/>
        <div class="col-12 lg:px-8 px-4">
            <div class="grid content mb-4" v-for="i in blogWrap" :key="i.title"  data-aos="zoom-in" data-aos-duration="2000">
                <div class="col-12 lg:col-4">
                    <img :src="i.url" alt="" style="width: 100%;">
                </div>
                <div class="col-12 lg:col-8">
                    <h1 class="my-0">{{ i.title }}</h1>
                    <p>{{ i.textBlog }}</p>
                    <Button label="Read More" @click="openDialog(i)" class="p-button-rounded p-button-outlined"
                        style="float: right; color: #00535B; font-weight: 600" />
                </div>
            </div>
        </div>
    </div>
    <Dialog header="&nbsp" v-model:visible="display" :modal="true" class="dialog">
        <div class="inside-dialog">
            <h1 class="text-center" style="color: #00535B">{{row.title}}</h1>
            <img :src="row.url" alt="" style="float: left;" class="lg:mr-2">
            <p class="m-0 dialog" v-html="row.textBlog"></p>
        </div>
    </Dialog>

</template>

<style scoped>
    hr {
        border: 2px solid yellow;
        max-width: 30%;
    }

    .content h1 {
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

    .inside-dialog {
        width: 50vw;
    }

    .dialog::first-letter {
        font-size: 200%;
    }

    .p-dialog .p-dialog-header {
        color: #00535B !important;
    }

    @media screen and (max-width: 480px) {
        .dialog img {
            width: 100%;
        }

        /* .dialog {
            width: 90vw;
        } */

        .content h1 {
            display: -webkit-box;
            overflow: hidden;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            color: #00535B;
        }

        .inside-dialog {
        width: 80vw;
    }
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
                loading: true,
            }
        },
        methods: {
            getBlog() {
                BlogService.getBlog().then((res) => {
                    this.blogWrap = res.data.data
                    this.loading = false;
                    console.log(this.blogWrap)
                })
            },
            openDialog(isi) {
                this.row = {
                    ...isi
                }
                this.row.textBlog = this.row.textBlog.replace(/(?:\r\n|\r|\n)/g, '<br>');
                // this.row.textBlog = this.parser.parseFromString(this.row.textBlog, 'text/html');
                console.log(this.row.textBlog, 'ini row')
                this.display = true;
            },
            loadingFalse(){
                this.loading=false;
                this.loadBlog=true;
                console.log(this.loadBlog, 'ini loadblog')
            }
        },
        created() {
            this.getBlog();
        }
    }
</script>