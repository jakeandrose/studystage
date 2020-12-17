package com.example.springdemo1.config;

import com.example.springdemo1.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(value = "com.example.springdemo1"
//,useDefaultFilters = false,includeFilters={
//        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class})
//})
@ComponentScan("com.example.springdemo1")
public class ConfigTest{

    @Bean("person1")
    public Person person(){
        return new Person();
    }
}
