package com.futbol.manager.model.usuario.impl;

import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.torneo.Torneo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "PARTICIPANTE_TORNEO")
public class ParticipanteTorneo {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "c_id_torneo")
    private Torneo torneo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    public void crearTorneo(){

    }
}
