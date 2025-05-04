package com.example.belajarspring.controller;

import com.example.belajarspring.model.Jurusan;
import com.example.belajarspring.model.Mahasiswa;
import com.example.belajarspring.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public String listMahasiswa(Model model) {
        model.addAttribute("mahasiswaList", mahasiswaService.getAllMahasiswa());
        return "mahasiswa";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("jurusanList", mahasiswaService.getAllJurusan());
        model.addAttribute("isEdit", false);
        return "form-mahasiswa";
    }

    @PostMapping("/add")
    public String addMahasiswa(@ModelAttribute Mahasiswa mahasiswa) {
        // Get the full Jurusan object from the ID
        Long jurusanId = mahasiswa.getJurusan().getId();
        Jurusan jurusan = mahasiswaService.getJurusanById(jurusanId);
        mahasiswa.setJurusan(jurusan);
        
        mahasiswa.setId(System.currentTimeMillis()); // Generate ID
        mahasiswaService.addMahasiswa(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaById(id);
        model.addAttribute("mahasiswa", mahasiswa);
        model.addAttribute("jurusanList", mahasiswaService.getAllJurusan());
        model.addAttribute("isEdit", true);
        return "form-mahasiswa";
    }

    @PostMapping("/edit/{id}")
    public String editMahasiswa(@PathVariable Long id, @ModelAttribute Mahasiswa mahasiswa) {
        // Ensure the ID from path is set on the object
        mahasiswa.setId(id);
        
        // Get the full Jurusan object from the ID
        Long jurusanId = mahasiswa.getJurusan().getId();
        Jurusan jurusan = mahasiswaService.getJurusanById(jurusanId);
        mahasiswa.setJurusan(jurusan);
        
        mahasiswaService.updateMahasiswa(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/delete/{id}")
    public String deleteMahasiswa(@PathVariable Long id) {
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }
}