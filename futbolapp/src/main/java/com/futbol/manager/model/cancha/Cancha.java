package com.futbol.manager.model.cancha;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.jornada.estado.Estado;
import com.futbol.manager.model.usuario.impl.Jugador;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "CANCHA")
public class Cancha {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;
    @Column(name = "c_descripcion")
    private String descripcion;
    @Column(name = "c_id_torneo")
    private String idTorneo;

    /*
    Map<Equipo,Map<Jugador,Integer>> jugTitularesByEquipo;
    Map<Equipo,Collection<Jugador>> jugSuplentesByEquipo;

    protected void addJugadorTitular(Equipo equipo,Jugador jugador,int posicion){
        Map<Jugador,Integer> map = jugTitularesByEquipo.get(equipo);
        map.put(jugador, posicion);
        jugTitularesByEquipo.put(equipo,map);
    }

    protected void addJugadorSuplente(Equipo equipo,Jugador jugador){
        Collection<Jugador> suplentes = jugSuplentesByEquipo.get(equipo);
        suplentes.add(jugador);
        jugSuplentesByEquipo.put(equipo,suplentes);
    }

    */
}
