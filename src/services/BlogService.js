import axios from 'axios';

const BASE_URL = 'https://esque-service.herokuapp.com:443/blog/';

class BlogService{
    getBlog(){
        return axios.get(BASE_URL + 'findAllOrderBy')
    }

    postBlog(data){
        return axios.post(BASE_URL + 'post', data)
    }

    uploadImage(data) {
        return axios.post('https://api.imgbb.com/1/upload?key=c13a2b0c3b26b09d7f26a0f69a7b5cbb', data, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
    }

    putBlog(data){
        return axios.put(BASE_URL + 'update', data)
    }

    postImage(data){
        return axios.post(BASE_URL + 'uploadFile', data)
    }

    deleteBlog(id) {
        return axios.delete(BASE_URL + `delete?id=${id}`)
    }
}

export default new BlogService()