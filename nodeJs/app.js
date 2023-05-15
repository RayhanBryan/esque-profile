const express = require('express');
const bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

const appRouteKaryawan = require('./src/routes/route-karyawan');
app.use('/karyawan', appRouteKaryawan);

const appRouteAchievement = require('./src/routes/route-achievement');
app.use('/achievement', appRouteAchievement);

const appRouteActivity = require('./src/routes/route-activity');
app.use('/activity', appRouteActivity);

const appRouteUser = require('./src/routes/route-user');
app.use('/user', appRouteUser);

const appRouteBlog = require('./src/routes/route-blog');
app.use('/blog', appRouteBlog);

const appRouteTeam = require('./src/routes/route-team');
app.use('/team', appRouteTeam);

const appRouteUpload = require('./src/routes/route-upload');
app.use('/blog', appRouteUpload);

app.listen(8080, ()=>{
    console.log('Server Berjalan di Port : 8080');
});