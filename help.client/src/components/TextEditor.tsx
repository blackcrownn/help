import React, { useCallback, useEffect, useRef, useState } from 'react';
import Quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill from 'react-quill';



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

    const [editorHtml, setEditorHtml] = useState('');

    const handleChange = (content, delta, source, editor) => {
        setEditorHtml(editor.getHTML()); // HTML formatında içeriği günceller
    };
         
    return (
        <div id="editor">
            <ReactQuill theme="snow" onChange={handleChange} />
            <div>{`HTML code is ${editorHtml}`}</div>
        </div>
    );
};
         


  
