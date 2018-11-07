--Data Application
USE STOCK_MARY_KAY_BBDD;
--ROLES DEL APLICATIVO
INSERT CAT_ROL(descripcion) VALUES('ADMINISTRADOR');
INSERT CAT_ROL(descripcion) VALUES('OPERADOR');
--INSERT PERSONA
INSERT INTO PERSONA (nombre,apellido_paterno,apellido_materno,correo_electronico,direccion,celular,fecha_nacimiento)
VALUES ('Martha Patricia','Ojeda','Aviles','patyojeda43@gmail.com', 'Poniente 11 No289 Colonia La perla Nezahualcóyotl', '5560092236', '1987-06-05');
--USUARIOS DEL APLICATIVO
INSERT INTO USERS (persona_id,rol_id, display_name, password)
VALUES (1,1,'admin', MD5('admin123'));

SELECT * from users; 

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

SELECT * from users;

SELECT 
USR.user_id,
USR.persona_id,
USR.rol_id,
USR.display_name,
USR.fecha_entrada,
USR.fecha_termino,
PER.persona_id,
PER.nombre,
PER.apellido_paterno,
PER.apellido_materno,
PER.correo_electronico,
PER.direccion,
PER.celular,
PER.fecha_nacimiento,
PER.fecha_entrada,
PER.fecha_termino,
ROL.rol_id,
ROL.descripcion,
ROL.fecha_entrada,
ROL.fecha_termino
FROM USERS USR
INNER JOIN CAT_ROL ROL ON USR.rol_id = ROL.rol_id
INNER JOIN PERSONA PER ON PER.persona_id = USR.persona_id
WHERE 
USR.password = MD5('admin123')
AND 
USR.display_name = 'admin'
AND USR.fecha_termino IS NULL;


UPDATE USERS USR SET 
USR.persona_id = ?,
USR.rol_id = ?,
USR.display_name = ?,
USR.password = MD5(?)
WHERE USR.user_id = ?

INSERT INTO 
PERSONA(nombre,apellido_paterno,apellido_materno,correo_electronico,direccion,celular,fecha_nacimiento)
VALUES (?,?,?,?,?,?,?);

UPDATE PERSONA 
SET fecha_termino=SYSDATE()
WHERE persona_id=?;

SELECT PER.persona_id,
PER.nombre,
PER.apellido_paterno,
PER.apellido_materno,
PER.correo_electronico,
PER.direccion,
PER.celular,
PER.fecha_nacimiento,
PER.fecha_entrada,
PER.fecha_termino
FROM PERSONA PER
WHERE PER.nombre LIKE '%A%' ORDER BY PER.nombre;
;

SELECT PER.persona_id,
PER.nombre,
PER.apellido_paterno,
PER.apellido_materno,
PER.correo_electronico,
PER.direccion,
PER.celular,
PER.fecha_nacimiento,
PER.fecha_entrada,
PER.fecha_termino
FROM PERSONA PER WHERE 1=1 
 ORDER BY 
PER.nombre;

SELECT 
COM.comision_id,
COM.descripcion,
COM.porcentaje,
COM.fecha_entrada,
COM.fecha_termino
FROM CAT_COMISIONES COM;

INSERT INTO CAT_COMISIONES(descripcion,porcentaje)
VALUES('MK',34.5);

UPDATE CAT_COMISIONES 
SET COM.fecha_termino = SYSDATE()
WHERE COM.comision_id = ?;

UPDATE CAT_COMISIONES COM 
SET COM.descripcion = 'MK',
COM.porcentaje = 3.3
WHERE COM.comision_id = 1;