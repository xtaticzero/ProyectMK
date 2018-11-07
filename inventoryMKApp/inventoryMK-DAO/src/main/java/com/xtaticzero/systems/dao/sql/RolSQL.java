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
public interface RolSQL extends BaseSQL {

    String ROL_TABLE = "CAT_ROL";

    String ROL_ID = " ROL.rol_id = ? ";
    String FECHA_TERMINO_EXPRESSION = ",ROL.fecha_termino = ?";

    String ROL_INSERT = " INSERT " + ROL_TABLE + "(descripcion) VALUES(?)";

    String ROL_UPDATE = " UPDATE CAT_ROL ROL SET ROL.descripcion = ?".concat(FECHA_TERMINO).concat(WHERE).concat(AND).concat(ROL_ID);

    String ROL_INACTIVATE = " UPDATE CAT_ROL ROL SET ROL.fecha_termino = SYSDATE() ".concat(WHERE).concat(AND).concat(ROL_ID);
    String ROL_ACTIVATE = " UPDATE CAT_ROL ROL SET ROL.fecha_termino = null ".concat(WHERE).concat(AND).concat(ROL_ID);
    ;

    String ROL_HEDER = " SELECT \n"
            + "ROL.rol_id,\n"
            + "ROL.descripcion,\n"
            + "ROL.fecha_entrada,\n"
            + "ROL.fecha_termino\n"
            + "FROM " + ROL_TABLE + " ROL ";

    String ROL_FIND_ALL = ROL_HEDER.concat(WHERE);

    String LIKE_DESCRIPCION = "ROL.descripcion LIKE '%{EXPRESION}%'";

    String ROL_FIND_DESCRIPCION = ROL_HEDER.concat(WHERE).concat(AND).concat(LIKE_DESCRIPCION);
    
    String ROL_FIND_ID = ROL_HEDER.concat(WHERE).concat(AND).concat(ROL_ID);

}
