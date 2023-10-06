import "../styles/homepage.css"
import FlightTakeoffIcon from '@mui/icons-material/FlightTakeoff';
import FlightLandIcon from '@mui/icons-material/FlightLand';
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import BusImage from "./BusImage";

const Homepage = () => {
    let [from, setFrom] = useState('')
    let [to, setTo] = useState('')
    let [dod, setDate] = useState('');
    let navigate = useNavigate()
    // useEffect(() => {

    //     fetchdata()
    // }, [])
    let fetchdata = (e) => {
        axios.get(`http://localhost:8080/bus/filter?from=${from}&to=${to}&dod=${dod}`)
            .then((resp) => {
                alert("Found")
                navigate("/result")
                console.log(resp)
            })
            .catch((err) => {
                alert("Not Found")
            })
    }
    return (
        <div className="hp">
            <br /><br />
            <div className="homepage">
                <div className="search" >
                    <form action="" className="sform">
                        <div> <><FlightTakeoffIcon id="i1" /></> <input type="text" placeholder="From" required value={from} onChange={(e) => { setFrom(e.target.value) }} /></div>
                        <div> <><FlightLandIcon id="i2" /></> <input type=" text" placeholder="To" required value={to} onChange={(e) => { setTo(e.target.value) }} /></div>
                        <div><input type="date" id="date" required placeholder="Departure Date" value={dod} onChange={(e) => { setDate(e.target.value) }} /></div>
                        <button onClick={fetchdata}>Search Buses</button>
                    </form >
                </div >
            </div >

            <div className="homepage2">
                <BusImage />
                <div className="so">
                    <h2>Special Offers</h2>
                    <div className="offers">
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Sep2023/14/1694685729-laddu-mob.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Nov2022/30/1669820028-720X360.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Dec2022/30/1672394050-tsrtc-mob-720X360.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Jul2023/19/1689748214-gsrtc720x360.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Mar2023/02/1677706766-get350mob.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/May2023/08/1683553938-MSRTC-SEO-MOB.webp" alt="" />
                        {/* <img src="https://static.abhibus.com/busgallery/offerbanners/May2022/18/1652881323-720-360.webp" alt="" />
                        <img src="https://static.abhibus.com/busgallery/offerbanners/Sep2023/01/1693576182-simplfest-mob.webp" alt="" /> */}
                    </div>
                </div>

            </div>
            <br /><br />

        </div>
    )
}

export default Homepage