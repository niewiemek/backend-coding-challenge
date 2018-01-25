package com.engagetech.codingchallenge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by niewiemek on 25.01.2018.
 */
@Controller
public class IndexController {

    @GetMapping("index.html")
    public String index() {
        return "index";
    }
}
