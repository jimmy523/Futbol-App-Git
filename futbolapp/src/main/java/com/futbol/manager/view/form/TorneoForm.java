package com.futbol.manager.view.form;

import java.util.Date;

/**
 * Created by aandrade on 06/09/2014.
 */
public class TorneoForm {

    private String nombre;
    private String tipo;
    private String duracion;
    private Date fechaInicio;
    private String[] diasJornada;
    private String horarioJornadaInicio;
    private String horarioJornadaFin;

    public TorneoForm() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String[] getDiasJornada() {
        return diasJornada;
    }

    public void setDiasJornada(String[] diasJornada) {
        this.diasJornada = diasJornada;
    }

    public String getHorarioJornadaInicio() {
        return horarioJornadaInicio;
    }

    public void setHorarioJornadaInicio(String horarioJornadaInicio) {
        this.horarioJornadaInicio = horarioJornadaInicio;
    }

    public String getHorarioJornadaFin() {
        return horarioJornadaFin;
    }

    public void setHorarioJornadaFin(String horarioJornadaFin) {
        this.horarioJornadaFin = horarioJornadaFin;
    }
}
