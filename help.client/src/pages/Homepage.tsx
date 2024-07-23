import React from "react";
import Navbar from "../components/Navbar.tsx";
import { Col, Container, Row } from "react-bootstrap";



function homepage() {
    return (
        <Container style={{ border: "1px solid red" }}>
            <Row style={{ border: "1px solid yellow" }}>
                <Col md={2}>Sol Menü</Col>
                <Col md={10}>İçerik</Col>
            </Row>
        </Container>
    )
}

export default homepage;