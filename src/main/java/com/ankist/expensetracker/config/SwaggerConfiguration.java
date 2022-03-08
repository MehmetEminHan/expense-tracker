package com.ankist.expensetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@Controller
@Profile("!test")
public class SwaggerConfiguration {

    @RequestMapping(value = {"/", "/swagger-ui.html"})
    public String home() {
        return "redirect:/";
    }git add
}
