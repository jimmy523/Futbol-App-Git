package com.futbol.manager.model.fixture.factory;

import com.futbol.manager.model.torneo.TorneoFutbol;
import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.strategy.StrategyBuildFixture;
import com.futbol.manager.model.fixture.strategy.impl.BuildFixtureCopa;
import com.futbol.manager.model.fixture.strategy.impl.BuildFixtureLiga;
import com.futbol.manager.model.usuario.impl.Arbitro;

import java.util.Calendar;
import java.util.Collection;

/**
 * @author: aandrade
 * @fecha: 02/09/2014
 */
public class FactoryStrategyFixture {
    public static StrategyBuildFixture getStrategyFixture(TorneoFutbol.Tipo tipoTorneo, Calendar fechaInicio, Collection<Equipo> equipos, Collection<Cancha> canchas, Collection<Arbitro> arbitros, int duracionEncuentros, String franjaHoraria, Integer[] diasTorneo){
        if(tipoTorneo.equals(TorneoFutbol.Tipo.LIGA))
            return new BuildFixtureLiga(fechaInicio, equipos, canchas, arbitros, duracionEncuentros, franjaHoraria, diasTorneo);
        else if (tipoTorneo.equals(TorneoFutbol.Tipo.COPA))
            return new BuildFixtureCopa(fechaInicio, equipos, canchas, arbitros, duracionEncuentros, franjaHoraria, diasTorneo);
        return null;
    }
}
