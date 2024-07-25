import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Treebeard } from "react-treebeard";    // Import the Treebeard component from the react-treebeard library



interface MenuItems{
    id: number;
    title: string,
    content: string,
    parentId: number | null,
}



export default function ContentsMenu() {

const [items, setItems] = useState<MenuItems[]>([]);

useEffect(() =>{
    const fetchContens = async () => {
        try{
            const response = await axios.get('http://localhost:8080/api/kategori/all');
            console.log(response);
            const contents = response.data;
            setItems(contents);
        }catch(error){  
            console.error('Sunucu yaniti :', error);
        }
            
    };
    fetchContens();
}, []);
    
    const content = items === undefined ?
     <p>Yükleniyor...</p> 
    :
    <ul>
        {items.map(item => 
                <li key={item.id}>
                    <Link to={"/content/"+item.id}>{item.title}</Link>
                </li>
        )}
    </ul>

        return <div>
            {content}
        </div>;
  
};






