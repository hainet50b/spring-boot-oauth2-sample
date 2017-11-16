package com.hainet.authorization.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(final Model model, final String error) {
        if (error != null) {
            model.addAttribute("error", true);
        }

        return "login";
    }
}
