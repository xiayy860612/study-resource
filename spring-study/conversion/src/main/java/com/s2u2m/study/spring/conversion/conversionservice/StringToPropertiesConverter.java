package com.s2u2m.study.spring.conversion.conversionservice;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

public class StringToPropertiesConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor source, TypeDescriptor target) {
        return String.class.equals(source.getObjectType())
            && Properties.class.equals(target.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Properties.class));
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader((String)o));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
