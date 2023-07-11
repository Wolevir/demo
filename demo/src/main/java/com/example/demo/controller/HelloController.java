package com.example.demo.controller;

import com.example.demo.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final ServiceHello serviceHello;

    public HelloController(ServiceHello serviceHello) {
        this.serviceHello = serviceHello;
    }


    @GetMapping
    public String hello() {
       String s = "122";
        return serviceHello.hel(s);
    }
}
