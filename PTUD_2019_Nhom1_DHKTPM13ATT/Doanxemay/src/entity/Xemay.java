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
public class Xemay {
    private String maXe, tenXe, mauXe, maNhaCungCap,loaiXe,nuocSX,phienBan;
    private int soLuong;
    private float donGiaNhap,phanKhoi,khoiLuong;

    public Xemay(String maXe, String tenXe, String mauXe, String maNhaCungCap, String loaiXe, String nuocSX, String phienBan, int soLuong, float donGiaNhap, float phanKhoi, float khoiLuong) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.mauXe = mauXe;
        this.maNhaCungCap = maNhaCungCap;
        this.loaiXe = loaiXe;
        this.nuocSX = nuocSX;
        this.phienBan = phienBan;
        this.soLuong = soLuong;
        this.donGiaNhap = donGiaNhap;
        this.phanKhoi = phanKhoi;
        this.khoiLuong = khoiLuong;
    }

    public Xemay() {
    }
    
    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }


    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getNuocSX() {
        return nuocSX;
    }

    public void setNuocSX(String nuocSX) {
        this.nuocSX = nuocSX;
    }

    public String getPhienBan() {
        return phienBan;
    }

    public void setPhienBan(String phienBan) {
        this.phienBan = phienBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(float donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public float getPhanKhoi() {
        return phanKhoi;
    }

    public void setPhanKhoi(float phanKhoi) {
        this.phanKhoi = phanKhoi;
    }

    public float getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
    

    
    

    
    
}
