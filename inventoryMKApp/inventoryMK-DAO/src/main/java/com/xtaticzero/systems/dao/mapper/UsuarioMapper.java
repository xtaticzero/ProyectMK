/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.mapper;

import com.xtaticzero.systems.base.dto.UsuarioDTO;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class UsuarioMapper extends BaseAbstractMapper implements RowMapper<UsuarioDTO> {

    @Override
    public UsuarioDTO mapRow(ResultSet rs, int i) throws SQLException {
        UsuarioDTO usuario = new UsuarioDTO();

        usuario.setUserId(new BigInteger(rs.getString(USER_ID)));
        usuario.setDisplayName(rs.getString(USER_DISPLAY_NAME));
        usuario.setFechaEntrada(rs.getTimestamp(USER_FECHA_ENTRADA));
        usuario.setFechaTermino(rs.getTimestamp(USER_FECHA_TERMINO));

        usuario.setPersona(new PersonaMapper().mapRow(rs, i));
        usuario.setRol(new RolMapper().mapRow(rs, i));

        return usuario;
    }

}
