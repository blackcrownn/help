import React, { useEffect, useState } from "react";

// Text props
interface Text {
    id: number;
    baslik: string;
    icerik: string;
}

// Props tanımlama
interface ContentsProps {
    id: number;
}

// get the content and returns it
export default function Contents({ id }: ContentsProps) {
    const [text, setText] = useState<Text>();

    useEffect(() => {
        const getData = async () => {
            const response = await fetch(`http://localhost:8080/api/yazi/id/${id}`);
            const data = await response.json();
            setText(data);
        };
        getData();
    }, [id]);

    const content = text === undefined ? (
        <p>Yükleniyor...</p>
    ) : (
        <div>
            <div>{text.baslik}</div>
            <br />
            <div dangerouslySetInnerHTML={{ __html: text.icerik }} />
        </div>
    );

    return (
        <div>
            <br />

            {content}
        </div>
    );
}
