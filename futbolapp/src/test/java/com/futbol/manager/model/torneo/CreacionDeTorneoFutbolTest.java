package com.futbol.manager.model.torneo;

import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.Fixture;
import com.futbol.manager.model.usuario.impl.Arbitro;
import com.futbol.manager.model.usuario.impl.AdministradorTorneo;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by aandrade on 09/09/2014.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class CreacionDeTorneoFutbolTest {

    private TorneoFutbol torneoFutbol;

    @Before
    public void Before(){
        /*
        Cancha7 cancha7 = new Cancha7(1l);
        Arbitro arbitro = new Arbitro("Juan","Perez");
        AdministradorTorneo administradorTorneo = new AdministradorTorneo("Suarez", "Lombardo");
        Equipo equipo = new Equipo("Sacachispa");
        Collection<Equipo> colEquipos = new ArrayList<Equipo>();
        colEquipos.add(equipo);
        equipo = new Equipo("Turin");
        colEquipos.add(equipo);
        equipo = new Equipo("Manchester");
        colEquipos.add(equipo);
        equipo = new Equipo("Boca burros");
        colEquipos.add(equipo);
        Integer[] dias = new Integer[]{6};*/
        //torneoFutbol = new TorneoFutbol(new ArrayList<AdministradorTorneo>(Collections.singletonList(administradorTorneo)),40,dias,"10:00-16:00", TorneoFutbol.Tipo.LIGA, Calendar.getInstance(),new ArrayList<Arbitro>(Collections.singletonList(arbitro)),colEquipos,new ArrayList<Cancha>(Collections.singletonList(cancha7)));
    }

    @Test
    public void test(){
        this.Before();
        Fixture fixture = torneoFutbol.getFixtureTorneo();
    }
}
