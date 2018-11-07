/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.dto;

import com.xtaticzero.systems.base.BaseModel;
import java.math.BigInteger;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class AsociacionCategoriaDTO extends BaseModel {

    private static final long serialVersionUID = -174049946385987724L;

    private BigInteger idAsociacionCategoria;
    private CategoriaDTO categoria;
    private CategoriaDTO categoriaParent;

    public BigInteger getIdAsociacionCategoria() {
        return idAsociacionCategoria;
    }

    public void setIdAsociacionCategoria(BigInteger idAsociacionCategoria) {
        this.idAsociacionCategoria = idAsociacionCategoria;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public CategoriaDTO getCategoriaParent() {
        return categoriaParent;
    }

    public void setCategoriaParent(CategoriaDTO categoriaParent) {
        this.categoriaParent = categoriaParent;
    }

}
