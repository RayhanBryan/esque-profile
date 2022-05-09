<template>
    <div class="grid">
        <div class="col-12">
            <h1 class="text-center">BLOG CONTROLLER</h1>
        </div>
        <div class="col-12">
            <h2>Title</h2>
            <InputText type="text" v-model="newPost.title" />
        </div>
        <div class="col-12">
            <h2>Text</h2>
            <Textarea v-model="newPost.textBlog" :autoResize="true" rows="5" cols="30" />
        </div>
        <!-- <div class="col-12"> -->
            <!-- <FileUpload name="demo[]" url="http://localhost:9090/blog/post" @change="onChange" @upload="onUpload" :multiple="true" accept="image/*" :maxFileSize="1000000">
            <template #empty>
                <p>Drag and drop files to here to upload.</p>
            </template>
        </FileUpload> -->
        <!-- <input type="file" id="image" name="image" accept="image/png, image/jpeg" @change="onChange(this.value)">
            <Toast />
        </div> -->
        <div class="col-12">
            <form method="POST" action="http://localhost:9090/blog/uploadFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
        </div>
        <div class="col-12">
            <h2>Image</h2>
            <InputText type="text" v-model="newPost.url" />
        </div>
        <div class="col-12">
            <Button label="Post now" style="background-color: #FFC800" @click="onUpload"/>
        </div>
<!--
        <FileUpload name="demo[]" url="http://localhost:9090/blog/file" @upload="onUploadImage" :multiple="true" accept="image/*" :maxFileSize="1000000">
            <template #empty>
                <p>Drag and drop files to here to upload.</p>
            </template>
        </FileUpload> -->
    </div>

    <div class="grid">
        <div class="col-12">
            <DataTable :value="blogWrap" :paginator="true" :rows="4"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[4,10,20]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="title" header="Title"></Column>
            <Column field="textBlog" header="Text"></Column>
            <Column header="Image">
                <template #body="slotProps">
                    <img :src="slotProps.data.url" :alt="slotProps.data.image" class="product-image" />
                </template>
            </Column>
            <Column header="Action">
                <template #body="slotProps">
                    <Button type="button" icon="pi pi-pencil" @click="openMaximizable(slotProps.data)" />
                    <Button type="button" icon="pi pi-trash" class="p-button-danger" />
                </template>
            </Column>
        </DataTable>    
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <h1 class="text-center">ACTIVITY CONTROLLER</h1>
        </div>
        <div class="col-12">
            <h2>Title</h2>
            <InputText type="text" v-model="newAct.title" />
        </div>
        <div class="col-12">
            <h2>Text</h2>
            <Textarea v-model="newAct.textActivity" :autoResize="true" rows="5" cols="30" />
        </div>
        <div class="col-12">
            <h2>Image</h2>
            <InputText type="text" v-model="newAct.url" />
        </div>
        <div class="col-12">
            <Button label="Post now" style="background-color: #FFC800" @click="onUploadAct"/>
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <DataTable :value="actWrap" :paginator="true" :rows="4"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[4,10,20]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="title" header="Title"></Column>
            <Column field="textActivity" header="Text"></Column>
            <Column header="Image">
                <template #body="slotProps">
                    <img :src="slotProps.data.url" :alt="slotProps.data.image" class="product-image" />
                </template>
            </Column>
            <Column header="Action">
                <template #body="slotProps">
                    <Button type="button" icon="pi pi-pencil" @click="openMaximizable(slotProps.data)" />
                    <Button type="button" icon="pi pi-trash" class="p-button-danger" />
                </template>
            </Column>
        </DataTable>    
        </div>
    </div>
    <Dialog header="&nbsp" v-model:visible="displayMaximizable" :style="{width: '50vw'}" :maximizable="true" :modal="true">
            <h5 class="mb-1">Title</h5>
            <InputText type="text" v-model="row.title" />
            <h5 class="mb-1">Text</h5>
            <Textarea v-model="row.textBlog" :autoResize="true" rows="10" cols="50" />
            <h5 class="mb-1">Image</h5>
            <InputText type="text" v-model="row.url" />
            <template #footer>
                <Button label="Cancel" icon="pi pi-times" @click="displayMaximizable=false " class="p-button-text"/>
                <Button label="Submit" icon="pi pi-check" @click="onEdit(); displayMaximizable=false" autofocus />
            </template>
        </Dialog>
        <Toast />
</template>

<style scoped>

</style>

<script>
import ActivityService from '@/services/ActivityService';
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
            newAct: {
                title: '',
                textActivity: '',
                url: '',
            },
            blogWrap: [{}],
            loading: [false, false, false],
            displayMaximizable: false,
            row: {},
            actWrap: [{}]
        }
    },
    methods: {
        onUpload() {
            this.$toast.add({severity: 'info', summary: 'Success', detail: 'File Uploaded', life: 3000});
            console.log('ini data yg diinput: ' ,this.newPost)
            BlogService.postBlog(this.newPost).then((res) => {
                console.log(res);
            }).catch((error) => {
                console.log(error.response.data)
            })
        },
        onUploadAct(){
            this.$toast.add({severity: 'info', summary: 'Success', detail: 'File Uploaded', life: 3000});
            ActivityService.postActivity(this.newAct);
        },
        load(index) {
            this.loading[index] = true;
            setTimeout(() => this.loading[index] = false, 1000);
        },
        onUploadImage(file){
            BlogService.postImage(file).then((res) => {
                console.log(res)
            })
        },

        openMaximizable(row) {
            this.row = {...row}
            this.displayMaximizable = true;
        },

        onChange(element) {
            // var file = element.target.files[0];
            var path = document.getElementById('image').value
            console.log(path, ' ini path')
            // var reader = new FileReader();
            // reader.onloadend = function() {
            //     console.log('RESULT', reader.result)
            //     this.image = reader.result
            // }
            // reader.readAsDataURL(file);
        },

        onEdit() {
            
            BlogService.putBlog(this.row).then((res) => {
                this.$toast.add({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
                window.location.reload();
            })
        }
    },
    mounted() {
        BlogService.getBlog().then((res) => {
            this.blogWrap = res.data.data;
        }),
        ActivityService.getActivity().then((res) => {
            this.actWrap = res.data.data
        })
    }
}
</script>