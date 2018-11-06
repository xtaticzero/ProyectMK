/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.mapper;

import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.dao.util.RowsNames;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class RolMapper implements RowMapper<RolDTO>, RowsNames {

    @Override
    public RolDTO mapRow(ResultSet rs, int i) throws SQLException {
        RolDTO rol = new RolDTO();

        rol.setRolId(new BigInteger(rs.getString(ROL_ID)));
        rol.setDescripcion((rs.getString(ROL_DESCRIPCION)));
        rol.setFechaEntrada((rs.getTimestamp(ROL_FECHA_ENTRADA)));
        rol.setFechaTermino((rs.getTimestamp(ROL_FECHA_FIN)));

        return rol;
    }

}
