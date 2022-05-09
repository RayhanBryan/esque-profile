import axios from 'axios';

const BASE_URL = 'http://localhost:9090/activity/';

class BlogService{
    getActivity(){
        return axios.get(BASE_URL + 'findAll')
    }

    postActivity(data){
        return axios.post(BASE_URL + 'post', data)
    }
}

export default new BlogService()