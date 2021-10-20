import axios from 'axios';

const ACCOUNT_API_BASE_URL = 'http://localhost:7070/list';

class AccountService{

    getEmployees(){
        return axios.get(ACCOUNT_API_BASE_URL + '/' + 'list');
    }

    createAccount(account){
        return axios.post("http://localhost:7070/create", account);
    }
}

export default new AccountService();