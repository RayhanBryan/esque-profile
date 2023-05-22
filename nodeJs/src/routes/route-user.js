const router = require('express').Router();
const { user } = require('../controllers');

router.get('/findByUserName', user.getDataUserByUsername);

module.exports = router;