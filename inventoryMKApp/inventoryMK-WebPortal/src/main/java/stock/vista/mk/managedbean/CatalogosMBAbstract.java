/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.vista.mk.managedbean;

import com.xtaticzero.systems.base.dto.RolDTO;
import com.xtaticzero.systems.business.service.RolService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import stock.vista.VistaAbstractMB;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public abstract class CatalogosMBAbstract extends VistaAbstractMB{
    
    @Autowired
    @Qualifier("rolService")
    private RolService rolService;

    private List<RolDTO> lstRoles;
    private RolDTO rolSeleccionado;
    private RolDTO nuevoRol;
    
    private static final long serialVersionUID = -6086687798755903319L;
    
    protected void inicializaRoles() {
        lstRoles = new ArrayList<>();
        rolSeleccionado = null;
        nuevoRol = new RolDTO();
    }
    
    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

    public List<RolDTO> getLstRoles() {
        return lstRoles;
    }

    public void setLstRoles(List<RolDTO> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public RolDTO getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(RolDTO rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public RolDTO getNuevoRol() {
        return nuevoRol;
    }

    public void setNuevoRol(RolDTO nuevoRol) {
        this.nuevoRol = nuevoRol;
    }
}
