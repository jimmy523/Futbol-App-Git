package com.futbol.manager.model.encuentro;

import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.encuentro.state.Estado;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.usuario.impl.Arbitro;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "ENCUENTRO")
public class Encuentro {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Time horario;

    @Column(name = "c_id_jornada")
    private Long idJornada;

    @JoinColumn(name = "c_id_estado",referencedColumnName = "c_id")
    private Estado estado;

}
