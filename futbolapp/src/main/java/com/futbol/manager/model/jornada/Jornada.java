package com.futbol.manager.model.jornada;

import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.encuentro.Encuentro;
import com.futbol.manager.model.jornada.estado.Estado;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by aandrade on 02/09/2014.
 */
@Entity
@Table(name = "JORNADA")
public class Jornada {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaInicio;
    @Column(name = "identificador")
    private String identificador;
    @Column(name = "c_id_torneo")
    private Long idTorneo;
    @JoinColumn(name = "c_id_estado",referencedColumnName = "c_id")
    private Estado estado;


    private Collection<Encuentro> encuentrosPorDisputarse;

    public Jornada() {
        encuentrosPorDisputarse = new LinkedList<Encuentro>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Encuentro> getEncuentrosPorDisputarse() {
        return encuentrosPorDisputarse;
    }

    public void setEncuentrosPorDisputarse(Collection<Encuentro> encuentrosPorDisputarse) {
        this.encuentrosPorDisputarse = encuentrosPorDisputarse;
    }

    public void addEncuentro(Encuentro e){
        encuentrosPorDisputarse.add(e);
    }

}
