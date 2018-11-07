/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.mapper;

import com.xtaticzero.systems.base.dto.PersonaDTO;
import com.xtaticzero.systems.dao.util.RowsNames;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class PersonaMapper implements RowMapper<PersonaDTO>, RowsNames {

    @Override
    public PersonaDTO mapRow(ResultSet rs, int i) throws SQLException { 
        PersonaDTO persona = new PersonaDTO();
        
        persona.setPersonaId(new BigInteger(rs.getString(PERSONA_ID)));
        persona.setNombre(rs.getString(PERSONA_NOMBRE));
        persona.setApellidoPaterno(rs.getString(PERSONA_APATERNO));
        persona.setApellidoMaterno(rs.getString(PERSONA_AMATERNO));
        persona.setCorreoElectronico(rs.getString(PERSONA_EMAIL));
        persona.setDireccion(rs.getString(PERSONA_DIRECCION));
        persona.setFechaNacimiento(rs.getTimestamp(PERSONA_FECHA_NACIMIENTO));
        persona.setFechaEntrada(rs.getTimestamp(PERSONA_FECHA_ENTRADA));
        persona.setFechaTermino(rs.getTimestamp(PERSONA_FECHA_TERMINO));
        
        return persona;
    }
    
}
