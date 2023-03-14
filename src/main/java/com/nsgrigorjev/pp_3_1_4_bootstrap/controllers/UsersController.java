package com.nsgrigorjev.pp_3_1_4_bootstrap.controllers;

import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.UserService;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.UserServiceImpl;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserPage(Principal principal, Model model) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        return "user_page";
    }

}
