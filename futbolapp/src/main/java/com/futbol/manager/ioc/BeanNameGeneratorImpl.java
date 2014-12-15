package com.futbol.manager.ioc;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.StringUtils;

/**
 * Created by aandrade on 12/09/2014.
 */
public class BeanNameGeneratorImpl implements BeanNameGenerator {

    //private static Logger logger = Logger.getLogger(BeanNameGeneratorImpl.class);

    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

        String generatedBeanName = definition.getBeanClassName();

        if (!StringUtils.hasText(generatedBeanName)) {
            throw new BeanDefinitionStoreException("Unnamed bean definition specifies neither " +
                    "'class' nor 'parent' nor 'factory-bean' - can't generate bean name");
        }

        //logger.debug("Nombre generado para " + definition.getBeanClassName() + " : " + generatedBeanName);

        return generatedBeanName;
    }

    public String generateBeanName(Class clazz){
        return clazz.getName();
    }
}
