package com.futbol.manager.view.dto;

import java.io.Serializable;

/**
 * Created by aandrade on 05/09/2014.
 */
public class CanchaDto implements Serializable {
    private String nombre;
    private String tipo;

    public CanchaDto() {
    }

    public CanchaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
