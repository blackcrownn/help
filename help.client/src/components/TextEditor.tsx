import React, { useEffect, useRef, useState } from "react";
import "quill/dist/quill.snow.css";
import ReactQuill, { Quill } from "react-quill";
import axios from "axios";
import "../css/texteditor.css";
import ImageResize from "quill-image-resize-module-react";

// quill implementation
Quill.register("modules/imageResize", ImageResize);



// definition of the category object
interface CategoryProps {
  id: number;
  kategoriAdi: string;
  parentId: number | null;
  yazilar: TitleProps[];
}

// definition of the title object
interface TitleProps {
  id: number;
  baslik: string;
  kategoriAdi: string;
  parentid: number;
  icerik: string;
  kategoriId: number;
}


// main function
export default function TextEditor() {

  // definitions :
  // values :  
  const [content, setContent] = useState<string>();
  const [category, setCategory] = useState<CategoryProps[]>([]);
  const [title, setTitle] = useState("");
  const [selectedCategory, setSelectedCategory] = useState<number>(); // this is using for the selected category id to send to the server
  const [selectedCategoryName, setSelectedCategoryName] = useState<string>("");
  const [newCategoryName, setNewCategoryName] = useState<string>(""); // this is using for the creating the new category
  const [newCategoryParent, setNewCategoryParent] = useState<number>();
  const [contentList, setcontentList] = useState<TitleProps[]>([]);  // the list of the content for the displaying the contents in the menu
  const [selectedContent, setSelectedContent] = useState<TitleProps>();

  
  // refs :
  const quillRef = useRef<ReactQuill | null>(null);
  //  states :
  const [showNewCategoryForm, setShowNewCategoryForm] = useState<boolean>(false);
  const [showMenu, setShowMenu] = useState<boolean>(true);
  const [showUpdate, setShowUpdate] = useState<boolean>(false);
  const [showEditor, setShowEditor] = useState<boolean>(false);
  




  // toolbar options
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
      ["link",  "video"],
      ],
    imageResize: { // appyling resizing the image
      modules: ["Resize", "DisplaySize"],
    },
    
  };

  
  //  axios functions:

  // fetching Categories
  const fetchCategories = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/kategori/all");
      console.log(response);
      setCategory(response.data);
    } catch (error) {
      console.error("Sunucu yaniti :", error);
    }
  };
  // useeffect for fetching categories
  useEffect(() => {
    fetchCategories();
  }, []);


  // fetching Contents for selection and editing
  const fetchContent = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/yazi/allyazi");
      console.log(response);
      setcontentList(response.data);
    } catch (error) {
      console.error("Sunucu yaniti :", error);
    }
  };
  //useffect for fetching contents
  useEffect(() => {
    fetchContent();
  }, []);



   //posting fucntions to the server 

  // add new category
  const addNewCategory = async () => {
    if (newCategoryName === "") {
      alert("Kategori adı boş olamaz.");
    } else {
      try {
        const response = await axios.post(
          "http://localhost:8080/api/kategori/savekategori",
          {
            kategoriAdi: newCategoryName,
            parentId: newCategoryParent // Add parent ID here
          }
        );
        console.log("Sunucu yanıtı:", response.data);
        fetchCategories();
        setNewCategoryName("");
        setNewCategoryParent(undefined);
        setShowNewCategoryForm(false); // Hide the form after saving
        
        alert("Kategori başarıyla kaydedildi.");
      } catch (error) {
        console.error("Sunucu yaniti :", error);
        alert("Kategori kaydedilirken bir hata oluştu." + error);
      }
    }
  };

  // send the text to the server
  const send = async () => {
    console.log("sunucuya gonderilecek içerik", content);
    console.log("sunucuya gonderilecek", title);
    // content
    if (content === undefined) {
      alert("Content boş olamaz.");
    }
    // title
    else if (title === "") {
      alert("Title boş olamaz.");
    }
     else {
      try {
        const response = await axios.post(
          "http://localhost:8080/api/yazi/saveyazi",
          {
            baslik: title,
            icerik: content,
            kategoriId: selectedCategory,
          }
        );
        console.log("********************");
        console.log("sunucuya gonderilecek", content);
        console.log("Sunucu yanıtı:", response.data);
        alert("Yazı başarıyla kaydedildi.");
        fetchContent();
      } catch (error) {
        console.error("Sunucu yaniti :", error);
        alert("Yazı kaydedilirken bir hata oluştu." + error);
      }
    }
    fetchCategories();
  };


  //update the content
  const updateContent = async () => {
    console.log("sunucuya gonderilecek içerik", content);
    console.log("sunucuya gonderilecek", title);
    if (content === undefined) {
      alert("Content boş olamaz.");
    }
    else if (title === "") {
      alert("Title boş olamaz.");
    }
     else {
      try {
        console.log("selectedContent : ", selectedContent?.id);
        const response = await axios.put(
          "http://localhost:8080/api/yazi/update/" + selectedContent?.id,
          {
            id: selectedContent?.id,
            baslik: title,
            icerik: content,
            kategoriId: selectedCategory,
          }
        );
        console.log("********************");
        console.log("sunucuya gonderilecek", content);
        console.log("Sunucu yanıtı:", response.data);
        alert("Yazı başarıyla kaydedildi.");
        fetchCategories();
      } catch (error) {
        console.error("Sunucu yaniti :", error);
        alert("Yazı kaydedilirken bir hata oluştu." + error);
      }
    }
  };

  // delete the content
  const deleteContent = async (id: number) => {
      const confirmed = window.confirm("Silmek istediğinizden emin misiniz?");
      if (confirmed) {
        try {
          await axios.delete(`http://localhost:8080/api/yazi/${id}`);
          alert("İçerik başarıyla silindi.");
          setSelectedContent(undefined);
          fetchContent(); 
          setContentsEmpty();
        } catch (error) {
          console.error("Sunucu yaniti :", error);
          alert("İçerik silinirken bir hata oluştu." + error);
        }
    }
  };



  const addNewContent = async (kategoriId: number) => {
    console.log("kategoriId", kategoriId);
    
    setContentsEmpty();
    setSelectedCategory(kategoriId);
    
    
    
  }

  const deleteCategory = async (id: number) => { 
    const confirmed = window.confirm("Silmek istediğinizden emin misiniz?");
    if (confirmed) {
      try {
        await axios.delete(`http://localhost:8080/api/kategori/${id}`);
        alert("kategori başarıyla silindi.");
        setSelectedContent(undefined);
        fetchCategories();
        setContentsEmpty();
      } catch (error) {
        console.error("Sunucu yaniti :", error);
        alert("İçerik silinirken bir hata oluştu." + error);
      }
  }
  }



  // getting Quill Contents and saving it into the content.
  const getQuillContent = () => {
    if (quillRef.current) {
      const editor = quillRef.current.getEditor();
      const content = editor.root.innerHTML; // reaching quill ref
      setContent(content); // getting content of quill into content
    }
    return null;
  };

  
  
  // handlers for values : 
  
  // setting all values empty
  const setContentsEmpty = () => {
    setContent("");
    setTitle("");
    setSelectedCategory(undefined);
  }

  // setting category id
  const handleCategory = (event) => {
    const selected = category.find((cat) => cat.kategoriAdi === event.target.value);
    setSelectedCategory(selected?.id);
  };

  // setting title
  const handleTitle = (input) => {
    setTitle(input.target.value);
    console.log("title :", title);
  };

  // handle selected content change
  const handleSelectedContent = async (id:number) => {
    const selectedContent = contentList.find(content => content.id === id);
    if (selectedContent) {
      setTitle(selectedContent.baslik);
      setContent(selectedContent.icerik);
      setSelectedContent(selectedContent);

      // Find the selected category name by id
      const selectedCategory = category.find(cat => cat.id === selectedContent.kategoriId);
      if (selectedCategory) {
        setSelectedCategoryName(selectedCategory.kategoriAdi);
      }
    }
  };


  
 


  //main return of the main fucntion for the output.
  return (
    <div className="mainContainer">
      <div className="sidebar">
        
        {/* UPDATE */}
      {showUpdate && (
        <div className="inputs">
          <input
            type="text"
            className="box title-input"
            placeholder="Yazının başlığı"
            value={title}
            onChange={handleTitle}
          />
          <select className="box category-input" onChange={handleCategory}>
            <option value="">{selectedCategoryName}</option>
            {category.map((cat) => (
              <option key={cat.id} value={cat.kategoriAdi}>
                {cat.kategoriAdi}
              </option>
            ))}
          </select>
          <button
            className="box buttons-of-menu"
            onClick={() => {
              setShowUpdate(false);
              setShowMenu(true);
              setContentsEmpty();
            }}
          >
            Geri Dön
          </button>
          <button className="update-btn " onClick={updateContent}>
            Güncelle
          </button>
        </div>
      )}






        
        {/* MENU */}
        {showMenu && (
          <div className="menuitems">
            <h2>İçerikler</h2>
            {category.length === 0 ? (
              <p>Yükleniyor...</p>
            ) : (
              <ul>
                {category.map((cat) => (
                  <li className="allCategories" key={cat.id}>
                    {cat.kategoriAdi}
                    <button className="delete-btn category" onClick={() => deleteCategory(cat.id)}>-</button>
                    <ul>
                      {cat.yazilar.map((cont) => (
                        <li
                          className="allTitles"
                          value={cont.id}
                          onClick={() => {handleSelectedContent(cont.id); setShowUpdate(true)}}
                        >
                          {cont.baslik}
                          <button
                            className="delete-btn"
                            onClick={() => deleteContent(cont.id)}
                          >
                            -
                          </button>
                        </li>
                      ))}
                      <button className="add-btn" onClick={() => {addNewContent(cat.id); setShowUpdate(false); setShowEditor(!showEditor); setShowMenu(!showMenu); }}>+</button>
                    </ul>
                  </li>
                ))}
                <button className="add-btn"
                  onClick={() => {
                    setShowNewCategoryForm(!showNewCategoryForm);
                  }}
                >
                  +
                </button>
              </ul>
            )}
          </div>
        )}
        
        


        {/* EDİTOR */}
      {showEditor && (
        <div>
          <input
            type="text"
            className="box title-input"
            placeholder="Yazının başlığı"
            value={title}
            onChange={handleTitle}
          />
          <button
            className="box buttons-of-menu"
            onClick={() => {
              setShowEditor(false);
              setShowMenu(true);
              setContentsEmpty();
            }}
          >
            Geri
          </button>

          {/* the button that sends the inputs to the server */}
          <button className="send-btn buttons-of-menu" onClick={send}>
            Yayımla
          </button>
        </div>
      )}


      {/* ADD NEW Category */}
      {showNewCategoryForm && (
        <div className="new-category">
          <input
            type="text"
            className="box new-category-input"
            placeholder="Yeni kategori adı"
            value={newCategoryName}
            onChange={(e) => setNewCategoryName(e.target.value)}
          />
          <select
            className="box new-category-parent-input"
            onChange={(e) => setNewCategoryParent(Number(e.target.value))}
          >
            <option value="">Üst kategori seçin</option>
            {category.map((cat) => (
              <option key={cat.id} value={cat.id}>
                {cat.kategoriAdi}
              </option>
            ))}
          </select>
          <button className="box buttons-of-menu" onClick={addNewCategory}>
            Kaydet
          </button>
          <button
            className="box buttons-of-menu"
            onClick={() => {
              setShowNewCategoryForm(false);
            }}
          >
            Vazgeç
          </button>
        </div>
      )}



      </div>


      
      {/* Quill Editor */}
        
      <div className="quill-text-editor">
       <ReactQuill
          ref={quillRef}
          className="container"
          theme="snow"
          modules={modules}
          value={content || ""}
          onChange={getQuillContent}
        />
      </div>

      
    </div>
  );
}
