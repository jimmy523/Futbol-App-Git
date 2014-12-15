package com.futbol.manager.model.exceptions;

import com.futbol.manager.model.helper.ReflectionHelper;

import java.text.MessageFormat;
import java.util.*;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class ExceptionMessagesManager  /*implements InitializingBean */{

    private static Map excepMsg = new HashMap();

    /*
    @Autowired
    private ApplicationContext context;*/


    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    private List<String> resources;
    private static ExceptionMessagesManager myInstance;

    public ExceptionMessagesManager() {
    }

    public static synchronized ExceptionMessagesManager getInstance() {
        if (myInstance==null) myInstance = new ExceptionMessagesManager();
        return myInstance;
    }

    /**
     * Obtiene un recurso del sistema y agrega sus mensajes a la lista.
     * @param exceptionMessageResource
     */
    public static void addExceptionMessageResource(String exceptionMessageResource) {
        try {
			/*
			 * Modifique la forma en que se obtiene el bundle, ya que aparentemente
			 * habia un conflicto con el ClassLoader ( por mas que el "exceptionMessageResource"
			 * estaba dentro del .jar de core no lo veia ). yapzaf
			 */

            ResourceBundle rb = ResourceBundle.getBundle ( exceptionMessageResource,
                    Locale.getDefault()
                    , ReflectionHelper.getClassLoader() );
            storeMessages(rb);
        } catch (MissingResourceException e) {
            //logger.warn("No pude cargar recurso \"" + exceptionMessageResource + "\"");
        }
    }

    /**
     * Agrega el contenido de un recurso a la lista de codigos de error disponibles
     * @param rb
     */
    private static void storeMessages(ResourceBundle rb) {
        Enumeration keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String message = rb.getString(key);
            excepMsg.put(key, message);
        }
    }


    /**
     * Devuelve el mensaje de error asociado con el c�digo. Si no encuentra un mensaje,
     * entonces devuelve el c�digo de error.
     * @param msgKey
     * @param params
     * @return String
     */
    public static String getExceptionMessageFor(String msgKey, Object[] params) {
        String msg = (String) excepMsg.get(msgKey);

        if (msg != null) {
            if (params!=null) msg = MessageFormat.format(msg, params);
        } else  {
            //msg = ApplContext.getInstance().getMessage(msgKey,params, Locale.getDefault());
        }

        if (msg==null) {
            // devuelvo el codigo de error como mensaje por compatibilidad hacia atras
            msg = msgKey;
        }


        return msg;
    }

    public void afterPropertiesSet() throws Exception {
        for (String resource : resources) {
            addExceptionMessageResource(resource);
        };
    }
}
