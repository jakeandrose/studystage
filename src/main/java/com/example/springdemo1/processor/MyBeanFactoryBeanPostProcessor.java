package com.example.springdemo1.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MyBeanFactoryBeanPostProcessor  implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        String []names = configurableListableBeanFactory.getBeanDefinitionNames();
        List<BeanDefinition> beanDefinitions = new ArrayList<>();

        Arrays.stream(names).forEach(item -> {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(item);
            beanDefinitions.add(beanDefinition);
        });

        System.out.println(beanDefinitions);
    }
}
