import React, { useCallback, useEffect, useRef, useState } from 'react';
import Quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill from 'react-quill';
import axios from 'axios';


//Rich Text Editor 
export default function TextEditor() {
    
    /*const wrapperRef = useCallback(wrapper => { 
    if (wrapper == null) return

        wrapper.innerHTML = ""
        const editor = document.createElement('div');
        wrapper.append(editor);
        new Quill(editor, {theme:'snow'});
    }, []); */


    //const quill = new Quill('#editor');

    //const html = quill.root.innerHTML;


    // editorHtml assignment:

    const [editorHtml, setEditorHtml] = useState('');

    // Changes the content when typed.
    const handleChange = (content, delta, source, editor) => {
        setEditorHtml(editor.getHTML()); // 
    };


    // send the text to the server
    const send = async () => {
        console.log("sunucuya gonderilecek", editorHtml);
        try { 
            const response = await axios.post('http://localhost:8080/api/yazi/save', {
            content: editorHtml,
        });
        console.log("sunucuya gonderilecek", editorHtml);
        console.log('Sunucu yanıtı:', response.data);

        }catch (error) {
            console.error('Sunucu yaniti :', error);
        }
    }  


    return (
        <div id="editor">
            <ReactQuill theme="snow" onChange={handleChange} />
            <div>{`HTML code is ${editorHtml}`}</div>
            <button onClick={send}>gönder</button>
        
        
        </div>
    );
};
         


  
