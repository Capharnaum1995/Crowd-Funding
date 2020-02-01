package com.crowdFunding.ui.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexHandler {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
