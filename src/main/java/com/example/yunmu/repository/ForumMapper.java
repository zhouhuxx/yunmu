package com.example.yunmu.repository;

import com.example.yunmu.entity.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ForumMapper {
    @Insert("insert into post " +
            "values(#{username,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, " +
            "#{content,jdbcType=LONGVARCHAR})")
    int insert(Post post);

    @Select("select * from post order by time desc")
    List<Post> selectAll();
}
