const config = require('../config/database');
const mysql = require('mysql');
const pool = mysql.createPool(config);

pool.on('error', (err) => {
    console.log(err);
})

module.exports ={
    //findAllByOrderByTeamIdDesc
    getDataTeam(req, res){
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                SELECT * FROM Teams ORDER BY Team_id DESC;
                `
                , function (error, results) {
                    if(error) throw error;
                    const mappedResults = results.map(result => {
                        return {
                            teamId: result.TEAM_ID,
                            url: result.URL,
                            title: result.TITLE,
                            textTeam: result.TEXT_TEAM,
                            position: result.POSITIONS
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
    // Simpan data Team
    addDataTeam(req,res){
        let data = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_TEAM : req.body.textTeam,
            POSITIONS : req.body.position
        }
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                INSERT INTO Teams SET ?;
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
    editDataTeam(req,res){
        let dataEdit = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_TEAM : req.body.textTeam,
            POSITIONS : req.body.position
        }
        let teamId = req.body.teamId
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                UPDATE Teams SET ? WHERE team_id = ?;
                `
            , [dataEdit, teamId],
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
    deleteDataTeam(req,res){
        let id = req.query.id
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                DELETE FROM Teams WHERE Team_id = ?;
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