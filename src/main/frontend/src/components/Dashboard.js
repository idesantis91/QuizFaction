import React, {useState, useEffect} from 'react'
import AccountService from '../services/AccountService';

function Dashboard() {

    const [employees, setEmployees] = useState([])

    useEffect(() => {
        getEmployees()
    }, [])

    const getEmployees = () => {

        AccountService.getEmployees().then((response) => {
            setEmployees(response.data)
            console.log(response.data);
        });
    };

    return (
        <div className = "container">
            <h1 className = "text-center">Faction Members</h1>
            <table className = "table table-striped">
                <thead>
                    <tr>
                        <th>Member</th>
                    </tr>

                </thead>
                <tbody>
                    {
                        employees.map(
                                employee =>
                                <tr key = {employee.username}>
                                    <td>{employee.username}</td>
                                </tr>
                        )
                    }
                </tbody>


            </table>

        </div>
    )
}

export default Dashboard;