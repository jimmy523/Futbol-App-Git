package com.futbol.manager.ioc;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by aandrade on 12/09/2014.
 */
public class ServiceLocator {

    private static Logger logger = Logger.getLogger(ServiceLocator.class);


    private static ApplicationContext springContext;
    private static ServiceLocator instance = null;
    private static String CONFIGURATION_FILE = "webapp/WEB-INF/applicationContext.xml";

    public static ServiceLocator getInstance()
    {
        if (instance == null) {
            logger.debug("Creo instancia ï¿½nica.");
            instance = new ServiceLocator();
            springContext = new ClassPathXmlApplicationContext(CONFIGURATION_FILE);
        }

        return instance;
    }

    public ApplicationContext getSpringContext() {
        return springContext;
    }

    public void setSpringContext(ApplicationContext springContext) {
        ServiceLocator.springContext = springContext;
    }
}
