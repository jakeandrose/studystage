package com.example.lambdatest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExam {

    /**
     * 学生对象集合
     */
    private static List<Student> students = new ArrayList<>();

    /**
     * 课程对象集合
     */
    private static List<Course> courses = new ArrayList<>();

    /**
     * 教师对象集合
     */
    private static List<Teacher> teachers = new ArrayList<>();

    /**
     * 成绩对象集合
     */
    private static List<Score> scores = new ArrayList<>();

    /**
     * 数据准备阶段，向各个对象集合中填充数据
     */
    static {

        /**
         *  学生类集合数据添加
         */
        students.add(new Student("01" , "赵雷" , "1990-01-01" , "男"));
        students.add(new Student("02" , "钱电" , "1990-12-21" , "男"));
        students.add(new Student("03" , "孙风" , "1990-05-20" , "男"));
        students.add(new Student("04" , "李云" , "1990-08-06" , "男"));

        students.add(new Student("05" , "周梅" , "1991-12-01" , "女"));
        students.add(new Student("06" , "吴兰" , "1992-03-01" , "女"));
        students.add(new Student("07" , "郑竹" , "1989-07-01" , "女"));
        students.add(new Student("08" , "王菊" , "1990-01-20" , "女"));


        /**
         *  课程集合添加数据
         */
        courses.add(new Course("01" , "语文" , "02"));
        courses.add(new Course("02" , "数学" , "01"));
        courses.add(new Course("03" , "英语" , "03"));


        /**
         *  教师集合添加数据
         */
        teachers.add(new Teacher("01" , "张三"));
        teachers.add(new Teacher("02" , "李四"));
        teachers.add(new Teacher("03" , "王五"));


        /**
         * 成绩集合添加数据
         */
        scores.add(new Score("01" , "01" , 80));
        scores.add(new Score("01" , "02" , 90));
        scores.add(new Score("01" , "03" , 99));
        scores.add(new Score("02" , "01" , 70));
        scores.add(new Score("02" , "02" , 60));
        scores.add(new Score("02" , "03" , 80));
        scores.add(new Score("03" , "01" , 80));
        scores.add(new Score("03" , "02" , 80));
        scores.add(new Score("03" , "03" , 80));
        scores.add(new Score("04" , "01" , 50));
        scores.add(new Score("04" , "02" , 30));
        scores.add(new Score("04" , "03" , 20));
        scores.add(new Score("05" , "01" , 76));
        scores.add(new Score("05" , "02" , 87));
        scores.add(new Score("06" , "01" , 31));
        scores.add(new Score("06" , "03" , 34));
        scores.add(new Score("07" , "02" , 89));
        scores.add(new Score("07" , "03" , 98));



    }


    /**
     * 查询"01"课程比"02"课程成绩高的学生的信息及课程分数
     */
    @Test
    public void test1(){


         scores.stream().collect(Collectors.groupingBy(Score::getsId,
                Collectors.reducing((t1, t2) -> {
                    t1.setsScore(t1.getsScore() + t2.getsScore());
                    return t1;
                }))).values().stream().forEach(item -> {
             System.out.println(item.get());
         });


    }
}
