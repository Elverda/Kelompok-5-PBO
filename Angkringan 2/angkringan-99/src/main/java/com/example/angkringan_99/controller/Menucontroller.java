package com.example.angkringan_99.controller;

import com.example.angkringan_99.model.MenuItem;
import com.example.angkringan_99.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/dashboard")
public class Menucontroller {
    @Autowired
    private MenuService menuService;

   @GetMapping
   public String getMenuPage(Model model) {
       List<MenuItem> menuItem = MenuService.getAllMenus(); // Pastikan ini memanggil service yang benar
       model.addAttribute("dashboard", menuItem);
       return "dashboard"; // Pastikan ini mengembalikan view yang benar
   }
   

    @PostMapping("/menufix")
    public String saveMenu(@ModelAttribute MenuItem menu) {
        menuService.saveMenu(menu);
        return "redirect:/dashboard";
    }

    @GetMapping("/menu")
    public String getMethodName(@RequestParam String menuService) {
        return new String();
    }
}
