/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectdatabase;

import entity.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAO {
    private Connection conn;
    
    public DAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Ban_Xe_May;"
                    + "username=sa;password=sapassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addHoaDon(HoaDon h){
        String sql= "Insert into [dbo].[HoaDon](maHoaDon, maKhachHang, ngayLap, maNhanVien)" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,h.getMaHoaDon() );
            ps.setString(2,h.getMaKhachHang() );
            ps.setString(3,h.getMaNhanVien() );
            ps.setDate(4, new Date(h.getNgayLap().getTime()));
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<HoaDon> getListHoaDon(){
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "Select * from [dbo].[HoaDon]";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                HoaDon hd= new HoaDon();
                hd.setMaHoaDon(rs.getString("maHoaDon"));
                hd.setMaKhachHang(rs.getString("maKhachHang"));
                hd.setNgayLap(rs.getDate("ngayLap"));
                hd.setMaNhanVien(rs.getString("maNhanVien"));
                        
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        new DAO();
    }
}
