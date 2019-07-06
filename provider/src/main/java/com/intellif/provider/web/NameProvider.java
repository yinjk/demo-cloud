package com.intellif.provider.web;

import com.intellif.provider.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author inori
 * @create 2019-07-02 13:44
 */
@RestController
public class NameProvider {

    @Autowired
    private Tracer tracer;

    @GetMapping("/user")
    public User getUser() {
        return new User("sweet", "女", 18);
    }

    public void trace() {
        Span currentSpan = tracer.getCurrentSpan();
        Span span = tracer.continueSpan(currentSpan);
        Span build = span.toBuilder().baggage("baggage", "hhh").tag("tag", "111").begin(new Date().getTime()).end(new Date().getTime()).build();
    }

}