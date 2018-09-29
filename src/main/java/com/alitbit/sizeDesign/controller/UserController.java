package com.alitbit.sizeDesign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/auth")
    public String auth(HttpSession httpSession){
        Object phone = httpSession.getAttribute("phone");
        if (phone != null){
            return "true";
        }
        return "false";
    }

    @GetMapping("/phone")
    public String phone(HttpSession httpSession){
        String phone = (String)httpSession.getAttribute("phone");

        return phone;
    }
}
