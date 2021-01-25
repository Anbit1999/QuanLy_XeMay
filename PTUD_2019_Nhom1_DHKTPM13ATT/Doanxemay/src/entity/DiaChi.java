/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class DiaChi {
    private String maDiaChi, soNha,Duong, Huyen, thanhPho, Tinh;

    public DiaChi(String maDiaChi, String soNha, String Duong, String Huyen, String thanhPho, String Tinh) {
        this.maDiaChi = maDiaChi;
        this.soNha = soNha;
        this.Duong = Duong;
        this.Huyen = Huyen;
        this.thanhPho = thanhPho;
        this.Tinh = Tinh;
    }

    public String getMaDiaChi() {
        return maDiaChi;
    }

    public void setMaDiaChi(String maDiaChi) {
        this.maDiaChi = maDiaChi;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String Duong) {
        this.Duong = Duong;
    }

    public String getHuyen() {
        return Huyen;
    }

    public void setHuyen(String Huyen) {
        this.Huyen = Huyen;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String Tinh) {
        this.Tinh = Tinh;
    }
    
}
