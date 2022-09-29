package com.example.yunmu.repository;

import com.example.yunmu.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("insert into record " +
            "values(#{no,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, #{type,jdbcType=CHAR}, " +
            "#{expert,jdbcType=CHAR}, #{time,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR})")
    int insert(Record record);

    @Update("update record " +
            "set status = #{status,jdbcType=CHAR} " +
            "where no = #{no,jdbcType=BIGINT}")
    int update(Record record);

    @Select("select * from record order by no desc")
    List<Record> selectAll();
}
