package com.futbol.manager.model.usuario.impl;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.usuario.IAdministradorEquipo;
import com.futbol.manager.model.usuario.IJugador;
import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.usuario.rol.Rol;

import javax.persistence.*;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "ADMINISTRADOR_EQUIPO")
public class AdministradorEquipo implements IAdministradorEquipo,IJugador{

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "c_id_equipo")
    private Equipo equipo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    @Override
    public void convocarJugador() {

    }

    @Override
    public void AgregarJugador() {

    }

    @Override
    public void darBajaJugador() {

    }

    @Override
    public void agregarInvitado() {

    }

    @Override
    public void darBajaInvitado() {

    }

    @Override
    public void confirmarEquipo() {

    }

    @Override
    public void confirmarAsistenciaProxEncuentro() {

    }
}
