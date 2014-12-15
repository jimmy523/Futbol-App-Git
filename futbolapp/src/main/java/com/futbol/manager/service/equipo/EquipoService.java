package com.futbol.manager.service.equipo;

import com.futbol.manager.view.dto.EquipoDto;
import com.futbol.manager.view.form.EquipoForm;
import com.futbol.manager.view.form.JugadorForm;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by aandrade on 05/09/2014.
 */
@Service
public interface EquipoService {

    public void crearEquipo(EquipoForm equipoForm);
    public void darDeBajaEquipo(EquipoDto equipoDto);
    public void addJugador(JugadorForm jugadorForm);
    public EquipoDto obtenerEquipoById(Long id);
    public Collection<EquipoDto> obtenerEquiposByTorneoId(Long id);
}
