/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.dto;

import com.xtaticzero.systems.base.BaseModel;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class CategoriaDTO extends BaseModel {

    private static final long serialVersionUID = 1188461395955095308L;

    private BigInteger idCategoria;
    private String nombre;

    private List<CategoriaDTO> subCategorias;

    public BigInteger getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigInteger idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CategoriaDTO> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<CategoriaDTO> subCategorias) {
        this.subCategorias = subCategorias;
    }

}
