package com.example.yunmu.service;

import com.example.yunmu.entity.Case;
import com.example.yunmu.entity.Result;
import com.example.yunmu.repository.CaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {
    @Autowired
    private CaseMapper caseMapper;

    public Result<?> insert(Case case1) {
        Result<?> result = new Result<>();
        try {
            if (caseMapper.insert(case1) == 1) {
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
}
