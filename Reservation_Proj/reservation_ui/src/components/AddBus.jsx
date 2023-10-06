import axios from 'axios'
import React, { useState } from 'react'

const AddBus = () => {
    let [from, setFrom] = useState('')
    let [to, setTo] = useState('')
    let [dod, setDod] = useState('')
    let [bus_no, setBusno] = useState('')
    let [bus_name, setBusname] = useState('')
    let [nos, setNos] = useState('')
    let data = { from, to, dod, bus_no, bus_name, nos }
    let id = 1
    let handleSubmit = (e) => {
        e.preventDefault()
        axios.post(`http://localhost:8080/bus/${id}`, data)
            .then((resp) => {
                console.log(resp)
                alert("Bus Added")
            })
            .catch((err) => {
                console.log(err)
                alert("Check Details")
            })
    }

    return (
        <div className='addbus'>
            <form className='addbusform'>
                <input type="text" placeholder='From' value={from} onChange={(e) => { setFrom(e.target.value) }} /> <br />
                <input type="text" placeholder='To' value={to} onChange={(e) => { setTo(e.target.value) }} /><br />
                <input type="date" placeholder='Date of Departure' value={dod} onChange={(e) => { setDod(e.target.value) }} /><br />
                <input type="text" placeholder='Bus Number' value={bus_no} onChange={(e) => { setBusno(e.target.value) }} /><br />
                <input type="text" placeholder='Bus Name' value={bus_name} onChange={(e) => { setBusname(e.target.value) }} /><br />
                <input type="number" placeholder='Number of Seats' value={nos} onChange={(e) => { setNos(e.target.value) }} /><br />
                <button onClick={handleSubmit}>Add Bus</button>
            </form>

        </div>
    )
}

export default AddBus