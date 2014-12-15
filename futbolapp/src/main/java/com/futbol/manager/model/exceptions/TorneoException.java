package com.futbol.manager.model.exceptions;

/**
 * @author: aandrade
 * @fecha: 04/09/2014
 */
public class TorneoException extends UserException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Este es por que generalmente se va a usar el mismo codigo de
     * error como key en el resource boundle, y como el codigo de 
     * error de usuario que se manda para afuera.
     *
     * @param errorCode
     * @param params
     */
    public TorneoException(String errorCode, Object[] params) {
        super (errorCode, params, errorCode);
    }

    /**
     * No se posee parametros para este error.
     *
     * @param errorCode
     */
    public TorneoException(String errorCode) {
        super (errorCode);
    }

    /**
     * Creamos una excepción en base a otra excepcion
     *
     * @param ex
     */
    public TorneoException(Throwable ex) {
        super(ex);
    }

    /**
     * Se crea una excepción en base a otra excepcion y un mensaje o codigo de error
     *
     * @param ex
     */
    public TorneoException(Throwable cause, String errorCode) {
        super(cause,errorCode);
    }

    /**
     * Crea una excepción dado un código de mensaje, parámetros y código adicional.
     * @param errorCode código de error referenciado en ResourceMsgBundle.
     * @param params parámetros que se referencian en en el formato del mensaje.
     * @param userErrorCode código adicional.
     */
    public TorneoException(String errorCode, Object[] params, String userErrorCode) {
        super (errorCode, params, userErrorCode);
    }





}
