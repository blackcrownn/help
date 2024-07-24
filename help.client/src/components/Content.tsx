import React, { useEffect, useState } from "react";
import {Link} from "react-router-dom";


interface Text{
    id: number;
    baslik: string,
    icerik: string,
}



export default function Contents(id: number) {
    const [text, setText] = useState<Text>();
    useEffect(() =>{

    const getData = async () => {
        const response = await fetch('http://localhost:8080/api/yazi/id/'+id);
        console.log(response);
        const data = await response.json();
        setText(data);
    }
    getData();
    
    }, []);


    const content = text ===undefined ? <p>Yükleniyor...</p> : 
        <div> 
            {text.baslik}
            <br />
            {text.icerik}
        </div>
   
    
    return (
        <div>
            {content}
        </div>
    );
}



