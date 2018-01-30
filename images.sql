--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2018-01-30 15:41:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16394)
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE images (
    search_term character varying(50) NOT NULL,
    url character varying(500)
);


ALTER TABLE images OWNER TO postgres;

--
-- TOC entry 2793 (class 0 OID 16394)
-- Dependencies: 198
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY images (search_term, url) FROM stdin;
cat	https://pixabay.com/get/ea34b1092af5023ed95c4518b74b449fe477e0dd04b0144092f2c479a2ebb2_640.jpg
tree	https://pixabay.com/get/ea35b8082cf5083ed95c4518b74b449fe477e0dd04b0144092f2c479afebb7_640.jpg
flower	https://pixabay.com/get/ea34b00c2bf5093ed95c4518b74b449fe477e0dd04b0144092f2c87ca4e4b3_640.jpg
big	https://pixabay.com/get/ea34b1092af5023ed95c4518b74b449fe477e0dd04b0144092f2c87ca0e4b6_640.jpg
new	https://pixabay.com/get/eb3cb40c2ff6033ed95c4518b74b449fe477e0dd04b0144092f2c87caeefbd_640.jpg
girl	https://pixabay.com/get/ea34b1092af5023ed95c4518b74b449fe477e0dd04b0144092f2c871a5edb7_640.jpg
some	https://pixabay.com/get/ea34b00f2cf5063ed95c4518b74b449fe477e0dd04b0144092f3c17ca0ebb2_640.jpg
table	https://pixabay.com/get/ea34b00b2afc093ed95c4518b74b449fe477e0dd04b0144092f3c07eafe4b0_640.jpg
\.


--
-- TOC entry 2671 (class 2606 OID 16401)
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_pkey PRIMARY KEY (search_term);


-- Completed on 2018-01-30 15:41:33

--
-- PostgreSQL database dump complete
--

