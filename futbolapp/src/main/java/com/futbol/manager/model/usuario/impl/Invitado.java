package com.futbol.manager.model.usuario.impl;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.equipo.tipo.EquipoFutbol;
import com.futbol.manager.model.usuario.Convocado;
import com.futbol.manager.model.persona.Usuario;
import com.futbol.manager.model.usuario.rol.Rol;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "INVITADO")
public class Invitado implements Convocado,Serializable {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_id_equipo")
    private Long id_equipo;

    @Column(name = "c_id_usuario")
    private Long id_usuario;

    @Column(name = "posicion")
    private String posicion;

    /**
     * Dueño de la relacion:
     * @see com.futbol.manager.model.equipo.Equipo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_equipo")
    private EquipoFutbol equipo;

    //Unidireccional
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id_usuario")
    private Usuario usuario;

    @Override
    public void confirmarConvocacion() {

    }

}
