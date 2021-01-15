package com.s2u2m.study.spring.data.bind;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Properties;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age;

    private Country country;
    private Properties context;
}
