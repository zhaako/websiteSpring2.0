package com.youtube.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/other")
public class OtherController {
    @GetMapping("/about")
    public String about(){
        return "new_about";
    }
}
