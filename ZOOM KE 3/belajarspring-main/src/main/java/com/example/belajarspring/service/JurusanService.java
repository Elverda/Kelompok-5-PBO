package com.example.belajarspring.service;

import com.example.belajarspring.model.Jurusan;
import com.example.belajarspring.model.Mahasiswa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JurusanService {
    private final List<Jurusan> jurusanList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Jurusan> getAllJurusan() {
        return jurusanList;
    }

    public Jurusan saveJurusan(Jurusan jurusan) {
        if (jurusan.getId() == null) {
            jurusan.setId(idCounter++);
            jurusanList.add(jurusan);
        }
        return jurusan;
    }

        public Jurusan getJurusanByID(Long id) {
        return jurusanList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
    public void updateJurusan(Jurusan jurusan) {
        jurusanList.replaceAll(m -> m.getId().equals(jurusan.getId()) ? jurusan : m);
    }
}