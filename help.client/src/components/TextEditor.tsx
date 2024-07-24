import React, { useCallback, useEffect, useRef, useState } from 'react';
//import Quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill, { Quill } from 'react-quill';
import axios from 'axios';
import '../css/texteditor.css';
import ImageResize from "quill-image-resize-module-react";

Quill.register("modules/imageResize", ImageResize);




//Rich Text Editor 
export default function TextEditor() {
    
    // editorHtml assignment:    
    const [editorHtml, setEditorHtml] = useState('');
    // title of the content
    const [title, setTitle] = useState('');


    // Changes the values when typed.
    const handleChange = (content, delta, source, editor) => {
        setEditorHtml(editor.getHTML()); // 
    };
   
    const handleTitle = (input) => {
        setTitle(input.target.value);
    }


    // send the values to the server
    const send = async () => {
        console.log("sunucuya gonderilecek", editorHtml);
        console.log("sunucuya gonderilecek", title);
        try { 
            const response = await axios.post('http://localhost:8080/api/yazi/save', {
                baslik: title,
                icerik: editorHtml,
        });
        console.log("********************");
        
        console.log("sunucuya gonderilecek", editorHtml);
        console.log('Sunucu yanıtı:', response.data);

        }catch (error) {
            console.error('Sunucu yaniti :', error);
        }
    }  


    const modules = {
        toolbar: [  // toolbar options
            [{header: [1, 2, 3, 4, 5, 6, false]}],
            [{font: []}],
        [{list: 'ordered'}, {list: 'bullet'}],
        ['bold', 'italic', 'underline'],
        [{color: []}, {background: []}],
        [{script: 'sub'}, {script: 'super'}],
        [{align: []}],
        ['image', 'blockquote', 'code-block'],
        ['clean'],
        ['link']

        ],
        imageResize: {  // image resize options
            modules: ["Resize", "DisplaySize"]
          }


    }



    return (
        <div id="editor">
            {/* Quill */}
            <input type="text" className='title-of-text' placeholder="Yazının başlığı" onChange={handleTitle} />
            <button onClick={send}>Send</button>
            <ReactQuill className="container" theme="snow" modules={modules} onChange={handleChange} />
            
            
        
        
        </div>
    );
};
         


  
