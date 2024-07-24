import React, { useCallback, useEffect, useRef, useState } from 'react';
import Quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill, { displayName } from 'react-quill';
import axios from 'axios';
import '../css/texteditor.css';


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

    

    const [title, setTitle] = useState('');

    const handleTitle = (input) => {
        setTitle(input.target.value);
    }


    // send the text to the server
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


    const Toolbar_Options = [
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

    ]


    return (
        <div id="editor">
            {/* Quill */}
            <input type="text" className='title-of-text'placeholder="Yazının başlığı" onChange={handleTitle} />
            <button onClick={send}>Send</button>
            <ReactQuill className="container" theme="snow" modules={{toolbar: Toolbar_Options}} onChange={handleChange} />
            
            
        
        
        </div>
    );
};
         


  
