package com.s2u2m.study.spring.conversion;

import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age;
    private Properties context;
}
