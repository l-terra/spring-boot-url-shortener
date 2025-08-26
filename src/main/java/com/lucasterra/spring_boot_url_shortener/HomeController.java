package com.lucasterra.spring_boot_url_shortener;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "URl Shortener");
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
