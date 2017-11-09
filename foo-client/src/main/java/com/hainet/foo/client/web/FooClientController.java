package com.hainet.foo.client.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FooClientController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/read")
    @PreAuthorize("hasAuthority('FOO_READ')")
    public String read(final RedirectAttributes attr) {
        attr.addFlashAttribute("foo_read", true);
        return "redirect:/";
    }

    @PostMapping("/write")
    @PreAuthorize("hasAuthority('FOO_WRITE')")
    public String write(final RedirectAttributes attr) {
        attr.addFlashAttribute("foo_write", true);
        return "redirect:/";
    }
}
