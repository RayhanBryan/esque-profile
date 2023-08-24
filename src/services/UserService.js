import axios from "axios";

const BASE_URL = "https://be.esque.co.id/user/";

class UserService {
  getUserByUsername(username) {
    return axios.get(BASE_URL + `findByUserName?username=${username}`);
  }
}

export default new UserService();
