const router = require('express').Router();
const { team } = require('../controllers');

// GET localhost:8080/Team => Ambil data semua Team
router.get('/findAllOrderBy', team.getDataTeam);

// POST localhost:8080/Team/add => Tambah data Team ke database
router.post('/post', team.addDataTeam);

// POST localhost:8080/Team/2 => Edit data Team
router.put('/update', team.editDataTeam);

// POST localhost:8080/Team/delete => Delete data Team
router.delete('/delete', team.deleteDataTeam);

module.exports = router;