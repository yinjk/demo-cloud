package com.intellif.consumer.web;

import com.intellif.consumer.bean.User;
import com.intellif.consumer.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author inori
 * @create 2019-07-02 14:01
 */
@RestController
public class HelloController {

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/hello")
    public String hello() {
        User user = remoteService.user();
        return "你好 " + user.getName() + " [性别：" + user.getSex() + ", 年龄： " + user.getAge() + "]";
    }
}