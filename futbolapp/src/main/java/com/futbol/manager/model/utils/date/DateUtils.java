package com.futbol.manager.model.utils.date;

import com.futbol.manager.model.exceptions.TorneoExcepcionHandler;
import com.futbol.manager.model.utils.date.wrapper.DateWrapper;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.*;

/**
 * @author: aandrade
 * @fecha: 02/09/2014
 */
public class DateUtils {

    public static Collection<DateWrapper> fechasBetween(Calendar fechaInicio, Integer[] diasTorneo/*1-7*/, String franjaHoraria/*10:00-15:00*/,
                                                        int duracionEncuentro, boolean equipoLibrePorJornada, Integer cantJornadasCalculadas, Integer cantEncuentrosByJornadasCalculados){
        Collection<DateWrapper> dias = new LinkedList<DateWrapper>();
        List<Integer> diasEnQueSeJuegaTorneo = Arrays.asList(diasTorneo);
        int contadorJornadas = 0;
        while (contadorJornadas != cantJornadasCalculadas){
            if(diasEnQueSeJuegaTorneo.contains(fechaInicio.get(Calendar.DAY_OF_WEEK))){
                DateWrapper date = new DateWrapper(fechaInicio);
                date = horariosEncuentros(date,duracionEncuentro,franjaHoraria,cantEncuentrosByJornadasCalculados);
                dias.add(date);
                contadorJornadas++;
            }
            //sumo un dia a la fecha inicio
            fechaInicio.add(Calendar.DATE,1);
        }

        return dias;
    }

    public static DateWrapper horariosEncuentros(DateWrapper fecha, int duracionEncuentro, String franjaHoraria,/*10:00-15:00*/Integer cantEncuentrosByJornadasCalculados){

        Integer horaInicio = Integer.valueOf(StringUtils.substringBefore(franjaHoraria, ":"));
        Integer minInicio = Integer.valueOf(StringUtils.substringBetween(franjaHoraria, ":","-"));
        String horaMinFin = StringUtils.substringAfter(franjaHoraria, "-");
        Integer horaFin = Integer.valueOf(StringUtils.substringBefore(horaMinFin, ":"));
        Integer minFin = Integer.valueOf(StringUtils.substringAfter(horaMinFin, ":"));

        Calendar calendarHoraInicio = new GregorianCalendar(fecha.getDia().get(Calendar.YEAR),fecha.getDia().get(Calendar.MONTH),fecha.getDia().get(Calendar.DAY_OF_MONTH),horaInicio,minInicio);
        Calendar calendarHoraFin = new GregorianCalendar(fecha.getDia().get(Calendar.YEAR),fecha.getDia().get(Calendar.MONTH),fecha.getDia().get(Calendar.DAY_OF_MONTH),horaFin,minFin);

        fecha.setDia((Calendar) calendarHoraInicio.clone());//queda seteada la fecha con la hora de inicio
        int contEncuentrosByJornada = 0;
        while (contEncuentrosByJornada != cantEncuentrosByJornadasCalculados && calendarHoraInicio.before(calendarHoraFin)){
            fecha.addHorario((Calendar) calendarHoraInicio.clone());//agrego la fecha
            contEncuentrosByJornada++;
            calendarHoraInicio.add(Calendar.MINUTE,duracionEncuentro); //verificar en algun momento que la cantidad de fechas alcance para cubrir la cantidad de aenuentros a disputarse
        }

        return fecha;

    }

    public static Collection<Calendar> calcularHorariosJornada(int duracionEncuentro, String franjaHoraria/*10:00-15:00*/){

        Integer horaInicio = Integer.valueOf(StringUtils.substringBefore(franjaHoraria, ":"));
        Integer minInicio = Integer.valueOf(StringUtils.substringBetween(franjaHoraria, ":","-"));
        String horaMinFin = StringUtils.substringAfter(franjaHoraria, "-");
        Integer horaFin = Integer.valueOf(StringUtils.substringBefore(horaMinFin, ":"));
        Integer minFin = Integer.valueOf(StringUtils.substringAfter(horaMinFin, ":"));

        Calendar calendarHoraInicio = new GregorianCalendar(0,0,0,0,horaInicio,minInicio);
        Calendar calendarHoraFin = new GregorianCalendar(0,0,0,0,horaFin,minFin);
        Collection<Calendar> horarios =new LinkedList<Calendar>();
        
        while (calendarHoraInicio.before(calendarHoraFin)){
            horarios.add((Calendar) calendarHoraInicio.clone());
            calendarHoraInicio.add(Calendar.MINUTE,duracionEncuentro); //verificar en algun momento que la cantidad de fechas alcance para cubrir la cantidad de aenuentros a disputarse
        }

        return horarios;

    }

    public static Date StringFromDate(String dia){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dia, "DD/MM/AAAA HH:mm:ss");
        } catch (ParseException e) {
            TorneoExcepcionHandler.launchException("Formato de fecha incorrecto se espera formato DD/MM/AAAA HH:mm:ss");
        }
        return null;
    }
}
