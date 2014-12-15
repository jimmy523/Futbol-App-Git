package com.futbol.manager.action;

import com.futbol.manager.model.utils.collection.TransformerFactory;
import com.futbol.manager.model.utils.date.DateUtils;
import com.futbol.manager.service.torneo.TorneoService;
import com.futbol.manager.view.form.TorneoForm;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by aandrade on 06/09/2014.
 */
public class AltaTorneoAction extends ActionSupport {

    private TorneoService torneoService;

    private TorneoForm torneoForm;

    private String nombre;
    private String tipo;
    private String duracion;
    private String fechaInicio;
    private String diasJornada;
    private String horarioJornadaInicio;
    private String horarioJornadaFin;

    private Collection<String> dias;

    public AltaTorneoAction(){
        dias = new ArrayList<String>();
        dias.add("Domingo");
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sabado");
    }

    public String[] getDefaultDias(){
        return new String [] {"Sabado"};
    }

    public Collection<String> getDias() {
        return dias;
    }

    public void setDias(Collection<String> dias) {
        this.dias = dias;
    }


    @Override
    public String execute() throws Exception
    {

        torneoForm = new TorneoForm();

        List<String> lisStringDias = Arrays.asList(StringUtils.split(diasJornada, ","));
        torneoForm.setDiasJornada((String[]) lisStringDias.toArray());
        torneoForm.setDuracion(duracion);
        torneoForm.setFechaInicio(DateUtils.StringFromDate(fechaInicio));
        torneoForm.setHorarioJornadaFin(horarioJornadaFin);
        torneoForm.setHorarioJornadaInicio(horarioJornadaInicio);
        torneoForm.setNombre(nombre);
        torneoForm.setTipo(tipo);

        torneoService.darAltaTorneo(torneoForm);

        return SUCCESS;

    }

    public TorneoService getTorneoService() {
        return torneoService;
    }

    public void setTorneoService(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    public TorneoForm getTorneoForm() {
        return torneoForm;
    }

    public void setTorneoForm(TorneoForm torneoForm) {
        this.torneoForm = torneoForm;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDiasJornada() {
        return diasJornada;
    }

    public void setDiasJornada(String diasJornada) {
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

    public String display() {
        return NONE;
    }
}
