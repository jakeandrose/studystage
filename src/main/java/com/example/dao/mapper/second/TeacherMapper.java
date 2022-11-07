package com.example.dao.mapper.second;

import com.example.entity.second.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    public List<Teacher> queryAll();
}
