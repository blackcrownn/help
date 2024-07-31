import axios from "axios";
import React, { useEffect, useState } from "react";
import "../css/contentmenu.css";

interface CategoryProps {
  id: number;
  kategoriAdi: string;
  parentid: number;
}

interface TitleProps {
  id: number;
  baslik: string;
  parentid: number;
}

export default function Category() {
  const [categories, setCategories] = useState<CategoryProps[]>([]);
  const [titles, setTitles] = useState<TitleProps[]>([]);

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

  const items =
    categories === undefined ? (
      <p>Yükleniyor...</p>
    ) : (
      <ul>
        {categories.map((category) => (
          <li key={category.id}>
            <p>{category.kategoriAdi}</p>
          </li>
        ))}
      </ul>
    );

  const menut = categories === undefined ? <p>Yükleniyor...</p> : <ul></ul>;

  const [isOpen, setIsOpen] = useState(false);

  const toggleOffcanvas = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="menuContainer">
      <button onClick={toggleOffcanvas} className={"open-btn" + (isOpen ? " open" : "")}>=</button>
      <div className={"menu" + (isOpen ? " open" : "")}>
        <div className="menuitems">
          <h2>İçerikler</h2>
          <p>{items}</p>
        </div>
      </div>
    </div>
  );
}
