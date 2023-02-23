<template>
    <h5>Username</h5>
    <InputText type="text" v-model="username" />
    <h5>Password</h5>
    <Password v-model="password" toggleMask :feedback="false"></Password>
    <br>
    <br>
    <Button label="Login" @click="onLogin" class="mb-6"/>
    <Toast />
</template>

<style scoped>

</style>

<script>
import UserService from '../services/UserService'

export default {
    data() {
        return {
            username : '',
            password : '',
        }
    },
    methods: {
        onLogin(){
            UserService.getUserByUsername(this.username).then((res) => {
                if (this.password == res.data.data[0].password) {
                    localStorage.setItem('LoggedUser', 'x');
                    this.$toast.add({severity: 'success', summary: 'Success', detail: 'Login sukses', life: 3000});
                    this.$router.push('adminesqueadmin2023')
                }
                else {
                    this.$toast.add({severity: 'warning', summary: 'Wrong', detail: 'Password salah', life: 3000});
                }
            })
        }
    }
}
</script>