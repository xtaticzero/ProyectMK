/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.business.service;

import com.xtaticzero.systems.base.constants.excepcion.impl.BusinessException;
import com.xtaticzero.systems.base.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface UserService {

    UsuarioDTO insert(UsuarioDTO nuevoUsuario) throws BusinessException;

    Integer update(UsuarioDTO usuario) throws BusinessException;

    Integer inactivar(UsuarioDTO nuevoUsuario) throws BusinessException;

    List<UsuarioDTO> findAll(UsuarioDTO nuevoUsuario) throws BusinessException;

    List<UsuarioDTO> findByName(UsuarioDTO nuevoUsuario) throws BusinessException;
}
