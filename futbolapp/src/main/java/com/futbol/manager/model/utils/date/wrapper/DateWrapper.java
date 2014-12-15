package com.futbol.manager.model.utils.date.wrapper;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author: aandrade
 * @fecha: 02/09/2014
 */
public class DateWrapper {

    private Calendar dia;
    private Collection<Calendar> horariosJornada;

    public DateWrapper(Calendar dia) {
        this.dia= dia;
        horariosJornada = new LinkedList<Calendar>();
    }

    public boolean isFeriado(){
        return false;
    }

    public Collection<Calendar> getHorariosJornada() {
        return horariosJornada;
    }

    public void addHorario(Calendar horario){
        horariosJornada.add(horario);
    }

    public Calendar getDia() {
        return dia;
    }

    public void setDia(Calendar dia) {
        this.dia = dia;
    }
}
