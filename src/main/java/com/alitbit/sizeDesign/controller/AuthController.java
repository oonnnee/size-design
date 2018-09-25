package com.alitbit.sizeDesign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping
    public String auth(HttpSession httpSession){
        Object phone = httpSession.getAttribute("phone");
        if (phone != null){
            return "true";
        }
        return "false";
    }

}
