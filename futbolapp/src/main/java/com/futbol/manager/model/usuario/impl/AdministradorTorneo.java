package com.futbol.manager.model.usuario.impl;

import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.torneo.Torneo;
import com.futbol.manager.model.torneo.TorneoFutbol;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "ADMINISTRADOR_TORNEO")
public class AdministradorTorneo {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    /**
     * Dueño de la relacion:
     *
     * @see com.futbol.manager.model.torneo.Torneo
     *
     * Bidireccional
     */
    @ManyToMany
    @JoinColumn(name = "c_id_torneo")
    private List<Torneo> torneos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    public void crearTorneo(){

    }
}
