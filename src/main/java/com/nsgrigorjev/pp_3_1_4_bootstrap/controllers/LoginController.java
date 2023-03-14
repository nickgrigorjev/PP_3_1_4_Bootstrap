package com.nsgrigorjev.pp_3_1_4_bootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
