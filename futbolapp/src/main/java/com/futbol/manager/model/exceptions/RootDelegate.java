package com.futbol.manager.model.exceptions;

import java.io.Serializable;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class RootDelegate implements Serializable, Nestable, InternationalizableMessage, UserCodedException {


    private static final long serialVersionUID = 1L;

    /**
     * Código de error de usuario
     */
    protected String userErrorCode = "";


    /**
     * Código identificador del mensaje de la Exception
     *
     */
    private String code;

    /**
     * Parámetros a usar para generar el mensaje.
     */
    private Object[] parameters;

    /**
     * Causa de la Exception
     */
    private Throwable cause;

    /**
     *
     * @param code
     */
    public RootDelegate ( String code ) {
        this.setCode ( code );
    }

    /**
     *
     * @param code
     * @param parameters
     */
    public RootDelegate ( String code, Object[] parameters) {
        this.setCode ( code );
        this.setParameters ( parameters );
    }

    /**
     *
     * @param cause
     */
    public RootDelegate ( Throwable cause ) {
        this.setCause ( cause );
    }

    /**
     *
     * @param cause
     * @param code
     * @param parameters
     */
    public RootDelegate ( Throwable cause, String code, Object[] parameters ) {
        this.setCause ( cause );
        this.setCode ( code );
        this.setParameters ( parameters );
    }

    //Methods generated from implementation of interface Nestable
    /**
     *
     */
    public boolean hasCause(){
        return ( this.getCause() != null );
    }

    /**
     * @param cause
     */
    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    /**
     *
     */
    public Throwable getCause(){
        return this.cause;
    }

    //Methods generated from implementation of interface InternationalizableMessage
    /**
     *
     */
    public String getMessage(){
        if (this.code != null ) {
            return ExceptionMessagesManager.getExceptionMessageFor ( this.getCode (), this.getParameters() );
        }
        if (this.cause != null) {
            return this.cause.getMessage();
        }
        return this.userErrorCode;
    }

    /**
     * @param code
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     *
     */
    public String getCode(){
        return this.code;
    }

    /**
     * @param parameters
     */
    public void setParameters(Object[] parameters){
        this.parameters = parameters;
    }

    /**
     *
     */
    public Object[] getParameters(){
        return this.parameters;
    }

    /**
     *
     * @return
     */
    public String getUserErrorCode() {
        return userErrorCode;
    }

    /**
     *
     * @param string
     */
    public void setUserErrorCode(String string) {
        userErrorCode = string;
    }

}