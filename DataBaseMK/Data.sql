--Data Application
USE STOCK_MARY_KAY_BBDD;
--ROLES DEL APLICATIVO
INSERT CAT_ROL(descripcion) VALUES('ADMINISTRADOR');
INSERT CAT_ROL(descripcion) VALUES('OPERADOR');
--USUARIOS DEL APLICATIVO
INSERT INTO USERS (email, display_name, password, rol_id)
VALUES ('user@dominio.com', 'admin', MD5('admin123'), 1);

select USR.user_id,
            USR.email,
            USR.display_name,
            USR.fecha_entrada,
            USR.fecha_termino,
            USR.rol_id,
            ROL.descripcion
            from USERS USR
            inner join CAT_ROL on USR.rol_id = CAT_ROL.rol_id
            where 
            USR.password = MD5('admin123')
            and 
            USR.display_name = 'admin';