/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.util;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface RowsNames {

    String USER_ID = "USR.user_id";
    String USER_ROL_ID = "USR.rol_id";
    String USER_PERSONA_ID = "USR.persona_id";
    String USER_DISPLAY_NAME = "USR.display_name";
    String USER_FECHA_ENTRADA = "USR.fecha_entrada";
    String USER_FECHA_TERMINO = "USR.fecha_termino";

    String PERSONA_ID = "PER.persona_id";
    String PERSONA_NOMBRE = "PER.nombre";
    String PERSONA_APATERNO = "PER.apellido_paterno";
    String PERSONA_AMATERNO = "PER.apellido_materno";
    String PERSONA_EMAIL = "PER.correo_electronico";
    String PERSONA_DIRECCION = "PER.direccion";
    String PERSONA_CELULAR = "PER.celular";
    String PERSONA_FECHA_NACIMIENTO = "PER.fecha_nacimiento";
    String PERSONA_FECHA_ENTRADA = "PER.fecha_entrada";
    String PERSONA_FECHA_TERMINO = "PER.fecha_termino";

    String ROL_ID = "ROL.rol_id";
    String ROL_DESCRIPCION = "ROL.descripcion";
    String ROL_FECHA_ENTRADA = "ROL.fecha_entrada";
    String ROL_FECHA_FIN = "ROL.fecha_termino";

    String TOTAL = "total";

}
