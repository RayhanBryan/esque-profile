import axios from 'axios';

const BASE_URL = 'https://api-esque.vercel.app/user/';

class UserService {
    getUserByUsername(username) {
        return axios.get(BASE_URL + `findByUserName?username=${username}`)
    }
}

export default new UserService()
