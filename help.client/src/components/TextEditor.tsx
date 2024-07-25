import React, { useCallback, useEffect, useRef, useState } from 'react';
import quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill, { Quill } from 'react-quill';
import axios from 'axios';
import '../css/texteditor.css';
import ImageResize from 'quill-image-resize-module-react';






//Rich Text Editor 
export default function TextEditor() {

    Quill.register("modules/imageResize", ImageResize);
    
    const modules = {
        toolbar: [
          [{ header: [1, 2, 3, 4, 5, 6, false] }],
          [{ font: [] }],
          [{ list: 'ordered' }, { list: 'bullet' }],
          ['bold', 'italic', 'underline'],
          [{ color: [] }, { background: [] }],
          [{ script: 'sub' }, { script: 'super' }],
          [{ align: [] }],
          ['image', 'blockquote', 'code-block'],
          ['clean'],
          ['link'],
        ],
        imageResize: {
          modules: ['Resize', 'DisplaySize'],
        },
      };
    


    //const quill = new Quill('#editor');

   


    const [editorHtml, setEditorHtml] = useState('');
    const [title, setTitle] = useState('');
    
    // Changes the content when typed.
    const handleChange = (content, delta, source, editor) => {
        setEditorHtml(editor.getHTML()); // 
    };


    const handleTitle = (input) => {
        setTitle(input.target.value);
    }


    // send the text to the server
    const send = async () => {
        console.log("sunucuya gonderilecek", editorHtml);
        console.log("sunucuya gonderilecek", title);
        try {
            const response = await axios.post('http://localhost:8080/api/yazi/saveyazi', {
                baslik: title,
                icerik: editorHtml,
            });
            console.log("********************");

            console.log("sunucuya gonderilecek", editorHtml);
            console.log('Sunucu yanıtı:', response.data);

        } catch (error) {
            console.error('Sunucu yaniti :', error);
        }
    }




    

    const Toolbar_Options = [
        [{ header: [1, 2, 3, 4, 5, 6, false] }],
        [{ font: [] }],
        [{ list: 'ordered' }, { list: 'bullet' }],
        ['bold', 'italic', 'underline'],
        [{ color: [] }, { background: [] }],
        [{ script: 'sub' }, { script: 'super' }],
        [{ align: [] }],
        ['image', 'blockquote', 'code-block'],
        ['clean'],
        ['link']

    ]


    return (
        <div id="editor">
            {/* Quill */}
            <input type="text" className='title-of-text' placeholder="Yazının başlığı" onChange={handleTitle} />
            <button onClick={send}>Send</button>
            <ReactQuill className="container" theme="snow" modules={modules} onChange={handleChange} />




        </div>
    );
};




