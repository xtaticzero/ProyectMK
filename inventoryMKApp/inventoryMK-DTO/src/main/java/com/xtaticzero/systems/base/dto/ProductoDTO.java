/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.dto;

import com.xtaticzero.systems.base.BaseModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class ProductoDTO extends BaseModel {

    private static final long serialVersionUID = 6624874039614393104L;

    private BigInteger idProducto;
    private FabricanteDTO fabricante;
    private AsociacionCategoriaDTO asociacionCategoria;
    private String codigo;
    private String descripcion;
    private BigDecimal costoCatalogo;
    private BigDecimal costoReal;
    private BigDecimal numeroUnidades;
    private Date fechaEntrada;
    private Date fechaTermino;

    public BigInteger getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigInteger idProducto) {
        this.idProducto = idProducto;
    }

    public FabricanteDTO getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteDTO fabricante) {
        this.fabricante = fabricante;
    }

    public AsociacionCategoriaDTO getAsociacionCategoria() {
        return asociacionCategoria;
    }

    public void setAsociacionCategoria(AsociacionCategoriaDTO asociacionCategoria) {
        this.asociacionCategoria = asociacionCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCostoCatalogo() {
        return costoCatalogo;
    }

    public void setCostoCatalogo(BigDecimal costoCatalogo) {
        this.costoCatalogo = costoCatalogo;
    }

    public BigDecimal getCostoReal() {
        return costoReal;
    }

    public void setCostoReal(BigDecimal costoReal) {
        this.costoReal = costoReal;
    }

    public BigDecimal getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(BigDecimal numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public Date getFechaEntrada() {
        return fechaEntrada != null ? (Date) fechaEntrada.clone() : null;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada != null ? (Date) fechaEntrada.clone() : null;
    }

    public Date getFechaTermino() {
        return fechaTermino != null ? (Date) fechaTermino.clone() : null;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino != null ? (Date) fechaTermino.clone() : null;
    }

}
