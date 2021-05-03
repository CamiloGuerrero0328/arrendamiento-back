--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-1.pgdg16.04+1)
-- Dumped by pg_dump version 12.3

-- Started on 2020-11-24 01:40:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 3345583)
-- Name: abogado; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.abogado (
    id_abogado integer NOT NULL,
    nombre_abogado character varying,
    apellido_abogado character varying,
    telefono_abogado numeric,
    correo_electronico character varying,
    estado character varying,
    id_usuario integer NOT NULL
);


ALTER TABLE public.abogado OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 203 (class 1259 OID 3345591)
-- Name: cliente; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nombre_cliente character varying,
    apellido_cliente character varying,
    telefono_cliente numeric,
    id_tipo_documento integer NOT NULL,
    documento character varying,
    id_usuario integer NOT NULL,
    id_tipo_cliente integer NOT NULL
);


ALTER TABLE public.cliente OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 204 (class 1259 OID 3345599)
-- Name: documentos; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.documentos (
    id_documentos integer NOT NULL,
    carta_laboral character varying,
    rut character varying,
    solicitud_arrendamiento character varying,
    cedula_ciudadania character varying,
    codeudor character varying,
    fecha_ingreso date NOT NULL,
    id_cliente integer NOT NULL
);


ALTER TABLE public.documentos OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 205 (class 1259 OID 3345607)
-- Name: inmueble; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.inmueble (
    id_inmueble integer NOT NULL,
    tipo_inmueble character varying,
    direccion character varying,
    descripcion character varying,
    id_cliente integer NOT NULL
);


ALTER TABLE public.inmueble OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 206 (class 1259 OID 3345615)
-- Name: proceso; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.proceso (
    id_proceso integer NOT NULL,
    nombre_proceso character varying,
    estado character varying,
    fecha_proceso date,
    id_abogado integer,
    id_cliente integer NOT NULL,
    id_inmueble integer NOT NULL,
    info character varying,
    pagado boolean
);


ALTER TABLE public.proceso OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 207 (class 1259 OID 3345623)
-- Name: tipo_cliente; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.tipo_cliente (
    id_tipo_cliente integer NOT NULL,
    nombre_tipo_cliente character varying
);


ALTER TABLE public.tipo_cliente OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 208 (class 1259 OID 3345631)
-- Name: tipo_documento; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.tipo_documento (
    id_tipo_documento integer NOT NULL,
    nombre_documento character varying,
    estado character varying
);


ALTER TABLE public.tipo_documento OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 209 (class 1259 OID 3345639)
-- Name: tipo_usuario; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.tipo_usuario (
    id_tipo_usuario integer NOT NULL,
    nombre_usuario character varying,
    estado character varying
);


ALTER TABLE public.tipo_usuario OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 210 (class 1259 OID 3345647)
-- Name: usuario; Type: TABLE; Schema: public; Owner: qvvxmeyukwlqvt
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    correo_electronico character varying,
    contrasena character varying,
    id_tipo_usuario integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO qvvxmeyukwlqvt;

--
-- TOC entry 3896 (class 0 OID 3345583)
-- Dependencies: 202
-- Data for Name: abogado; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.abogado (id_abogado, nombre_abogado, apellido_abogado, telefono_abogado, correo_electronico, estado, id_usuario) FROM stdin;
33	Pastor emilio	Betancour Ocampo	1236517548	pastor@gmail.com	S	54
0	ejemplo	ejemplo2	123123123	ejemplo@gmail.com	S	196
\.


--
-- TOC entry 3897 (class 0 OID 3345591)
-- Dependencies: 203
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.cliente (id_cliente, nombre_cliente, apellido_cliente, telefono_cliente, id_tipo_documento, documento, id_usuario, id_tipo_cliente) FROM stdin;
96	Juan Camilo	Guerrero Melchor	3176718006	1	1115555000	29	1
138	Juan Camilo	Guerrero Melchor	3176718006	1	1107507334	8	2
174	PASTOR EMILIO	BETANCOURT OCAMPO SANt	31638686511	1	123243543	62	2
183	SERGIO NARANJO	BENITEZ	365894	1	1453651	10	1
\.


