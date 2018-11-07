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
public interface PersonaSQL extends BaseSQL {

    String PERSONA_TABLE = "PERSONA";
    String PERSONA_SHORT_TABLE = " PER ";
    
    String TERMINO = "{TERMINO}";
    String PERSONA_LIKE_NOMBRE = "PER.nombre LIKE '%"+TERMINO+"%'";
    String PERSONA_LIKE_APATERNO = "PER.apellido_paterno LIKE '%"+TERMINO+"%'";
    String PERSONA_LIKE_AMATERNO = "PER.apellido_materno LIKE '%"+TERMINO+"%'";

    String PERSONA_INSERT = "INSERT INTO \n"
            + PERSONA_TABLE
            + "(nombre,apellido_paterno,apellido_materno,correo_electronico,direccion,celular,fecha_nacimiento)\n"
            + "VALUES (?,?,?,?,?,?,?)";

    String PERSONA_UPDATE = "UPDATE " + PERSONA_TABLE + " \n"
            + "SET nombre=?,\n"
            + "apellido_paterno=?,\n"
            + "apellido_materno=?,\n"
            + "correo_electronico=?,\n"
            + "direccion=?,\n"
            + "celular=?,\n"
            + "fecha_nacimiento=?\n"
            + "WHERE persona_id=?";

    String PERSONA_DELET = "UPDATE " + PERSONA_TABLE + " \n"
            + "SET fecha_termino=SYSDATE()\n"
            + "WHERE persona_id=?";

    String PERSONA_ACTIVATE = "UPDATE " + PERSONA_TABLE + " \n"
            + "SET fecha_termino=NULL\n"
            + "WHERE persona_id=?";

    String SELECT_HEDER = "SELECT PER.persona_id,\n"
            + "PER.nombre,\n"
            + "PER.apellido_paterno,\n"
            + "PER.apellido_materno,\n"
            + "PER.correo_electronico,\n"
            + "PER.direccion,\n"
            + "PER.celular,\n"
            + "PER.fecha_nacimiento,\n"
            + "PER.fecha_entrada,\n"
            + "PER.fecha_termino\n"
            + "FROM PERSONA PER";
    
    String FIND_ALL = SELECT_HEDER.concat(WHERE).concat(ORDEY_BY).concat("PER.nombre");
    String FIND_BY_NOMBRE = SELECT_HEDER.concat(WHERE).concat(AND).concat(PERSONA_LIKE_NOMBRE).concat(ORDEY_BY).concat("PER.nombre");
    String FIND_BY_APATERNO = SELECT_HEDER.concat(WHERE).concat(AND).concat(PERSONA_LIKE_APATERNO).concat(ORDEY_BY).concat("PER.apellido_paterno");
    String FIND_BY_AMATERNO = SELECT_HEDER.concat(WHERE).concat(AND).concat(PERSONA_LIKE_AMATERNO).concat(ORDEY_BY).concat("PER.apellido_materno");

}
