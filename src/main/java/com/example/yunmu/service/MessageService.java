package com.example.yunmu.service;

import com.example.yunmu.entity.Message;
import com.example.yunmu.repository.MassageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MassageMapper massageMapperMapper;

    public void insert(Message message) {
        massageMapperMapper.insert(message);
    }

}
