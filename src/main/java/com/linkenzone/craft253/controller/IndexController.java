package com.linkenzone.craft253.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "introduce")
    public String introduce(){
        return "introduce";
    }

    @GetMapping(value = "download")
    public String download(){
        return "download";
    }

    @GetMapping(value = "live2d")
    public String live2d() {
        return "comm/live2d";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

}
