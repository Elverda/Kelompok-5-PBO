package com.example.belajarspring.service;

import com.example.belajarspring.model.Jurusan;
import com.example.belajarspring.model.Mahasiswa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private List<Jurusan> jurusanList = new ArrayList<>();

    public MahasiswaService() {
        // Data awal
        Jurusan jurusanTI = new Jurusan(1L, "Teknik Informatika");
        Jurusan jurusanSI = new Jurusan(2L, "Sistem Informasi");
        jurusanList.add(jurusanTI);
        jurusanList.add(jurusanSI);

        mahasiswaList.add(new Mahasiswa(1L, "Wahyu", jurusanTI));
        mahasiswaList.add(new Mahasiswa(2L, "Andi", jurusanSI));
    }

    // CRUD Mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

    public Mahasiswa getMahasiswaById(Long id) {
        return mahasiswaList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.replaceAll(m -> m.getId().equals(mahasiswa.getId()) ? mahasiswa : m);
    }

    public void deleteMahasiswa(Long id) {
        mahasiswaList.removeIf(m -> m.getId().equals(id));
    }

    // Data Jurusan
    public List<Jurusan> getAllJurusan() {
        return jurusanList;
    }
    public Jurusan getJurusanById(Long id) {
	    return jurusanList.stream()
	        .filter(j -> j.getId().equals(id))
	        .findFirst()
	        .orElse(null);
	}
}