const config = require('../config/database');
const mysql = require('mysql');
const pool = mysql.createPool(config);

pool.on('error',(err)=> {
    console.error(err);
});

module.exports ={
    // Ambil data semua Activity
    getDataActivity(req,res){
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                SELECT * FROM activitys ORDER BY activity_id DESC;
                `
            , function (error, results) {
                const mappedResults = results.map(result => {
                    return {
                        activityId: result.ACTIVITY_ID,
                        url: result.URL,
                        title: result.TITLE,
                        textActivity: result.TEXT_ACTIVITY
                    }
                })
                if(error) throw error;  
                res.send({ 
                    success: true, 
                    message: 'Berhasil ambil data!',
                    data: mappedResults 
                });
            });
            connection.release();
        })
    },
    // Simpan data Activity
    addDataActivity(req,res){
        let data = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_ACTIVITY : req.body.textActivity
        }
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                INSERT INTO activitys SET ?;
                `
            , [data],
            function (error, results) {
                if(error) throw error;  
                res.send({ 
                    success: true, 
                    message: 'Berhasil tambah data!',
                });
            });
            connection.release();
        })
    },
    // Update data karyawan
    editDataActivity(req,res){
        let dataEdit = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_ACTIVITY : req.body.textActivity
        }
        let activityId = req.body.activityId
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                UPDATE activitys SET ? WHERE activity_id = ?;
                `
            , [dataEdit, activityId],
            function (error, results) {
                if(error) throw error;  
                res.send({ 
                    success: true, 
                    message: 'Berhasil edit data!',
                });
            });
            connection.release();
        })
    },
    // Delete data karyawan
    deleteDataActivity(req,res){
        let id = req.query.id
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                DELETE FROM activitys WHERE activity_id = ?;
                `
            , [id],
            function (error, results) {
                if(error) throw error;  
                res.send({ 
                    success: true, 
                    message: 'Berhasil hapus data!'
                });
            });
            connection.release();
        })
    }
}