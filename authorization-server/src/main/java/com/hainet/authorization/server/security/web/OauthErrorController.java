package com.hainet.authorization.server.security.web;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OauthErrorController {

    @GetMapping("/oauth/error")
    public String oauthError(final HttpServletRequest request, final Model model) {
        Object error = request.getAttribute("error");
        if (error instanceof OAuth2Exception) {
            model.addAttribute(
                    "errorSummary",
                    ((OAuth2Exception) error).getSummary());
        } else {
            model.addAttribute("errorSummary", "Unknown error");
        }

        return "error/oauth-error";
    }
}
