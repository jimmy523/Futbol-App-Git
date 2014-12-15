package com.futbol.manager.model.torneo;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.Fixture;
import com.futbol.manager.model.fixture.strategy.StrategyBuildFixture;
import com.futbol.manager.model.torneo.modalidad.Modalidad;
import com.futbol.manager.model.usuario.impl.AdministradorTorneo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aandrade on 23/10/2014.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="C_ID_TIPO", discriminatorType=DiscriminatorType.INTEGER )
@Table(name = "TORNEO")
public abstract class Torneo {

    /**
     * Dueño de la relacion
     */
    @OneToMany(mappedBy = "torneo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    protected Collection<Equipo> equipos;

    //Unidireccional
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_modalidad",referencedColumnName = "codigo")
    private Modalidad modalidad;

    /**
     * Dueño de la relacion
     */
    @ManyToMany(mappedBy = "torneos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    protected Collection<AdministradorTorneo> administradores;

    protected Fixture fixtureTorneo;

    protected StrategyBuildFixture strategy;

    public abstract void generarFixture();
}
