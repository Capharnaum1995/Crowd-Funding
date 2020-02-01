package com.crowdFunding.ui.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHandler {
    @RequestMapping("/goCreate")
    public String goCreate() {
        return "goCreate";
    }

    @GetMapping("/supportProtocol")
    public String supportProtocol() {
        return "supportProtocol";
    }

    @GetMapping("/serviceProtocol")
    public String serviceProtocol() {
        return "serviceProtocol";
    }


    @GetMapping("/add_Project")
    public String addProject() {
        return "add_Project";
    }
}

