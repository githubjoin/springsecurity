package com.practice.liam.rest.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LiamController {

    @GetMapping(value = "/introduce/string")
    @ResponseBody
    public String introduceString() {
        return "Hello World";
    }

    @GetMapping(value = "/introduce/page")
    public String introduce(){
        return "introduce";
    }
}
