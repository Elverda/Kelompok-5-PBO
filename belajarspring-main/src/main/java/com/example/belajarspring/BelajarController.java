package com.example.belajarspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BelajarController {

    @GetMapping("/")
    public String hello() {
        return "welcome";
    }

    @GetMapping("/hello/(name)")
    public String helloName (@PathVariable String name) {
        return "Hello" + name;
    }

    @GetMapping("/welcome")
    public String showAddForm(){
        return "welcome";
    }
}
