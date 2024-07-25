import React from "react";
import Content from "../components/Content.tsx";
 


export default function ContentPage() {
    
    const url = window.location.href
    const splitted = url.split("/")
    const id = splitted[splitted.length-1];
    
    const get = () => {
        return Content(id);
    };

    return (
        <div>
            {get()}
        </div>
    );
}



