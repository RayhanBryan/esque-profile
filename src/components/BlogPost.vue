<template>
    <form enctype="multipart/form-data">
        <div class="grid">
            <div class="col-12">
                <Button label="Logout" style="background-color: #FFC800; float: right;" @click="logout"/>
            </div>
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
            
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeBlog" /></td>
        </tr>
    </table>

        </div>
        <!-- <div class="col-12">
            <h2>Image</h2>
            <InputText type="text" v-model="newPost.url" />
        </div> -->

        <div class="col-12">
            <Button label="Post now" style="background-color: #FFC800" @click="onUploadBlog"/>
        </div>
    </div>
</form>
<!--
        <FileUpload name="demo[]" url="http://localhost:9090/blog/file" @upload="onUploadImage" :multiple="true" accept="image/*" :maxFileSize="1000000">
            <template #empty>
                <p>Drag and drop files to here to upload.</p>
            </template>
        </FileUpload> -->
    <!-- </div> -->

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
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeAct" /></td>
        </tr>
    </table>
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
                    <Button type="button" icon="pi pi-pencil" @click="openMaximizableAct(slotProps.data)" />
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
            <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeBlog" /></td>
        </tr>
    </table>
            <template #footer>
                <Button label="Cancel" icon="pi pi-times" @click="displayMaximizable=false " class="p-button-text"/>
                <Button label="Submit" icon="pi pi-check" @click="onEditBlog(); displayMaximizable=false" autofocus />
            </template>
        </Dialog>
        <Dialog header="&nbsp" v-model:visible="displayMaximizableAct" :style="{width: '50vw'}" :maximizable="true" :modal="true">
            <h5 class="mb-1">Title</h5>
            <InputText type="text" v-model="row.title" />
            <h5 class="mb-1">Text</h5>
            <Textarea v-model="row.textActivity" :autoResize="true" rows="10" cols="50" />
            <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeAct" /></td>
        </tr>
    </table>
            <template #footer>
                <Button label="Cancel" icon="pi pi-times" @click="displayMaximizableAct=false " class="p-button-text"/>
                <Button label="Submit" icon="pi pi-check" @click="onEditAct(); displayMaximizableAct=false" autofocus />
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
            imageBlog: '',
            imageAct: '',
            newPost: {
                
            },
            newAct: {
                
            },
            newImage: {
                
            },
            multipartFile: {
                image: '',
            },
            multipartFileAct: {
                image: '',
            },
            blogWrap: [{}],
            loading: [false, false, false],
            displayMaximizable: false,
            displayMaximizableAct: false,
            row: {},
            actWrap: [{}],
        }
    },
    methods: {
        onUpload() {
            this.$toast.add({severity: 'info', summary: 'Success', detail: 'File Uploaded', life: 3000});
            console.log('ini data yg diinput: ' ,this.newPost)
            BlogService.postBlog(this.newPost).then((res) => {
                console.log(res.data.data.blogId, 'ini id blog');
                this.newImage.file = this.multipartFile;
                this.newImage.id = res.data.data.blogId;
                BlogService.postImage(this.newImage)
            }).catch((error) => {
                console.log(error.response.data)
            })
        },
        onUploadAct(){
            this.multipartFileAct.image = this.imageAct;
            BlogService.uploadImage(this.multipartFileAct).then((res) => {
                this.newAct.url = res.data.data.display_url;
                ActivityService.postActivity(this.newAct);
                this.$toast.add({severity: 'success', summary: 'Success', detail: 'Activity Added', life: 3000});
                window.location.reload()
            })
            
        },
        load(index) {
            this.loading[index] = true;
            setTimeout(() => this.loading[index] = false, 1000);
        },
        onUploadBlog(){
            this.multipartFile.image = this.imageBlog;
            BlogService.uploadImage(this.multipartFile).then((res) => {
                this.newPost.url = res.data.data.display_url;
                console.log(this.newPost)
                BlogService.postBlog(this.newPost);
                this.$toast.add({severity: 'success', summary: 'Success', detail: 'Blog Added', life: 3000});
                window.location.reload()
            })
        },

        openMaximizable(row) {
            this.row = {...row}
            this.displayMaximizable = true;
        },

        openMaximizableAct(row) {
            this.row = {...row}
            this.displayMaximizableAct = true;
        },

        onChangeBlog(element) {
            var file = element.target.files[0];
            this.imageBlog = file;
        },

        onChangeAct(element) {
            var file = element.target.files[0];
            this.imageAct = file;
        },

        onEditBlog() {
            if (this.imageBlog == ''){
                BlogService.putBlog(this.row).then((res) => {
                    this.$toast.add({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
                    window.location.reload();
                })
            }
            else {
                this.multipartFile.image = this.imageBlog;
                BlogService.uploadImage(this.multipartFile).then((res) => {
                    this.row.url = res.data.data.display_url;
                    BlogService.putBlog(this.row).then((res) => {
                    this.$toast.add({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
                    window.location.reload();
                })
                })
            }
        },

        onEditAct() {
            if (this.imageAct == ''){
                ActivityService.putActivity(this.row).then((res) => {
                    this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                    window.location.reload();
                })
            }
            else {
                this.multipartFile.image = this.imageAct;
                BlogService.uploadImage(this.multipartFile).then((res) => {
                    this.row.url = res.data.data.display_url;
                    ActivityService.putActivity(this.row).then((res) => {
                    this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                    window.location.reload();
                })
                })
            }
        },
        logout(){
            localStorage.removeItem("LoggedUser");
            this.$router.push('login')
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