package com.futbol.manager.model.equipo;

import com.futbol.manager.model.torneo.Torneo;
import com.futbol.manager.model.torneo.TorneoFutbol;
import com.futbol.manager.model.usuario.impl.Invitado;
import com.futbol.manager.model.usuario.impl.Jugador;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="C_ID_TIPO", discriminatorType=DiscriminatorType.INTEGER )
@Table(name = "EQUIPO")
public class Equipo implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "c_id_torneo")
    private Long id_torneo;

    /**
     * Dueño de la relacion
     *
     * @see com.futbol.manager.model.usuario.impl.Jugador
     */
    @OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Jugador> jugadores;

    /**
     * Dueño de la relacion
     *
     * @see com.futbol.manager.model.usuario.impl.Invitado
     */
    @OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Invitado> invitados;


    /**
     * Dueño de la relacion:
     * @see com.futbol.manager.model.torneo.Torneo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_torneo")
    private Torneo torneo;


    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(TorneoFutbol torneo) {
        this.torneo = torneo;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void addInvitados(Invitado invitado) {
        this.invitados.add(invitado);
    }
}
