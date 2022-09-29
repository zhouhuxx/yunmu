package com.example.yunmu.repository;

import com.example.yunmu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user " +
            "values(#{email,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})")
    int insert(User user);

    @Select("select * from user " +
            "where username = #{username, jdbcType=VARCHAR}")
    User selectByUsername(String username);

}
