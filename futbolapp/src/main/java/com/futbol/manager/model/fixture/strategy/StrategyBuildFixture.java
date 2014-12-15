package com.futbol.manager.model.fixture.strategy;

import com.futbol.manager.model.exceptions.TorneoExcepcionHandler;
import com.futbol.manager.model.cancha.Cancha;
import com.futbol.manager.model.equipo.Equipo;
import com.futbol.manager.model.fixture.Fixture;
import com.futbol.manager.model.encuentro.Encuentro;
import com.futbol.manager.model.fecha.Jornada;
import com.futbol.manager.model.usuario.impl.Arbitro;
import com.futbol.manager.model.utils.collection.SetModificable;
import com.futbol.manager.model.utils.date.DateUtils;
import com.futbol.manager.model.utils.date.wrapper.DateWrapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.math3.util.Combinations;
import org.apache.log4j.Logger;


import java.util.*;

/**
 * @author: aandrade
 * @fecha: 02/09/2014
 */
public abstract class StrategyBuildFixture {

    public static Logger LOGGER = Logger.getLogger(StrategyBuildFixture.class);

    protected Calendar fechaInicio;
    protected Collection<Equipo> equipos;
    protected Collection<Cancha> canchas;
    protected Collection<Arbitro> arbitros;
    protected int duracionEncuentros;
    protected String franjaHoraria;//10:00-17:00
    protected Integer[] diasTorneo;//1 (DOMINGO)- 2 (LUNES)-3 (MARTES)-4 (MIERCOLES)-5 (JUEVES)-6 (VIERNES)-7 (SABADO)-


    protected StrategyBuildFixture(Calendar fechaInicio, Collection<Equipo> equipos, Collection<Cancha> canchas, Collection<Arbitro> arbitros, int duracionEncuentros, String franjaHoraria, Integer[] diasTorneo) {
        this.fechaInicio = fechaInicio;
        this.equipos = equipos;
        this.canchas = canchas;
        this.duracionEncuentros = duracionEncuentros;
        this.franjaHoraria = franjaHoraria;
        this.diasTorneo = diasTorneo;
        this.arbitros = arbitros;
    }

    public Fixture buildFixture() {
        Fixture fixture = new Fixture();
        LOGGER.debug("Iniciando Creacion de FIXTURE");
        Collection<Jornada> jornadas = construirJornadasConHorarios(fechaInicio, equipos, duracionEncuentros, diasTorneo);
        jornadas = asignarCanchasEncuentrosByJornada(jornadas, canchas);
        jornadas = asignarArbitrajeByEncuentro(jornadas,arbitros,canchas.size());
        fixture.setFechas(jornadas);

        return fixture;
    }

    protected Collection<Jornada> asignarArbitrajeByEncuentro(Collection<Jornada> jornadas, Collection<Arbitro> arbitros, int cantidadCanchas){

        if(cantidadCanchas <= arbitros.size()){
            Iterator<Jornada> itJornada = jornadas.iterator();
            SetModificable<Arbitro> conjuntoArbitros = new SetModificable<Arbitro>(arbitros);
            while (itJornada.hasNext()){
                Jornada jornada = itJornada.next();
                Iterator<Encuentro> itEncuentro = jornada.getEncuentrosPorDisputarse().iterator();
                while (itEncuentro.hasNext()){
                    Encuentro encuentro = itEncuentro.next();
                    Arbitro arbitro = conjuntoArbitros.getAndRemove();
                    if (arbitro != null){
                        encuentro.setArbitraje(Collections.singletonList(arbitro));
                    }else {
                        TorneoExcepcionHandler.launchException("No existen Arbitros disponibles para asignar a jornada");
                    }
                }

            }
        }else {
            // excepcion se deben agregar mas arbitros al torneo para cubrir los encuentros o agregar mas dias a la jornadas del torneo
        }

        return jornadas;
    }

