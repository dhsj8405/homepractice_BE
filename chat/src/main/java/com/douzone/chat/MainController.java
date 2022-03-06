package com.douzone.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/main")
    public String getHome(){
        return "Chat-practice (StompJS) React & SpringBoot";
    }
}