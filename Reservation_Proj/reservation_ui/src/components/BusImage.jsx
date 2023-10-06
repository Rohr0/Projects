import React from 'react'
import "../styles/busimg.css"

const BusImage = () => {
    return (
        <div className='busimg'>
            <h2>Book Bus Tickets</h2>

            <img src="https://static.abhibus.com/web/media/operators/apsrtc.webp" alt="APSRTC" />
            <img src="https://static.abhibus.com/web/media/operators/tsrtc.webp" alt="TSRTC" />
            <img src="https://static.abhibus.com/web/media/operators/hsrtc.webp" alt="HSRTC" />
            <img src="https://static.abhibus.com/web/media/operators/gsrtc.webp" alt="GSRTC" />
            <img src="https://static.abhibus.com/web/media/operators/msrtc.webp" alt="MSRTC" />
            <img src="https://static.abhibus.com/web/media/operators/bsrtc.webp" alt="BSRTC" />
        </div>
    )
}

export default BusImage