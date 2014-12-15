package com.futbol.manager.model.utils.collection;

import org.apache.commons.collections.Transformer;

/**
 * Created by aandrade on 06/09/2014.
 */
public class TransformerFactory {
    public static Transformer getTransformerFromStringToInteger(){
        return new Transformer() {
            @Override
            public Object transform(Object input) {
                String value = (String) input;
                Integer integer = new Integer(value);
                return integer;
            }
        };
    }
}
