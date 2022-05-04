import axios from 'axios';

const url = 'http://localhost:9090/blog/';

class BlogService{
    getBlog(){
        return axios.get(url + 'findAll')
    }

    postImage(data){
        return axios.post(url + 'post', data, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
    }
}

export default new BlogService()