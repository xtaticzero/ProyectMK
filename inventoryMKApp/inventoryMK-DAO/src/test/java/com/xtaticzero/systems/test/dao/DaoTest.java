/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.test.dao;

import com.xtaticzero.systems.base.constants.excepcion.impl.DAOException;
import com.xtaticzero.systems.base.dto.PersonaDTO;
import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.base.dto.UsuarioDTO;
import com.xtaticzero.systems.dao.PersonaDAO;
import com.xtaticzero.systems.dao.PruebaDao;
import com.xtaticzero.systems.dao.RolDAO;
import com.xtaticzero.systems.dao.UserDao;
import com.xtaticzero.systems.test.base.BaseTest;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ing Emmanuel Estrada Gonzalez
 */
public class DaoTest extends BaseTest {

    @Autowired
    @Qualifier("pruebaDao")
    private PruebaDao pruebaDao;

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier("rolDAO")
    private RolDAO rolDAO;

    @Autowired
    @Qualifier("personaDAO")
    private PersonaDAO personaDAO;

    @Test
    @Ignore
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void pruebaInyeccionDao() {
        System.out.println("todo ok");
        try {
            if (pruebaDao != null) {
                System.out.println("todo ok");
                System.out.println("Imprime resultado de la base " + pruebaDao.getTime());
            } else {
                System.err.println("Valio ");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        }
    }

    @Test
    @Ignore
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void pruebaDao() {
        System.out.println("todo ok");
        try {
            if (userDao != null && rolDAO != null) {
                UsuarioDTO usuario = new UsuarioDTO();
                UsuarioDTO usuarioV;
                usuario.setDisplayName("admin");
                usuario.setPassword("admin123");
                System.out.println("todo ok");
                usuarioV = userDao.passwordValido(usuario);

                UsuarioDTO usr = userDao.findName("admin");

                System.out.println("com.xtaticzero.systems.test.dao.TbcDaoTest.pruebaDao() : " + usr);

                usr.setDisplayName("admin");
                userDao.update(usr);
                System.out.println("com.xtaticzero.systems.test.dao.TbcDaoTest.pruebaDao() update : " + usr);

                List<UsuarioDTO> lstUsr = userDao.findRol(BigInteger.ONE);

                if (lstUsr != null) {
                    for (UsuarioDTO usuarioDTO : lstUsr) {
                        System.out.println("com.xtaticzero.systems.test.dao.TbcDaoTest.pruebaDao() findRol : " + usuarioDTO);
                    }
                }

                List<RolDTO> lstRoles = rolDAO.findAll();
                List<RolDTO> lstRolesDes = rolDAO.findByDescripcion("OPERADOR");

                if (lstRoles != null) {
                    for (RolDTO role : lstRoles) {
                        logger.debug("Descripcion: " + role.getDescripcion());
                    }
                }
                if (lstRolesDes != null) {
                    for (RolDTO role : lstRolesDes) {
                        logger.debug("Descripcion: " + role.getDescripcion());
                    }
                }

                if (usuarioV != null) {
                    System.out.println("El usuario es valido" + usuarioV);
                }
            } else {
                System.err.println("Valio ");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        }
    }

    @Test
    @Ignore
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void personaTest() throws Exception {
        try {
            PersonaDTO personaDTO = new PersonaDTO();

            personaDTO.setNombre("NOMBRE");
            personaDTO.setApellidoPaterno("APATERNO");
            personaDTO.setApellidoMaterno("AMATERNO");
            personaDTO.setCorreoElectronico("correo@dominio.com");
            personaDTO.setDireccion("DIRECCION");
            personaDTO.setCelular("5555555555");
            personaDTO.setFechaNacimiento(new Date());

            personaDTO = personaDAO.insert(personaDTO);
            
            System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() insert : "+ personaDTO);
            
            personaDTO.setNombre("NUEVO MONBRE");            

            System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() update : {"+ personaDAO.update(personaDTO)+"} "+ personaDTO);
            System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() delete : {"+ personaDAO.delete(personaDTO)+"} ");
            List<PersonaDTO> lst = personaDAO.findAll();
            for (PersonaDTO per : lst) {
                System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() findAll() :"+per);
            }
            lst = personaDAO.findByName("M");
            for (PersonaDTO per : lst) {
                System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() findByName() :"+per);
            }
            lst = personaDAO.findByAPaterno("A");
            for (PersonaDTO per : lst) {
                System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() findByAPaterno() :"+per);
            }
            lst = personaDAO.findByAMaterno("A");
            for (PersonaDTO per : lst) {
                System.out.println("com.xtaticzero.systems.test.dao.DaoTest.personaTest() findByAMaterno() :"+per);
            }
            
            if (personaDTO.getPersonaId() != null) {
                throw new Exception("Prueba insert");
            }
        } catch (DAOException ex) {
            System.err.println(ex);
        }
    }
}
