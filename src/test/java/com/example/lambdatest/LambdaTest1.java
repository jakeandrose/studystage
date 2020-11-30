package com.example.lambdatest;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest1 {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        User user1 = new User("Tom", BigDecimal.valueOf(23l), "96968686");
        User user2 = new User("Cat", BigDecimal.valueOf(24l), "10086000");
        User user3 = new User("Storm", BigDecimal.valueOf(25l), "89898989");
        User user4 = new User("HBase", BigDecimal.valueOf(26l), "85858585");
        User user5 = new User("Hadoop", BigDecimal.valueOf(26l), "78787878");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);


        List<User> collect = userList.stream().collect(Collectors.groupingBy(item -> item.getAge(), Collectors.reducing((t1, t2) -> {
            t1.setAge(t1.getAge().add(t2.getAge()));
            return t1;
        }))).values().stream().map(Optional::get).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        User user1 = new User("Tom", BigDecimal.valueOf(23l), "96968686");
        User user2 = new User("Cat", BigDecimal.valueOf(24l), "10086000");
        User user3 = new User("Storm", BigDecimal.valueOf(25l), "89898989");
        User user4 = new User("HBase", BigDecimal.valueOf(26l), "85858585");
        User user5 = new User("Hadoop", BigDecimal.valueOf(26l), "78787878");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        List<List<User>> values = new ArrayList<>(userList.stream().collect(Collectors.groupingBy(User::getAge)).values());

        System.out.println(values);
    }

    public class User {
        //姓名
        private String name;
        //年龄
        private BigDecimal age;
        //学号
        private String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getAge() {
            return age;
        }

        public void setAge(BigDecimal age) {
            this.age = age;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public User(String name, BigDecimal age, String number) {
            this.name = name;
            this.age = age;
            this.number = number;
        }

        public User() {
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}
