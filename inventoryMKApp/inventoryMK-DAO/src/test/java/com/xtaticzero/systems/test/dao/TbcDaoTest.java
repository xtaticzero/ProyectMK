/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.test.dao;

import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.base.dto.UsuarioDTO;
import com.xtaticzero.systems.dao.PruebaDao;
import com.xtaticzero.systems.dao.RolDAO;
import com.xtaticzero.systems.dao.UserDao;
import com.xtaticzero.systems.test.base.BaseTest;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ing Emmanuel Estrada Gonzalez
 */
public class TbcDaoTest extends BaseTest {

    @Autowired
    @Qualifier("pruebaDao")
    private PruebaDao pruebaDao;

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @Autowired
    @Qualifier("rolDAO")
    private RolDAO rolDAO;

    @Test
    //@Ignore
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
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void pruebaDao() {
        System.out.println("todo ok");
        try {
            if (userDao != null && rolDAO != null) {
                UsuarioDTO usuario = new UsuarioDTO();
                UsuarioDTO usuarioV;
                usuario.setDisplay_name("admin");
                usuario.setPassword("admin123");
                System.out.println("todo ok");
                usuarioV = userDao.passwordValido(usuario);
                
                List<RolDTO> lstRoles = rolDAO.findAll();
                List<RolDTO> lstRolesDes = rolDAO.findByDescripcion("OPERADOR");
                
                if(lstRoles!=null){
                    for (RolDTO role : lstRoles) {
                        logger.debug("Descripcion: "+role.getDescripcion());
                    }
                }
                if(lstRolesDes!=null){
                    for (RolDTO role : lstRolesDes) {
                        logger.debug("Descripcion: "+role.getDescripcion());
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
}
