package com.example.yunmu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class EmailUtils {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String getCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(4);
        for (int i = 0; i < 4; ++i)
            code.append(random.nextInt(10));
        return code.toString();
    }

    public void saveCode(String email, String code) {
        redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
    }

    public boolean send(String email) {
        boolean result;
        String code = getCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zhouhux@qq.com");
        message.setTo(email);
        message.setSubject("验证码");
        message.setText("【xxx网站】验证码：" + code + "（有效期为5分钟），如非本人操作，请忽略。");
        try {
            saveCode(email, code);
            javaMailSender.send(message);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
