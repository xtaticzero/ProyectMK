/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.preparedstatement;

import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.dao.sql.RolSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class RolPreparedStatement extends PreparedStatementBase implements PreparedStatementCreator {

    private final RolDTO newRol;

    public RolPreparedStatement(RolDTO newRol) {
        super();
        this.newRol = newRol;
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        int numParametro = PARAMETRO_INICIAL;
        try {
            ps = connection.prepareStatement(RolSQL.ROL_INSERT, new String[]{RolSQL.ROL_TABLE});
            //Se asignan id's de la propuesta
            ps.setObject(numParametro++, newRol.getDescripcion());
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

    public RolDTO getRol() {
        return newRol;
    }

}
