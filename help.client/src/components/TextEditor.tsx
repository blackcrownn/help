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

// Rich Text Editor
export default function TextEditor() {

  // definitions
  const [content, setContent] = useState<string>();
  const [category, setCategory] = useState<CategoryProps[]>([]);
  const [selectedCategory, setSelectedCategory] = useState<number>();
  const [title, setTitle] = useState("");
  const [selectedCategoryName, setSelectedCategoryName] = useState<string>("");
  const quillRef = useRef<ReactQuill | null>(null);
  const [newCategoryName, setNewCategoryName] = useState<string>("");
  const [newCategoryParent, setNewCategoryParent] = useState<number>();
  const [showNewCategoryForm, setShowNewCategoryForm] = useState<boolean>(false);
  const [showMenu, setShowMenu] = useState<boolean>(true);
  const [showUpdate, setShowUpdate] = useState<boolean>(false);
  const [showEditor, setShowEditor] = useState<boolean>(false);
  const [contentList, setcontentList] = useState<TitleProps[]>([]);
  const [selectedContent, setSelectedContent] = useState<TitleProps | null>(null);

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
      ["link"],
    ],
    imageResize: {
      modules: ["Resize", "DisplaySize"],
    },
  };

  // fetching Categories for selection
  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/kategori/all");
        console.log(response);
        setCategory(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchCategories();
  }, []);

  // fetching Contents for editing
  useEffect(() => {
    const fetchContent = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/yazi/allyazi");
        console.log(response);
        setcontentList(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchContent();
  }, []);

  // getting Quill Contents and returning it.
  const getQuillContent = () => {
    if (quillRef.current) {
      const editor = quillRef.current.getEditor();
      const content = editor.root.innerHTML; // reaching quill ref
      setContent(content); // getting content of quill
      return content;
    }
    return null;
  };

  // setting category id
  const handleCategory = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selected = category.find((cat) => cat.kategoriAdi === event.target.value);
    setSelectedCategory(selected?.id);
  };

  const handleTitle = (input: React.ChangeEvent<HTMLInputElement>) => {
    setTitle(input.target.value);
  };

  // handle selected content change
  const handleSelectedContent = async (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedId = Number(event.target.value);
    const selectedContent = contentList.find(content => content.id === selectedId);
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
        setCategory([...category, response.data]);
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
    // category
    else if (selectedCategory === undefined) {
      alert("Kategori boş olamaz.");
    } else {
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
        alert("Yazı başarıyla kaydedildi.");
      } catch (error) {
        console.error("Sunucu yaniti :", error);
        alert("Yazı kaydedilirken bir hata oluştu." + error);
      }
    }
  };

  return (
    <div className="mainContainer">
      {/* MENU */}
      {showMenu && (
        <div className="button-menu">
          <button
            className="box new-content-btn"
            onClick={() => {
              setShowEditor(true);
              setShowMenu(false);
            }}
          >
            Yeni İçerik Ekle
          </button>
          <button
            className="box update-content-btn"
            onClick={() => {
              setShowUpdate(true);
              setShowMenu(false);
            }}
          >
            İçeriği Düzenle
          </button>
        </div>
      )}

      {/* EDİTOR */}
      {showEditor && (
        <div className="inputs">
          <input
            type="text"
            className="box title-input"
            placeholder="Yazının başlığı"
            value={title}
            onChange={handleTitle}
          />
          <input
            type="text"
            className="box category-input"
            placeholder="Kategori"
            value={selectedCategoryName}
            readOnly
          />
          <select className="box category-input" onChange={handleCategory}>
            <option value="">Kategori seçin veya yeni bir kategori oluşturun</option>
            {category.map((cat) => (
              <option key={cat.id} value={cat.kategoriAdi}>
                {cat.kategoriAdi}
              </option>
            ))}
          </select>
          <button
            className="box add-category-btn"
            onClick={() => setShowNewCategoryForm(true)}
          >
            Yeni Kategori Ekle
          </button>
          <button className="box close-form" onClick={() => { setShowEditor(false); setShowMenu(true) }}>Ana Menu</button>
          {/* this is for toogling the form */}
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
                <option value="">Parent kategori seçin</option>
                {category.map((cat) => (
                  <option key={cat.id} value={cat.id}>
                    {cat.kategoriAdi}
                  </option>
                ))}
              </select>
              <button className="box save-new-category-btn" onClick={addNewCategory}>
                Kaydet
              </button>
              <button className="box close-form" onClick={() => setShowNewCategoryForm(false)}>Vazgeç</button>
            </div>
          )}

          {/* the button that sends the inputs to the server */}
          <button className="send-btn" onClick={send}>Yayımla</button>
        </div>
      )}

      {/* UPDATE */}
      {showUpdate && (
        <div className="inputs">
          <select className="box contents" onChange={handleSelectedContent}>
            <option value="">İçeriği Seçin</option>
            {contentList.map((content) => (
              <option key={content.id} value={content.id}>
                {content.baslik}
              </option>
            ))}
          </select>
          <input
            type="text"
            className="box title-input"
            placeholder="Yazının başlığı"
            value={title}
            onChange={handleTitle}
          />
          <input
            type="text"
            className="box category-input"
            placeholder="Kategori"
            value={selectedCategoryName}
            readOnly
          />
          <button className="box close-form" onClick={() => { setShowUpdate(false); setShowMenu(true) }}>Ana Menu</button>
        </div>
      )}

      {/* Quill Editor */}
      <ReactQuill
        ref={quillRef}
        className="container"
        theme="snow"
        modules={modules}
        value={content || ""}
        onChange={getQuillContent}
      />
    </div>
  );
}
