package com.futbol.manager.ioc;

import com.futbol.manager.model.exceptions.TorneoException;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by aandrade on 06/09/2014.
 */
public class TorneoContext {
    private static Map<Class, ConcurrentHashMap<String, Object>> testBeans = new ConcurrentHashMap<Class, ConcurrentHashMap<String, Object>>();
    private static boolean isUnitTestExecution = false;
    private static BeanNameGeneratorImpl beanNameGenerator = new BeanNameGeneratorImpl();

    /**
     * Setea un bean usando como clave el qualifier. La clase se infiere a partir del bean </br>
     * Usar solo en tests
     * @param qualifier
     * @param bean
     * @throws com.futbol.manager.model.exceptions.TorneoException - Si ya existe un test bean con el mismo qualifier
     */
    public static void setTestBean(String qualifier,Object bean){
        if (getTestBean(qualifier) != null)
            throw new TorneoException("Ya existe un test bean con el mismo qualifier");
        setTestBean(bean.getClass(),qualifier,bean);
    }

    public static void setTestBean(Class clazz, Object bean){
        setTestBean(clazz, generateBeanName(clazz), bean);
    }

    /**
     * Setea un bean. Usar solo en tests
     * @param qualifier
     * @param bean
     * @throws TorneoException - Si ya existe un test bean con la misma clase y qualifier
     */
    public static void setTestBean(Class clazz, String qualifier, Object bean){

        ConcurrentHashMap<String, Object> map;

        if(testBeans.get(clazz) != null)
            map = testBeans.get(clazz);
        else
            map = new ConcurrentHashMap<String, Object>();

        if(map.get(qualifier) != null)
            throw new TorneoException("Ya existe un test bean con el mismo tipo y qualifier del que se quiere agregar");

        map.put(qualifier, bean);

        testBeans.put(clazz, map);
    }

    public static void cleanTestBeans(){
        testBeans = new ConcurrentHashMap<Class, ConcurrentHashMap<String, Object>>();
    }

    /**
     * Retorna un test bean de tipo beanType.<br>
     * Si existen varios, retorna el que tenga un qualifier que coincida con la nomenclatura default de los beans.<br>
     * Si existen varios y ninguno tiene un qualifier que coincida con la nomenclatura default, lanza LaboratorioException.
     */
    private static <B> B getTestBean(Class<B> beanType){

        Map qualifiersMap = testBeans.get(beanType);

        if(qualifiersMap == null)
            return null;

        if(qualifiersMap.size() == 1)
            return (B)testBeans.get(beanType).values().iterator().next();

        if(qualifiersMap.size() > 1){
            Object candidate = qualifiersMap.get(generateBeanName(beanType));
            if (candidate != null){
                return (B)candidate;
            }else{
                throw new TorneoException("No se encontro el componente: " + beanType.getName());
            }
        }

        return (B)testBeans.get(beanType).values().iterator().next();
    }

    private static <B> B getTestBean(Class<B> beanType, String qualifier){

        if(testBeans.get(beanType) == null || testBeans.get(beanType).get(qualifier) == null)
            return null;

        return (B)testBeans.get(beanType).get(qualifier);
    }

    /**
     * Retorna un test bean que coincida con el qualifier recibido como parámetro.<br>
     * Si hay varios test beans para el mismo qualifier, puede devolver cualquiera.
     */
    private static Object getTestBean(String qualifier) {

        for(Map<String, Object> map:testBeans.values()) {
            if(map.containsKey(qualifier)) {
                return map.get(qualifier);
            }
        }
        return null;
    }


    /**
     * Obtenemos un bean en base al tipo.
     *
     * @throws com.futbol.manager.model.exceptions.TorneoException si no se encontro el componente
     */
    public static <B> B get(Class<B> beanType) throws TorneoException {

        if (isUnitTestExecution){
            return getTestBean(beanType);
        }

        ApplicationContext applicationContext = getApplicationContext();

        if (applicationContext == null)
            return null;

        Map beans =  applicationContext.getBeansOfType(beanType);

        if(beans == null || beans.isEmpty()) {
            throw new TorneoException("No se encontro el componente: " + beanType.getSimpleName());
        }
        else if(beans.size() > 1){
            throw new TorneoException("No se pudo obtener el componente: " + beanType.getSimpleName() + ". Existe mas de un bean para su tipo");
        }

        return (B)beans.values().iterator().next();
    }

    /**
     * Obtenemos un bean en base a dado nombre y el tipo.
     *
     * @param qualifier
     * @param beanType
     * @return
     * @throws TorneoException si no se encontro el componente
     */
    public static <B> B get(Class<B> beanType, String qualifier) throws TorneoException {

        if (isUnitTestExecution){
            return getTestBean(beanType, qualifier);
        }

        ApplicationContext applicationContext = getApplicationContext();

        if (applicationContext == null)
            return null;

        B bean = (B)getApplicationContext().getBean(qualifier, beanType);
        if(bean == null) {
            throw new TorneoException("No se pudo levantar el componente: " + qualifier);
        }
        return bean;
    }

    /**
     * Obtenemos un bean en base al nombre.
     *
     * @param name
     * @return
     * @throws TorneoException si no se encontro el componente
     */
    public static Object get(String name) throws TorneoException {

        if (isUnitTestExecution){
            return getTestBean(name);
        }

        ApplicationContext applicationContext = getApplicationContext();

        if (applicationContext == null)
            return null;

        Object bean = applicationContext.getBean(name);
        if(bean == null) {
            throw new TorneoException("No se pudo levantar el componente: " + name);
        }
        return bean;
    }

    /**
     * Obtiene un bean de la clase beanType. No considera subclases de beanType.
     */
    public static <B> B getWithoutInheritance(Class<B> beanType) throws TorneoException {
        return get(beanType, generateBeanName(beanType));
    }

    private static String generateBeanName(Class beanType) {
        return beanNameGenerator.generateBeanName(beanType);
    }

    /**
     * Obtiene las clases de los beans que aplican a la clase beanType
     */
    public static Set<Class> getBeanClassesForType(Class beanType) {
        String [] beanNames = getApplicationContext().getBeanNamesForType(beanType);
        Set<Class> beanClasses = new HashSet<Class>();
        for(String beanName : beanNames){
            beanClasses.add(getApplicationContext().getType(beanName));
        }
        return beanClasses;
    }

    /**
     * Retornamos el {@link ApplicationContext} del {@link ServiceLocator} del core.
     *
     * @return
     */
    private static ApplicationContext getApplicationContext() {
        if (isUnitTestExecution)
            return null;
        return ServiceLocator.getInstance().getSpringContext();
    }

    public static void setUnitTestExecution(){
        isUnitTestExecution = true;
    }

}

