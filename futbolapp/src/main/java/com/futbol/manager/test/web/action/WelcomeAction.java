package com.futbol.manager.test.web.action;

import com.futbol.manager.test.web.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by aandrade on 05/09/2014.
 */
public class WelcomeAction extends ActionSupport {

    private MessageStore welcome;

    public void setWelcome(MessageStore welcome) {
        this.welcome = welcome;
    }

    public MessageStore getWelcome() {
        return welcome;
    }

    public String execute(){
        return SUCCESS;
    }

}