--
-- TOC entry 3898 (class 0 OID 3345599)
-- Dependencies: 204
-- Data for Name: documentos; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.documentos (id_documentos, carta_laboral, rut, solicitud_arrendamiento, cedula_ciudadania, codeudor, fecha_ingreso, id_cliente) FROM stdin;
111	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_bu8es4bezou.pdf?alt=media&token=fab498b4-fdf1-49b4-8092-ff737dd9310f	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_5oelrwsnjas.pdf?alt=media&token=0ac0068a-dca9-4abe-a8c1-d9725ebd44c7	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_l0c445o4rpn.pdf?alt=media&token=e1f5431c-ed18-43a1-93ab-457d911f06c3	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_gkvgh3lx8xq.pdf?alt=media&token=5a39b42c-e3ef-457a-a63a-063c13f52857	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_hn6isac07op.pdf?alt=media&token=06392c2a-087e-48cc-93a1-9b324030ead0	2020-11-24	96
155	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_ixqq6v2ccc.pdf?alt=media&token=575d658f-bde6-4191-acbd-4c76c934b876	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_2emp67sk5aa.pdf?alt=media&token=7be91a44-bacd-406a-974a-b53367363e87	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_zwdginz2wa.pdf?alt=media&token=e4ec715e-04c4-4f1a-ba3d-95f2cc8ddf99	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_obo9vxx3sk.pdf?alt=media&token=5fbced9d-6d51-4c44-952a-88bdc2be260a	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_zqhd4xc5m0i.pdf?alt=media&token=1c877724-09c7-4ac7-9350-663765f1fc5f	2020-11-24	183
154	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_l7gg95su67h.pdf?alt=media&token=6994d040-e4b2-423c-949d-5cda4d7654b7	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_arenzbdyl0f.pdf?alt=media&token=8f66ee09-10d3-41b4-9ae2-c09519738cec	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_vbbqf3x7mo.pdf?alt=media&token=0f73323c-9729-444d-a34b-6836211c6859	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_zs9a9zy88vs.pdf?alt=media&token=fe216973-558c-4d3a-a886-47266b6a8ef6	https://firebasestorage.googleapis.com/v0/b/arrendamiento-pc.appspot.com/o/documentos%2Fprofile_37kvo3th89x.pdf?alt=media&token=db6a388c-039b-4bbd-bd91-b1164f292618	2020-11-24	183
\.


--
-- TOC entry 3899 (class 0 OID 3345607)
-- Dependencies: 205
-- Data for Name: inmueble; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.inmueble (id_inmueble, tipo_inmueble, direccion, descripcion, id_cliente) FROM stdin;
1	Casa	carrera 24d # 42a - 21	Casa segundo piso con garaje	96
3	Casa	Carrera 24D # 42a - 21	Casa segundo piso	96
295	Casa	Casa roja	Casa color rojo con garaje.	138
466	Casa	CALLE 25#34-3412	CASA BLANCA 22321	174
893	Apartamento	CALLE 25#34-34342342	apartamento bonito	174
\.


--
-- TOC entry 3900 (class 0 OID 3345615)
-- Dependencies: 206
-- Data for Name: proceso; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.proceso (id_proceso, nombre_proceso, estado, fecha_proceso, id_abogado, id_cliente, id_inmueble, info, pagado) FROM stdin;
36	Casa siempre	false	2020-11-24	0	96	1	\N	f
197	casa esta es	false	2020-11-24	0	96	3	\N	f
196	Casa roja aplicar	false	2020-11-24	0	96	295	\N	t
17	APLICAR INMUEBLE CASA	Activo	2020-11-24	0	183	295	todo salio 	t
\.


--
-- TOC entry 3901 (class 0 OID 3345623)
-- Dependencies: 207
-- Data for Name: tipo_cliente; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.tipo_cliente (id_tipo_cliente, nombre_tipo_cliente) FROM stdin;
1	Arrendatario
2	Arrendador
\.


--
-- TOC entry 3902 (class 0 OID 3345631)
-- Dependencies: 208
-- Data for Name: tipo_documento; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.tipo_documento (id_tipo_documento, nombre_documento, estado) FROM stdin;
1	Cedula ciudadania	S
2	Tarjeta Identidad	S
3	Pasaporte	S
\.


--
-- TOC entry 3903 (class 0 OID 3345639)
-- Dependencies: 209
-- Data for Name: tipo_usuario; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.tipo_usuario (id_tipo_usuario, nombre_usuario, estado) FROM stdin;
1	Cliente	S
2	Abogado	S
\.


--
-- TOC entry 3904 (class 0 OID 3345647)
-- Dependencies: 210
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: qvvxmeyukwlqvt
--

