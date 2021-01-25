/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class ChuCuaHang {
    private String maChuCuaHang, tenChuCuaHang, soDienThoai, soCMND, quocTich, email;
    private Date ngaySinh;

    public ChuCuaHang(String maChuCuaHang, String tenChuCuaHang, String soDienThoai, String soCMND, String quocTich, String email, Date ngaySinh) {
        this.maChuCuaHang = maChuCuaHang;
        this.tenChuCuaHang = tenChuCuaHang;
        this.soDienThoai = soDienThoai;
        this.soCMND = soCMND;
        this.quocTich = quocTich;
        this.email = email;
        this.ngaySinh = ngaySinh;
    }   

    public String getMaChuCuaHang() {
        return maChuCuaHang;
    }

    public void setMaChuCuaHang(String maChuCuaHang) {
        this.maChuCuaHang = maChuCuaHang;
    }

    public String getTenChuCuaHang() {
        return tenChuCuaHang;
    }

    public void setTenChuCuaHang(String tenChuCuaHang) {
        this.tenChuCuaHang = tenChuCuaHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
}
