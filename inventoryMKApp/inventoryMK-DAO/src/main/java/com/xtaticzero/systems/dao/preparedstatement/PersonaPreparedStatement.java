/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.preparedstatement;

import com.xtaticzero.systems.base.dto.PersonaDTO;
import com.xtaticzero.systems.dao.sql.PersonaSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class PersonaPreparedStatement extends PreparedStatementBase implements PreparedStatementCreator,PersonaSQL{

    private final PersonaDTO newPersona;

    public PersonaPreparedStatement(PersonaDTO newPersona) {
        super();
        this.newPersona = newPersona;
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        int numParametro = PARAMETRO_INICIAL;
        try {
            ps = connection.prepareStatement(PERSONA_INSERT, new String[]{PERSONA_TABLE});
            //Se asignan id's de la propuesta
            ps.setObject(numParametro++, newPersona.getNombre());
            ps.setObject(numParametro++, newPersona.getApellidoPaterno());
            ps.setObject(numParametro++, newPersona.getApellidoMaterno());
            ps.setObject(numParametro++, newPersona.getCorreoElectronico());
            ps.setObject(numParametro++, newPersona.getDireccion());
            ps.setObject(numParametro++, newPersona.getCelular());
            ps.setObject(numParametro++, newPersona.getFechaNacimiento());
           
            fail = false;
        } catch (SQLException ex) {
            logger.error("No se pudo realizar la incercion:");
            logger.error(ex);
            throw ex;
        } finally {
            cerrarPS();
        }
        return ps;
    }

    public PersonaDTO getRol() {
        return newPersona;
    }
    
}
