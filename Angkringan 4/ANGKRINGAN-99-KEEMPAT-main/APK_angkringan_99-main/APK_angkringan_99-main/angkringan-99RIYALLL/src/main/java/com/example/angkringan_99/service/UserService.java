package com.example.angkringan_99.service;

import com.example.angkringan_99.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, String> users = new HashMap<>();
    
    // Constructor to add a test user
    public UserService() {
        // Add a test user - admin:admin
        users.put("admin", "admin");
    }
    
    public boolean login(String username, String password) {
        // Check if user exists and password matches
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        }
        return false;
    }
    
    public boolean register(String username, String password) {
        // Check if username already exists
        if (users.containsKey(username)) {
            return false;
        }
        
        // Register new user
        users.put(username, password);
        return true;
    }
}