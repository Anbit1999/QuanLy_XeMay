/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
import static Controll.DanhsachXe.ps;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DanhsachNhanVien {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    /**
    * Lấy dữ liệu thông tin nhân viên từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 9/10/2019
    * 
    */
    public static void loadDuLieuNhanVien(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại", "Số CMND", "Ngày sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhanVien]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenNhanVien"));
                vector.add(rs.getString("soDienThoai"));
                //vector.add("");
                vector.add(rs.getString("soCMND"));
                vector.add(sdf.format(rs.getDate("ngaySinh")));
                vector.add(rs.getString("email"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin nhân viên theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param  tennv: Tên của khách hàng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void TimtenNhanVien(String sql, JTable tb, String tennv) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại", "Số CMND", "Ngày sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhanVien] where tenNhanVien like '%"+tennv+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenNhanVien"));
                vector.add(rs.getString("soDienThoai"));
                //vector.add("");
                vector.add(rs.getString("soCMND"));
                vector.add(sdf.format(rs.getDate("ngaySinh")));
                vector.add(rs.getString("email"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin nhân viên theo số điện thoại
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param sodienthoai: Giá trị số điện thoại khách hàng
    * 
    * Ngày 9/10/2019
    * 
    */
    public static void TimsdtNhanVien(String sql, JTable tb, String sodienthoai) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại", "Số CMND", "Ngày sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhanVien] where soDienThoai like '%"+sodienthoai+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenNhanVien"));
                vector.add(rs.getString("soDienThoai"));
                //vector.add("");
                vector.add(rs.getString("soCMND"));
                vector.add(sdf.format(rs.getDate("ngaySinh")));
                vector.add(rs.getString("email"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin nhân viên theo số cmnd
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param cmnd: Giá trị số cmnd khách hàng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void TimcmndNhanVien(String sql, JTable tb, String cmnd) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại", "Số CMND", "Ngày sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhanVien] where soCMND like '%"+cmnd+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenNhanVien"));
                vector.add(rs.getString("soDienThoai"));
                //vector.add("");
                vector.add(rs.getString("soCMND"));
                vector.add(sdf.format(rs.getDate("ngaySinh")));
                vector.add(rs.getString("email"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Thêm thông tin nhân viên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void ThemNhanVien(String manhanvien, String tennhanvien,String sodienthoai,String socmnd, String ngaysinh ,String email, byte [] image){
        String sql = "Insert into dbo.[NhanVien](maNhanVien,tenNhanVien,soDienthoai,soCMND,ngaySinh,imageNV,email) values(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, manhanvien);
            ps.setString(2, tennhanvien);
            ps.setString(3, sodienthoai);
            ps.setString(4, socmnd);
            ps.setString(5, ngaysinh);            
            ps.setBytes(6, image);
            ps.setString(7, email);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm nhân viên thành công","thong bao",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại","thong bao", 1);
           
        }
    }
    /**
    * Sửa thông tin nhân viên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void SuaNhanVien(String manhanvien, String tennhanvien,String sodienthoai,String socmnd, String ngaysinh ,String email,byte [] image){
        /*String sql="update dbo.[NhanVien] set  tenNhanVien=N'"+tennhanvien+"',"
                + " soDienThoai='"+sodienthoai+"', soCMND='"+socmnd+"', ngaySinh='"+ngaysinh+"', email='"+email+"'
        where maNhanVien='"+manhanvien+"'";*/
        String sql = "Update dbo.[NhanVien] set tenNhanVien=?,soDienThoai=?,soCMND=?,ngaysinh=?,imageNV=?,email=? where maNhanVien='"+manhanvien+"'";
        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1, tennhanvien);
            ps.setString(2, sodienthoai);
            ps.setString(3, socmnd);
            ps.setString(4, ngaysinh); 
            ps.setBytes(5, image);
            ps.setString(6, email);
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã sửa nhân viên có mã là "+manhanvien+" thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên thất bại","thông báo", 1);
            e.printStackTrace();
        }
    }
    /**
    * Xóa thông tin nhân viên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void XoaNhanVien(String manhanvien){
        String sql = "Delete from dbo.[NhanVien] where maNhanVien='"+manhanvien+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Nhân viên có mã "+manhanvien+"đã được xóa","Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhân viên có mã "+manhanvien+" có thể sử dụng ở thực thể khác nên không thẻ xóa","Thông báo",1);
        }
    }
}
