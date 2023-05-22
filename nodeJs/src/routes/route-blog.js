const router = require('express').Router();
const { blog } = require('../controllers');

router.get('/findAllOrderBy', blog.getDataBlog);

router.post('/post', blog.addDataBlog);

// POST localhost:8080/activity/2 => Edit data Blog
router.put('/update', blog.editDataBlog);

// POST localhost:8080/activity/delete => Delete data Blog
router.delete('/delete', blog.deleteDataBlog);

module.exports = router;