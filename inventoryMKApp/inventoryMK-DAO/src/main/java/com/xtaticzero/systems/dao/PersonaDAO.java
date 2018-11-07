/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.dao;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.PersonaDTO;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public interface PersonaDAO {

    PersonaDTO insert(PersonaDTO newPersona) throws DAOException;

    int update(PersonaDTO persona) throws DAOException;

    int delete(PersonaDTO persona) throws DAOException;

    int activate(PersonaDTO persona) throws DAOException;

    List<PersonaDTO> findAll() throws DAOException;

    List<PersonaDTO> findByName(String name) throws DAOException;

    List<PersonaDTO> findByAPaterno(String aPaterno) throws DAOException;

    List<PersonaDTO> findByAMaterno(String aMaterno) throws DAOException;

}
