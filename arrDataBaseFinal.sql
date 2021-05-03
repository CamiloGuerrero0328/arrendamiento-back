CREATE TABLE abogado (
    id_abogado           INTEGER NOT NULL,
    nombre_abogado       VARCHAR,
    apellido_abogado     VARCHAR,
    telefono_abogado     NUMERIC,
    correo_electronico   VARCHAR,
    estado               VARCHAR,
    id_usuario   	 INTEGER NOT NULL
);

ALTER TABLE abogado ADD CONSTRAINT abogado_pk PRIMARY KEY ( id_abogado );

CREATE TABLE cliente (
    id_cliente                     INTEGER NOT NULL,
    nombre_cliente                 VARCHAR,
    apellido_cliente               VARCHAR,
    telefono_cliente               NUMERIC,
    id_tipo_documento              INTEGER NOT NULL,
    documento                      VARCHAR,
    id_usuario             	   INTEGER NOT NULL,
    id_tipo_cliente   		   INTEGER NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT arrendatario_pk PRIMARY KEY ( id_cliente );

CREATE TABLE documentos (
    id_documentos             INTEGER NOT NULL,
    carta_laboral             VARCHAR,
    rut                       VARCHAR,
    solicitud_arrendamiento   VARCHAR,
    cedula_ciudadania         VARCHAR,
    codeudor                  VARCHAR,
    fecha_ingreso             DATE NOT NULL,
    id_cliente        	      INTEGER NOT NULL
);

ALTER TABLE documentos ADD CONSTRAINT persona_natural_pk PRIMARY KEY ( id_documentos );

CREATE TABLE inmueble (
    id_inmueble                    INTEGER NOT NULL,
    tipo_inmueble                  VARCHAR,
    direccion                      VARCHAR,
    descripcion                    VARCHAR,
    id_cliente   		   INTEGER NOT NULL
);

ALTER TABLE inmueble ADD CONSTRAINT inmueble_pk PRIMARY KEY ( id_inmueble );

CREATE TABLE proceso (
    id_proceso           INTEGER NOT NULL,
    nombre_proceso       VARCHAR,
    estado               VARCHAR,
    fecha_proceso        DATE,
    id_abogado   	 INTEGER,
    id_cliente   	 INTEGER NOT NULL,
    id_inmueble  	 INTEGER NOT NULL,
    info		 VARCHAR,
    pagado 		 BOOLEAN,
);

ALTER TABLE proceso ADD CONSTRAINT proceso_pk PRIMARY KEY ( id_proceso );

CREATE TABLE tipo_cliente (
    id_tipo_cliente       INTEGER NOT NULL,
    nombre_tipo_cliente   VARCHAR
);

ALTER TABLE tipo_cliente ADD CONSTRAINT tipo_cliente_pk PRIMARY KEY ( id_tipo_cliente );

CREATE TABLE tipo_documento (
    id_tipo_documento   INTEGER NOT NULL,
    nombre_documento    VARCHAR,
    estado              VARCHAR
);

ALTER TABLE tipo_documento ADD CONSTRAINT tipo_documento_pk PRIMARY KEY ( id_tipo_documento );

CREATE TABLE tipo_usuario (
    id_tipo_usuario   INTEGER NOT NULL,
    nombre_usuario    VARCHAR,
    estado            VARCHAR
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( id_tipo_usuario );

CREATE TABLE usuario (
    id_usuario                     INTEGER NOT NULL,
    correo_electronico             VARCHAR,
    contrasena                     VARCHAR,
    id_tipo_usuario   		   INTEGER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE abogado
    ADD CONSTRAINT abogado_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE cliente
    ADD CONSTRAINT arrendatario_tipo_documento_fk FOREIGN KEY ( id_tipo_documento )
        REFERENCES tipo_documento ( id_tipo_documento );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_tipo_cliente_fk FOREIGN KEY ( id_tipo_cliente )
        REFERENCES tipo_cliente ( id_tipo_cliente );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE documentos
    ADD CONSTRAINT documentos_cliente_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE inmueble
    ADD CONSTRAINT inmueble_arrendatario_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE proceso
    ADD CONSTRAINT proceso_abogado_fk FOREIGN KEY ( id_abogado )
        REFERENCES abogado ( id_abogado );

ALTER TABLE proceso
    ADD CONSTRAINT proceso_cliente_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE proceso
    ADD CONSTRAINT proceso_inmueble_fk FOREIGN KEY ( id_inmueble )
        REFERENCES inmueble ( id_inmueble );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY ( id_tipo_usuario )
        REFERENCES tipo_usuario ( id_tipo_usuario );

