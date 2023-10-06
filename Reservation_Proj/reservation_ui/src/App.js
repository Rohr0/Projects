// import logo from './logo.svg';
// import './App.css';
import 'react-toastify/dist/ReactToastify.css';
import NavBar from './components/NavBar';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import About from './components/About';
import Contact from './components/Contact';
import Login from './components/Login';
import BusImage from './components/BusImage';
import SignUp from './components/SignUp';
import AdminLogin from './components/AdminLogin';
import AdminSignup from './components/AdminSignup';
import Homepage from './components/Homepage';
import Result from './components/Result';
import AdminHompage from './components/AdminHompage';
import Error from './components/Error'
import AddBus from './components/AddBus';
import MailSendingApi from './components/MailSendingApi';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/bus" element={<BusImage />} />
          <Route path="/about" element={<About />}></Route>
          <Route path="/contact" element={<Contact />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/signup" element={<SignUp />}></Route>
          <Route path="/adminlogin" element={<AdminLogin />} />
          <Route path="/adminsignup" element={<AdminSignup />} />
          <Route path="/result" element={<Result />} />
          <Route path="/adminhomepage/*" element={<AdminHompage />} />
          <Route path="/*" element={<Error />} />
          <Route path="/addbus" element={<AddBus />} />
          <Route path="/sendmail" element={<MailSendingApi />} />
        </Routes>
      </BrowserRouter>

    </div>
  );
}


export default App;
