/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
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
public class DanhsachKhachHang {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    /**
    * Lấy dữ liệu thông tin khách hàng từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void loadDuLieuKhachHang(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","CMND","Ngày Sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[KhachHang]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maKhachHang"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(rs.getString("soDienThoai"));
                vector.add("");
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
    * Tìm thông tin khách hàng theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param  tenkh: Tên của khách hàng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void TimtenKhachHang(String sql, JTable tb, String tenkh) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","CMND","Ngày Sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[KhachHang] where tenKhachHang like '%"+tenkh+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maKhachHang"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(rs.getString("soDienThoai"));
                vector.add("");
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
    * Tìm thông tin khách hàng theo số điện thoại
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param sodienthoai: Giá trị số điện thoại khách hàng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void TimsdtKhachHang(String sql, JTable tb, String sodienthoai) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","CMND","Ngày Sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[KhachHang] where soDienThoai like '%"+sodienthoai+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maKhachHang"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(rs.getString("soDienThoai"));
                vector.add("");
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
    * Tìm thông tin khách hàng theo số CMND
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param sodienthoai: Giá trị số cmnd khách hàng
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void TimcmndKhachHang(String sql, JTable tb, String cmnd) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","CMND","Ngày Sinh","Email"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
         String query = "Select * from dbo.[KhachHang] where soCMND like '%"+cmnd+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maKhachHang"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(rs.getString("soDienThoai"));
                vector.add("");
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
    * Thêm thông tin khách hàng 
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void ThemKhachHang(String makhachhang, String tenkhachhang,String sodienthoai,String socmnd, String ngaysinh ,String email){
        String sql = "Insert into dbo.[KhachHang](maKhachHang,tenKhachHang,soDienthoai,soCMND,ngaySinh,email) values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, makhachhang);
            ps.setString(2, tenkhachhang);
            ps.setString(3, sodienthoai);
            ps.setString(4, socmnd);
            ps.setString(5, ngaysinh);
            
            ps.setString(6, email);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công","thông báo",1);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Đã tồn tại khách hàng này","thông báo", 1);
            e.printStackTrace();
        }
    }
    /**
    * Sửa thông tin khách hàng 
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void SuaKhachHang(String makhachhang, String tenkhachhang,String sodienthoai,String socmnd, String ngaysinh ,String email){
        String sql="update dbo.[KhachHang] set tenKhachHang=N'"+tenkhachhang+"',"
                + " soDienThoai='"+sodienthoai+"', soCMND='"+socmnd+"', ngaySinh='"+ngaysinh+"', email='"+email+"' where maKhachHang='"+makhachhang+"'";
        try {
            ps= conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã sửa khách hàng có mã là "+makhachhang+" thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa khách hàng thất bại","Thông báo", 1);
            e.printStackTrace();
        }
    }
    /**
    * Xóa thông tin khách hàng 
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 7/10/2019
    * 
    */
    public static void XoaKhachHang(String makhachhang){
        String sql = "Delete from dbo.[KhachHang] where maKhachHang='"+makhachhang+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Khách hàng có mã "+makhachhang+"đã được xóa","Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng có mã "+makhachhang+" có thể sử dụng ở thực thể khác nên không thẻ xóa","Thông báo",1);
        }
    }
}
