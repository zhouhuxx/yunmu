package com.example.yunmu.controller;

import com.example.yunmu.entity.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> handler1(ConstraintViolationException e) {
        Result<Object> result = new Result<>();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> list = new ArrayList<>();
        constraintViolations.forEach(constraintViolation -> {
            String msg = constraintViolation.getMessage();
            list.add(msg);
        });
        result.setCode("1001");
        result.setMessage("操作失败");
        result.setData(list);
        return result;
    }

    @ExceptionHandler(BindException.class)
    public Result<?> handler2(BindException e) {
        Result<Object> result = new Result<>();
        BindingResult bindingResult = e.getBindingResult();
        List<String> list = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msg = fieldError.getDefaultMessage();
            list.add(msg);
        });
        result.setCode("1001");
        result.setMessage("操作失败");
        result.setData(list);
        return result;
    }
}
