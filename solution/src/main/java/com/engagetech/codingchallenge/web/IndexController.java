package com.engagetech.codingchallenge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private static final String INDEX = "index";

    @GetMapping("index.html")
    public String index() {
        return INDEX;
    }
}