    protected Collection<Jornada> asignarCanchasEncuentrosByJornada(Collection<Jornada> jornadas, Collection<Cancha> canchas){
        int partidosByJornada = jornadas.iterator().next().getEncuentrosPorDisputarse().size();
        int horariosByJornada = DateUtils.calcularHorariosJornada(duracionEncuentros,franjaHoraria).size();///NO ESTA FUNCIONANDO CORRECTAMENTE

        if(partidosByJornada/horariosByJornada<=1){
            if(canchas.size()>=1){
                Iterator<Jornada> itJornada = jornadas.iterator();
                SetModificable<Cancha> conjuntoCanchas = new SetModificable<Cancha>(canchas);
                while (itJornada.hasNext()){
                    Jornada jornada = itJornada.next();
                    Iterator<Encuentro> itEncuentro = jornada.getEncuentrosPorDisputarse().iterator();
                    while (itEncuentro.hasNext()){
                        Encuentro encuentro = itEncuentro.next();
                        Cancha cancha = conjuntoCanchas.getAndRemove();
                        if (cancha != null){
                            encuentro.setCancha(cancha);
                        }else {
                            TorneoExcepcionHandler.launchException("No existen canchas disponibles para asignar a encuentro");
                        }
                    }

                }
            }else {
                TorneoExcepcionHandler.launchException("Debe existir al menos una cancha creada");
            }

        }else {
            //redondeo y debo veriifcar que existan la cantidad de acanchas adecuadas
            Double cantidadCanchasCalculadas = Math.ceil( (double)partidosByJornada / (double)horariosByJornada );
            if (cantidadCanchasCalculadas<=canchas.size()){
                Iterator<Jornada> itJornada = jornadas.iterator();
                SetModificable<Cancha> conjuntoCanchas = new SetModificable<Cancha>(canchas);
                while (itJornada.hasNext()){
                    Jornada jornada = itJornada.next();
                    Iterator<Encuentro> itEncuentro = jornada.getEncuentrosPorDisputarse().iterator();
                    while (itEncuentro.hasNext()){
                        Encuentro encuentro = itEncuentro.next();
                        Cancha cancha = conjuntoCanchas.getAndRemove();
                        if (cancha != null){
                            encuentro.setCancha(cancha);
                        }else {
                            TorneoExcepcionHandler.launchException("No existen canchas disponibles para asignar a encuentro");
                        }
                    }

                }
            }else {
                TorneoExcepcionHandler.launchException("Deben haber creadas al menos:"+(canchas.size()-cantidadCanchasCalculadas)+" canchas creadas");
            }

        }

        return jornadas;
    }

