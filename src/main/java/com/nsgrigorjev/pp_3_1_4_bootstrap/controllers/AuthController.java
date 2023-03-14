package com.nsgrigorjev.pp_3_1_4_bootstrap.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.Role;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.RegistrationService;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.RoleService;
import com.nsgrigorjev.pp_3_1_4_bootstrap.util.UserValidator;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserValidator userValidator;
    private final RegistrationService registrationService;
    private final RoleService roleService;

    @Autowired
    public AuthController(RegistrationService registrationService, UserValidator userValidator, RoleService roleService) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registrationPage(Model model, @ModelAttribute("user") User user) {
        Set<Role> roles = new HashSet<>(roleService.getAllRoles());
        model.addAttribute("rolesAdd", roles);
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user,
                                        BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }
        registrationService.register(user);
        return "redirect:/login";
    }
}
