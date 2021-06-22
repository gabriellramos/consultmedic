--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-06-22 17:07:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'ISO_8859_5';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16430)
-- Name: CONSULTA; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CONSULTA" (
    "idConsulta" integer NOT NULL,
    "cpfPaciente" character varying[] NOT NULL,
    "cpfMedico" "char"[] NOT NULL,
    "consultaRealizada" boolean NOT NULL,
    "dataConsulta" date NOT NULL,
    "idAgendamento" integer NOT NULL,
    "horaConsulta" date NOT NULL
);


ALTER TABLE public."CONSULTA" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17043)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    cpf character varying(15) NOT NULL,
    endereco character varying(50),
    telefone character varying(50),
    nome character varying(50),
    datanascimento character varying(15),
    idade integer,
    tipopessoa character varying(20)
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17048)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    nomeusuario character varying(15),
    senha character varying(20),
    usuariologado boolean
)
INHERITS (public.pessoa);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17051)
-- Name: administrador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.administrador (
    nomeclinica character varying(50),
    enderecoclinica character varying(50),
    telefoneclinica character varying(20)
)
INHERITS (public.funcionario);


ALTER TABLE public.administrador OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17094)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    crm character varying(15),
    ufcrm character varying(5),
    especialidade character varying(30)
)
INHERITS (public.funcionario);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17008)
-- Name: teste; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teste (
    nome character varying(50)
);


ALTER TABLE public.teste OWNER TO postgres;

--
-- TOC entry 3004 (class 0 OID 16430)
-- Dependencies: 200
-- Data for Name: CONSULTA; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CONSULTA" ("idConsulta", "cpfPaciente", "cpfMedico", "consultaRealizada", "dataConsulta", "idAgendamento", "horaConsulta") FROM stdin;
\.


--
-- TOC entry 3008 (class 0 OID 17051)
-- Dependencies: 204
-- Data for Name: administrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.administrador (cpf, endereco, telefone, nome, datanascimento, idade, tipopessoa, nomeusuario, senha, usuariologado, nomeclinica, enderecoclinica, telefoneclinica) FROM stdin;
\.


--
-- TOC entry 3007 (class 0 OID 17048)
-- Dependencies: 203
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (cpf, endereco, telefone, nome, datanascimento, idade, tipopessoa, nomeusuario, senha, usuariologado) FROM stdin;
00000000000	\N	\N	admin	\N	0	administrador	00000000000	admin	f
\.


--
-- TOC entry 3009 (class 0 OID 17094)
-- Dependencies: 205
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (cpf, endereco, telefone, nome, datanascimento, idade, tipopessoa, nomeusuario, senha, usuariologado, crm, ufcrm, especialidade) FROM stdin;
\.


--
-- TOC entry 3006 (class 0 OID 17043)
-- Dependencies: 202
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (cpf, endereco, telefone, nome, datanascimento, idade, tipopessoa) FROM stdin;
\.


--
-- TOC entry 3005 (class 0 OID 17008)
-- Dependencies: 201
-- Data for Name: teste; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teste (nome) FROM stdin;
admin
\.


--
-- TOC entry 2870 (class 2606 OID 16437)
-- Name: CONSULTA CONSULTA_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CONSULTA"
    ADD CONSTRAINT "CONSULTA_pkey" PRIMARY KEY ("idConsulta");


--
-- TOC entry 2872 (class 2606 OID 17047)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (cpf);


--
-- TOC entry 3003 (class 6104 OID 17093)
-- Name: clinica; Type: PUBLICATION; Schema: -; Owner: postgres
--

CREATE PUBLICATION clinica FOR ALL TABLES WITH (publish = 'insert, update, delete, truncate', publish_via_partition_root = true);


ALTER PUBLICATION clinica OWNER TO postgres;

-- Completed on 2021-06-22 17:07:22

--
-- PostgreSQL database dump complete
--

