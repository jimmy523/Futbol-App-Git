package com.futbol.manager.service.torneo;

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
 * Created by aandrade on 06/09/2014.
 */
@Service
public interface TorneoService {
    public void darAltaTorneo(TorneoForm torneoForm);
    public TorneoDto obtenerTorneoById(Long id);
    public Collection<TorneoDto> obtenerTorneoByManagerId(Long id);
    public void darDeAltaCancha(CanchaForm canchaForm);
    public void darAltaArbitro(ArbitroForm arbitroForm);
    public Collection<EncuentroDto> obtenerEncuentrosByFechaJornada(Date fecha);
    public void suspenderJornadaByFecha(Date fecha);
    public void SuspenderEquipo(SuspensionEquipoForm suspensionEquipoForm);
}
