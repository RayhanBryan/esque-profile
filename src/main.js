import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import PrimeVue from 'primevue/config';
import Button from 'primevue/button';
import Menubar from 'primevue/menubar';
import Image from 'primevue/image';

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
app.use(PrimeVue);
app.use(router).mount('#app')

