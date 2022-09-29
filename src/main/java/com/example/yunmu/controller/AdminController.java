package com.example.yunmu.controller;

import com.example.yunmu.entity.Admin;
import com.example.yunmu.entity.Result;
import com.example.yunmu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public Result<?> login(@Validated Admin admin) {
        return adminService.login(admin);
    }


}
