<template>
    <form enctype="multipart/form-data">
        <div class="grid">
            <div class="col-12">
                <Button label="Logout" style="background-color: #FFC800; float: right;" @click="logout" />
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
                    <Button type="button" icon="pi pi-trash" @click="deleteBlog(slotProps.data.blogId)" class="p-button-danger" />
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
                    <Button type="button" icon="pi pi-trash" @click="deleteAct(slotProps.data.activityId)" class="p-button-danger" />
                </template>
            </Column>
        </DataTable>    
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <h1 class="text-center">ACHIEVEMENT CONTROLLER</h1>
        </div>
        <div class="col-12">
            <h2>Title</h2>
            <InputText type="text" v-model="newAch.title" />
        </div>
        <div class="col-12">  
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeAch" /></td>
        </tr>
    </table>
        </div>
        <div class="col-12">
            <Button label="Post now" style="background-color: #FFC800" @click="onUploadAch"/>
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <DataTable :value="achWrap" :paginator="true" :rows="4"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[4,10,20]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="title" header="Title"></Column>
            <Column header="Image">
                <template #body="slotProps">
                    <img :src="slotProps.data.url" :alt="slotProps.data.image" class="product-image" />
                </template>
            </Column>
            <Column header="Action">
                <template #body="slotProps">
                    <Button type="button" icon="pi pi-pencil" @click="openMaximizableAch(slotProps.data)" />
                    <Button type="button" icon="pi pi-trash" @click="deleteAch(slotProps.data.achievementId)" class="p-button-danger" />
                </template>
            </Column>
        </DataTable>    
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <h1 class="text-center">TEAM CONTROLLER</h1>
        </div>
        <div class="col-12">
            <h2>Name</h2>
            <InputText type="text" v-model="newTeam.title" />
        </div>
        <div class="col-12">
            <h2>Position</h2>
            <InputText type="text" v-model="newTeam.positions" />
        </div>
        <div class="col-12">
            <h2>Testimoni</h2>
            <Textarea v-model="newTeam.textAchievement" :autoResize="true" rows="5" cols="30" />
        </div>
        <div class="col-12">  
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeTeam" /></td>
        </tr>
    </table>
        </div>
        <div class="col-12">
            <Button label="Post now" style="background-color: #FFC800" @click="onUploadTeam"/>
        </div>
    </div>
    <div class="grid">
        <div class="col-12">
            <DataTable :value="teamWrap" :paginator="true" :rows="4"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[4,10,20]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="title" header="Title"></Column>
            <Column field="positions" header="Position"></Column>
            <Column field="textAchievement" header="Testimoni"></Column>
            <Column header="Image">
                <template #body="slotProps">
                    <img :src="slotProps.data.url" :alt="slotProps.data.image" class="product-image" />
                </template>
            </Column>
            <Column header="Action">
                <template #body="slotProps">
                    <Button type="button" icon="pi pi-pencil" @click="openMaximizableTeam(slotProps.data)" />
                    <Button type="button" icon="pi pi-trash" @click="deleteTeam(slotProps.data.teamId)" class="p-button-danger" />
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
        <Dialog header="&nbsp" v-model:visible="displayMaximizableAch" :style="{width: '50vw'}" :maximizable="true" :modal="true">
            <h5 class="mb-1">Title</h5>
            <InputText type="text" v-model="row.title" />
            <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeAct" /></td>
        </tr>
    </table>
            <template #footer>
                <Button label="Cancel" icon="pi pi-times" @click="displayMaximizableAct=false " class="p-button-text"/>
                <Button label="Submit" icon="pi pi-check" @click="onEditAch(); displayMaximizableAct=false" autofocus />
            </template>
        </Dialog>
        <Dialog header="&nbsp" v-model:visible="displayMaximizableTeam" :style="{width: '50vw'}" :maximizable="true" :modal="true">
            <h5 class="mb-1">Title</h5>
            <InputText type="text" v-model="row.title" />
            <h5 class="mb-1">Position</h5>
            <InputText type="text" v-model="row.positions" />
            <h5 class="mb-1">Testimoni</h5>
            <Textarea v-model="row.textAchievement" :autoResize="true" rows="10" cols="50" />
            <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" @change="onChangeTeam" /></td>
        </tr>
    </table>
            <template #footer>
                <Button label="Cancel" icon="pi pi-times" @click="displayMaximizableTeam=false " class="p-button-text"/>
                <Button label="Submit" icon="pi pi-check" @click="onEditTeam(); displayMaximizableTeam=false" autofocus />
            </template>
        </Dialog>
        <Toast />
        <ConfirmDialog></ConfirmDialog>
