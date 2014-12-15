package com.futbol.manager.model.exceptions;

import java.util.Collection;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class TorneoExcepcionHandler{
    
     private TorneoExcepcionHandler (){
     }


     /**
      *  Valida que la Coleccion collection no este vacia. En caso de estar vacia arroja una TorneoException.
      *
      * @param collection Coleccion a validar
      * @param msg Mensaje de la Exception 
      * @param params Parametros de la Exception
      */
     public static void checkCollection(Collection<?> collection, String msg, Object... params){
         if (collection.isEmpty())
             throw new TorneoException(msg,params);
     }


     /**
      * Valida que el objeto param no sea nulo. En caso de ser nulo arroja una TorneoException.
      *
      * @param param Objeto a validar
      * @param msg Mensaje de la Exception
      * @param params Parametros de la Exception
      */
     public static void checkNull(Object param, String msg, Object... params){
         if (param == null)
             throw new TorneoException(msg, params);
     }

     /**
      *
      * @param msg - Codigo del mensaje a lanzar
      * @param params - Parametros que se instanciaran en el el texto del mensaje
      */
     public static void launchException(String msg, Object... params){
         throw new TorneoException(msg, params);
     }

     /**
      * Permite lanzar exceptions sin parametros.
      *
      * @param msg es el codigo del mensaje a lanzar.
      */
     public static void launchException(String msg){
         throw new TorneoException(msg);
     }

     /**
      * Tiramos una TorneoException en base a otra excepcion
      *
      * @param ex
      */
     public static void launchException(Throwable ex) {
         throw new TorneoException(ex);
     }

     /**
      * Tiramos una TorneoException en base a otra excepcion
      *
      * @param ex
      */
     public static void launchException(Throwable ex, String msg) {
         throw new TorneoException(ex, msg);
     }

}
