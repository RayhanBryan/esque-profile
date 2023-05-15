const router = require('express').Router();
const { activity } = require('../controllers');

// GET localhost:8080/activity => Ambil data semua activity
router.get('/findAllOrderBy', activity.getDataActivity);

// POST localhost:8080/activity/add => Tambah data activity ke database
router.post('/post', activity.addDataActivity);

// POST localhost:8080/activity/2 => Edit data activity
router.put('/update', activity.editDataActivity);

// POST localhost:8080/activity/delete => Delete data activity
router.delete('/delete', activity.deleteDataActivity);

module.exports = router;