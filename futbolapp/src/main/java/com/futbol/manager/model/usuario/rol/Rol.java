package com.futbol.manager.model.usuario.rol;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "ROL")
public class Rol implements Serializable{

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
