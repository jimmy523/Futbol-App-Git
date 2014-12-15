package com.futbol.manager.model.usuario.impl;


import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.torneo.TorneoFutbol;
import com.futbol.manager.model.usuario.arbitro.TipoArbitraje;

import javax.persistence.*;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "ARBITRO")
public class Arbitro {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "c_id_tipo_arbitraje")
    private TipoArbitraje tipoArbitraje;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_torneo")
    private TorneoFutbol torneo;


}
