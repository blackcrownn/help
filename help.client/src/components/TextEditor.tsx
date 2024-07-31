import React, { useCallback, useEffect, useRef, useState } from 'react';
import quill from 'quill';
import 'quill/dist/quill.snow.css';
import ReactQuill, { Quill } from 'react-quill';
import axios from 'axios'; 
import '../css/texteditor.css';
import ImageResize from 'quill-image-resize-module-react';
import { Delta } from 'quill/core';


//quill implementation
Quill.register("modules/imageResize", ImageResize);




//Rich Text Editor 
export default function TextEditor() {

    
    

    //definitions
    const [content, setContent] = useState<string>();
    const [title, setTitle] = useState('');
    const quillRef = useRef<ReactQuill | null>(null);
    
    //toolbar options
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

   
      const getQuillContent = () => {
        if (quillRef.current) {
          const editor = quillRef.current.getEditor();
          const content = editor.root.innerHTML; // reaching quill ref
          console.log("osman " +editor);
          console.log("gültekin "+ content);
          setContent(content);        // getting content of quill
          console.log('Quill içeriği:', content);
          return content;
        }
        return null;
      };

    

    const handleTitle = (input) => {
        setTitle(input.target.value);
    }


    // send the text to the server
    const send = async () => {
        console.log("sunucuya gonderilecek içerik", content);
        console.log("sunucuya gonderilecek", title);
        try {
            const response = await axios.post('http://localhost:8080/api/yazi/saveyazi', {
                baslik: title,
                icerik: content,
            });
            console.log("********************");

            console.log("sunucuya gonderilecek", content);
            console.log('Sunucu yanıtı:', response.data);

        } catch (error) {
            console.error('Sunucu yaniti :', error);
        }
    }

    

    return (
        <div id="editor">
            {/* Quill */}
            <input type="text" className='title-of-text' placeholder="Yazının başlığı" onChange={handleTitle} />
            <button onClick={send}>Send</button>
            <ReactQuill ref={quillRef} className="container" theme="snow" modules={modules} onChange={getQuillContent} />




        </div>
    );
};




