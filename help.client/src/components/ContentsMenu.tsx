import axios from "axios";
import React, { useEffect, useState } from "react";
import "../css/contentmenu.css";
import Contents from "./Content.tsx";

interface CategoryProps {
  id: number;
  kategoriAdi: string;
  parentid: number;
}

interface TitleProps {
  id: number;
  title: string;
}

export default function Category() {
  const [categories, setCategories] = useState<CategoryProps[]>([]);
  const [titles, setTitles] = useState<TitleProps[]>([]);
  const [selectedId, setSelectedId] = useState<number>(1); // Seçilen yazının id'si
  const [isOpen, setIsOpen] = useState(false);

  const toggleOffcanvas = () => {
    setIsOpen(!isOpen);
  };

  // fetch categories
  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/kategori/all"
        );
        console.log(response);
        setCategories(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchCategories();
  }, []);

  // fetch titles
  useEffect(() => {
    const fetchtitles = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/yazi/simple"
        );
        console.log(response);
        setTitles(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchtitles();
  }, []);

  // tıklanan yazının id'sini kaydet
  const handleTitleClick = (id: number) => {
    toggleOffcanvas();
    setSelectedId(id);
  };

  const items = categories === undefined ? (
    <p>Yükleniyor...</p>
  ) : (
    <ul>
      {categories.map((category) => (
        <li key={category.id}>
          <p>{category.kategoriAdi}</p>
        </li>
      ))}
      <ul>
        {titles.map((title) => (
          <li key={title.id} onClick={() => handleTitleClick(title.id)}>
            {title.title}
          </li>
        ))}
      </ul>
    </ul>
  );





  return (
    <div className="menuContainer">
      <button onClick={toggleOffcanvas} className={"open-btn" + (isOpen ? " open" : "")}>=</button>
      <div className={"menu" + (isOpen ? " open" : "")}>
        <div className="menuitems">
          <h2>İçerikler</h2>
          {items}
        </div>
      </div>
      {<Contents id={selectedId} />} {/*  */}
    </div>
  );
}