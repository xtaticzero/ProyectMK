/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.vista.mk.managedbean;

import com.xtaticzero.systems.base.constants.excepcion.impl.FrontException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
    private void init() throws FrontException {

        validateUsuarioValido();

    }

}
