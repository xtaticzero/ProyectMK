/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.impl;

import com.xtaticzero.systems.dao.preparedstatement.RolPreparedStatement;
import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.dao.BaseJDBCDao;
import com.xtaticzero.systems.dao.RolDAO;
import com.xtaticzero.systems.dao.mapper.RolMapper;
import com.xtaticzero.systems.dao.sql.RolSQL;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
@Repository("rolDAO")
public class RolDAOImpl extends BaseJDBCDao<RolDTO> implements RolDAO, RolSQL {

    private static final long serialVersionUID = -6243803751227731383L;

    @Override
    public RolDTO insert(RolDTO newRol) throws DAOException {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            PreparedStatementCreator statement
                    = new RolPreparedStatement(newRol);
            getJdbcTemplateBase().update(statement, keyHolder);
            newRol.setRolId(new BigInteger(String.valueOf(keyHolder.getKey().intValue())));
            return newRol;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public Integer update(RolDTO rol) throws DAOException {
        if (rol == null || rol.getRolId() == null || rol.getDescripcion() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {
            List<Object> params = new ArrayList<>();

            params.add(rol.getDescripcion());
            params.add(rol.getRolId());

            return getJdbcTemplateBase().update(ROL_UPDATE.replace(FECHA_TERMINO, ""), params.toArray());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public Integer delete(RolDTO rol) throws DAOException {
        if (rol == null || rol.getRolId() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {

            List<Object> params = new ArrayList<>();

            params.add(rol.getDescripcion());
            params.add(rol.getRolId());

            return getJdbcTemplateBase().update(ROL_INACTIVATE, params.toArray());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<RolDTO> findAll() throws DAOException {
        try {
            return getJdbcTemplateBase().query(ROL_INACTIVATE, new RolMapper());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<RolDTO> findByDescripcion(String descripcion) throws DAOException {
        try {
            return getJdbcTemplateBase().query(ROL_FIND_DESCRIPCION, new RolMapper());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public RolDTO findById(RolDTO rol) throws DAOException {
        try {
            return getJdbcTemplateBase().queryForObject(ROL_FIND_ID, new RolMapper());
        } catch (EmptyResultDataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

}
