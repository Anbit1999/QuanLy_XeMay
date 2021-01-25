/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
import entity.Xemay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import entity.HoaDon;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DanhsachHoaDon {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    java.util.Date date = new java.util.Date();
    /**
    * Lấy dữ liệu thông tin hóa đơn từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 6/10/2019
    * 
    */
    public static void loadDuLieuHoaDon(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Tên khách hàng","Ngày lập","Mã nhân viên" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select * from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));                
               
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadDuLieu1HoaDon(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Tên khách hàng","Ngày lập","Mã nhân viên" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select top 1 * from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang order by maHoaDon desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("tenKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));                
               
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Lấy dữ liệu thông tin chi tiết hóa đơn từ cơ sở dữ liệu
    * 
    * @author: Phan Duy Tuấn
    * 
    * @param sql: Câu lệnh sql
    * @param tb: Tên bảng
    * 
    * Ngày 6/10/2019
    * 
    */
    public static void loadDuLieuChiTiet(String sql, JTable tb, String mahoadon) {
        int i=1;
        try{
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Mã xe","Tên xe","Số lượng","Đơn giá","Thành Tiền" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "SELECT ct.maHoaDon,ct.maXe,tenXe,ct.soLuong,donGia,thanhTien=(ct.soLuong*donGia) "
                + "FROM dbo.[ChiTietHoaDon] ct join dbo.[XeMay] x on ct.maXe=x.maXe join dbo.[HoaDon] h on h.maHoaDon=ct.maHoaDon"
                    + " where ct.maHoaDon='"+mahoadon+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("maXe"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("donGia"));                
                vector.add(rs.getString("thanhTien"));      
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Thêm chi tiết hóa đơn thất bại","Thông báo",1);
        }
    }
    public static void ThemHoaDon(String mahoadon, String makhachhang, Date ngaylap ,String manhanvien){
        String sql = "Insert into dbo.[HoaDon](maHoaDon,maKhachHang,ngayLap,maNhanVien) values(?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mahoadon);
            ps.setString(2, makhachhang);
            ps.setDate(3, ngaylap);
            ps.setString(4, manhanvien);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Da them hoa don thanh cong","thong bao",1);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Da ton tai","thong bao", 1);
            e.printStackTrace();
        }
    }
    public static void ThemChiTiet(String mahoadon, String maxe, int soluong,double dongia, double thanhtien){
        String sql = "Insert into dbo.[ChiTietHoaDon](maHoaDon,maXe,soLuong,donGia,thanhTien) values(?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mahoadon);
            ps.setString(2, maxe);
            ps.setInt(3, soluong);
            ps.setDouble(4, dongia);
            ps.setDouble(5, thanhtien);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm chi tiết hóa đơn thành công","thong bao",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số lượng xe không đủ","thong bao", 1);
            
        }
    }
    public static void SuaHoaDon(String mahoadon, String makhachhang, Date ngaylap, String manhanvien){
        String sql="update dbo.[HoaDon] set maHoaDon='"+mahoadon+"', maKhachHang='"+makhachhang+"', ngayLap='"+ngaylap+"', maNhanVien='"+manhanvien+"'";
        try {
            ps= conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Da them hoa don co ma"+mahoadon+" thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hoa don da sua truoc do roi","thong bao", 1);
        }
    }
    public static void XoaHoaDon(String mahoadon){
        String sql = "Delete from dbo.[HoaDon] where maXe='"+mahoadon+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Chiếc xe có mã "+mahoadon+"đã được xóa","Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chiếc xe có mã "+mahoadon+" có thể sử dụng ở thực thể khác nên không thẻ xóa","Thông báo",1);
        }
    }
    public static void Thongke(String thang, String nam,String sql, JTable tb){
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Mã khách hàng","Ngày lập","Mã nhân viên","Tên xe", "Số Lượng", "Thành tiền" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select * from dbo.[HoaDon] h join dbo.[ChiTietHoaDon] ct on h.maHoaDon=ct.maHoaDon join dbo.[XeMay] x on x.maXe=ct.maXe where MONTH(ngayLap)='"+thang+"' and YEAR(ngayLap)='"+nam+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("maKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("thanhTien"));
                
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Thongketheothang(String thang,String sql, JTable tb){
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Mã khách hàng","Ngày lập","Mã nhân viên","Tên xe", "Số Lượng", "Thành tiền" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select * from dbo.[HoaDon] h join dbo.[ChiTietHoaDon] ct on h.maHoaDon=ct.maHoaDon join dbo.[XeMay] x on x.maXe=ct.maXe where MONTH(ngayLap)='"+thang+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("maKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("thanhTien"));
                
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Thongketheonam(String nam,String sql, JTable tb){
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Mã khách hàng","Ngày lập","Mã nhân viên","Tên xe", "Số Lượng", "Thành tiền" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select * from dbo.[HoaDon] h join dbo.[ChiTietHoaDon] ct on h.maHoaDon=ct.maHoaDon join dbo.[XeMay] x on x.maXe=ct.maXe where YEAR(ngayLap)='"+nam+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("maKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("thanhTien"));
                
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadDuLieuThongke(String sql, JTable tb) {
        
        try {
            int i=1;
            /*ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            tb.removeAll();
            String []arr= {"STT","Mã hóa dơn","Mã khách hàng","Ngày lập","Mã nhân viên","Tên xe", "Số Lượng", "Thành tiền" };
            DefaultTableModel model= new DefaultTableModel(arr,0);
            Connection connection= Connect.getConnect();
            String query = "select * from dbo.[HoaDon] h join dbo.[ChiTietHoaDon] ct on h.maHoaDon=ct.maHoaDon join dbo.[XeMay] x on x.maXe=ct.maXe";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {                
                Vector vector= new Vector();
                vector.add(i++);
                vector.add(rs.getString("maHoaDon"));
                vector.add(rs.getString("maKhachHang"));
                vector.add(sdf.format(rs.getDate("ngayLap")));
                vector.add(rs.getString("maNhanVien"));
                vector.add(rs.getString("tenXe"));
                vector.add(rs.getString("soLuong"));
                vector.add(rs.getString("thanhTien"));
                
                model.addRow(vector);
            }
            tb.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
