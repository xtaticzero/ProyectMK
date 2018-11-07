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
public interface UsuarioSQL extends BaseSQL {

    String USER_NAME = " USR.display_name = ? ";
    String USER_PASSWORD = " USR.password = MD5(?) ";
    String USER_ID = "USR.user_id = ?";
    String USER_ROL = "USR.rol_id = ?";

    String SQL_INSERT_USER = "INSERT INTO USERS (persona_id,rol_id, display_name, password)\n"
            + "VALUES (?,?,?, MD5(?))";

    String USER_ACTIVE = " AND USR.fecha_termino IS NULL ";

    String SQL_UPDATE_USER = "UPDATE USERS USR SET "
            + "USR.persona_id = ?,"
            + "USR.rol_id = ?,"
            + "USR.display_name = ? "
            + "WHERE USR.user_id = ?";

    String SQL_DELETE_USER = "UPDATE USERS SET fecha_termino = SYSDATE() WHERE user_id = ?";

    String SQL_ACTIVATE_USER = "UPDATE USERS SET fecha_termino = NULL WHERE user_id = ?";

    String SQL_FIND_HEDER = "SELECT \n"
            + "USR.user_id,\n"
            + "USR.persona_id,\n"
            + "USR.rol_id,\n"
            + "USR.display_name,\n"
            + "USR.fecha_entrada,\n"
            + "USR.fecha_termino,\n"
            + "PER.persona_id,\n"
            + "PER.nombre,\n"
            + "PER.apellido_paterno,\n"
            + "PER.apellido_materno,\n"
            + "PER.correo_electronico,\n"
            + "PER.direccion,\n"
            + "PER.celular,\n"
            + "PER.fecha_nacimiento,\n"
            + "PER.fecha_entrada,\n"
            + "PER.fecha_termino,\n"
            + "ROL.rol_id,\n"
            + "ROL.descripcion,\n"
            + "ROL.fecha_entrada,\n"
            + "ROL.fecha_termino\n"
            + "FROM USERS USR\n"
            + "INNER JOIN CAT_ROL ROL ON USR.rol_id = ROL.rol_id\n"
            + "INNER JOIN PERSONA PER ON PER.persona_id = USR.persona_id\n";

    String SQL_FIND_BY_NAME = SQL_FIND_HEDER.concat(WHERE).concat(AND).concat(USER_NAME);

    String SQL_FIND_BY_ROL = SQL_FIND_HEDER.concat(WHERE).concat(AND).concat(USER_ROL);

    String SQL_FIND_BY_ALL = SQL_FIND_HEDER.concat("1=1");

    String SQL_LOGGIN = SQL_FIND_HEDER.concat(WHERE).concat(AND).concat(USER_PASSWORD).concat(AND).concat(USER_NAME);

}