COPY public.usuario (id_usuario, correo_electronico, contrasena, id_tipo_usuario) FROM stdin;
54	pastor@gmail.com	pastor123	2
29	jc.guerrero1997@outlook.com	camilo0328	1
196	ejemplo@gmail.com	ejemplo	2
8	juanchico1997@hotmail.com	camilo01	1
62	pastorocampo@gmail.com	pastor123	1
10	sergio6006@gmail.com	sergio123	1
\.


--
-- TOC entry 3743 (class 2606 OID 3345590)
-- Name: abogado abogado_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.abogado
    ADD CONSTRAINT abogado_pk PRIMARY KEY (id_abogado);


--
-- TOC entry 3745 (class 2606 OID 3345598)
-- Name: cliente arrendatario_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT arrendatario_pk PRIMARY KEY (id_cliente);


--
-- TOC entry 3749 (class 2606 OID 3345614)
-- Name: inmueble inmueble_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.inmueble
    ADD CONSTRAINT inmueble_pk PRIMARY KEY (id_inmueble);


--
-- TOC entry 3747 (class 2606 OID 3345606)
-- Name: documentos persona_natural_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.documentos
    ADD CONSTRAINT persona_natural_pk PRIMARY KEY (id_documentos);


--
-- TOC entry 3751 (class 2606 OID 3345622)
-- Name: proceso proceso_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.proceso
    ADD CONSTRAINT proceso_pk PRIMARY KEY (id_proceso);


--
-- TOC entry 3753 (class 2606 OID 3345630)
-- Name: tipo_cliente tipo_cliente_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.tipo_cliente
    ADD CONSTRAINT tipo_cliente_pk PRIMARY KEY (id_tipo_cliente);


--
-- TOC entry 3755 (class 2606 OID 3345638)
-- Name: tipo_documento tipo_documento_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pk PRIMARY KEY (id_tipo_documento);


--
-- TOC entry 3757 (class 2606 OID 3345646)
-- Name: tipo_usuario tipo_usuario_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY (id_tipo_usuario);


--
-- TOC entry 3759 (class 2606 OID 3345654)
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id_usuario);


--
-- TOC entry 3760 (class 2606 OID 3345655)
-- Name: abogado abogado_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.abogado
    ADD CONSTRAINT abogado_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3761 (class 2606 OID 3345660)
-- Name: cliente arrendatario_tipo_documento_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT arrendatario_tipo_documento_fk FOREIGN KEY (id_tipo_documento) REFERENCES public.tipo_documento(id_tipo_documento);


--
-- TOC entry 3762 (class 2606 OID 3345665)
-- Name: cliente cliente_tipo_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_tipo_cliente_fk FOREIGN KEY (id_tipo_cliente) REFERENCES public.tipo_cliente(id_tipo_cliente);


--
-- TOC entry 3763 (class 2606 OID 3345670)
-- Name: cliente cliente_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3764 (class 2606 OID 3345675)
-- Name: documentos documentos_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.documentos
    ADD CONSTRAINT documentos_cliente_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- TOC entry 3765 (class 2606 OID 3345680)
-- Name: inmueble inmueble_arrendatario_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.inmueble
    ADD CONSTRAINT inmueble_arrendatario_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- TOC entry 3766 (class 2606 OID 3345685)
-- Name: proceso proceso_abogado_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.proceso
    ADD CONSTRAINT proceso_abogado_fk FOREIGN KEY (id_abogado) REFERENCES public.abogado(id_abogado);


--
-- TOC entry 3767 (class 2606 OID 3345690)
-- Name: proceso proceso_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.proceso
    ADD CONSTRAINT proceso_cliente_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- TOC entry 3768 (class 2606 OID 3345695)
-- Name: proceso proceso_inmueble_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.proceso
    ADD CONSTRAINT proceso_inmueble_fk FOREIGN KEY (id_inmueble) REFERENCES public.inmueble(id_inmueble);


--
-- TOC entry 3769 (class 2606 OID 3345700)
-- Name: usuario usuario_tipo_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: qvvxmeyukwlqvt
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY (id_tipo_usuario) REFERENCES public.tipo_usuario(id_tipo_usuario);


--
-- TOC entry 3910 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: qvvxmeyukwlqvt
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO qvvxmeyukwlqvt;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 3911 (class 0 OID 0)
-- Dependencies: 665
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO qvvxmeyukwlqvt;


-- Completed on 2020-11-24 01:40:39

--
-- PostgreSQL database dump complete
--

