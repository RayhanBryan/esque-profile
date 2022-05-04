<template>
    <div class="grid">
        <div class="col-12">
            <h2>Title</h2>
            <InputText type="text" v-model="title" />
        </div>
        <div class="col-12">
            <Textarea v-model="text" :autoResize="true" rows="5" cols="30" />
        </div>
        <div class="col-12">
            <!-- <FileUpload name="demo[]" url="http://localhost:9090/blog/post" @change="onChange" @upload="onUpload" :multiple="true" accept="image/*" :maxFileSize="1000000">
            <template #empty>
                <p>Drag and drop files to here to upload.</p>
            </template>
        </FileUpload> -->
        <input type="file" id="image" name="image" accept="image/png, image/jpeg" @change="onChange">
            <Toast />
        </div>
        <div class="col-">
            <Button label="Post now" style="background-color: #FFC800" @click="onUpload"/>
        </div>

        <FileUpload name="demo[]" url="http://localhost:9090/blog/file" @upload="onUploadImage" :multiple="true" accept="image/*" :maxFileSize="1000000">
            <template #empty>
                <p>Drag and drop files to here to upload.</p>
            </template>
        </FileUpload>
    </div>

</template>

<style scoped>

</style>

<script>
import BlogService from '../services/BlogService'
export default {
    data() {
        return {
            messages: [],
            title: '',
            text: '',
            image: '',
            newPost: {
                title: '',
                textBlog: '',
                url: '',
            },
        }
    },
    methods: {
        onUpload() {
            this.$toast.add({severity: 'info', summary: 'Success', detail: 'File Uploaded', life: 3000});
            this.newPost.title = this.title;
            this.newPost.textBlog = this.text;
            console.log('ini data yg diinput: ' ,this.newPost)
            BlogService.postImage(this.newPost).then((res) => {
                console.log(res);
            }).catch((error) => {
                console.log(error.response.data)
            })
        },

        onChange() {
            console.log(event.target.files[0].name)
            this.newPost.url = event.target.files[0].name
        },

        onUploadImage(){

        }
    }
}
</script>