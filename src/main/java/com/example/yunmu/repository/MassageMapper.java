package com.example.yunmu.repository;

import com.example.yunmu.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MassageMapper {
    @Insert("insert into message " +
            "values(#{sender,jdbcType=VARCHAR}, #{recipient,jdbcType=VARCHAR}, " +
            "#{time,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})")
    int insert(Message message);
}
