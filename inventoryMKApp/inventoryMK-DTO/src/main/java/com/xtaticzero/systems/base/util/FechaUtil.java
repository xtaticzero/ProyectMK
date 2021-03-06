/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtaticzero.systems.base.util;

import com.xtaticzero.systems.base.constants.Constantes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 *
 * @author Ing. Emmanuel Estrada Gonzalez <emmanuel.estradag.ipn@gmail.com>
 */
public class FechaUtil {

    /**
     * Es el formato por defecto que tendran las fechas cadena
     * original(ddMMyyyy_HHmmss), si no se asigna alguno.
     */
    public static final String FORMATO_CADENA_ORIGINAL = "ddMMyyyyHHmmss";
    /**
     * Es el formato por defecto que tendran las fechas (dd/MM/yyyy), si no se
     * asigna alguno.
     */
    public static final String FORMATO_DEFAULT = "dd/MM/yyyy";
    public static final String FORMATO_MYSQL = "yyyy-MM-dd";
    /**
     * Formato extendido que incluye la hora (dd/MM/yyyy HH:mm).
     */
    public static final String FORMATO_COMPLETO = "dd/MM/yyyy HH:mm";

    /**
     * Formato extendido que incluye la hora (dd/MM/yyyy HH:mm).
     */
    public static final String FORMATO_COMPLETO_AMPM = "dd/MM/yyyy h:mm a";

    /**
     * Formato que solo incluye la hora (HH:mm).
     */
    public static final String FORMATO_SOLO_HORA = "HH:mm";
    /**
     * Zona horaria de M&eacute;xico (GMT-06:00).
     */
    public static final String ZONA_HORARIA_MEXICO = "GMT-06:00";

    private FechaUtil() {
    }

    /**
     * Valida que la fecha ingresada sea una entre lunes y viernes.
     *
     * @param fechaIngresada Fecha a validar.
     */
    public void validaDiaEntreSemana(Date fechaIngresada) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaIngresada);

        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            throw new IllegalArgumentException("La fecha ingresada no puede ser "
                    + (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? "Sabado" : "Domingo"));
        }

    }

    /**
     * Convierte una cadena en formato hora (HH:mm), a Calendar.
     *
     * @param hora cadena con el valor de la hora a convertir.
     * @return Calendar con el valor indicado.
     * @throws NumberFormatException en caso que el valor de la hora y/o minuto
     * no pueda ser convertido a entero.
     */
    public Calendar stringHoraACalendarHora(String hora) {
        Calendar horaCalendar = Calendar.getInstance();
        int hrs = 0;
        int min = 0;

        StringTokenizer texto = new StringTokenizer(hora, ":");
        while (texto.hasMoreTokens()) {
            hrs = Integer.valueOf(texto.nextToken());
            min = Integer.valueOf(texto.nextToken());
        }

        horaCalendar.set(Calendar.YEAR, 0);
        horaCalendar.set(Calendar.MONTH, 0);
        horaCalendar.set(Calendar.DAY_OF_MONTH, 0);

        horaCalendar.set(Calendar.HOUR_OF_DAY, hrs);
        horaCalendar.set(Calendar.MINUTE, min);
        horaCalendar.set(Calendar.SECOND, 0);
        horaCalendar.set(Calendar.MILLISECOND, 0);

        return horaCalendar;

    }

    /**
     * Convierte un Date a Calendar, solo con el contenido de la hora.
     *
     * @param horaIngresada Date con el valor de la hora a convertir.
     * @return Calendar con el valor indicado.
     */
    public Calendar dateHoraACalendarHora(Date horaIngresada) {
        Calendar hora = Calendar.getInstance();
        hora.setTime(horaIngresada);

        hora.set(Calendar.YEAR, 0);
        hora.set(Calendar.MONTH, 0);
        hora.set(Calendar.DAY_OF_MONTH, 0);

        return hora;
    }

    /**
     * M&eacute;todo que convierte a cadena un date en el formato default y en
     * la zona horaria de M&eacute;xico.
     *
     * @see {@link mx.gob.sat.siat.negocio.util.FechaUtil#FORMATO_DEFAULT}
     * @see {@link mx.gob.sat.siat.negocio.util.FechaUtil#ZONA_HORARIA_MEXICO}
     * @param fecha a convertir.
     * @return String con el formato por defecto.
     */
    public static String formatFecha(Date fecha) {
        return formatFecha(fecha, null, null);
    }

    /**
     * M&eacute;todo que convierte a cadena un date en el formato y zona horaria
     * especificada.
     *
     * @param fecha a convertir.
     * @param formato a tener encuenta ej. (dd/MM/yyyy).
     * @param zonaHoraria a tener encuenta ej. (GMT-06:00).
     * @return String con el formato y zona horaria especificada.
     */
    public static String formatFecha(Date fecha, String formato, String zonaHoraria) {
        String fechaRes = Constantes.ESPACIO_VACIO;

        if (fecha != null) {
            DateFormat dateFormat;

            if (StringUtil.isEmpty(formato)) {
                dateFormat = new SimpleDateFormat(FORMATO_DEFAULT);
            } else {
                dateFormat = new SimpleDateFormat(formato);
            }

            if (StringUtil.isEmpty(zonaHoraria)) {
                dateFormat.setTimeZone(TimeZone.getTimeZone(ZONA_HORARIA_MEXICO));
            } else {
                dateFormat.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
            }
            fechaRes = dateFormat.format(fecha);
        }

        return fechaRes;
    }

    /**
     * M&eacute;todo que convierte a cadena un date en el formato y zona horaria
     * especificada.
     *
     * @param fecha a convertir.
     * @param formato a tener encuenta ej. (dd/MM/yyyy).
     * @return String con el formato especificado.
     */
    public static String formatFecha(Date fecha, String formato) {
        if (fecha != null) {
            DateFormat dateFormat;

            if (StringUtil.isEmpty(formato)) {
                dateFormat = new SimpleDateFormat(FORMATO_DEFAULT);
            } else {
                dateFormat = new SimpleDateFormat(formato);
            }

            return dateFormat.format(fecha);
        } else {
            return "";
        }

    }

    /**
     * Suma o resta un numero de d&iacute;as a una fecha determinada.
     *
     * @param fechaHora a la que se le sumaran o restaran los d&iacute;as.
     * @param numeroDias que se sumaran o restaran (puede ser positivo o
     * negativo).
     * @return Fecha con el nuevo valor, sin horas, minutos, segundos y
     * milisegundos asignados.
     */
    public static Date sumaRestaDiasFecha(Date fechaHora, int numeroDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaHora);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, numeroDias);

        return calendar.getTime();
    }

    public static Date getCustomDate(Integer year, Integer month, Integer day, Integer hour, Integer minute) {
        Calendar calendar = Calendar.getInstance();

        if (year != null && year > 1900) {
            calendar.set(Calendar.YEAR, year);

            calendar.set(Calendar.MONTH, month != null ? month - 1 : Calendar.JANUARY);

            calendar.set(Calendar.DAY_OF_MONTH, day != null ? day : Calendar.SUNDAY);

            calendar.set(Calendar.HOUR_OF_DAY, hour != null ? hour : 0);
            calendar.set(Calendar.MINUTE, minute != null ? minute : 0);
            calendar.set(Calendar.SECOND, 0);

        }

        return calendar.getTime();
    }

    public static Integer getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static String getDateFormatMySQL(Date date, String format) {
        return "'" + formatFecha(date, format) + "'";
    }

}
