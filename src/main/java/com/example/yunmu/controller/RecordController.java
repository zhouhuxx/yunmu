package com.example.yunmu.controller;

import com.example.yunmu.entity.Record;
import com.example.yunmu.entity.Result;
import com.example.yunmu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @RequestMapping("/add")
    public Result<?> add(HttpServletRequest request, @RequestBody Record record) {
        String username = (String) request.getAttribute("user");
        record.setUsername(username);
        return recordService.insert(record);
    }

    @RequestMapping("/all")
    public Result<?> getAll() {
        return recordService.selectAll();
    }

    @RequestMapping("/process")
    public Result<?> process(@RequestBody Record record) {
        return recordService.update(record);
    }
}
