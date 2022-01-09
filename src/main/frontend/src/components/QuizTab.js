import React, {useState, useEffect} from 'react'
import AccountService from '../services/AccountService';

function QuizTab() {

    const QuizSelection = {
        background: 'blue',
        float: 'left',
        height: "auto",
        width: "10%"
      };

    const playQuiz = {
        background: 'blue',
        width: "80%",
        height: "100%",
        float: 'right'
      };

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
        <div className="container">
            <div style={QuizSelection}>
            <table>
            <h1>Faction Quizzes</h1>
                <thead>
                    <tr>
                        <th></th>
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
            <div style={playQuiz}>
            <table>
            <h1 className = "text-center">Faction Quizzes</h1>
                <thead>
                    <tr>
                        <th></th>
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
        </div>
    )
}

export default QuizTab;