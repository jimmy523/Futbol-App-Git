package com.futbol.manager.model.torneo;

import com.futbol.manager.model.exceptions.TorneoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author: aandrade
 * @fecha: 03/09/2014
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BuildFixtureLigaTest {

    @Test(expected = TorneoException.class)
    public void seDebeGenerarOKFixture(){/*
        Persona admin = new AdministradorTorneo("Andres","Andrade");

        Integer[] dias = {6};
        String franjaHoraria = "10:00-16:00";

        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);


        Torneo torneo = new Torneo(Collections.singletonList(admin),40,dias,franjaHoraria,Torneo.Tipo.LIGA, calendar);

        Cancha7 cancha = new Cancha7(1l);
        torneo.addCancha(cancha);
        cancha = new Cancha7(2l);
        torneo.addCancha(cancha);

        Equipo equipo = new Equipo();
        equipo.setNombre("sacachispa");
        torneo.addEquipo(equipo);

        equipo = new Equipo();
        equipo.setNombre("manchester");
        torneo.addEquipo(equipo);

        equipo = new Equipo();
        equipo.setNombre("ypf");
        torneo.addEquipo(equipo);

        equipo = new Equipo();
        equipo.setNombre("la malla");
        torneo.addEquipo(equipo);

        torneo.generarFixture();

        System.out.println("Inicio creacion torneo el dia: "+torneo.getFechaInicio().getTime());
        System.out.println();

        for (Jornada jornada : torneo.getFixtureTorneo().getFechas()){
            System.out.println("La jornada: "+jornada.getId()+"- Comienza el dia: "+jornada.getFecha().getTime());
            System.out.println("Se enfrentaran los siguientes equipos");
            for (Encuentro encuentro : jornada.getEncuentrosPorDisputarse()){
                System.out.println("Horario Encuentro: "+encuentro.getHorario().getTime());
                System.out.println("Local: "+encuentro.getLocal().getNombre());
                System.out.println("Visitante: "+encuentro.getVisitante().getNombre());
            }
        }*/

    }
}
