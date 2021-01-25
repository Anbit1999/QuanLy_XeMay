/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Connectdatabase.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class DanhsachDangNhap {
    public static PreparedStatement ps= null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    
    
}
