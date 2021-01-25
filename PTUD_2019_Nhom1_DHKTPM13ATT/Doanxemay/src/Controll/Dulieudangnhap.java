/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
import static Controll.Dulieubang.conn;
import static Controll.Dulieubang.ps;
import static Controll.Dulieubang.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 * Lấy dữ liệu thông tin đăng nhập từ cơ sở dữ liệu
 * 
 * @author: Phan Duy Tuấn
 * 
 * Ngày 1/10/2019
 * 
 */
public class Dulieudangnhap {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    
    public static void loadDuLieu(String sql) {
        try {
            ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
