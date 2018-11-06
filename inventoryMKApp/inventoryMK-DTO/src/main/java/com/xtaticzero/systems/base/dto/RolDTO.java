/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.dto;

import com.xtaticzero.systems.base.BaseModel;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class RolDTO extends BaseModel {

    private static final long serialVersionUID = 5316028315883115410L;

    private BigInteger rolId;
    private String descripcion;
    private Date fechaEntrada;
    private Date fechaTermino;

    public BigInteger getRolId() {
        return rolId;
    }

    public void setRolId(BigInteger rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
