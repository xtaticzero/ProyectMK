/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.dto;

import com.xtaticzero.systems.base.BaseModel;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class ComisionDTO extends BaseModel {

    private static final long serialVersionUID = 3999673394786806400L;

    private BigInteger comisionId;
    private BigDecimal porcentaje;
    private String descripcion;

    public BigInteger getComisionId() {
        return comisionId;
    }

    public void setComisionId(BigInteger comisionId) {
        this.comisionId = comisionId;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ComisionDTO{" + "comisionId=" + comisionId + ", porcentaje=" + porcentaje + ", descripcion=" + descripcion + ", fechaEntrada=" + getFechaEntrada() + ", fechaTermino=" + getFechaTermino() + '}';
    }
    
    

}
