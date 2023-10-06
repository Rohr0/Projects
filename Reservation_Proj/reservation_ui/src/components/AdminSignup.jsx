import React, { useState } from 'react'
import "../styles/signup.css"
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const AdminSignup = () => {
    let [name, setName] = useState('')
    let [email, setEmail] = useState('')
    let [phone, setPhone] = useState('')
    let [password, setPassword] = useState('')
    let [gst, setGst] = useState('')
    let data = { name, email, phone, gst, password }
    let nav = useNavigate()
    let handleSubmit = () => {
        axios.post('http://localhost:8080/admins', data)
            .then((resp) => {
                alert("Admin Added :)")
                nav('/adminhomepage')
            })
            .catch((err) => {
                alert("Not Added!")
            })
    }
    return (
        <div className='signup'>
            <form action="">
                <h1>Admin Register</h1>
                <input type="text" placeholder='Name' value={name} onChange={(e) => { setName(e.target.value) }} required /> <br /><br />
                <input type="text" placeholder='Email' value={email} onChange={(e) => { setEmail(e.target.value) }} required /> <br /><br />
                <input type="tel" pattern='[0-9]{10}' placeholder='Phone Number' value={phone} onChange={(e) => { setPhone(e.target.value) }} required /> <br /><br />
                <input type="text" placeholder='GST Number' value={gst} onChange={(e) => { setGst(e.target.value) }} required /> <br /><br />
                <input type="password" placeholder='Password' value={password} onChange={(e) => { setPassword(e.target.value) }} required /> <br /><br />
                <button onSubmit={handleSubmit}>Register</button>

            </form>
        </div>
    )
}

export default AdminSignup