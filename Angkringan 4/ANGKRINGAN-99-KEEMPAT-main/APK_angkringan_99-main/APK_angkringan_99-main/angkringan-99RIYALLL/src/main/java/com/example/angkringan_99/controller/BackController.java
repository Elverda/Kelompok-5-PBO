package com.example.angkringan_99.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.angkringan_99.model.MenuItem;
import com.example.angkringan_99.service.MenuService;

public class BackController {
    
     @GetMapping("/dashboard")
    public String getMenuPage(Model model) {
    List<MenuItem> menuItem = MenuService.getAllMenus();
    model.addAttribute("dashboard", menuItem);
    return "dashboard";
    }
}
