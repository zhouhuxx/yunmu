package com.example.yunmu.service;

import com.example.yunmu.entity.Admin;
import com.example.yunmu.entity.Result;
import com.example.yunmu.repository.AdminMapper;
import com.example.yunmu.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JWTUtils jwtUtils;

    public Result<?> login(Admin admin) {
        Result<Object> result = new Result<>();
        try {
            Admin admin1 = adminMapper.selectByUsername(admin.getUsername());
            if (admin1 == null) {
                result.setCode("1001");
                result.setMessage("账号不存在");
            }
            else {
                if (admin.getPassword().equals(admin1.getPassword())) {
                    result.setCode("1000");
                    result.setMessage("登录成功");
                    HashMap<String, String> map = new HashMap<>();
                    map.put("token", jwtUtils.getToken(admin.getUsername()));
                    result.setData(map);
                } else {
                    result.setCode("1001");
                    result.setMessage("密码错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("登录失败");
        }
        return result;
    }
}
