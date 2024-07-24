import React from "react";
import Content from "../components/Content.tsx";



export default function ContentPage() {

    var id = 49;

    const get = () => {
        return Content(id);
    };

    return (
        <div>
            {get()}
        </div>
    );
}



