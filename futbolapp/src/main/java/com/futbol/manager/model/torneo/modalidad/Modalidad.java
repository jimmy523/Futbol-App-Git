package com.futbol.manager.model.torneo.modalidad;

import javax.persistence.*;

/**
 * Created by aandrade on 23/10/2014.
 */
@Entity
@Table(name = "MODALIDAD")
public class Modalidad {
    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;
}
