package com.futbol.manager.model.utils.collection;

import com.futbol.manager.model.jornada.Jornada;
import org.apache.commons.collections.Predicate;

import java.util.Date;

/**
 * Created by aandrade on 02/09/2014.
 */
public class PredicateFactory {

    public static Predicate getPredicateJornadaByFecha(final Date dia){

        return new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                Jornada fecha = (Jornada) o;

                return true; //TODO fecha.getFecha().equals(dia);

            }
        };
    }
}
