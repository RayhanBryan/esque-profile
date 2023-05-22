const config = require('../config/database');
const mysql = require('mysql');
const pool = mysql.createPool(config);

pool.on('error', (err) => {
    console.log(err);
})

module.exports ={
    //findAllByOrderByAchievementIdDesc
    getDataAchievement(req, res){
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                SELECT * FROM achievement ORDER BY achievement_id DESC;
                `
                , function (error, results) {
                    if(error) throw error;
                    const mappedResults = results.map(result => {
                        return {
                            achievementId: result.ACHIEVEMENT_ID,
                            url: result.URL,
                            title: result.TITLE,
                            textAchievement: result.TEXT_ACHIEVEMENT
                        }
                    })
                    res.send({
                        success: true,
                        message: 'Berhasil ambil data!',
                        data: mappedResults
                    });
                });
                connection.release
        })
    },
    // Simpan data Achievement
    addDataAchievement(req,res){
        let data = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_Achievement : req.body.textAchievement
        }
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                INSERT INTO Achievement SET ?;
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
    editDataAchievement(req,res){
        let dataEdit = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_Achievement : req.body.textAchievement
        }
        let achievementId = req.body.achievementId
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                UPDATE Achievement SET ? WHERE achievement_id = ?;
                `
            , [dataEdit, achievementId],
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
    deleteDataAchievement(req,res){
        let id = req.query.id;
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                DELETE FROM achievement WHERE achievement_id = ?;
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