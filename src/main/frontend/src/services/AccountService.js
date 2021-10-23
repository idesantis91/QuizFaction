import axios from 'axios';

class AccountService{

    getEmployees(){
        return axios.get("http://localhost:7070/list");
    }

    createAccount(account){
        return axios.post("http://localhost:7070/create", account);
    }

    createFaction(faction){
        return axios.post("http://localhost:7070/create" , faction)
    }
}

export default new AccountService();