/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.enums;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public enum ReportsEnum {

    REPORTE_PRUEBA("reports/ReportePrueba.jasper");

    private final String path;

    ReportsEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
