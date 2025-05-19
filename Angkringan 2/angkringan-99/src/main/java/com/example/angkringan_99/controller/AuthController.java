package com.example.angkringan_99.controller;

import com.example.angkringan_99.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";  // This should match your template path
    }
    
    @PostMapping("/login")
    public String login(
    @RequestParam String username, 
    @RequestParam String password,HttpServletRequest request,Model model) {
        
        if (userService.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);
            return "redirect:/dashboard";
        }
        
        model.addAttribute("error", "Username atau password salah!");
        return "auth/login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/auth/login";
    }
    
    @GetMapping("/register")
    public String registerForm() {
        return "auth/register";  // This should match your template path
    }
    
    @PostMapping("/register")
    public String register(
            @RequestParam String username, 
            @RequestParam String password,
            @RequestParam(required = false) String email,  // Added email parameter 
            Model model) {
        
        if (userService.register(username, password)) {
            return "redirect:/auth/login";
        }
        
        model.addAttribute("error", "Username sudah ada!");
        return "auth/register";
    }
}