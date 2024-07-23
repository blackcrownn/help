import React, { useEffect, useState } from "react";


interface Text{
    title: string,
    content: string,
}



export default function Contents() {
    const [text, setText] = useState<Text>();
    useEffect(() =>{

    const getData = async () => {
        const response = await fetch('http://localhost:8080/api/yazi/id/1');
        console.log(response);
        const data = await response.json();
        setText(data);
    }
    getData();
    
    }, []);


    const content = text ===undefined ? <p>Yükleniyor...</p> : 
        <div> 
            {text.title}
            <br />
            {text.content}
        </div>
   
    
    return (
        <div>
            {content}
        </div>
    );
}



