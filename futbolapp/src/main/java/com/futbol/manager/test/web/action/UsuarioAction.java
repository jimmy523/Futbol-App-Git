package com.futbol.manager.test.web.action;

import com.futbol.manager.test.web.formulario.Usuario;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by aandrade on 05/09/2014.
 */
public class UsuarioAction extends ActionSupport {

    private String nombre;
    private String username;
    private String password;
    private int edad;
    private Date fechaNacimiento;

    private Usuario usuario;

    @Override
    public String execute() throws Exception
    {
        usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEdad(edad);
        usuario.setFechaNacimiento(fechaNacimiento);

        return SUCCESS;
    }


    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}