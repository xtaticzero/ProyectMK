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
public class UsuarioDTO extends BaseModel {

    private static final long serialVersionUID = 9060326732700909763L;

    private BigInteger userId;
    private RolDTO rol;
    private PersonaDTO persona;
    private String displayName;
    private String password;
    private Date fechaEntrada;
    private Date fechaTermino;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
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

    @Override
    public String toString() {
        return "UsuarioDTO{" + "userId=" + userId + ", rol=" + rol + ", persona=" + persona + ", displayName=" + displayName + ", password=" + password + ", fechaEntrada=" + fechaEntrada + ", fechaTermino=" + fechaTermino + '}';
    }
    
    

}
