import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import "../styles/login.css"
import { useState } from 'react'
import axios from 'axios'

const AdminLogin = () => {
    let [email, setEmail] = useState('')
    let [password, setPassword] = useState('')
    let navigate = useNavigate()
    let handleSubmit = (e) => {
        e.preventDefault()
        axios.post(`http://localhost:8080/admins/verifyByEmail?email=${email}&password=${password}`)
            .then((resp) => {
                localStorage.setItem("admin", JSON.stringify(resp.data.data))
                alert("Login Successful")
                navigate('/adminhomepage')
            }).catch((err) => {
                alert("Invalid Credentials")
            })
    }
    return (
        <div className='login'>
            <form action="">
                <h1>Admin Login</h1>
                <input type="email" placeholder='Email' value={email} onChange={(e) => { setEmail(e.target.value) }} />
                <br />
                <br />
                <input type="password" placeholder='Password' value={password} onChange={(e) => { setPassword(e.target.value) }} />
                <br /><br />
                <button onClick={handleSubmit}>Sign In</button>
                <br />
                <h3>New Admin?<Link to="/adminsignup">Register</Link></h3>
            </form>
        </div>
    )
}

export default AdminLogin