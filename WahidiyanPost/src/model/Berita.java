/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo - GK
 */
public class Berita extends NewsDisplay implements NewsArticle{
    private final int kodeBerita;
    private String penulis;
    private String judul;
    private String jenis;
    private String tanggal;
    private String isi;

    public Berita(int kodeBerita, String penulis, String judul, String jenis, String tanggal, String isi) {
        this.kodeBerita = kodeBerita;
        this.penulis = penulis;
        this.judul = judul;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    @Override
    public int getkodeBerita() {
        return kodeBerita;
    }

    @Override
    public String[] display() {
        String[] news = new String[4];
        news[0] = this.judul;
        news[1] = this.penulis;
        news[2] = this.tanggal;
        news[3] = this.isi;
        return news;
    }
    
}
