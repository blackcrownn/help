import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TextEditor from './components/TextEditor.tsx';
import HomePage from './pages/Homepage.tsx'; 
import Navbar from './components/Navbar.tsx';
import ContentPage from './pages/ContentPage.tsx';
import ContentsMenu from './components/ContentsMenu.tsx';




function App() {
  return (
    <div>
      <Navbar/>
      <ContentsMenu/>
      <Routes>
        <Route path="/*" element={<HomePage/>} />
        <Route path="/texteditor" element={<TextEditor/>} />
        <Route path="/content/*" element={<ContentPage/>}/>
        <Route path='/contentsmenu' element={<ContentsMenu/>}/>
      </Routes>
    </div>
  );
}

export default App;