    protected Collection<Jornada> construirJornadasConHorarios(Calendar fechaInicio, Collection<Equipo> equipos, int duracionEncuentros, Integer[] diasTorneo){
        LOGGER.debug("Construyendo las jornadas necesarias para que se enfrenten los: "+equipos.size());
        Map<Integer,Equipo> map = new HashMap<Integer, Equipo>();// le asigno a cada equipo un id numerico;
        List<Equipo> listEquipos = new ArrayList<Equipo>(equipos);
        for(int i = 0; i<listEquipos.size(); i++){
            map.put(i,listEquipos.get(i));
        }

        LOGGER.debug("Se le asigno a cada equipo un identificador parcial para generar los encuentros");
        LOGGER.debug(map.toString());

        Iterator<int[]> combinacionEncuentros = new Combinations(equipos.size(),2).iterator();
        List<int[]> list = IteratorUtils.toList(combinacionEncuentros);
        HashSet<int[]> setEncuentros = new HashSet<int[]>(list);

        Integer cantEncuentrosEstimadosInt = list.size();
        Integer cantJornadasCalculadas = cantEncuentrosEstimadosInt/2;
        Integer cantFechasByJornada = equipos.size()/2;
        LOGGER.debug("Cantidad de encuentros calculados:"+cantEncuentrosEstimadosInt);
        LOGGER.debug("Cantidad de jornadas necesarias para el torneo:"+cantJornadasCalculadas);
        LOGGER.debug("Cantidad de fechas que deberan jugarse por jornada:"+cantFechasByJornada);



        boolean equipoLibrePorJornada = Boolean.FALSE;

        if(cantEncuentrosEstimadosInt%2 != 0){//es impar
            equipoLibrePorJornada = Boolean.TRUE;
            LOGGER.debug("Habra un equipo libre por jornada");
            cantJornadasCalculadas = (cantJornadasCalculadas+1)/2;
            LOGGER.debug("Se calculo nuevamente la cantidad de jornadas necesarias, nuevo valor: "+cantJornadasCalculadas);
        }

        LinkedList<Jornada> jornadasList = new LinkedList<Jornada>();
        int identificadorJornada = 0;

        do {
            identificadorJornada++;

            Jornada jornada = new Jornada();//
            jornada.setId(Long.valueOf(identificadorJornada));

            HashSet<Integer> setEquiposEnEncuentroEnJornada = new HashSet<Integer>();//utilizo este set para evitar generar encuentros
            SetModificable<int[]> setEncuentrosDinamico = new SetModificable<int[]>(setEncuentros);//creo un set para poder generar los encuentros

            boolean deboSalir = false;
            int contEncuentrosByJornada = 0;
            while (!deboSalir && !setEncuentrosDinamico.isEmpty()){
                int[] idsEquipo = setEncuentrosDinamico.getAndRemove();//lo obtengo y lo quito del set
                Integer equipoLocal = (Integer) CollectionUtils.get(idsEquipo, 0);
                Integer equipoVisitante = (Integer) CollectionUtils.get(idsEquipo, 1);
                if(!setEquiposEnEncuentroEnJornada.contains(equipoLocal) && !setEquiposEnEncuentroEnJornada.contains(equipoVisitante)){
                    //genero el encuentro<
                    Encuentro encuentro = new Encuentro();
                    encuentro.setLocal(map.get(equipoLocal));
                    encuentro.setVisitante(map.get(equipoVisitante));
                    jornada.addEncuentro(encuentro);
                    //setEncuentrosARemove.add(idsEquipo);//lo quito del set
                    LOGGER.debug("Jornada: " + identificadorJornada);
                    LOGGER.debug("Equipo: " + equipoLocal + " VS Equipo: " + equipoVisitante);
                    contEncuentrosByJornada++;
                    setEquiposEnEncuentroEnJornada.add(equipoLocal);
                    setEquiposEnEncuentroEnJornada.add(equipoVisitante);
                    if (contEncuentrosByJornada == cantFechasByJornada)
                        deboSalir = Boolean.TRUE;
                }
            }

            jornadasList.add(jornada);

        }while (jornadasList.size() != cantJornadasCalculadas);

        Iterator<DateWrapper> itJornadasWithHorarios = DateUtils.fechasBetween(fechaInicio,diasTorneo,franjaHoraria,duracionEncuentros,equipoLibrePorJornada,cantJornadasCalculadas,cantFechasByJornada).iterator();
        Iterator<Jornada> itJornada = jornadasList.iterator();

        while(itJornadasWithHorarios.hasNext() && itJornada.hasNext()){
            DateWrapper dateWrapper = itJornadasWithHorarios.next();
            Jornada jornada = itJornada.next();

            jornada.setFecha(dateWrapper.getDia());

            Iterator<Encuentro> itEncuentro = jornada.getEncuentrosPorDisputarse().iterator();
            Iterator<Calendar> itHorarios = dateWrapper.getHorariosJornada().iterator();

            while (itEncuentro.hasNext() && itHorarios.hasNext()){
                Encuentro encuentro = itEncuentro.next();
                Calendar horario = itHorarios.next();
                encuentro.setHorario(horario);
            }

        }

        return jornadasList;
    }
}
