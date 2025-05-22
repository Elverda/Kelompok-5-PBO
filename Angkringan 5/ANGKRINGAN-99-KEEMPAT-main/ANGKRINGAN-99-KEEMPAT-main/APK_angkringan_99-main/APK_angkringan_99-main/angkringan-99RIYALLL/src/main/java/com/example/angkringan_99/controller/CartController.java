package com.example.angkringan_99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.example.angkringan_99.model.MenuItem;
import com.example.angkringan_99.service.MenuService;



@Controller
public class CartController {

    @GetMapping("/menu")
    public String getMenuPage(Model model) {
    List<MenuItem> menuItem = MenuService.getAllMenus();
    model.addAttribute("menu", menuItem);
    return "menu";
    }
    
}