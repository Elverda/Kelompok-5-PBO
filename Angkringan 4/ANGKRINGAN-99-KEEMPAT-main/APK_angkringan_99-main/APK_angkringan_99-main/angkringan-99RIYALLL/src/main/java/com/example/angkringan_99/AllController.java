package com.example.angkringan_99;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.angkringan_99.service.MenuService;
import com.example.angkringan_99.service.UserService;


@Controller
public class AllController {
    @Autowired
    private MenuService menuService;

    @Autowired
     private UserService userService;

     
    
}
