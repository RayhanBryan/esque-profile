import axios from 'axios';

const BASE_URL = 'https://api-esque.vercel.app/team/';

class TeamService{
    get(){
        return axios.get(BASE_URL + 'findAllOrderBy')
    }

    post(data){
        return axios.post(BASE_URL + 'post', data)
    }

    put(data){
        return axios.put(BASE_URL + 'update', data)
    }

    delete(id){
        return axios.delete(BASE_URL + `delete?id=${id}`)
    }
}

export default new TeamService()
