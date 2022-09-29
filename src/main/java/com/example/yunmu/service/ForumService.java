package com.example.yunmu.service;

import com.example.yunmu.entity.Post;
import com.example.yunmu.entity.Result;
import com.example.yunmu.repository.ForumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
    @Autowired
    private ForumMapper messageMapper;

    public Result<?> insert(Post post) {
        Result<?> result = new Result<>();
        try {
            if (messageMapper.insert(post) == 1) {
                result.setCode("1000");
                result.setMessage("发表成功");
            } else {
                result.setCode("1001");
                result.setMessage("发表失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("发表失败");
        }
        return result;
    }

    public Result<?> selectAll() {
        Result<Object> result = new Result<>();
        try {
            List<Post> list = messageMapper.selectAll();
            result.setCode("1000");
            result.setMessage("操作成功");
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("操作失败");
        }
        return result;
    }
}
