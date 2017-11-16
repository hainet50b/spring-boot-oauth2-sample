package com.hainet.resource.server.web;

import com.hainet.resource.server.domain.entity.SsoUser;
import com.hainet.resource.server.domain.service.SsoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ResourceRestController {

    private final SsoUserService service;

    @GetMapping("/user-info")
    public Map<String, Object> userInfo(final Authentication authentication) {
        SsoUser ssoUser = service.findByUsername(authentication.getName());

        return new HashMap<String, Object>() {{
            put("username", ssoUser.getUsername());
            put("logged_in_at", ssoUser.getLoggedInAt());
            put("failed_to_log_in_at", ssoUser.getFailedToLogInAt());
        }};
    }
}
