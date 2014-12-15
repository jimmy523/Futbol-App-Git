package com.futbol.manager.model.usuario.arbitro;

import javax.persistence.*;

/**
 * Created by aandrade on 22/10/2014.
 */
@Entity
@Table(name = "TIPO_ARBITRAJE")
public class TipoArbitraje {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
