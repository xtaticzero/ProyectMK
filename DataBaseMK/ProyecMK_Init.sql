SHOW VARIABLES LIKE "%version%";
--Init
CREATE DATABASE IF NOT EXISTS STOCK_MARY_KAY_BBDD CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'user_market'@'localhost' IDENTIFIED BY 'P@55W0rd007';
GRANT CREATE ON STOCK_MARY_KAY_BBDD.* TO 'user_market'@'localhost';
GRANT INSERT ON STOCK_MARY_KAY_BBDD.* TO 'user_market'@'localhost';
GRANT SELECT ON STOCK_MARY_KAY_BBDD.* TO 'user_market'@'localhost';
GRANT UPDATE ON STOCK_MARY_KAY_BBDD.* TO 'user_market'@'localhost';

CREATE TABLE STOCK_MARY_KAY_BBDD.CAT_ROL (
    rol_id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (rol_id)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.PERSONA (
    persona_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    apellido_paterno VARCHAR(60) NOT NULL,
    apellido_materno VARCHAR(60) NOT NULL,
    correo_electronico VARCHAR(60) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    celular VARCHAR(15) NOT NULL,
    fecha_nacimiento DATETIME,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (persona_id)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.USERS (
    user_id INT NOT NULL AUTO_INCREMENT,
    persona_id INT NOT NULL,
    rol_id INT NOT NULL,
    display_name VARCHAR(50) NOT NULL,
    password CHAR(41) NOT NULL,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,    
    PRIMARY KEY (user_id)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.CAT_COMISIONES (
    comision_id INT NOT NULL AUTO_INCREMENT,
    porcentaje DOUBLE NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (comision_id)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.CAT_FABRICANTE (
    id_fabricante INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    correo_electronico VARCHAR(60) NOT NULL,
    sitio_web VARCHAR(200) NOT NULL,
    descripcion VARCHAR(200),
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (id_fabricante)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.CAT_CATEGORIA (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (id_categoria)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.ASOCIACION_CATEGORIAS (
    id_asociacion_categoria INT NOT NULL AUTO_INCREMENT,
    id_categoria INT NOT NULL,
    id_parent_categoria INT,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (id_asociacion_categoria)
) ENGINE=INNODB;

CREATE TABLE STOCK_MARY_KAY_BBDD.PRODUCTO (
    id_producto INT NOT NULL AUTO_INCREMENT,
    id_fabricante INT NOT NULL,
    id_asociacion_categoria INT NOT NULL,
    codigo VARCHAR(10) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    costo_catalogo DOUBLE NOT NULL,
    costo_real DOUBLE NOT NULL,
    numero_unidades INT NOT NULL DEFAULT 0,
    fecha_entrada DATETIME DEFAULT NOW(),
    fecha_termino DATETIME,
    PRIMARY KEY (id_producto)
) ENGINE=INNODB;


--Constraint DB
ALTER TABLE STOCK_MARY_KAY_BBDD.USERS ADD CONSTRAINT fk_rol_id FOREIGN KEY (rol_id) REFERENCES STOCK_MARY_KAY_BBDD.CAT_ROL(rol_id);
ALTER TABLE STOCK_MARY_KAY_BBDD.USERS ADD CONSTRAINT fk_persona_id FOREIGN KEY (persona_id) REFERENCES STOCK_MARY_KAY_BBDD.PERSONA(persona_id);
ALTER TABLE STOCK_MARY_KAY_BBDD.ASOCIACION_CATEGORIAS ADD CONSTRAINT fk_categoria_id FOREIGN KEY (id_categoria) REFERENCES STOCK_MARY_KAY_BBDD.CAT_CATEGORIA(id_categoria);
ALTER TABLE STOCK_MARY_KAY_BBDD.PRODUCTO ADD CONSTRAINT fk_proveedor_id FOREIGN KEY (id_fabricante) REFERENCES STOCK_MARY_KAY_BBDD.CAT_FABRICANTE(id_fabricante);
ALTER TABLE STOCK_MARY_KAY_BBDD.PRODUCTO ADD CONSTRAINT fk_asociacion_categoria_id FOREIGN KEY (id_asociacion_categoria) REFERENCES STOCK_MARY_KAY_BBDD.ASOCIACION_CATEGORIAS(id_asociacion_categoria);


--ROLL BACK
REVOKE ALL PRIVILEGES STOCK_MARY_KAY_BBDD.* FROM 'user_market'@'localhost';
DROP USER 'user_market'@'localhost';
DROP DATABASE IF EXISTS STOCK_MARY_KAY_BBDD;


