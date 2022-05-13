import axios from 'axios';

const BASE_URL = 'https://esque-service.herokuapp.com:443/activity/';

class BlogService{
    getActivity(){
        return axios.get(BASE_URL + 'findAllOrderBy')
    }

    postActivity(data){
        return axios.post(BASE_URL + 'post', data)
    }

    putActivity(data){
        return axios.put(BASE_URL + 'update', data)
    }
}

export default new BlogService()