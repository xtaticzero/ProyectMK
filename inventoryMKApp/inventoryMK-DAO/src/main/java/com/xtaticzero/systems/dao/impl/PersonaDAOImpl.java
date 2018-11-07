/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.impl;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.PersonaDTO;
import com.xtaticzero.systems.dao.BaseJDBCDao;
import com.xtaticzero.systems.dao.PersonaDAO;
import com.xtaticzero.systems.dao.mapper.PersonaMapper;
import com.xtaticzero.systems.dao.preparedstatement.PersonaPreparedStatement;
import com.xtaticzero.systems.dao.sql.PersonaSQL;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
@Repository("personaDAO")
public class PersonaDAOImpl extends BaseJDBCDao<PersonaDTO> implements PersonaDAO, PersonaSQL {

    private static final long serialVersionUID = 5946040317696107330L;

    @Override
    public PersonaDTO insert(PersonaDTO newPersona) throws DAOException {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            PreparedStatementCreator statement
                    = new PersonaPreparedStatement(newPersona);
            getJdbcTemplateBase().update(statement, keyHolder);
            newPersona.setPersonaId(new BigInteger(String.valueOf(keyHolder.getKey().intValue())));
            return newPersona;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public int update(PersonaDTO persona) throws DAOException {
        try {
            List<Object> params = new ArrayList<>();

            params.add(persona.getNombre());
            params.add(persona.getApellidoPaterno());
            params.add(persona.getApellidoMaterno());
            params.add(persona.getCorreoElectronico());
            params.add(persona.getDireccion());
            params.add(persona.getCelular());
            params.add(persona.getFechaNacimiento());
            params.add(persona.getPersonaId());

            return getJdbcTemplateBase().update(PERSONA_UPDATE, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public int delete(PersonaDTO persona) throws DAOException {
        if (persona == null || persona.getPersonaId() == null) {
            return 0;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(persona.getPersonaId());

            return getJdbcTemplateBase().update(PERSONA_DELET, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public int activate(PersonaDTO persona) throws DAOException {
        if (persona == null || persona.getPersonaId() != null) {
            return 0;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(persona.getPersonaId());

            return getJdbcTemplateBase().update(PERSONA_ACTIVATE, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<PersonaDTO> findAll() throws DAOException {
        try {

            return getJdbcTemplateBase().query(FIND_ALL, new PersonaMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<PersonaDTO> findByName(String name) throws DAOException {
        try {

            return getJdbcTemplateBase().query(FIND_BY_NOMBRE.replace(TERMINO, name), new PersonaMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<PersonaDTO> findByAPaterno(String aPaterno) throws DAOException {
        try {

            return getJdbcTemplateBase().query(FIND_BY_APATERNO.replace(TERMINO, aPaterno), new PersonaMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<PersonaDTO> findByAMaterno(String aMaterno) throws DAOException {
        try {

            return getJdbcTemplateBase().query(FIND_BY_APATERNO.replace(TERMINO, aMaterno), new PersonaMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

}
