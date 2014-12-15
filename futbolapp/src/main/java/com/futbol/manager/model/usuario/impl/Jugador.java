package com.futbol.manager.model.usuario.impl;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.usuario.Convocado;
import com.futbol.manager.model.usuario.IJugador;
import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.usuario.rol.Rol;
import com.futbol.manager.model.usuario.state.Estado;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "JUGADOR")
public class Jugador implements IJugador,Convocado,Serializable{

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_id_equipo")
    private Long id_equipo;

    @Column(name = "c_id_usuario")
    private Long id_usuario;

    /**
     * Dueño de la relacion:
     * @see com.futbol.manager.model.equipo.Equipo
     *
     * Bireccional
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_equipo")
    private Equipo equipo;

    //Unidireccional
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    @Column(name = "numero_camiseta")
    private int numero_camiseta;

    @Column(name = "posicion")
    private int posicion;

    public void denegarConvocacion() {
    }

    @Override
    public void confirmarAsistenciaProxEncuentro() {

    }

    public void denegarAsistProxEncuentro(){}

    @Override
    public void confirmarConvocacion() {

    }
}
