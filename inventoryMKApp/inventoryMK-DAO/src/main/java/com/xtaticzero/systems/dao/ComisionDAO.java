/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.ComisionDTO;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface ComisionDAO {
    ComisionDTO insert(ComisionDTO newComision) throws DAOException;

    Integer update(ComisionDTO comision) throws DAOException;

    Integer delete(ComisionDTO comision) throws DAOException;
    
    Integer activate(ComisionDTO comision) throws DAOException;

    List<ComisionDTO> findAll() throws DAOException;
    
    List<ComisionDTO> findByDescripcion(String descripcion) throws DAOException;
    
    ComisionDTO findById(ComisionDTO comision) throws DAOException;
}
