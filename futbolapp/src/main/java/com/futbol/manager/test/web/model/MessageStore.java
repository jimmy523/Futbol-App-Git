package com.futbol.manager.test.web.model;

/**
 * Created by aandrade on 05/09/2014.
 */
public class MessageStore {
    private String message;

    public void setMessage(String message) {

        this.message = message;

    }

    public String getMessage() {

        return message;

    }



    @Override

    public String toString() {

        return message;

    }
}
