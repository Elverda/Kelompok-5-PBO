package com.example.angkringan_99.controller;

import com.example.angkringan_99.*;
import com.example.angkringan_99.controller.*;
import com.example.angkringan_99.service.*;
import com.example.angkringan_99.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Menucontroller {

    @GetMapping("/")
    public String getMenuPage(Model model) {
        List<MenuItem> menuList = MenuRepository.getAllMenus();
        model.addAttribute("menu", menuList);
        return "menu"; // menu.html in /templates
    }
}
