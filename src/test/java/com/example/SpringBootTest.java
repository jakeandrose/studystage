package com.example;

import com.example.springdemo1.config.ConfigTest;
import com.example.springdemo1.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;

public class SpringBootTest {


    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);

        Person person = (Person) applicationContext.getBean("person1");
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println(person == person1);

    }


    /**
     * map的entry遍历方式测试服
     */
    @Test
    public void test2(){
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("1","apple");
        stringMap.put("2","origin");
        stringMap.put("3","banana");
        for (Map.Entry<String,String>  entry : stringMap.entrySet()){
            System.out.println("key:" + entry.getKey() + "-----" + "value:" + entry.getValue());
        }
    }

    /**
     * 日期化格式测试
     */
    @Test
    public void test3(){

        String text = "20180225142051";
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                // 解析date+time
                .appendPattern("yyyyMMddHHmmss")
                .toFormatter();
        formatter.parse(text);

        LocalDateTime t1 = LocalDateTime.parse(text, formatter);
        System.out.println(t1);
    }
}
