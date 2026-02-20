package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
public class ApologyController {
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/choice")
    public String choice(@RequestParam String result) {

        System.out.println("========= 接口被调用了 =========");
        System.out.println("收到结果：" + result);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("m18645541744@163.com");
            message.setTo("m18645541744@163.com");
            message.setSubject("来自王欣蕊宝宝的回应 ❤️");
            message.setText("她点击了：" + result);

            mailSender.send(message);

            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
