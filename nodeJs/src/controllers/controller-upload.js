const fs = require('fs');
const path = require('path');

function uploadFile(file, blogId) {
  const filePath = path.join(__dirname, '..','src' , 'assets', 'blog', `${blogId}.jpg`);

  fs.writeFile(filePath, file.buffer, (err) => {
    if (err) {
      throw err;
    }

    console.log(filePath);
    console.log(path.resolve(filePath));
  });
}

module.exports = {
  uploadFile
};
