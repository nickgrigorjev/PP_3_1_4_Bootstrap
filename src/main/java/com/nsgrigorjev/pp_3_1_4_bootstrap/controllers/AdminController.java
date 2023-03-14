package com.nsgrigorjev.pp_3_1_4_bootstrap.controllers;

import com.nsgrigorjev.pp_3_1_4_bootstrap.services.RoleService;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }



    @PatchMapping("/edit")
    public String getUpdate(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUserName());
        userService.update(user);
        return "redirect:/admin/page";
    }
    @DeleteMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user, int id) {
        userService.delete(user.getId());
        return "redirect:/admin/page";
    }

    @GetMapping("/page")
    public String getUserName(Principal principal, Model model) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("new_user", new User());
        model.addAttribute("users_roles", user.getRoles());
        model.addAttribute("all_roles", roleService.getUniqueRoles());
        return "admin_page";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("new_user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user);
        return "redirect:/admin/page";
    }

}
