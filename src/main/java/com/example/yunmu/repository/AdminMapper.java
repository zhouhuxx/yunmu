package com.example.yunmu.repository;

import com.example.yunmu.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("Select * from admin where username = #{username,jdbcType=VARCHAR}")
    Admin selectByUsername(String username);
}
