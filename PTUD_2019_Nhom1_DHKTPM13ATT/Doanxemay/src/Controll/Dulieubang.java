/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import entity.Xemay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connectdatabase.Connect;
/**
 *
 * @author DELL
 */
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import sun.security.pkcs11.Secmod;
public class Dulieubang {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    /**
     * Đẩy dữ liệu từ cớ sở dữ liệu lên trên bảng của giao diện
     * 
     * @author: Phan Duy Tuấn
     * 
     * @param sql: Câu lệnh sql
     * @param tb: Tên bảng
     * 
     * Ngày 2/10/2019
     */
    public static void loadDuLieu(String sql, JTable tb) {
        String []arr= {"STT","Mã Hóa Đơn","Tên Khách Hàng","Tên Xe","Số Lượng","Đơn Giá","Ngày Lập hóa đơn"};
        try {
            ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Đẩy dữ liệu từ cớ sở dữ liệu lên trên các ô trên giao diện
     * 
     * @author: Phan Duy Tuấn
     * 
     * @param sql: Câu lệnh sql
     * 
     * 
     * Ngày 2/10/2019
     */
    public static ResultSet ShowTextField(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
}
