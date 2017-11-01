package com.hainet.resource.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResourceController {

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @PostMapping("/write")
    public String write() {
        return "write";
    }
}
