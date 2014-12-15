package com.futbol.manager.model.exceptions;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public interface Nestable {
    public boolean hasCause();

    /**
     * @param cause
     */
    public void setCause(Throwable cause);
    public Throwable getCause();

}