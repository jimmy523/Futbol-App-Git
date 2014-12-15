package com.futbol.manager.model.helper;

import com.futbol.manager.model.exceptions.TorneoException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: aandrade
 * @fecha: 05/09/2014
 */
public class ReflectionHelper {

    protected static ClassLoader classLoader = null;

    public ReflectionHelper()  {
    }

    /**
     * Retorna un m�todo llamado methodName de la clase de anObject
     * No permite especificar qu� m�todo retornar en caso de que haya overloading
     * @return Method
     */
    public static Method getMethod(Object anObject, String methodName) throws TorneoException {
        return getMethod(anObject.getClass(),methodName);
    }

    /**
     * Retorna un m�todo llamado methodName de la clase llamada className
     * No permite especificar qu� m�todo retornar en caso de que haya overloading
     * @return Method
     */
    public static Method getMethod(String className, String methodName) throws TorneoException {

        try  {
            return getMethod(loadClass(className), methodName);
        } catch (ClassNotFoundException cnfex)  {
            throw new TorneoException(cnfex );
        }
    }

    /**
     * Retorna un m�todo llamado methodName de la clase clazz
     * No permite especificar qu� m�todo retornar en caso de que haya overloading
     * @param clazz La clase ( o una superclase ) donde est�n declarados los m�todos
     * @param methodName
     * @return Method
     */
    public static Method getMethod(Class clazz, String methodName) throws TorneoException {
        Method method = null;

        Method[] methods = clazz.getMethods();
        for (int i = 0;(method == null) && (i < methods.length); i++) {
            if (methods[i].getName().equals(methodName)) {
                method = methods[i];
            }
        }
        if (method == null) {
            throw new TorneoException("Method '"+methodName+"' not found in "+clazz.getName());
        }
        return method;
    }


    /**
     * Este m�todo devuelve una lista de todas las superclases de una clase
     *@return Collection
     */
    public static Collection getSuperclasses(Class clazz) {
        Vector ret = new Vector();

        Class superClass = clazz.getSuperclass();
        while (superClass != null) {
            ret.add(superClass);
            superClass = superClass.getSuperclass();
        }

        return ret;
    }

    /**
     * Carga una clase usando un class loader del contexto
     * @param className Nombre completo de la clase ( FQ )
     * @return Class La clase
     * @throws ClassNotFoundException
     */
    public static Class loadClass( String className ) throws ClassNotFoundException {

        return getClassLoader().loadClass(className);
    }

    /**
     * Retorna el ClassLoader a usar para cargar recursos y clases
     * @return El ClassLoader
     */
    public static synchronized ClassLoader getClassLoader() {
        return ( classLoader == null ) ? Thread.currentThread().getContextClassLoader() : classLoader;
    }

    /**
     * Retorna un InputStream cargado a trav�s del ContextClassLoader del Thread.
     *
     */
    public static InputStream getResourceAsStream(String resourceName ) {
        return getClassLoader().getResourceAsStream(resourceName);
    }

    /**
     * @see java.lang.ClassLoader#getResources
     *
     */
    public static Enumeration getResources(String resourceName ) throws IOException, IOException {
        return getClassLoader().getResources(resourceName);
    }

    /**
     * Retorna un URL cargado a trav�s del ContextClassLoader del Thread.
     *
     */
    public static URL getResource(String resourceName ) {
        return getClassLoader().getResource(resourceName);
    }

    public static synchronized void setClassLoader ( ClassLoader cl ) {
        classLoader = cl;
    }

    public static synchronized void resetClassLoader () {
        classLoader = null;
    }

}