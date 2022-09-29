package com.example.yunmu.repository;

import com.example.yunmu.entity.Expert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExpertMapper {
    @Select("select no, name, sex, photo, score, field from expert")
    List<Expert> selectAll();

    @Select("select * from expert where no = #{no,jdbcType=CHAR}")
    Expert select(String no);

    @Insert("insert into expert " +
            "values(#{no,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{sex,jdbcType=CHAR}, " +
            "#{photo,jdbcType=BLOB}, #{score,jdbcType=FLOAT}, #{field,jdbcType=VARCHAR}, " +
            "#{introduction,jdbcType=LONGVARCHAR})")
    int insert(Expert expert);
}
