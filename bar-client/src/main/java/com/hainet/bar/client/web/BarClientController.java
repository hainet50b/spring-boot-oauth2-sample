package com.hainet.bar.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarClientController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
