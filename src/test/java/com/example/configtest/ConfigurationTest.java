package com.example.configtest;

import com.example.springdemo1.config.ConfigTest;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(ConfigTest.class);
        String []beanNames = application.getBeanDefinitionNames();
        System.out.println(beanNames);

    }
}
