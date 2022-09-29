package com.example.yunmu.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    private String email;
    @NotBlank(message = "用户名不能为空", groups = {Group1.class})
    @Size(min = 2, max = 12, message = "用户名长度需设置为1～12", groups = {Group2.class})
    private String username;
    @NotBlank(message = "密码不能为空", groups = {Group1.class})
    @Size(min = 6, max = 18, message = "密码长度需设置为6～18", groups = {Group2.class})
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
