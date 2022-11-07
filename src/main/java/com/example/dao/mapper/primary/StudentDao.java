package com.example.dao.mapper.primary;


import com.example.entity.primary.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentDao {

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    public Student selectOne(int id);

    public List<Student> selectList();
}
