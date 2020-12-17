package com.example.springdemo1.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Conditional1 implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        if (conditionContext.getRegistry().getBeanDefinition("person") != null) {
            return true;
        }else{
            return false;
        }
    }
}
