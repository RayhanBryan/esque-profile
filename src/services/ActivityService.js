import axios from 'axios';

const BASE_URL = 'https://api-esque.vercel.app/activity/';

class ActivityService{
    getActivity(){
        return axios.get(BASE_URL + 'findAllOrderBy')
    }

    postActivity(data){
        return axios.post(BASE_URL + 'post', data)
    }

    putActivity(data){
        return axios.put(BASE_URL + 'update', data)
    }

    deleteActivity(id){
        return axios.delete(BASE_URL + `delete?id=${id}`)
    }
}

export default new ActivityService()
