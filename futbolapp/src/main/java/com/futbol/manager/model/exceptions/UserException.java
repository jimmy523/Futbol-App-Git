package com.futbol.manager.model.exceptions;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class UserException extends RootException implements UserCodedException {

    /**
     * Constructor for UserException.
     * @param errorCode
     */
    public UserException ( String errorCode ) {
        super ( errorCode );
    }

    /**
     * Constructor for UserException.
     * @param errorCode
     * @param params
     */
    public UserException ( String errorCode, Object[] params ) {
        super ( errorCode, params );
    }

    /**
     * Constructor for UserException.
     * @param cause
     */
    public UserException ( Throwable cause ) {
        super ( cause );
    }

    /**
     * Constructor for UserException.
     * @param cause
     * @param errorCode
     * @param params
     */
    public UserException ( Throwable cause, String errorCode, Object[] params ) {
        super ( cause, errorCode, params );
    }


    /**
     * Constructor for UserException.
     * @param errorCode Código del mensaje de error
     * @param userErrorCode Código de error de usuario
     */
    public UserException ( String errorCode, String userErrorCode ) {
        super ( errorCode );
        setUserErrorCode(userErrorCode);
    }

    /**
     * Constructor for UserException.
     * @param errorCode
     * @param params
     * @param userErrorCode Código de error de usuario
     */
    public UserException ( String errorCode, Object[] params, String userErrorCode  ) {
        super ( errorCode, params );
        setUserErrorCode(userErrorCode);
    }

    /**
     * Constructor for UserException.
     * @param cause
     * @param userErrorCode Código de error de usuario
     */
    public UserException ( Throwable cause, String userErrorCode  ) {
        super ( cause );
        setUserErrorCode(userErrorCode);
    }

    /**
     * Constructor for UserException.
     * @param cause
     * @param errorCode
     * @param params
     * @param userErrorCode Código de error de usuario
     */
    public UserException ( Throwable cause, String errorCode, Object[] params, String userErrorCode  ) {
        super ( cause, errorCode, params );
        setUserErrorCode(userErrorCode);
    }


    /**
     *
     * @return
     */
    public String getUserErrorCode() {
        return this.rootDelegate.getUserErrorCode();
    }

    /**
     *
     * @param string
     */
    public void setUserErrorCode(String string) {
        this.rootDelegate.setUserErrorCode(string);
    }

}