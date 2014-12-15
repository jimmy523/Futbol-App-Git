package com.futbol.manager.model.fixture.strategy.impl;

import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.strategy.StrategyBuildFixture;
import com.futbol.manager.model.usuario.impl.Arbitro;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by aandrade on 02/09/2014.
 */
public class BuildFixtureCopa extends StrategyBuildFixture{

    public BuildFixtureCopa(Calendar fechaInicio, Collection<Equipo> equipos, Collection<Cancha> canchas, Collection<Arbitro> arbitros, int duracionEncuentros, String franjaHoraria, Integer[] diasTorneo) {
        super(fechaInicio, equipos, canchas, arbitros, duracionEncuentros, franjaHoraria, diasTorneo);
    }

}
