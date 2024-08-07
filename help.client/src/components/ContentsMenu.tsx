import axios from "axios";
import React, { useEffect, useState } from "react";
import "../css/contentmenu.css";
import Contents from "./Content.tsx";

interface TitleProps {
  id: number;
  title: string;
}

interface CategoryProps {
  id: number;
  kategoriAdi: string;
  parentId: number | null;
  yazilar: TitleProps[];
}

export default function Category() {
  const [categories, setCategories] = useState<CategoryProps[]>([]);
  const [selectedId, setSelectedId] = useState<number | null>(null); // Seçilen yazının id'si
  const [isOpen, setIsOpen] = useState(false);

  const toggleOffcanvas = () => {
    setIsOpen(!isOpen);
  };

  // fetch categories
  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/kategori/all");
        console.log(response);
        setCategories(response.data);
      } catch (error) {
        console.error("Sunucu yaniti :", error);
      }
    };
    fetchCategories();
  }, []);

  // tıklanan yazının id'sini kaydet
  const handleTitleClick = (id: number) => {
    toggleOffcanvas();
    setSelectedId(id);
  };

  const items = categories.length === 0 ? (
    <p>Yükleniyor...</p>
  ) : (
    <ul>
      {categories.map((category) => (
        <li key={category.id}>
          <p>{category.kategoriAdi}</p>
          <ul>
            {category.yazilar.map((title) => (
              <li key={title.id} onClick={() => handleTitleClick(title.id)}>
                {title.title}
              </li>
            ))}
          </ul>
        </li>
      ))}
    </ul>
  );

  return (
    <div className="menuContainer">
      <button onClick={toggleOffcanvas} className={"open-btn" + (isOpen ? " open" : "")}>
        =
      </button>
      <div className={"menu" + (isOpen ? " open" : "")}>
        <div className="menuitems">
          <h2>İçerikler</h2>
          {items}
        </div>
      </div>
      {selectedId && <Contents id={selectedId} />}
    </div>
  );
}
