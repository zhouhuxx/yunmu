package com.example.yunmu.service;

import com.example.yunmu.entity.Record;
import com.example.yunmu.entity.Result;
import com.example.yunmu.repository.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    public Result<?> insert(Record record) {
        Result<?> result = new Result<>();
        record.setStatus("未处理");
        try {
            if (recordMapper.insert(record) == 1) {
                result.setCode("1000");
                result.setMessage("操作成功");
            } else {
                result.setCode("1001");
                result.setMessage("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("操作失败");
        }
        return result;
    }

    public Result<?> update(Record record) {
        Result<?> result = new Result<>();
        try {
            if (recordMapper.update(record) == 1) {
                result.setCode("1000");
                result.setMessage("操作成功");
            } else {
                result.setCode("1001");
                result.setMessage("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("操作失败");
        }
        return result;
    }

    public Result<?> selectAll() {
        Result<Object> result = new Result<>();
        try {
            List<Record> list = recordMapper.selectAll();
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
