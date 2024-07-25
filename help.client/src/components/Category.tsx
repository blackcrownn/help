
import axios from 'axios';
import React, { useEffect, useState } from 'react';


interface CategoryProps{
    id: number;
    kategoriAdi: string;
}



export default function Category() {


    const [categories, setCategories] = useState<CategoryProps[]>([]);

    useEffect(() =>{
        const fetchCategories = async () => {
            try{
                const response = await axios.get('http://localhost:8080/api/kategori/findall');
                console.log(response);
                setCategories(response.data);
            }catch(error){  
                console.error('Sunucu yaniti :', error);
            }
                
        };
        fetchCategories();
    }, []);
    
    
    const items = categories === undefined ?
    <p>Yükleniyor...</p>
    :
    <ul>
        {categories.map(category => 
                <li key={category.id}>
                    <p>{category.kategoriAdi}</p>
                </li>
        )}
    </ul>
    
    return <div>
        {items}
    </div>;
    

}




