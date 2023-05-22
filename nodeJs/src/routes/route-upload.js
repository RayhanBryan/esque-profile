const express = require('express');
const multer = require('multer');
const uploadController = require('../controllers/controller-upload');

const router = express.Router();
const upload = multer();

router.post('/uploadFile', upload.single('file'), (req, res) => {
  const { blogId } = req.body;
  const file = req.file;

  if (!file) {
    return res.status(400).send('No file uploaded');
  }

  try {
    uploadController.uploadFile(file, blogId);
    res.sendStatus(200);
  } catch (err) {
    console.error(err);
    res.sendStatus(500);
  }
});

module.exports = router;
