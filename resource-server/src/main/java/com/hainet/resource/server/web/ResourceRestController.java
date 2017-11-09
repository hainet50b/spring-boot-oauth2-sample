package com.hainet.resource.server.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ResourceRestController {

    @GetMapping("/user-info")
    public Map<String, Object> userInfo(final Authentication authentication) {
        return new HashMap<String, Object>() {{
            put("username", authentication.getName());
        }};
    }
}
