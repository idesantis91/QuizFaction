import axios from 'axios';

const ACCOUNT_API_BASE_URL = 'http://localhost:7070/create';

class CreateService{

    createAccount(){
        return axios.post(ACCOUNT_API_BASE_URL);
    }
}

export default new CreateService();