</template>

<style scoped>

</style>

<script>
import ActivityService from '@/services/ActivityService';
import BlogService from '../services/BlogService';
import AchievementService from '../services/AchievementService';
import TeamService from '../services/TeamService';
import ConfirmDialog from 'primevue/confirmdialog';

export default {
    data() {
        return {
            messages: [],
            title: '',
            text: '',
            imageBlog: '',
            imageAct: '',
            imageAch: '',
            imageTeam: '',
            newPost: {
                
            },
            newAct: {
                
            },
            newAch: {

            },
            newTeam: {

            },
            newImage: {
                
            },
            multipartFile: {
                image: '',
            },
            multipartFileAct: {
                image: '',
            },
            multipartFileAch: {
                image: '',
            },
            multipartFileTeam: {
                image: '',
            },
            blogWrap: [{}],
            loading: [false, false, false],
            displayMaximizable: false,
            displayMaximizableAct: false,
            displayMaximizableAch: false,
            displayMaximizableTeam: false,
            row: {},
            actWrap: [{}],
            achWrap: [{}],
            teamWrap: [{}],
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
                ActivityService.postActivity(this.newAct).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity: 'success', summary: 'Success', detail: 'Activity Added', life: 3000});
                        window.location.reload()
                    }
                })  
            })
            
        },
        onUploadAch(){
            this.multipartFileAch.image = this.imageAch;
            BlogService.uploadImage(this.multipartFileAch).then((res) => {
                this.newAch.url = res.data.data.display_url;
                AchievementService.post(this.newAch).then((res) => {
                    console.log(res);
                    if (res.status == 200){
                        this.$toast.add({severity: 'success', summary: 'Success', detail: 'Activity Added', life: 3000});
                        window.location.reload()
                    }
                })
                
            })
            
        },
        onUploadTeam(){
            this.multipartFileTeam.image = this.imageTeam;
            BlogService.uploadImage(this.multipartFileTeam).then((res) => {
                this.newTeam.url = res.data.data.display_url;
                TeamService.post(this.newTeam).then((res) => {
                    console.log(res);
                    if (res.status == 200){
                        this.$toast.add({severity: 'success', summary: 'Success', detail: 'Activity Added', life: 3000});
                        window.location.reload()
                    }
                })
                
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
                BlogService.postBlog(this.newPost).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity: 'success', summary: 'Success', detail: 'Blog Added', life: 3000});
                        window.location.reload()
                    }
                })
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
        openMaximizableAch(row) {
            this.row = {...row}
            this.displayMaximizableAch = true;
        },
        openMaximizableTeam(row) {
            this.row = {...row}
            this.displayMaximizableTeam = true;
        },
        onChangeBlog(element) {
            var file = element.target.files[0];
            this.imageBlog = file;
        },

        onChangeAct(element) {
            var file = element.target.files[0];
            this.imageAct = file;
        },
        onChangeAch(element) {
            var file = element.target.files[0];
            this.imageAch = file;
        },
        onChangeTeam(element) {
            var file = element.target.files[0];
            this.imageTeam = file;
        },

        onEditBlog() {
            if (this.imageBlog == ''){
                BlogService.putBlog(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
                        window.location.reload();
                    }
                })
            }
            else {
                this.multipartFile.image = this.imageBlog;
                BlogService.uploadImage(this.multipartFile).then((res) => {
                    this.row.url = res.data.data.display_url;
                    BlogService.putBlog(this.row).then((res) => {
                        if (res.status == 200) {
                            this.$toast.add({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
                            window.location.reload();
                        }
                })
                })
            }
        },

        onEditAct() {
            if (this.imageAct == ''){
                ActivityService.putActivity(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
            }
            else {
                this.multipartFileAct.image = this.imageAct;
                BlogService.uploadImage(this.multipartFileAct).then((res) => {
                    this.row.url = res.data.data.display_url;
                    ActivityService.putActivity(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
                })
            }
        },
        onEditTeam() {
            if (this.imageTeam == ''){
                TeamService.put(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
            }
            else {
                this.multipartFileTeam.image = this.imageTeam;
                BlogService.uploadImage(this.multipartFileTeam).then((res) => {
                    this.row.url = res.data.data.display_url;
                    TeamService.put(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
                })
            }
        },
        onEditAch() {
            if (this.imageAch == ''){
                AchievementService.put(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
            }
            else {
                this.multipartFileAch.image = this.imageAch;
                BlogService.uploadImage(this.multipartFileAch).then((res) => {
                    this.row.url = res.data.data.display_url;
                    AchievementService.put(this.row).then((res) => {
                    if (res.status == 200) {
                        this.$toast.add({severity:'success', summary: 'Success', detail:'Activity Edited', life: 3000});
                        window.location.reload();
                    }
                })
                })
            }
        },
        logout(){
            localStorage.removeItem("LoggedUser");
            this.$router.push('loginesqueadmin2023')
        },
        deleteBlog(id) {
            this.$confirm.require({
                message: 'Do you want to delete this record?',
                header: 'Delete Confirmation',
                icon: 'pi pi-info-circle',
                acceptClass: 'p-button-danger',
                accept: () => {
                    BlogService.deleteBlog(id).then((res) => {
                        if (res.status == 200) {
                            this.$toast.add({severity:'info', summary:'Confirmed', detail:'Record deleted', life: 3000});
                            window.location.reload();
                        }
                    })
                },
                reject: () => {
                    this.$toast.add({severity:'error', summary:'Rejected', detail:'You have rejected', life: 3000});
                }
            });
        },
        deleteAct(id) {
            this.$confirm.require({
                message: 'Do you want to delete this record?',
                header: 'Delete Confirmation',
                icon: 'pi pi-info-circle',
                acceptClass: 'p-button-danger',
                accept: () => {
                    ActivityService.deleteActivity(id).then((res) => {
                        if (res.status == 200) {
                            this.$toast.add({severity:'info', summary:'Confirmed', detail:'Record deleted', life: 3000});
                            window.location.reload();
                        }
                    })
                },
                reject: () => {
                    this.$toast.add({severity:'error', summary:'Rejected', detail:'You have rejected', life: 3000});
                }
            });
        },
        deleteAch(id) {
            this.$confirm.require({
                message: 'Do you want to delete this record?',
                header: 'Delete Confirmation',
                icon: 'pi pi-info-circle',
                acceptClass: 'p-button-danger',
                accept: () => {
                    AchievementService.delete(id).then((res) => {
                        if (res.status == 200) {
                            this.$toast.add({severity:'info', summary:'Confirmed', detail:'Record deleted', life: 3000});
                            window.location.reload();
                        }
                    });
                },
                reject: () => {
                    this.$toast.add({severity:'error', summary:'Rejected', detail:'You have rejected', life: 3000});
                }
            });
        },
        deleteTeam(id) {
            this.$confirm.require({
                message: 'Do you want to delete this record?',
                header: 'Delete Confirmation',
                icon: 'pi pi-info-circle',
                acceptClass: 'p-button-danger',
                accept: () => {
                    TeamService.delete(id).then((res) => {
                        if (res.status == 200) {
                            this.$toast.add({severity:'info', summary:'Confirmed', detail:'Record deleted', life: 3000});
                            window.location.reload();
                        }
                    });
                },
                reject: () => {
                    this.$toast.add({severity:'error', summary:'Rejected', detail:'You have rejected', life: 3000});
                }
            });
        },
    },
    mounted() {
        BlogService.getBlog().then((res) => {
            this.blogWrap = res.data.data;
        }),
        ActivityService.getActivity().then((res) => {
            this.actWrap = res.data.data
        }),
        AchievementService.get().then((res) => {
            this.achWrap = res.data.data
        }),
        TeamService.get().then((res) => {
            this.teamWrap = res.data.data
        })
    }
}
</script>