package com.example.yunmu.controller;

import com.example.yunmu.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("{\"code\": \"1001\",\"message\": \"未登录\", \"data\": null}");
            return false;
        }
        String username = jwtUtils.verify(token);
        if (username == null) {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("{\"code\": \"1001\",\"message\": \"验证失败\", \"data\": null}");
            return false;
        } else {
            request.setAttribute("user", username);
            return true;
        }
    }
}
