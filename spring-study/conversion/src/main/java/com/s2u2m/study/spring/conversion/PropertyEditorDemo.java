package com.s2u2m.study.spring.conversion;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyEditorDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "META-INF/property-editors-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        context.close();
    }
}
