package com.futbol.manager.model.torneo;

import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.factory.FactoryStrategyFixture;
import com.futbol.manager.model.fixture.Fixture;
import com.futbol.manager.model.fixture.strategy.StrategyBuildFixture;
import com.futbol.manager.model.usuario.impl.Arbitro;
import com.futbol.manager.model.usuario.impl.AdministradorTorneo;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 *
 * @user: aandrade
 * @fecha: 02/09/2014
 */
@Entity
@DiscriminatorValue("1")
public class TorneoFutbol  extends Torneo implements Serializable{

    public enum Tipo {
        LIGA,
        COPA
    }

    public TorneoFutbol() {
    }

    private Collection<Cancha> canchas = new ArrayList<Cancha>();
    private Collection<Arbitro> arbitros = new ArrayList<Arbitro>();


    private int duracionPartidos;

    private Integer[] diasJornada;

    private String bandaHoraria;

    private Tipo tipo;

    private Calendar fechaInicio;

    public TorneoFutbol(Collection<AdministradorTorneo> administradores, int duracionPartidos, Integer[] diasJornada, String bandaHoraria, Tipo tipo, Calendar fechaInicio, Collection<Arbitro> arbitros, List<Equipo> equipoCollection, Collection<Cancha> canchaCollection) {
        this.administradores = administradores;
        this.duracionPartidos = duracionPartidos;
        this.diasJornada = diasJornada;
        this.bandaHoraria = bandaHoraria;
        this.tipo = tipo;
        this.fechaInicio = (Calendar) fechaInicio.clone();
        this.canchas = canchaCollection;
        this.arbitros = arbitros;
        this.equipos = equipoCollection;
        strategy = FactoryStrategyFixture.getStrategyFixture(tipo,fechaInicio, equipoCollection, canchaCollection, arbitros, duracionPartidos, bandaHoraria, diasJornada);

    }

    public void addCancha(Cancha cancha){
        canchas.add(cancha);
    }

    public void addEquipo(Equipo equipo){
        equipos.add(equipo);
    }

    public void generarFixture(){
        fixtureTorneo = strategy.buildFixture();
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public Fixture getFixtureTorneo() {
        if(fixtureTorneo == null)
            generarFixture();
        return fixtureTorneo;
    }//TODO QUITAR

    public Collection<AdministradorTorneo> getAdministradores() {
        return administradores;
    }

    public Collection<Cancha> getCanchas() {
        return canchas;
    }

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public int getDuracionPartidos() {
        return duracionPartidos;
    }

    public Integer[] getDiasJornada() {
        return diasJornada;
    }

    public String getBandaHoraria() {
        return bandaHoraria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setCanchas(Collection<Cancha> canchas) {
        this.canchas = canchas;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }
}
