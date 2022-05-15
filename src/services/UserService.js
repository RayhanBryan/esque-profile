import axios from 'axios';

const BASE_URL = 'https://esque-service.herokuapp.com:443/user/';

class UserService {
    getUserByUsername(username) {
        return axios.get(BASE_URL + `findByUserName?username=${username}`)
    }
}

export default new UserService()