--Data Application
USE STOCK_MARY_KAY_BBDD;
--ROLES DEL APLICATIVO
INSERT CAT_ROL(descripcion) VALUES('ADMINISTRADOR');
INSERT CAT_ROL(descripcion) VALUES('OPERADOR');
--USUARIOS DEL APLICATIVO
INSERT INTO USERS (email, display_name, password, rol_id)
VALUES ('user@dominio.com', 'admin', MD5('admin123'), 1);

SELECT 
USR.user_id,
USR.email,
USR.display_name,
USR.fecha_entrada,
USR.fecha_termino,
USR.rol_id,
ROL.descripcion,
ROL.rol_id,
ROL.fecha_entrada,
ROL.fecha_termino
FROM USERS USR
INNER JOIN CAT_ROL ROL on USR.rol_id = ROL.rol_id
WHERE 
USR.password = MD5('admin123')
and 
USR.display_name = 'admin';

SELECT 
ROL.rol_id,
ROL.descripcion,
ROL.fecha_entrada,
ROL.fecha_termino
FROM CAT_ROL ROL  WHERE 1=1;


 SELECT 
ROL.rol_id,
ROL.descripcion,
ROL.fecha_entrada,
ROL.fecha_termino
FROM CAT_ROL ROL  WHERE 1=1 
 AND 
ROL.descripcion LIKE 'OPERADOR%';