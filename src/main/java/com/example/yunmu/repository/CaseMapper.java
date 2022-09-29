package com.example.yunmu.repository;

import com.example.yunmu.entity.Case;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaseMapper {
    @Insert("insert into casee " +
            "values(#{type,jdbcType=VARCHAR}, #{situstion,jdbcType=LONGVARCHAR}, " +
            "#{result,jdbcType=LONGVARCHAR}, #{meaning,jdbcType=LONGVARCHAR}, #{impression,jdbcType=LONGVARCHAR})")
    int insert(Case case1);

}
