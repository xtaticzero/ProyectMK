/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.sql;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface UsuarioSQL {

    String SQL_INSERT_USER = "INSERT INTO USERS (email, display_name, password, fecha)\n"
            + "VALUES (?, ?, MD5(?), SYSDATE())";

    String USER_ID = "USR.user_id = ?";
    String DISPLAY_NAME = "USR.display_name = ?";
    String E_MAIL = "USR.email = ?";
    String ROL = "USR.rol_id = ?";

    String SQL_UPDATE_USER = "UPDATE USERS SET email = ?, display_name = ?, password = MD5(?) WHERE user_id = ?";

    String SQL_DELETE_USER = "UPDATE USERS SET fechaTermino = SYSDATE() WHERE user_id = ?";

    String SQL_FIND_HEDER = "SELECT \n"
            + "USR.user_id,\n"
            + "USR.email,\n"
            + "USR.display_name,\n"
            + "USR.fecha,\n"
            + "USR.fechaTermino,\n"
            + "USR.rol_id,\n"
            + "ROL.descripcion\n"
            + "FROM USERS USR\n"
            + "INNER JOIN CAT_ROL ROL on USR.rol_id = ROL.rol_id\n"
            + "WHERE ";

    String SQL_FIND_BY_NAME = SQL_FIND_HEDER.concat(USER_ID);

    String SQL_FIND_BY_ROL = SQL_FIND_HEDER.concat(ROL);

    String SQL_FIND_BY_EMAIL = SQL_FIND_HEDER.concat(E_MAIL);

    String SQL_FIND_BY_ALL = SQL_FIND_HEDER.concat("1=1");

    String SQL_LOGGIN = "SELECT \n"
            + "USR.user_id,\n"
            + "USR.email,\n"
            + "USR.display_name,\n"
            + "USR.fecha_entrada,\n"
            + "USR.fecha_termino,\n"
            + "USR.rol_id,\n"
            + "ROL.descripcion,\n"
            + "ROL.rol_id,\n"
            + "ROL.fecha_entrada,\n"
            + "ROL.fecha_termino\n"
            + "FROM USERS USR\n"
            + "INNER JOIN CAT_ROL ROL on USR.rol_id = ROL.rol_id\n"
            + "WHERE \n"
            + "USR.password = MD5(?)\n"
            + "AND \n"
            + "USR.display_name = ? ";

}
