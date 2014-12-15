package com.futbol.manager.service.torneo.impl;

import com.futbol.manager.service.torneo.TorneoService;
import com.futbol.manager.view.dto.EncuentroDto;
import com.futbol.manager.view.dto.TorneoDto;
import com.futbol.manager.view.form.ArbitroForm;
import com.futbol.manager.view.form.CanchaForm;
import com.futbol.manager.view.form.SuspensionEquipoForm;
import com.futbol.manager.view.form.TorneoForm;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Contendra todos los servicios de la Administracion del torneo
 */
public class TorneoServiceImpl implements TorneoService{

    @Override
    public void darAltaTorneo(TorneoForm torneoForm) {

    }

    @Override
    public TorneoDto obtenerTorneoById(Long id) {
        return null;
    }

    @Override
    public Collection<TorneoDto> obtenerTorneoByManagerId(Long id) {
        return null;
    }

    @Override
    public void darDeAltaCancha(CanchaForm canchaForm) {

    }

    @Override
    public void darAltaArbitro(ArbitroForm arbitroForm) {

    }

    @Override
    public Collection<EncuentroDto> obtenerEncuentrosByFechaJornada(Date fecha) {
        return null;
    }

    @Override
    public void suspenderJornadaByFecha(Date fecha) {

    }

    @Override
    public void SuspenderEquipo(SuspensionEquipoForm suspensionEquipoForm) {

    }
}
