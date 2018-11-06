/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.dao.sql.RolSQL;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface RolDAO extends RolSQL {

    RolDTO insert(RolDTO newRol) throws DAOException;

    Integer update(RolDTO rol) throws DAOException;

    Integer delete(RolDTO newRol) throws DAOException;

    List<RolDTO> findAll() throws DAOException;
    
    List<RolDTO> findByDescripcion(String descripcion) throws DAOException;
    
    RolDTO findById(RolDTO rol) throws DAOException;

}
