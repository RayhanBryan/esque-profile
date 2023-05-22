const fs = require('fs');
const path = require('path');
const express = require('express');
const multer = require('multer');

const app = express();
const upload = multer();

app.post('/uploadFile', upload.single('file'), (req, res) => {
    const { blogId } = req.body;
    const file = req.file;

    if(!file) {
        return res.status(400).send('No file uploaded');
    }

    try {
        uploadFile(file, blogId);
        res.sendStatus(200);
    } catch (err) {
        console.error(err);
        res.sendStatus(500);
    }
});

function uploadFile(file, blogId) {
    const filePath = path.join(__dirname, 'src', 'assets', 'blog', `${blogId}.jpg`);
  
    fs.writeFile(filePath, file.buffer, (err) => {
      if (err) {
        throw err;
      }
  
      console.log(filePath);
      console.log(path.resolve(filePath));
    });
  }
  
  app.listen(3000, () => {
    console.log('Server listening on port 8080');
  });