package com.example.sqltest;

import com.example.SqlTestApplication;
import com.example.dao.mapper.primary.StudentDao;
import com.example.dao.mapper.second.StudentMapper;
import com.example.dao.mapper.second.TeacherMapper;
import com.example.dao.mapper.second.UserMapper;
import com.example.entity.primary.Student;
import com.example.entity.second.Teacher;
import com.example.entity.second.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = SqlTestApplication.class)
public class SqlTestApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;


    /**
     * 测试pageHelper分页
     */
    @Test
    public void testPageHelper(){
        Page<Student> page = PageHelper.startPage(1, 5);
        studentDao.selectList();
        System.out.println(page);
    }


    /**
     * 测试多数据源
     */
    @Test
    public void testManyDataSource(){
        List<Student> Students = studentDao.selectList();
        List<User> users = userMapper.queryAll();
        System.out.println(Students);
        System.out.println(users);
    }


    /**
     * 用于测试mybatis中多对一的情况
     */
    @Test
    public void testManyToOne(){
        List<com.example.entity.second.Student> students = studentMapper.queryAll();
        System.out.println(students);
    }

    /**
     * 测试mybatis中一对多的情况
     */
    @Test
    public void testOneToMany(){
        List<Teacher> teachers = teacherMapper.queryAll();
        System.out.println(teachers);
    }
}
