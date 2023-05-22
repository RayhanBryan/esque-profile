const config = require('../config/database');
const mysql = require('mysql');
const pool = mysql.createPool(config);

pool.on('error',(err)=> {
    console.error(err);
});

module.exports ={
    // Ambil data semua Blog
    getDataBlog(req,res){
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                SELECT * FROM blogs ORDER BY blog_id DESC;
                `
            , function (error, results) {
                if(error) throw error;  
                const mappedResults = results.map(result => {
                    return {
                        blogId: result.BLOG_ID,
                        url: result.URL,
                        title: result.TITLE,
                        textBlog: result.TEXT_BLOG
                    }
                })
                res.send({ 
                    success: true, 
                    message: 'Berhasil ambil data!',
                    data: mappedResults 
                });
            });
            connection.release();
        })
    },
    // Simpan data Blog
    addDataBlog(req,res){
        let data = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_BLOG : req.body.textBlog
        }
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                INSERT INTO blogs SET ?;
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
    // Update data Blog
    editDataBlog(req,res){
        let dataEdit = {
            URL : req.body.url,
            TITLE : req.body.title,
            TEXT_BLOG : req.body.textBlog
        }
        let blogId = req.body.blogId
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                UPDATE blogs SET ? WHERE blog_id = ?;
                `
            , [dataEdit, blogId],
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
    // Delete data Blog
    deleteDataBlog(req,res){
        let id = req.query.id
        pool.getConnection(function(err, connection) {
            if (err) throw err;
            connection.query(
                `
                DELETE FROM blogs WHERE blog_id = ?;
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