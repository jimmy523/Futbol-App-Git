package com.futbol.manager.model.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class RootException  extends RuntimeException implements Nestable, InternationalizableMessage{

    /**
     *
     */
    protected RootDelegate rootDelegate;

    /**
     *
     * @param code
     */
    public RootException ( String code ) {
        this.rootDelegate = new RootDelegate ( code );
    }

    /**
     *
     * @param code
     * @param parameters
     */
    public RootException ( String code, Object[] parameters ) {
        this.rootDelegate = new RootDelegate ( code, parameters );
    }

    /**
     *
     * @param cause
     */
    public RootException ( Throwable cause ) {
        this.rootDelegate = new RootDelegate ( cause );
    }

    /**
     *
     * @param cause
     * @param code
     * @param parameters
     */
    public RootException ( Throwable cause, String code, Object[] parameters ) {
        this.rootDelegate = new RootDelegate ( cause, code, parameters );
    }


    //Methods generated from implementation of interface Nestable
    /**
     *
     */
    public boolean hasCause (){
        return this.rootDelegate.hasCause ();
    }

    /**
     * @param    cause
     */
    public void setCause(Throwable cause ) {
        this.rootDelegate.setCause ( cause );
    }

    /**
     *
     */
    public Throwable getCause () {
        return this.rootDelegate.getCause();
    }

    //Methods generated from implementation of interface InternationalizableMessage
    /**
     *
     */
    public String getMessage () {
        return this.rootDelegate.getMessage();
    }

    /**
     * @param    code
     */
    public void setCode ( String code ) {
        this.rootDelegate.setCode ( code );
    }

    /**
     *
     */
    public String getCode () {
        return this.rootDelegate.getCode ();
    }

    /**
     * @param    parameters
     */
    public void setParameters ( Object[] parameters ){
        this.rootDelegate.setParameters (  parameters );
    }

    /**
     *
     */
    public Object[] getParameters () {
        return this.rootDelegate.getParameters ();
    }

    // printStackTrace
    /**
     * Imprime el stacktrace de la Exception y de su causa
     */
    public void printStackTrace () {
        super.printStackTrace ();
        if ( this.hasCause() ) {
            this.getCause().printStackTrace ();
        }
    }

    /**
     * Imprime el stacktrace de la Exception y de su causa
     */
    public void printStackTrace ( PrintStream s ) {
        super.printStackTrace ( s );
        if ( this.hasCause () ) {
            this.getCause().printStackTrace ( s );
        }
    }

    /**
     * Imprime el stacktrace de la Exception y de su causa
     */
    public void printStackTrace ( PrintWriter s ) {
        super.printStackTrace ( s );
        if ( this.hasCause() ) {
            this.getCause().printStackTrace ( s );
        }
    }
}