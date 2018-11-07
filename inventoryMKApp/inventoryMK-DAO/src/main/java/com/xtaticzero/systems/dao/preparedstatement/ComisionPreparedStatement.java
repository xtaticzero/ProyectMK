/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.preparedstatement;

import com.xtaticzero.systems.base.dto.ComisionDTO;
import com.xtaticzero.systems.dao.sql.ComisionSQL;
import com.xtaticzero.systems.dao.sql.PersonaSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class ComisionPreparedStatement extends PreparedStatementBase implements PreparedStatementCreator, ComisionSQL {

    private final ComisionDTO newComision;

    public ComisionPreparedStatement(ComisionDTO newComision) {
        super();
        this.newComision = newComision;
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        int numParametro = PARAMETRO_INICIAL;
        try {
            ps = connection.prepareStatement(COMISION_INSERT, new String[]{COMISION_TABLE});
            //Se asignan id's de la propuesta
            ps.setObject(numParametro++, newComision.getDescripcion());
            ps.setObject(numParametro++, newComision.getPorcentaje());
            
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

    public ComisionDTO getNewComision() {
        return newComision;
    }

}
