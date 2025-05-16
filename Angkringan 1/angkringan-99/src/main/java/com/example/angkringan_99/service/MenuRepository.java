package com.example.angkringan_99.service;

import com.example.angkringan_99.model.MenuItem;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MenuRepository {
    public static List<MenuItem> getAllMenus() {
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng Seafood", "Rasa gurih dengan bumbu spesial", 20000, 4.8, "Makanan Utama"));
        menu.add(new MenuItem("Rendang Sapi", "Lembut kaya rempah", 35000, 5.0, "Makanan Utama"));
        return menu;
    }
}
