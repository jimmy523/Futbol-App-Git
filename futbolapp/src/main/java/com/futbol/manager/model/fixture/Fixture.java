package com.futbol.manager.model.fixture;

import com.futbol.manager.model.encuentro.Encuentro;
import com.futbol.manager.model.encuentro.state.Estado;
import com.futbol.manager.model.fecha.Jornada;
import com.futbol.manager.model.utils.collection.PredicateFactory;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by aandrade on 02/09/2014.
 */
public class Fixture {

    private Collection<Jornada> fechas;

    private Collection<Jornada> fechasSuspendidas;

    public void suspenderFecha(Date dia){
        Jornada fechaSuspendida = (Jornada) CollectionUtils.find(fechas, PredicateFactory.getPredicateJornadaByFecha(dia));
        Collection<Encuentro> encuentrosSuspendidos = new ArrayList<Encuentro>();
        fechas.remove(fechaSuspendida);

        for (Encuentro encuentro : fechaSuspendida.getEncuentrosPorDisputarse()){
            encuentro.setEstado(Estado.SUSPENDIDO);
            encuentrosSuspendidos.add(encuentro);
        }

        fechaSuspendida.setEncuentrosPorDisputarse(encuentrosSuspendidos);
        fechasSuspendidas.add(fechaSuspendida);
    }

    public Collection<Jornada> getFechas() {
        return fechas;
    }

    public void setFechas(Collection<Jornada> fechas) {
        this.fechas = fechas;
    }

    public Collection<Jornada> getFechasSuspendidas() {
        return fechasSuspendidas;
    }

    public void setFechasSuspendidas(Collection<Jornada> fechasSuspendidas) {
        this.fechasSuspendidas = fechasSuspendidas;
    }
}
