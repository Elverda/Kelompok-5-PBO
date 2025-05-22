package com.example.angkringan_99.service;

import com.example.angkringan_99.model.MenuItem;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MenuService {
    public static List<MenuItem> getAllMenus() {
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Kucing", "Nasi dengan lauk ayam suwir, sambal, dan tempe orek yang disajikan dalam porsi pas.", 8000, 4.5, "Makanan"));
        menu.add(new MenuItem("Sate Usus", "Sate usus ayam yang dibakar dengan bumbu rempah khas dan disajikan dengan sambal kecap.", 5000, 4.7, "Makanan"));
        menu.add(new MenuItem("Es Teh", "Teh manis segar dengan es batu yang menyegarkan, cocok untuk menemani makanan pedas.", 3000, 4.2, "Minuman"));
        menu.add(new MenuItem("Wedang Jahe", "Minuman tradisional dengan jahe, gula merah, dan rempah yang menghangatkan tubuh.", 5000, 4.6, "Minuman"));
        menu.add(new MenuItem("Tempe Mendoan", "Tempe yang diiris tipis dan digoreng dengan tepung berbumbu khas yang gurih.", 7000, 4.4, "Cemilan"));
        menu.add(new MenuItem("Tahu Bacem", "Tahu yang dimasak dengan bumbu gula merah, bawang, dan rempah tradisional yang kaya rasa.", 5000, 4.3, "Cemilan"));
        return menu;
    }

    public boolean login(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public boolean register(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    public void saveMenu(MenuItem menu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveMenu'");
    }
}

