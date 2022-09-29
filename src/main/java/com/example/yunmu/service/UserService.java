package com.example.yunmu.service;

import com.example.yunmu.entity.Result;
import com.example.yunmu.entity.User;
import com.example.yunmu.repository.UserMapper;
import com.example.yunmu.utils.EmailUtils;
import com.example.yunmu.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private EmailUtils emailUtils;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Result<?> getCode(String email) {
        Result<?> result = new Result<>();
        boolean success = emailUtils.send(email);
        if (success) {
            result.setCode("1000");
            result.setMessage("验证码发送成功");
        } else {
            result.setCode("1001");
            result.setMessage("验证码发送失败");
        }
        return result;
    }

    public Result<?> verify(String email, String code) {
        Result<?> result = new Result<>();
        try {
            String code1 = redisTemplate.opsForValue().get(email);
            if (code.equals(code1)) {
                result.setCode("1000");
                result.setMessage("验证成功");
            } else {
                result.setCode("1001");
                result.setMessage("验证码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("验证失败");
        }
        return result;
    }

    public Result<?> register(User user) {
        Result<?> result = new Result<>();
        try {
            if (userMapper.selectByUsername(user.getUsername()) != null) {
                result.setCode("1001");
                result.setMessage("用户名已存在");
            } else {
                if (userMapper.insert(user) == 1) {
                    result.setCode("1000");
                    result.setMessage("注册成功");
                } else {
                    result.setCode("1001");
                    result.setMessage("注册失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1001");
            result.setMessage("注册失败");
        }
        return result;
    }

    public Result<?> login(User user) {
        Result<Object> result = new Result<>();
        try {
            User user1 = userMapper.selectByUsername(user.getUsername());
            if (user1 == null) {
                result.setCode("1001");
                result.setMessage("用户不存在");
            }
            else {
                if (user.getPassword().equals(user1.getPassword())) {
                    result.setCode("1000");
                    result.setMessage("登录成功");
                    HashMap<String, String> map = new HashMap<>();
                    map.put("token", jwtUtils.getToken(user.getUsername()));
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
