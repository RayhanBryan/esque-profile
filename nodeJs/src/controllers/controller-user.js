const config = require('../config/database');
const mysql = require('mysql');
const pool = mysql.createPool(config);

pool.on('error', (err) => {
    console.log(err);
})

module.exports ={
    // Ambil data User berdasarkan ID
    getDataUserByUsername(req,res){
        let username = req.query.username;
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                SELECT * FROM users WHERE LOWER(username) = LOWER(?);
                `
            , [username],
            function (error, results) {
                if(error) throw error;  
                res.send({ 
                    success: true, 
                    message: 'Berhasil ambil data!',
                    data: results
                });
            });
            connection.release();
        })
    }
}