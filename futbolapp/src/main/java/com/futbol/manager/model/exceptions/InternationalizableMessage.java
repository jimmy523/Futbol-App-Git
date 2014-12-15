package com.futbol.manager.model.exceptions;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public interface InternationalizableMessage {
    public String getMessage();

    /**
     * @param code
     */
    public void setCode(String code);

    public String getCode();

    /**
     * @param parameters
     */
    public void setParameters(Object[] parameters);

    public Object[] getParameters();

}