import React, { useCallback, useEffect, useRef, useState } from "react";
import quill from "quill";
import "quill/dist/quill.snow.css";
import ReactQuill, { Quill } from "react-quill";
import axios from "axios";
import "../css/texteditor.css";
import ImageResize from "quill-image-resize-module-react";

//quill implementation
Quill.register("modules/imageResize", ImageResize);

//defination of the category objeect
interface CategoryProps {
  id: number;
  kategoriAdi: string;
}



//Rich Text Editor
export default function TextEditor() {
  //definitions
  const [content, setContent] = useState<string>();
  const [category, setCategory] = useState<CategoryProps[]>([]);
  const [selectedCategory, setSelectedCategory] = useState<string>("");
  const [title, setTitle] = useState("");
  const quillRef = useRef<ReactQuill | null>(null);

  //toolbar options
  const modules = {
    toolbar: [
      [{ header: [1, 2, 3, 4, 5, 6, false] }],
      [{ font: [] }],
      [{ list: "ordered" }, { list: "bullet" }],
      ["bold", "italic", "underline"],
      [{ color: [] }, { background: [] }],
      [{ script: "sub" }, { script: "super" }],
      [{ align: [] }],
      ["image", "blockquote", "code-block"],
      ["clean"],
      ["link"],
    ],
    imageResize: {
      modules: ["Resize", "DisplaySize"],
    },
  };

  //fecthing Categories for selection
  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/kategori/all"
        );
        console.log(response);
        setCategory(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchCategories();
  }, []);

  //getting Quill Contents and returning it.
  const getQuillContent = () => {
    if (quillRef.current) {
      const editor = quillRef.current.getEditor();
      const content = editor.root.innerHTML; // reaching quill ref
      console.log("editor : " + editor);
      console.log("content :" + content);
      setContent(content); // getting content of quill
      console.log("Quill içeriği:", content);
      return content;
    }
    return null;
  };

  //setting category id
  const handleCategory = (event) => {
    setSelectedCategory(event.target.value);
  };

  const handleTitle = (input) => {
    setTitle(input.target.value);
  };

  // send the text to the server
  const send = async () => {
    console.log("sunucuya gonderilecek içerik", content);
    console.log("sunucuya gonderilecek", title);
    // content
    if (content === undefined) {
      alert("Content boş olamaz.");
    }
    //title
    else if (title === "") {
      alert("title boş olamaz.");
    }
    //category
    else if (selectedCategory === "") {
      alert("Kategori boş olamaz.");
    
    } 
    else {
      try {
        const response = await axios.post(
          "http://localhost:8080/api/yazi/saveyazi",
          {
            baslik: title,
            icerik: content,
            kategori: selectedCategory,
          }
        );
        console.log("********************");

        console.log("sunucuya gonderilecek", content);
        console.log("Sunucu yanıtı:", response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    }
  };


  const update = (content: string, title : string, category: string) => {
    setContent(content);
    setTitle(title);
    setSelectedCategory(category);
  }




  const pageUI = useState();


  return (
    <div  className="mainContainer">
      {/* Inputs */}
      <div className="inputs">

      
      <input
        type="text"
        className="box title-input"
        placeholder="Yazının başlığı"
        onChange={handleTitle}
      />
      
      <input
      className="box category-input"
        list="categoryList"
        value={selectedCategory}
        onChange={handleCategory}
        placeholder="Kategori seçin veya yeni bir kategori oluşturun"
      />
      
      <datalist className="categoryList" id="categoryList">
        {category.map((category) => (
          <option key={category.id} value={category.kategoriAdi} />
        ))}
      </datalist>
      
      {/* the button that sends the inputs to the server */}
      <button className="send-btn" onClick={send}>Yayımla</button>
      </div>
        {/* Quill Editor */}  
      <ReactQuill
        ref={quillRef}
        className="container"
        theme="snow"
        modules={modules}
        onChange={getQuillContent}
      />
    </div>
  );
}
