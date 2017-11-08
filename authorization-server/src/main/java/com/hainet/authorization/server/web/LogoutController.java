package com.hainet.authorization.server.web;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogoutController {

    @GetMapping("/user-logout")
    public void userLogout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, null, null);

        try {
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
