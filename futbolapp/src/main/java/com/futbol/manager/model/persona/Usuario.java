package com.futbol.manager.model.persona;

import com.futbol.manager.model.usuario.rol.Rol;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by aandrade on 09/09/2014.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

    @Id
    @Column(name = "c_id")
    @GeneratedValue
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date updateDate;
    @Column(name = "username")
    private String usuarname;
    @Column(name = "password")
    private String password;
    @Column(name = "dni")
    private String dni;
    @Column(name = "email")
    private String email;


    /**
     * http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/#entity-mapping-association
     *
     * 2.2.5.3.1.3. Unidirectional with join table
     */
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable
            (
                    name="USUARIO_ROL",
                    joinColumns={ @JoinColumn(name="c_id_usuario", referencedColumnName="c_id") },
                    inverseJoinColumns={ @JoinColumn(name="c_id_rol", referencedColumnName="c_id") }
            )
    protected List<Rol> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUsuarname() {
        return usuarname;
    }

    public void setUsuarname(String usuarname) {
        this.usuarname = usuarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void addRoles(Rol rol) {
        this.roles.add(rol);
    }
}
