import React, { useState } from 'react'

const Header = () => {
    const [isOpen, setIsOpen] = useState(false)
    const navbar = {
        open: () => {
            clipPath: 'polygon(0 100%,100% 100%,100% 0,0 0)'
        }
    }
    return (
        <div>Header</div>
    )
}

export default Header