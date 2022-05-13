import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import PrimeVue from 'primevue/config';
import Button from 'primevue/button';
import Menubar from 'primevue/menubar';
import Image from 'primevue/image';
import AOS from 'aos'
import Timeline from 'primevue/timeline';
import Card from 'primevue/card';
import InputText from 'primevue/inputtext';
import Textarea from 'primevue/textarea';
import FileUpload from 'primevue/fileupload';
import ToastService from 'primevue/toastservice';
import Toast from 'primevue/toast';
import Dialog from 'primevue/dialog';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import ColumnGroup from 'primevue/columngroup';     //optional for column grouping
import Row from 'primevue/row';         
import Password from 'primevue/password';

import 'aos/dist/aos.css'
import 'primevue/resources/themes/saga-blue/theme.css'       //theme
import 'primevue/resources/primevue.min.css'                 //core css
import 'primeicons/primeicons.css'                           //icons

const firebaseConfig = {
    apiKey: "AIzaSyDqfIHGbW4lgtLi-Lqu-06ugP2kyJX9utY",
    authDomain: "esque-profile.firebaseapp.com",
    projectId: "esque-profile",
    storageBucket: "esque-profile.appspot.com",
    messagingSenderId: "982330324853",
    appId: "1:982330324853:web:0dd3a2d674396cc503853c",
    measurementId: "G-09C9QRLY3Q"
  };

const app = createApp(App);
app.component('Button', Button);
app.component('Menubar', Menubar);
app.component('Image', Image);
app.component('Timeline', Timeline);
app.component('Card', Card);
app.component('InputText', InputText);
app.component('Textarea', Textarea);
app.component('FileUpload', FileUpload);
app.component('Toast', Toast);
app.component('Dialog', Dialog);
app.component('DataTable', DataTable);
app.component('Column', Column);
app.component('Password', Password)
app.use(PrimeVue);
app.use(router);
app.use(ToastService);
app.mount('#app')

