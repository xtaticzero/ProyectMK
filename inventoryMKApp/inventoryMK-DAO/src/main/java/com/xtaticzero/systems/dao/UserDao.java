/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.UsuarioDTO;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface UserDao {

    int insert(UsuarioDTO usuario) throws DAOException;

    int update(UsuarioDTO usuario) throws DAOException;

    int delete(UsuarioDTO usuario) throws DAOException;

    int activate(UsuarioDTO usuario) throws DAOException;

    List<UsuarioDTO> findAll() throws DAOException;

    UsuarioDTO findName(String name) throws DAOException;

    List<UsuarioDTO> findRol(BigInteger idRol) throws DAOException;

    UsuarioDTO passwordValido(UsuarioDTO usuario) throws DAOException;

}
