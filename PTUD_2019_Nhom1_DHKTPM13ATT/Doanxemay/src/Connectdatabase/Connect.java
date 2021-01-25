/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author: Phan Duy Tuấn
 * Kết nối database
 */
public class Connect {
    public static Connection getConnect(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Ban_Xe_May;"
                    + "username=sa;password=sapassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public  static void closeConnect(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Connect();
    }
    
    
}
