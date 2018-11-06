/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.business.service.impl;

import com.xtaticzero.systems.base.constants.excepcion.impl.BusinessException;
import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.business.BaseBusinessServices;
import com.xtaticzero.systems.business.service.RolService;
import com.xtaticzero.systems.dao.RolDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
@Service("rolService")
public class RolServiceImpl extends BaseBusinessServices implements RolService {

    private static final long serialVersionUID = 1359108939243092568L;

    @Autowired
    @Qualifier("rolDAO")
    private RolDAO rolDAO;

    @Override
    public RolDTO insert(RolDTO newRol) throws BusinessException {
        try {
            if (newRol != null && newRol.getDescripcion() != null) {
                newRol.setDescripcion(newRol.getDescripcion().toUpperCase());
            }
            return rolDAO.insert(newRol);
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

    @Override
    public Integer update(RolDTO rol) throws BusinessException {
        try {
            if (rol != null && rol.getDescripcion() != null) {
                rol.setDescripcion(rol.getDescripcion().toUpperCase());
            }
            return rolDAO.update(rol);
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

    @Override
    public Integer delete(RolDTO newRol) throws BusinessException {
        try {
            return rolDAO.delete(newRol);
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

    @Override
    public List<RolDTO> findAll() throws BusinessException {
        try {
            return rolDAO.findAll();
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

    @Override
    public List<RolDTO> findByDescripcion(String descripcion) throws BusinessException {
        try {
            return rolDAO.findByDescripcion(descripcion);
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

    @Override
    public RolDTO findById(RolDTO rol) throws BusinessException {
        try {
            return rolDAO.findById(rol);
        } catch (DAOException daoEx) {
            logger.error(daoEx.getMessage(), daoEx);
            throw new BusinessException(ERR_GENERAL_DESCRIPCION, daoEx.getMessage(), daoEx);
        }
    }

}
