package com.hainet.authorization.server.security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SsoUserLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                final Authentication authentication) {
        try {
            if (request.getHeader("referer") == null) {
                response.sendRedirect(request.getContextPath());
            } else {
                response.sendRedirect(request.getHeader("referer").split("\\?")[0]);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
