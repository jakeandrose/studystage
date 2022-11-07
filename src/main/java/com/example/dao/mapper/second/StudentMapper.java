package com.example.dao.mapper.second;

import com.example.entity.second.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    public List<Student> queryAll();
}
