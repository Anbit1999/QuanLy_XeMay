/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
import static Controll.DanhsachKhachHang.conn;
import static Controll.DanhsachKhachHang.ps;
import static Controll.Dulieubang.conn;
import static Controll.Dulieubang.ps;
import static Controll.Dulieubang.rs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Xemay;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author DELL
 */
public class DanhsachXe {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    /**
    * Lấy dữ liệu thông tin xe từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void loadDuLieuXe(String sql, JTable tb) {
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            tb.removeAll();
            String []arr= {"STT","Mã Xe","Tên Nhà cung cấp","Tên Xe","Màu Xe","Số lượng","Đơn giá nhập","Loại xe","Nước sản xuất","Phân khối",
            "Khối lượng","Phiên bản"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "SELECT * from dbo.[XeMay] x join dbo.[NhaCungCap] n on x.maNhaCungCap=n.maNhaCungCap join dbo.[LoaiXe] l on l.maLoaiXe=x.maLoaiXe ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maXe"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("mauXe"));                
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("donGiaNhap"));
                vector.add(rs.getString("loaiXe"));
                vector.add(rs.getString("nuocSX"));
                vector.add(rs.getString("phanKhoi"));
                vector.add(rs.getString("khoiLuong"));
                vector.add(rs.getString("phienBan"));
                //vector.add(rs.getBytes("imageXM"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin xe theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void TimtenXe(String sql, JTable tb, String tenxe) {
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            tb.removeAll();
            String []arr= {"STT","Mã Xe","Tên nhà cung cấp","Tên Xe","Màu Xe","Số lượng","Đơn giá nhập","Loại xe","Nước sản xuất","Phân khối",
            "Khối lượng","Phiên bản"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "SELECT * from dbo.[XeMay] x join dbo.[NhaCungCap] n on x.maNhaCungCap=n.maNhaCungCap join dbo.[LoaiXe] l on l.maLoaiXe=x.maLoaiXe where tenXe like '%"+tenxe+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maXe"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("mauXe"));                
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("donGiaNhap"));
                vector.add(rs.getString("LoaiXe"));
                vector.add(rs.getString("nuocSX"));
                vector.add(rs.getString("phanKhoi"));
                vector.add(rs.getString("khoiLuong"));
                vector.add(rs.getString("phienBan"));
                //vector.add(rs.getBytes("imageXM"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin xe theo phân khối
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void Timpkxe(String sql, JTable tb, float phankhoi) {
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            tb.removeAll();
            String []arr= {"STT","Mã Xe","Tên nhà cung cấp","Tên Xe","Màu Xe","Số lượng","Đơn giá nhập","Loại xe","Nước sản xuất","Phân khối",
            "Khối lượng","Phiên bản"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "SELECT * from dbo.[XeMay] x join dbo.[NhaCungCap] n on x.maNhaCungCap=n.maNhaCungCap join dbo.[LoaiXe] l on l.maLoaiXe=x.maLoaiXe where phanKhoi="+phankhoi+"";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maXe"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("mauXe"));                
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("donGiaNhap"));
                vector.add(rs.getString("LoaiXe"));
                vector.add(rs.getString("nuocSX"));
                vector.add(rs.getString("phanKhoi"));
                vector.add(rs.getString("khoiLuong"));
                vector.add(rs.getString("phienBan"));
                //vector.add(rs.getBytes("imageXM"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Tìm thông tin xe theo loại
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void timloaixe(String sql, JTable tb, String loaixe) {
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            tb.removeAll();
            String []arr= {"STT","Mã Xe","Tên nhà cung cấp","Tên Xe","Màu Xe","Số lượng","Đơn giá nhập","Loại xe","Nước sản xuất","Phân khối",
            "Khối lượng","Phiên bản"};
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "SELECT * from dbo.[XeMay] x join dbo.[NhaCungCap] n on x.maNhaCungCap=n.maNhaCungCap join dbo.[LoaiXe] l on l.maLoaiXe=x.maLoaiXe where loaiXe like N'%"+loaixe+"%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maXe"));
                vector.add(rs.getString("tenNhaCungCap"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("mauXe"));                
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("donGiaNhap"));
                vector.add(rs.getString("LoaiXe"));
                vector.add(rs.getString("nuocSX"));
                vector.add(rs.getString("phanKhoi"));
                vector.add(rs.getString("khoiLuong"));
                vector.add(rs.getString("phienBan"));
                //vector.add(rs.getBytes("imageXM"));
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Thêm thông tin xe theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void ThemXe(String maXe,String tenXe,String mauXe,int soLuong,double donGiaNhap,
            int loaiXe,String nuocSX,int phanKhoi,float khoiLuong,String phienBan,String maNhaCungCap, byte [] image){
        String sql = "Insert into dbo.[XeMay](maXe,tenXe,mauXe,soLuong,donGiaNhap,maLoaiXe,"
                + "nuocSX,phanKhoi,khoiLuong,phienBan,maNhaCungCap,imageXM) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, maXe);
            ps.setString(2, tenXe);
            ps.setString(3, mauXe);
            ps.setInt(4, soLuong);
            ps.setDouble(5, donGiaNhap);
            ps.setInt(6, loaiXe);
            ps.setString(7, nuocSX);
            ps.setInt(8, phanKhoi);
            ps.setFloat(9, khoiLuong);
            ps.setString(10, phienBan);
            ps.setString(11, maNhaCungCap); 
            ps.setBytes(12, image);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm thông tin xe thành công");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Thêm thông tin xe thất bại");
           
        }
    }
    /**
    * Sửa thông tin xe theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void SuaXe(String maXe,String tenXe,String mauXe,int soLuong,double donGiaNhap,
            int loaiXe,String nuocSX,int phanKhoi,float khoiLuong,String phienBan,String maNhaCungCap, byte [] image){
        //DecimalFormat df = new DecimalFormat("#,###.00");
        /*String sql="Update dbo.[XeMay] set tenXe=N'"+tenXe+"',mauXe=N'"+mauXe+"',soLuong='"+soLuong+"',donGiaNhap="+donGiaNhap+",maLoaiXe="+loaiXe+","
                + "nuocSX=N'"+nuocSX+"',phanKhoi='"+phanKhoi+"',khoiLuong='"+khoiLuong+"',phienBan='"+phienBan+"',maNhaCungCap='"+maNhaCungCap+"',imageXM='"+image+"'"
                + "where maXe='"+maXe+"'";*/
        String sql="Update dbo.[XeMay] set tenXe=?,mauXe=?,soLuong=?,donGiaNhap=?,maLoaiXe=?,"
                + "nuocSX=?,phanKhoi=?,khoiLuong=?,phienBan=?,maNhaCungCap=?,imageXM=? where maXe='"+maXe+"'";
        try {
            ps= conn.prepareStatement(sql);            
            
            ps.setString(1, tenXe);
            ps.setString(2, mauXe);
            ps.setInt(3, soLuong);
            ps.setDouble(4, donGiaNhap);
            ps.setInt(5, loaiXe);
            ps.setString(6, nuocSX);
            ps.setInt(7, phanKhoi);
            ps.setFloat(8, khoiLuong);
            ps.setString(9, phienBan);
            ps.setString(10, maNhaCungCap); 
            ps.setBytes(11, image);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã sửa xe có mã là "+maXe+" thành công");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Hoa don da sua truoc do roi","thong bao", 1);
            JOptionPane.showMessageDialog(null, "Sửa thông tin xe thất bại");
        }
    }
    /**
    * Xóa thông tin xe theo tên
    * 
    * @author: Phan Duy Tuấn
    * 
    * Ngày 5/10/2019
    * 
    */
    public static void XoaXe(String maxe){
        String sql = "Delete from dbo.[XeMay] where maXe='"+maxe+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Chiếc xe có mã "+maxe+"đã được xóa","Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chiếc xe có mã "+maxe+" có thể sử dụng ở thực thể khác nên không thẻ xóa","Thông báo",1);
        }
    }

    

    
}
