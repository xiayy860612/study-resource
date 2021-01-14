package com.s2u2m.study.spring.data.bind;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DataBindDemo {
    public static void main(String[] args) {
        User user = new User();
        DataBinder binder = new DataBinder(user, "user");

        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "test");
        properties.put("age", "12");
        properties.put("sex", "male");
        properties.put("country.name", "China");
        PropertyValues values = new MutablePropertyValues(properties);

        // 绑定结果到对象
        binder.bind(values);

        // 用于弱校验的绑定结果, 包含错误信息
        BindingResult result = binder.getBindingResult();
        System.out.println(result);

        System.out.println(user);
    }
}
