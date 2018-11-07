/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.impl;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.ComisionDTO;
import com.xtaticzero.systems.dao.BaseJDBCDao;
import com.xtaticzero.systems.dao.ComisionDAO;
import com.xtaticzero.systems.dao.mapper.ComisionMapper;
import com.xtaticzero.systems.dao.preparedstatement.ComisionPreparedStatement;
import com.xtaticzero.systems.dao.sql.ComisionSQL;
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
@Repository("comisionDAO")
public class ComisionDAOImpl extends BaseJDBCDao<ComisionDTO> implements ComisionDAO, ComisionSQL {

    private static final long serialVersionUID = 8781343142158871148L;

    @Override
    public ComisionDTO insert(ComisionDTO newComision) throws DAOException {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {

            List<ComisionDTO> resultLst = findByDescripcion(newComision.getDescripcion());

            if (resultLst != null && !resultLst.isEmpty()) {
                for (ComisionDTO comisionDTO : resultLst) {
                    if (comisionDTO.getDescripcion().equalsIgnoreCase(newComision.getDescripcion())) {
                        logger.error("La comision esta repetida");
                        throw new DAOException(ERR_GENERAL, "La comision esta repetida");
                    }
                }
            }

            PreparedStatementCreator statement
                    = new ComisionPreparedStatement(newComision);
            getJdbcTemplateBase().update(statement, keyHolder);
            newComision.setComisionId(new BigInteger(String.valueOf(keyHolder.getKey().intValue())));
            return newComision;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public Integer update(ComisionDTO comision) throws DAOException {
        if (comision == null || comision.getComisionId() == null || comision.getDescripcion() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {
            List<Object> params = new ArrayList<>();

            params.add(comision.getDescripcion());
            params.add(comision.getPorcentaje());
            params.add(comision.getComisionId());

            return getJdbcTemplateBase().update(COMISION_UPDATE, params.toArray());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public Integer delete(ComisionDTO comision) throws DAOException {
        if (comision == null || comision.getComisionId() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {

            List<Object> params = new ArrayList<>();

            params.add(comision.getComisionId());

            return getJdbcTemplateBase().update(COMISION_INACTIVATE, params.toArray());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public Integer activate(ComisionDTO comision) throws DAOException {
        if (comision == null || comision.getComisionId() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {

            List<Object> params = new ArrayList<>();

            params.add(comision.getComisionId());

            return getJdbcTemplateBase().update(COMISION_ACTIVATE, params.toArray());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<ComisionDTO> findAll() throws DAOException {
        try {
            return getJdbcTemplateBase().query(COMISION_FIND_ALL, new ComisionMapper());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<ComisionDTO> findByDescripcion(String descripcion) throws DAOException {
        if (descripcion == null) {
            throw new DAOException(ERR_GENERAL, "No hay descripcion de busqueda");
        }
        try {
            return getJdbcTemplateBase().query(COMISION_FIND_DESCRIPCION.replace(EXPRESION, descripcion), new ComisionMapper());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public ComisionDTO findById(ComisionDTO comision) throws DAOException {
        if (comision == null || comision.getComisionId() == null) {
            throw new DAOException(ERR_GENERAL);
        }
        try {

            List<Object> params = new ArrayList<>();

            params.add(comision.getComisionId());

            return getJdbcTemplateBase().queryForObject(COMISION_FIND_ID, params.toArray(), new ComisionMapper());
        } catch (EmptyResultDataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

}
