import React from 'react'
import "../styles/login.css"
import { Link } from 'react-router-dom'

const Login = () => {
    return (
        <div className='login'>
            <div class="login-box">
                <h2>Login</h2>
                <form>
                    <div class="user-box">
                        <input type="text" name="" required="" />
                        <label>Username</label>
                    </div>
                    <div class="user-box">
                        <input type="password" name="" required="" />
                        <label>Password</label>
                    </div>
                    <a href="#" id="link1">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        Submit
                    </a>
                    <a href="#" id='link2'>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        SignUp
                    </a>

                </form>
            </div>

        </div>
    )
}

export default Login