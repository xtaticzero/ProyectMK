/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.business.service;

import com.xtaticzero.systems.base.constants.excepcion.impl.BusinessException;
import com.xtaticzero.systems.base.dto.RolDTO;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface RolService {

    RolDTO insert(RolDTO newRol) throws BusinessException;

    Integer update(RolDTO rol) throws BusinessException;

    Integer delete(RolDTO newRol) throws BusinessException;

    List<RolDTO> findAll() throws BusinessException;

    List<RolDTO> findByDescripcion(String descripcion) throws BusinessException;

    RolDTO findById(RolDTO rol) throws BusinessException;
}
