/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.vista.mk.managedbean;

import com.xtaticzero.systems.base.constants.excepcion.impl.BusinessException;
import com.xtaticzero.systems.base.constants.excepcion.impl.FrontException;
import com.xtaticzero.systems.base.dto.RolDTO;
import javax.annotation.PostConstruct;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
@Controller("catalogosMB")
//@Scope(value = "session")
@Scope(value = "view")
public class CatalogosMB extends CatalogosMBAbstract {

    private static final long serialVersionUID = 1770456612125556484L;

    @PostConstruct
    protected void init() throws FrontException {
        validateUsuarioValido();
        inicializaRoles();
    }

    public void cargarRoles() {
        try {
            setLstRoles(getRolService().findAll());
        } catch (BusinessException ex) {
            logger.error(ex.getMessage(), ex);
            msgError(ex.getMessage());
        }
    }

    public void agregarRol() {
        try {
            if (getNuevoRol() != null && getNuevoRol().getDescripcion() != null) {
                getNuevoRol().setDescripcion(getNuevoRol().getDescripcion().toUpperCase());
                getRolService().insert(getNuevoRol());
                setNuevoRol(new RolDTO());
                cargarRoles();
            }
        } catch (BusinessException ex) {
            logger.error(ex.getMessage(), ex);
            msgError("No se puede agregar un ROL repetido");
        }
    }

    public void onRolRowEdit(RowEditEvent event) {
        try {
            getRolService().update(((RolDTO) event.getObject()));
            msgInfo("Se Edito : " + ((RolDTO) event.getObject()).getDescripcion());
        } catch (Exception e) {
            msgError("Error al actualizar Rol");
        }

    }

    public void onRolRowCancel(RowEditEvent event) {
        msgInfo("Se Cancelo la edicion de : " + ((RolDTO) event.getObject()).getDescripcion());
    }

}
