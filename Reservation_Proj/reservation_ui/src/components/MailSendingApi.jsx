import axios from 'axios'
import React, { useState } from 'react'

const MailSendingApi = () => {
    let [mail, setMail] = useState("")
    let handleSubmit = (e) => {
        e.preventDefault()
        axios.post(`http://localhost:8080/send?email=${mail}`)
            .then((resp) => {
                alert("Mail Sent")
            }).catch((err) => { alert("Mail Not Sent") })
    }

    return (
        <div>
            <form action="">
                <fieldset>
                    <legend>Enter Email</legend>
                    <input type="email" value={mail} onChange={(e) => { setMail(e.target.value) }} /> <br /><br />
                    <button onClick={handleSubmit}>Submit</button>
                </fieldset>
            </form>

        </div>
    )
}

export default MailSendingApi