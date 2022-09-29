package com.example.yunmu.controller;

import com.example.yunmu.entity.Post;
import com.example.yunmu.entity.Result;
import com.example.yunmu.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService messageService;

    @RequestMapping("/post")
    public Result<?> post(HttpServletRequest request, @Validated @RequestBody Post post) {
        String username = (String) request.getAttribute("user");
        post.setUsername(username);
        return messageService.insert(post);
    }

    @RequestMapping("/all")
    public Result<?> getAll() {
        return messageService.selectAll();
    }
}
