package com.github.perscholas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.StringJoiner;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    @GetMapping
    String getView(Model model) {
        model.addAttribute("message", new StringJoiner("<br />")
                .add(String.format("This message has been injected from the %s!", this.getClass().getName()))
                .add("The purpose of this message is to demonstrate how JSPs can consume requests from a controller")
                .toString());
        return "view-hello-world";
    }
}