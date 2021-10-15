import axios from 'axios';

const EMPLOYEE_API_BASE_URL = 'http://localhost:7070/list';

class AccountService{

    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
}

export default new AccountService();