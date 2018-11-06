/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.mapper;

import com.xtaticzero.systems.base.dto.UsuarioDTO;
import com.xtaticzero.systems.dao.util.RowsNames;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class UsuarioMapper implements RowMapper<UsuarioDTO>,RowsNames {

    @Override
    public UsuarioDTO mapRow(ResultSet rs, int i) throws SQLException {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setDisplay_name(rs.getString(USER_DISPLAY_NAME));
        usuario.setUser_id(new BigInteger(rs.getString(USER_ID)));
        usuario.setRol_id(new BigInteger(rs.getString(USR_ROL_ID)));
        usuario.setEmail(rs.getString(USER_EMAIL));
        usuario.setFecha(rs.getTimestamp(USER_FECHA_ENTRADA));
        usuario.setFecha(rs.getTimestamp(USER_FECHA_TERMINO));
        
        usuario.setRol(new RolMapper().mapRow(rs, i));

        return usuario;
    }

}
