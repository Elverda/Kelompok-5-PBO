package com.example.angkringan_99.model;


public class MenuItem {
    private String nama;
    private String deskripsi;
    private double harga;
    private double rating;
    private String kategori;

    public MenuItem(String nama, String deskripsi, double harga, double rating, String kategori) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.rating = rating;
        this.kategori = kategori;
    }

    public String getNama() { 
        return nama;
    }
    public void setNama(String nama) { 
        this.nama = nama;
    }
    public String getDeskripsi() { 
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) { 
        this.deskripsi = deskripsi;
    }
    public double getHarga(){
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getKategori() { 
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    
}
