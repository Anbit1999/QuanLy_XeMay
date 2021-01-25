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
public class DanhsachNhaCungCap {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    /**
    * Lấy dữ liệu thông tin nhà cung cấp từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void loadDuLieuNhaCungCap(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhaCungCap]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhaCungCap"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("soDienThoai"));                            
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin nhà cung cấp theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param  tennv: Tên của khách hàng
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void timtenNhaCungCap(String sql, JTable tb, String tenncc) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhaCungCap] where tenNhaCungCap like '%"+tenncc+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhaCungCap"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("soDienThoai"));                            
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin nhà cung cấp theo số điện thoại
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * @param  sodienthoai: Tên của khách hàng
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void timsdtNhaCungCap(String sql, JTable tb, String sodienthoai) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "Select * from dbo.[NhaCungCap] where soDienThoai like '%"+sodienthoai+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maNhaCungCap"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("soDienThoai"));                            
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Thêm thông tin nhà cung cấp
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void ThemNhaCungCap(String mancc, String tenncc, String sodienthoai){
        String sql = "Insert into dbo.[NhaCungCap](maNhaCungCap,tenNhaCungCap,soDienthoai) values(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mancc);
            ps.setString(2, tenncc);
            ps.setString(3, sodienthoai);          
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm nhà cung cấp thành công","thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại nhà cung cấp này","thông báo", 1);
        }
    }
    
    /**
    * Sửa thông tin nhà cung cấp
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void SuaNhaCungCap(String mancc, String tenncc, String sodienthoai){
        String sql="update dbo.[NhaCungCap] set maNhaCungCap='"+mancc+"', tenNhaCungCap=N'"+tenncc+"',"
                + " soDienThoai='"+sodienthoai+"' where maNhaCungCap='"+mancc+"'";
        try {
            ps= conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã sửa nhà cung cấp có mã là "+mancc+" thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thất bại","thong bao", 1);
        }
    }
    /**
    * Xóa thông tin nhà cung cấp
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 10/10/2019
    * 
    */
    public static void XoaNhaCungCap(String mancc){
        String sql = "Delete from dbo.[NhaCungCap] where maNhaCungCap='"+mancc+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Nhà cung cấp có mã "+mancc+" đã được xóa","Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhà cung cấp có mã "+mancc+" có thể sử dụng ở thực thể khác nên không thẻ xóa","Thông báo",1);
        }
    }
}
