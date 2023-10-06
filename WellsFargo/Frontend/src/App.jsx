// import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Homepage from './components/homepage'
import NavBar from './components/NavBar'
import About from './components/About'
import Contact from './components/Contact'
import Login from './components/Login'
import Search2 from './components/Search2'

function App() {

  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Search2 />} />
          <Route path="/search" element={<Homepage />} />

        </Routes>
      </BrowserRouter>

    </>
  )
}

export default App