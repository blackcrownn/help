import React from "react";
import { Link } from "react-router-dom";
import '../css/navbar.css';

function Navbar() {
  return (
    <div className="navbar">
       
            <div className="logo">AFAD</div>
            {//This links to the contents page
            }
            <div className="content">
            <Link to='/' className="content">İçerikler</Link>
            </div>
        
            <div className="content">
                <input type="text" placeholder="Ara..." />
                <button>Ara</button>
            </div>
        
        
    </div>
  );
}

export default Navbar;