import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Treebeard } from "react-treebeard";    // Import the Treebeard component from the react-treebeard library



interface MenuItem{
    id: number;
    title: string,
    content: string,
    parentId: number | null,
}



export default function ContentsMenu() {

const [items, setItems] = useState<MenuItem[]>([]);
const [data, setData] = useState<any>(null); // tree data

useEffect(() =>{
    const getData = async () => {
        try{
    
            const response = await fetch('http://localhost:8080/api/yazi/all');
            if(!response.ok){
                throw new Error('Ağ hatası oluştu');
            }
            const data: MenuItem[] = await response.json();
            setItems(data);
            const treeData = createTreeData(data);
            setData(treeData);
        }catch(error){  
            console.error('Sunucu yaniti :', error);
        }
            
    };
    getData();
}, []);
    
  const createTreeData = (items: MenuItem[]) => {
    const rootItems = items.filter(item => item.parentId === null);
    const createTree = (nodes: MenuItem[]) => {
        return nodes.map(node => {
            const children = items.filter(item => item.parentId === node.id);
            return {
                id: node.id,
                name: node.title,
                children: createTree(children)
            };
        });
    };
    return createTree(rootItems);
}


const onToggle =(node: any, toggled: string) => {
    node.active = true;
    node.toggled = toggled;
    setData(Object.assign({}, data));
   
    };
    return data ? <Treebeard data={data} onToggle={onToggle} /> : <div>Yükleniyor...</div>;

};






