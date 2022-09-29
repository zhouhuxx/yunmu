package com.example.yunmu.service;

import com.example.yunmu.entity.Expert;
import com.example.yunmu.entity.Result;
import com.example.yunmu.repository.ExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    public Result<?> selectAll() {
        Result<Object> result = new Result<>();
        try {
            List<Expert> list = expertMapper.selectAll();
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

    public int insert(Expert expert) throws Exception {
        File file = new File("/Users/zhouhux/Downloads/000002.webp");
        InputStream in = new FileInputStream(file);
        byte[] photo = new byte[(int) file.length()];
        in.read(photo);
        expert.setPhoto(photo);
        return expertMapper.insert(expert);
    }

    public Result<?> get(String no) {
        Result<Object> result = new Result<>();
        try {
            Expert expert = expertMapper.select(no);
            result.setCode("1000");
            result.setMessage("操作成功");
            result.setData(expert);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("操作失败");
        }
        return result;
    }
}
