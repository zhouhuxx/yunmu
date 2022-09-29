package com.example.yunmu.controller;

import com.example.yunmu.entity.Expert;
import com.example.yunmu.entity.Result;
import com.example.yunmu.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @RequestMapping("/all")
    public Result<?> getAll() {
        return expertService.selectAll();
    }

    @RequestMapping("/add")
    public int add(@RequestBody Expert expert) throws Exception {
        return expertService.insert(expert);
    }

    @RequestMapping("/{no}")
    public Result<?> get(@PathVariable String no) {
        return expertService.get(no);
    }

}
