import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TextEditor from './components/TextEditor.tsx';
import HomePage from './pages/Homepage.tsx'; 
import Navbar from './components/Navbar.tsx';
import ContentPage from './pages/ContentPage.tsx';
import ContentsMenu from './components/ContentsMenu.tsx';
import Categories from './components/Category.tsx';



function App() {
  return (
    <div>
      <Navbar/>
      <Routes>
        <Route path="/*" element={<HomePage/>} />
        <Route path="/texteditor" element={<TextEditor/>} />
        <Route path="/content/*" element={<ContentPage/>}/>
        <Route path='/contentsmenu' element={<ContentsMenu/>}/>
        <Route path='/categories' element={<Categories/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
