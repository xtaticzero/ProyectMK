/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao.impl;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.UsuarioDTO;
import com.xtaticzero.systems.dao.BaseJDBCDao;
import com.xtaticzero.systems.dao.UserDao;
import com.xtaticzero.systems.dao.sql.UsuarioSQL;
import com.xtaticzero.systems.dao.mapper.UsuarioMapper;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
@Repository("userDao")
public class UserDAOImpl extends BaseJDBCDao<UsuarioDTO> implements UserDao, UsuarioSQL {

    private static final long serialVersionUID = -6351443720713415227L;

    @Override
    public int insert(UsuarioDTO usuario) throws DAOException {
        if (usuario == null || usuario.getPersona() == null || usuario.getPersona().getPersonaId() == null) {
            return 0;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(usuario.getPersona().getPersonaId());
            params.add(usuario.getRol().getRolId());
            params.add(usuario.getDisplayName());
            params.add(usuario.getPassword());

            return getJdbcTemplateBase().update(UsuarioSQL.SQL_INSERT_USER, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public int update(UsuarioDTO usuario) throws DAOException {
        if (usuario != null && usuario.getPersona() != null && usuario.getPersona().getPersonaId() != null) {

            try {
                List<Object> params = new ArrayList<>();

                params.add(usuario.getPersona().getPersonaId());
                params.add(usuario.getRol().getRolId());
                params.add(usuario.getDisplayName());
                params.add(usuario.getUserId());

                return getJdbcTemplateBase().update(UsuarioSQL.SQL_UPDATE_USER, params.toArray());

            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
                throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
            }

        } else {
            return 0;
        }

    }

    @Override
    public int delete(UsuarioDTO usuario) throws DAOException {
        if (usuario == null || usuario.getUserId() != null) {
            return 0;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(usuario.getUserId());

            return getJdbcTemplateBase().update(UsuarioSQL.SQL_DELETE_USER, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }
    
    @Override
    public int activate(UsuarioDTO usuario) throws DAOException {
        if (usuario == null || usuario.getUserId() != null) {
            return 0;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(usuario.getUserId());

            return getJdbcTemplateBase().update(UsuarioSQL.SQL_ACTIVATE_USER, params.toArray());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<UsuarioDTO> findAll() throws DAOException {
        try {

            return getJdbcTemplateBase().query(UsuarioSQL.SQL_FIND_BY_ALL, new UsuarioMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }

    }

    @Override
    public UsuarioDTO findName(String name) throws DAOException {
        if (name == null) {
            return null;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(name);

            return getJdbcTemplateBase().queryForObject(UsuarioSQL.SQL_FIND_BY_NAME, params.toArray(), new UsuarioMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public List<UsuarioDTO> findRol(BigInteger idRol) throws DAOException {
        if (idRol == null) {
            return null;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(idRol);

            return getJdbcTemplateBase().query(UsuarioSQL.SQL_FIND_BY_ROL, params.toArray(), new UsuarioMapper());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

    @Override
    public UsuarioDTO passwordValido(UsuarioDTO usuario) throws DAOException {
        if (usuario == null) {
            return null;
        }

        try {

            List<Object> params = new ArrayList<>();

            params.add(usuario.getPassword());
            params.add(usuario.getDisplayName());

            return getJdbcTemplateBase().queryForObject(SQL_LOGGIN.concat(USER_ACTIVE), params.toArray(), new UsuarioMapper());

        } catch (EmptyResultDataAccessException emty) {
            return null;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new DAOException(ERR_GENERAL, ex.getMessage(), ex);
        }
    }

}
