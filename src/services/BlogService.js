import axios from 'axios';

const BASE_URL = 'http://localhost:9090/blog/';

class BlogService{
    getBlog(){
        return axios.get(BASE_URL + 'findAll')
    }

    postBlog(data){
        return axios.post(BASE_URL + 'post', data)
    }

    upload(formData) {
        return axios.post('https://api.imgbb.com/1/upload', data)
    }

    putBlog(data){
        return axios.put(BASE_URL + 'update', data)
    }

    postImage(data){
        return axios.post(BASE_URL + 'uploadFile', data)
    }
}

export default new BlogService()