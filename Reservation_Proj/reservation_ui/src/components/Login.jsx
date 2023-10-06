import React, { useState } from 'react'
import "../styles/login.css"
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'

const Login = () => {
    let [email, setEmail] = useState('')
    let [password, setPassword] = useState('')
    let navigate = useNavigate()
    let handleSubmit = (e) => {
        e.preventDefault()
        axios.post(`http://localhost:8080/users/verifyByEmail?email=${email}&password=${password}`)
            .then((resp) => {

                alert("Login Successful")
                navigate('/')
            }).catch((err) => {
                alert("Invalid Credentials")
            })
    }
    return (
        <div className="loginbg">
            <div className='login'>
                <form action="" className='loginform'>
                    <h1>User Login</h1>
                    <input type="email" placeholder='Email' value={email} onChange={(e) => { setEmail(e.target.value) }} />
                    <br />
                    <br />
                    <input type="password" placeholder='Password' valu={password} onChange={(e) => { setPassword(e.target.value) }} />
                    <br /><br />
                    <button onClick={handleSubmit}>Sign In</button>
                    <br />
                    <h3>New User?<Link to="/signup">Register</Link></h3>
                    <h3>Are you an Admin?<Link to="/adminlogin">Admin Login</Link></h3>
                </form>
            </div>
        </div>
    )
}

export default Login