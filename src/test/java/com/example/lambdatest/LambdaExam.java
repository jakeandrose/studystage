package com.example.lambdatest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
     *  使用lambda表达式计算出每个学生的总成绩
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

    /**
     *  查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
     */
    @Test
    public void test2(){
        Map<String, Double> collect = scores.stream().collect(Collectors.groupingBy(Score::getsId,
                Collectors.averagingDouble(Score::getsScore)));

        Map<String, List<Student>> stuMap = students.stream().collect(Collectors.groupingBy(Student::getsId));

        for (Map.Entry<String,Double> entry : collect.entrySet()){
            String sId = entry.getKey();
            Student student = stuMap.get(sId).get(0);
            System.out.println("学生编号：" + student.getsId() + "，学生姓名：" + student.getsName() + ",平均成绩:" + entry.getValue());
        }
    }

    /**
     * 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
     */
    @Test
    public void test3(){
        Map<String, List<Score>> collect = scores.stream().collect(Collectors.groupingBy(Score::getsId));

        Map<String, List<Student>> stuMap = students.stream().collect(Collectors.groupingBy(Student::getsId));


        for (Map.Entry<String,List<Score>> entry : collect.entrySet()){
            String sId = entry.getKey();
            Student student = stuMap.get(sId).get(0);
            int courseSize = entry.getValue().size();
            int totalScore = entry.getValue().stream().reduce((t1, t2) -> {
                t1.setsScore(t1.getsScore() + t2.getsScore());
                return t1;
            }).get().getsScore();
            System.out.println("学生编号：" + student.getsId() + "，学生姓名：" + student.getsName()
                    + ",选课数：" + courseSize + ",总成绩:" + totalScore);
        }

    }


    /**
     * 查询"李"姓老师的数量
     */
    @Test
    public void test4(){
        long tcount = teachers.stream().filter(item -> {
            if (item.gettName().startsWith("李")) {
                return true;
            } else {
            }
            return false;
        }).count();

        System.out.println("李姓老师的数量是 :" + tcount);
    }

    /*
        查询没有学全所有课程的同学的信息
     */
    @Test
    public void test5(){

        /*
            将学生按照学号进行分组成一个map，供后面查询学生时使用
         */
        Map<String, List<Student>> studentsMap = students.stream().collect(Collectors.groupingBy(Student::getsId));

        /*
             将成绩集合按照学号进行分组形成一个map
         */
        Map<String, Long> collect = scores.stream().collect(Collectors.groupingBy(Score::getsId, Collectors.counting()));

        /*
            从map集合中筛选出没有学全所有课程的记录
         */
        List<Map.Entry<String, Long>> scoresList = collect.entrySet().stream().filter(item -> item.getValue()  < courses.size()).collect(Collectors.toList());

        /*
           通过学号，到学生map中找到该学生，并将其信息输出
         */
        scoresList.stream().forEach(item -> {
            List<Student> studentList = studentsMap.get(item.getKey());
            System.out.println(studentList.get(0));
        });
    }
}

