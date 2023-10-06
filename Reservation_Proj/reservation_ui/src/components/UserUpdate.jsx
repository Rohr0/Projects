import React, { useState } from 'react'

const UserUpdate = () => {
    let [name, setName] = useState('')
    let [email, setEmail] = useState('')
    let [date, setDate] = useState('')
    let [phone, setPhone] = useState('')
    let [aadhar, setAadhar] = useState('')
    let [password, setPassword] = useState('')
    let data = { name, email, date, phone, aadhar, password }
    let nav = useNavigate()
    let handleSubmit = () => {
        axios.post('http://localhost:8080/users', data)
            .then((resp) => {
                alert("User Added :)")
                nav('/login')
            })
            .catch((err) => {
                alert("Not Added!")
                console.log(err)
            })
    }
    return (
        <div className='signup'>
            <form action="">
                <h1>User Register</h1>
                <input type="text" placeholder='Name' value={name} onChange={(e) => { setName(e.target.value) }} required /> <br /><br />
                <input type="text" placeholder='Email' value={email} onChange={(e) => { setEmail(e.target.value) }} required /> <br /><br />
                <input type="date" placeholder='DOB' value={date} onChange={(e) => { setDate(e.target.value) }} required /> <br /><br />
                <input type="tel" pattern='[0-9]{10}' placeholder='Phone Number' value={phone} onChange={(e) => { setPhone(e.target.value) }} required /> <br /><br />
                <input type="tel" pattern='[0-9]{12}' placeholder='Aadhar Number' value={aadhar} onChange={(e) => { setAadhar(e.target.value) }} required /> <br /><br />
                <input type="password" placeholder='Password' value={password} onChange={(e) => { setPassword(e.target.value) }} required /> <br /><br />
                <button onClick={handleSubmit}>Register</button>

            </form>
        </div>
    )
}

export default UserUpdate