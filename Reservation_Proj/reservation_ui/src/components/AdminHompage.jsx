import React from 'react'
import { Link, Routes, Route } from 'react-router-dom'
import "../styles/adminnavbar.css"
import Reservations from './Reservations'
import Users from './Users'
import MyBus from './MyBus'

const AdminHompage = () => {
    return (
        <div className='adminhomepage'>
            <div className="adminnavbar">
                <Link to="/adminhomepage/users">UserList</Link>
                <Link to="/adminhomepage/reservations">Reservations</Link>
                <Link to="/adminhomepage/mybus">My Bus</Link>
            </div>
            <Routes>
                <Route path="/reservations" element={<Reservations />} />
                <Route path="/mybus" element={<MyBus />} />
                <Route path="/users" element={<Users />} />
            </Routes>

            <h1>Hello</h1>

        </div>
    )
}

export default AdminHompage