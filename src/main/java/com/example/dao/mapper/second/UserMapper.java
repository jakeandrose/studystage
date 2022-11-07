package com.example.dao.mapper.second;

import com.example.entity.second.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> queryAll();
}
