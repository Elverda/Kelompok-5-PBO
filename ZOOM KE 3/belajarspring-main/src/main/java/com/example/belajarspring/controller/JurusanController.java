package com.example.belajarspring.controller;

import com.example.belajarspring.model.Jurusan;
import com.example.belajarspring.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService jurusanService;

    @GetMapping
    public String listJurusan(Model model) {
        model.addAttribute("jurusanList", jurusanService.getAllJurusan());
        return "jurusan/index";
    }

    @GetMapping("/add")
    public String addJurusanForm(Model model) {
        model.addAttribute("jurusan", new Jurusan());
        model.addAttribute("isEdit", false);
        return "jurusan/add";
    }

    @PostMapping("/add")
    public String saveJurusan(@ModelAttribute Jurusan jurusan) {
        jurusanService.saveJurusan(jurusan);
        return "redirect:/jurusan";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Jurusan jurusan = jurusanService.getJurusanByID(id);
        model.addAttribute("jurusan", jurusan);
        model.addAttribute("isEdit", true);
        return "jurusan/add";
    }

    @PostMapping("/edit/{id}")
    public String editJurusan(@PathVariable Long id, @ModelAttribute Jurusan jurusan) {
        // Ensure the ID from path is set on the object
        jurusan.setId(id);
        
        // Get the full Jurusan object from the ID
        // Long jurusanId = jurusan.getId();
        // jurusan = jurusanService.getJurusanByID(jurusanId);
        jurusan.setNamaJurusan(jurusan.getNamaJurusan());
        
        jurusanService.updateJurusan(jurusan);
        return "redirect:/jurusan";
    }
}