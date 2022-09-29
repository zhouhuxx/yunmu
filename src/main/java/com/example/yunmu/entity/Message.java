package com.example.yunmu.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Message {
    private String sender;
    private String recipient;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String content;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
