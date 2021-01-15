package com.s2u2m.study.spring.data.bind;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {

        propertyEditorRegistry.registerCustomEditor(User.class, "context", new StringToPropertiesPropertyEditor());
    }
}
