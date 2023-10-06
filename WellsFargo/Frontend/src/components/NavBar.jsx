import React from 'react'
import { Link } from 'react-router-dom'
import "../styles/navbar.css"

const NavBar = () => {
    return (
        <div>
            <div className="navbar">
                <h2>WellsFargo</h2>
                <div className='navlinks'><Link to="/about">About Us</Link>
                    <Link to="/contact">Contact Us</Link>
                    <Link to="/login">Login</Link></div>

            </div>
        </div>
    )
}

export default NavBar