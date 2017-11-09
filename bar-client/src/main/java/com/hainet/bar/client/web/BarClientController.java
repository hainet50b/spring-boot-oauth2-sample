package com.hainet.bar.client.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BarClientController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/read")
    @PreAuthorize("hasAuthority('BAR_READ')")
    public String read(final RedirectAttributes attr) {
        attr.addFlashAttribute("bar_read", true);
        return "redirect:/";
    }

    @PostMapping("/write")
    @PreAuthorize("hasAuthority('BAR_WRITE')")
    public String write(final RedirectAttributes attr) {
        attr.addFlashAttribute("bar_write", true);
        return "redirect:/";
    }
}
