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
public interface ComisionSQL extends BaseSQL {

    String COMISION_TABLE = "CAT_COMISIONES";
    String COMISION_TABLE_SHORT = "COM";

    String COMISION_INSERT = "INSERT INTO CAT_COMISIONES(descripcion,porcentaje)\n"
            + "VALUES(?,?)";

    String COMISION_UPDATE = "UPDATE " + COMISION_TABLE + " " + COMISION_TABLE_SHORT + " \n"
            + "SET COM.descripcion = ?,\n"
            + "COM.porcentaje = ?\n"
            + "WHERE COM.comision_id = ?";

    String COMISION_INACTIVATE = "UPDATE " + COMISION_TABLE + " " + COMISION_TABLE_SHORT + " \n"
            + "SET COM.fecha_termino = SYSDATE()\n"
            + "WHERE COM.comision_id = ?";

    String COMISION_ACTIVATE = "UPDATE " + COMISION_TABLE + " " +COMISION_TABLE_SHORT + " \n"
            + "SET COM.fecha_termino = NULL\n"
            + "WHERE COM.comision_id = ?";

    String COMISION_HEDER = "SELECT \n"
            + "COM.comision_id,\n"
            + "COM.descripcion,\n"
            + "COM.porcentaje,\n"
            + "COM.fecha_entrada,\n"
            + "COM.fecha_termino\n"
            + "FROM " + COMISION_TABLE + " COM";

    String COMISION_FIND_ALL = COMISION_HEDER.concat(WHERE);

    String COMISION_LIKE_DESCRIPCION = "COM.descripcion LIKE '%" + EXPRESION + "%'";

    String COMISION_FIND_DESCRIPCION = COMISION_HEDER.concat(WHERE).concat(AND).concat(COMISION_LIKE_DESCRIPCION);

    String COMISION_FIND_ID = COMISION_HEDER.concat(WHERE).concat(AND).concat("COM.comision_id = ?");
}
