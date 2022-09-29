package com.example.yunmu.controller;

import com.example.yunmu.entity.Group;
import com.example.yunmu.entity.Group1;
import com.example.yunmu.entity.Result;
import com.example.yunmu.entity.User;
import com.example.yunmu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result<?> login(@Validated({Group1.class}) User user) {
        return userService.login(user);
    }

    @RequestMapping("/register")
    public Result<?> register(@Validated({Group.class}) User user) {
        return userService.register(user);
    }

    @RequestMapping("/getcode")
    public Result<?> getCode(@NotBlank(message = "邮箱不能为空") @Email(message = "邮箱格式不正确")
                             @RequestParam String email) {
        return userService.getCode(email);
    }

    @RequestMapping("/verify")
    public Result<?> verify(@RequestParam String email, @NotBlank(message = "验证码不能为空")
                                    @RequestParam String code) {
        return userService.verify(email, code);
    }
}
