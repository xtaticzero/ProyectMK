--Data Application
USE STOCK_MARY_KAY_BBDD;
--ROLES DEL APLICATIVO
INSERT CAT_ROL(descripcion) VALUES('ADMINISTRADOR');
INSERT CAT_ROL(descripcion) VALUES('OPERADOR');
--USUARIOS DEL APLICATIVO
INSERT INTO USERS (email, display_name, password, rol_id)
VALUES ('user@dominio.com', 'admin', MD5('admin123'), 1);