/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanxemay;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import Connectdatabase.Connect;
import Controll.DanhsachHoaDon;
import Controll.Dulieubang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.SimplePdfTextRenderer;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 * Giao diện hóa đơn
 * 
 * @author: Phan Duy Tuấn
 * 
 */
public class GUIHoaDon extends javax.swing.JFrame {
    public static String sql = "Select * from dbo.[HoaDon]";
    public static String maHoaDon;
    public static String maXe;
    public static String maKhachHang;
    /**
     * Tạo giao diện hóa đơn
     * 
     * @author : Phan Duy Tuấn
     */
    public GUIHoaDon() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        showDuLieu();
        showcombobox();
        DanhsachHoaDon.loadDuLieu1HoaDon(sql, tblHoaDon);
        AutoCompleteDecorator.decorate(cmbsdt);
        AutoCompleteDecorator.decorate(cmbmakh);
        AutoCompleteDecorator.decorate(cmbtenxe);
        Crt(false);
    }
    /**
     * Ẩn hiện các nút trên giao diện
     * 
     * @param b : Giá trị true hoặc false
     * 
     * Ngày 17/10/2019
     */
    public void Crt(boolean b){
        this.btnluuhd.setEnabled(b);
        this.btninhd.setEnabled(b);        
        this.cmbmakh.setEnabled(b);
        this.txtsoluong.setEnabled(b);
        this.calender_ngaylap.setEnabled(b);
        this.cmbsdt.setEnabled(b);
        
    }
    /**
     * Hiển thị giá trị của combobox
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 20/10/2019
     */
    public void showcombobox(){
        Connection connection = Connect.getConnect();
        try {
                    String sql1="Select * from dbo.[XeMay]";
                    PreparedStatement ps = connection.prepareStatement(sql1);
                    ResultSet rs = ps.executeQuery();
                    
                    
                    while(rs.next()){            
                        
                        this.cmbtenxe.addItem(rs.getString("tenXe"));                     
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
        
        try {
                String sql2="Select * from dbo.[KhachHang]";
                    PreparedStatement ps = connection.prepareStatement(sql2);
                    ResultSet rs = ps.executeQuery();
                    
                    
                    while(rs.next()){        
                        
                        this.cmbmakh.addItem(rs.getString("tenKhachHang"));
                        this.cmbsdt.addItem(rs.getString("soDienThoai"));
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
                String sql3="Select * from dbo.[KhachHang] where tenKhachHang like N'%"+this.cmbmakh.getSelectedItem().toString()+"%'";
                    PreparedStatement ps = connection.prepareStatement(sql3);
                    ResultSet rs = ps.executeQuery();
                    
                    
                    while(rs.next()){      
                        String tenkh = rs.getString("tenKhachHang");
                        //this.lblmakh.setText(rs.getString("maKhachHang"));
                        
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
           
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblxe = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblhoadon = new javax.swing.JLabel();
        lbldangxuat = new javax.swing.JLabel();
        lblkhachhang = new javax.swing.JLabel();
        lblnhanvien = new javax.swing.JLabel();
        lblnhacc = new javax.swing.JLabel();
        lblthongke = new javax.swing.JLabel();
        lblthongtin = new javax.swing.JLabel();
        btnthemhd = new javax.swing.JPanel();
        lblthoat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblthemhd = new javax.swing.JButton();
        btnluuhd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblmahd = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblmanv = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        btninhd = new javax.swing.JButton();
        cmbtenxe = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblthanhtien = new javax.swing.JLabel();
        btnthemct = new javax.swing.JButton();
        txtsoluong = new javax.swing.JTextField();
        calender_ngaylap = new com.toedter.calendar.JDateChooser();
        lblngaylap = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbsdt = new javax.swing.JComboBox<>();
        cmbmakh = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lbldongia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(76, 95, 107));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 743));

        label1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Phan Duy Tuấn");

        class RoundedPanel extends JPanel
        {
            private Color backgroundColor;
            private int cornerRadius = 15;
            public RoundedPanel(LayoutManager layout, int radius) {
                super(layout);
                cornerRadius = radius;
            }
            public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
                super(layout);
                cornerRadius = radius;
                backgroundColor = bgColor;
            }
            public RoundedPanel(int radius) {
                super();
                cornerRadius = radius;

            }
            public RoundedPanel(int radius, Color bgColor) {
                super();
                cornerRadius = radius;
                backgroundColor = bgColor;
            }
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(cornerRadius, cornerRadius);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Draws the rounded panel with borders.
                if (backgroundColor != null) {
                    graphics.setColor(backgroundColor);
                } else {
                    graphics.setColor(getBackground());
                }
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
                graphics.setColor(getForeground());
                //            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
                //
            }
        }

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Anhdaidien.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        lblxe.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblxe.setForeground(new java.awt.Color(255, 255, 255));
        lblxe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblxe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/xemay_khongchon.png"))); // NOI18N
        lblxe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblxeMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("duytuan");

        lblhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Hoadon_chon.png"))); // NOI18N
        lblhoadon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhoadonMouseClicked(evt);
            }
        });

        lbldangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangxuat.png"))); // NOI18N
        lbldangxuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbldangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldangxuatMouseClicked(evt);
            }
        });

        lblkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/khachhang_khongchon.png"))); // NOI18N
        lblkhachhang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkhachhangMouseClicked(evt);
            }
        });

        lblnhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/nhanvien_khongchon.png"))); // NOI18N
        lblnhanvien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnhanvienMouseClicked(evt);
            }
        });

        lblnhacc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/NhaCC_khongchon.png"))); // NOI18N
        lblnhacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnhaccMouseClicked(evt);
            }
        });

        lblthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Khongchon_Thongke.png"))); // NOI18N
        lblthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblthongkeMouseClicked(evt);
            }
        });

        lblthongtin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Thongtin_khongchon.png"))); // NOI18N
        lblthongtin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblthongtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblthongtinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblthongtin)
                    .addComponent(lblthongke)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblnhacc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldangxuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblhoadon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblxe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbldangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblxe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnhacc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblthongke)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblthongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnthemhd.setBackground(new java.awt.Color(242, 242, 242));
        btnthemhd.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        lblthoat.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        lblthoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        lblthoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblthoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblthoatMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 95, 107));
        jLabel1.setText("Hóa đơn");

        lblthemhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Themhd.png"))); // NOI18N
        lblthemhd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        lblthemhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblthemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblthemhdActionPerformed(evt);
            }
        });

        btnluuhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Luuct.png"))); // NOI18N
        btnluuhd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        btnluuhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnluuhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuhdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setText("Thông tin hóa đơn");

        tblHoaDon.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.setRowHeight(20);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel3.setText("Chi tiết hóa đơn");

        tblChiTietHoaDon.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên xe", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblChiTietHoaDon.setRowHeight(20);
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietHoaDon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setText("Mã hóa đơn");

        lblmahd.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblmahd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel6.setText("Tên khách hàng");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("Ngày lập");

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setText("Mã nhân viên");

        lblmanv.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblmanv.setText("jLabel10");
        lblmanv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel11.setText("Tổng tiền");

        lbltongtien.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbltongtien.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        lbltongtien.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lbltongtienComponentShown(evt);
            }
        });

        btninhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/In.png"))); // NOI18N
        btninhd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        btninhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btninhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninhdActionPerformed(evt);
            }
        });

        cmbtenxe.setEditable(true);
        cmbtenxe.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        cmbtenxe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        cmbtenxe.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbtenxePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbtenxe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbtenxeKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel12.setText("Số lượng");

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel13.setText("Đơn giá");

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel15.setText("Thành tiền");

        lblthanhtien.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblthanhtien.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));

        btnthemct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/css/Themct.png"))); // NOI18N
        btnthemct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemctActionPerformed(evt);
            }
        });

        txtsoluong.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });
        txtsoluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsoluongKeyReleased(evt);
            }
        });

        calender_ngaylap.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));
        calender_ngaylap.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        lblngaylap.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblngaylap.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(76, 95, 107)));

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel16.setText("Số điện thoại");

        cmbsdt.setEditable(true);
        cmbsdt.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        cmbsdt.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbsdtPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cmbmakh.setEditable(true);
        cmbmakh.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        cmbmakh.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbmakhPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmakhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel17.setText("Tên xe");

        lbldongia.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbldongia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(76, 95, 107)));

        javax.swing.GroupLayout btnthemhdLayout = new javax.swing.GroupLayout(btnthemhd);
        btnthemhd.setLayout(btnthemhdLayout);
        btnthemhdLayout.setHorizontalGroup(
            btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnthemhdLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnthemhdLayout.createSequentialGroup()
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(btnthemhdLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 402, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnthemhdLayout.createSequentialGroup()
                                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnthemhdLayout.createSequentialGroup()
                                                .addComponent(lblthemhd)
                                                .addGap(86, 86, 86)
                                                .addComponent(btnluuhd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btninhd))
                                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbldongia, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbtenxe, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(btnthemhdLayout.createSequentialGroup()
                                                        .addComponent(lblngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(calender_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(58, 58, 58))))
                            .addGroup(btnthemhdLayout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(btnthemct, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnthemhdLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        btnthemhdLayout.setVerticalGroup(
            btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnthemhdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(btnthemhdLayout.createSequentialGroup()
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(lblmahd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calender_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnluuhd)
                            .addComponent(lblthemhd)
                            .addComponent(btninhd))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btnthemhdLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbtenxe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldongia, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnthemhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(lblthanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnthemct)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthemhd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
            .addComponent(btnthemhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblxeMouseClicked
        new GUIXeMay().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblxeMouseClicked

    private void lblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhoadonMouseClicked
        new GUIHoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblhoadonMouseClicked

    private void lblthoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthoatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblthoatMouseClicked

    private void lblthemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblthemhdActionPerformed
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        long day = System.currentTimeMillis();
        Date ngay = new Date();
        this.calender_ngaylap.setDate(ngay);
        this.lblngaylap.setText(sdf.format(ngay));
        btnluuhd.setEnabled(true);
        cmbmakh.setEnabled(true);
        
        cmbsdt.setEnabled(true);
        this.lblmahd.setText("Tự động phát sinh");
        
        
    }//GEN-LAST:event_lblthemhdActionPerformed
    /**
     * In hóa đơn
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 7/11/2019
     */
    private void btninhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninhdActionPerformed
        try {
            Connection connection = Connect.getConnect();
            String reportFile = "E:/Phanmemxemay/baocaoexe/StyledTextReport.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);
            Map<String,Object> parameters = new HashMap<String,Object>();
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters,connection);
            File outDir = new File("E:/Phanmemxemay/baocaoexe");
            outDir.mkdirs();
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput= new SimpleExporterInput(print);
            exporter.setExporterInput(exporterInput);
            
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("E:/Phanmemxemay/baocaoexe/StyledTextReport.pdf");
            exporter.setExporterOutput(exporterOutput);
            
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } catch (Exception e) {
            
        }
        /*Connection conn=Connect.getConnect();
        String ma_hd=lblhoadon.getText();
        String ma_ctx=lblct.getText();
        int row=tblHoaDon.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Bạn Chưa Chọn Hóa Đơn Để Xuất","Lỗi",JOptionPane.ERROR_MESSAGE);
        }else{
            
            ob_xuat=hd_md.hoa_don_output(ma_hd,ma_ctx);
            List<Map<String, ?>> datax=new ArrayList<>();
            for (hoadon_entiti ob : ob_xuat) {
                Map<String,Object> row_x=new HashMap<String,Object>();
                row_x.put("Ma_HD",ob.getMa_hd());
                ob_kh = hd_md.getIDkhachhang(ob.getMa_kh());
                row_x.put("Ma_KH",ob_kh.get(0).getTen_kh());
                row_x.put("Dia_chi",ob_kh.get(0).getDia_chi());
                row_x.put("SDT",ob_kh.get(0).getSdt());
                ob_nv = hd_md.getIDnhanvien(ob.getMa_nv());
                row_x.put("Ma_NV",ob_nv.get(0).getTentk());
                ob_id_xe = hd_md.getIDxe(ob.getMa_xe());
                row_x.put("Ma_xe",ob_id_xe.get(0).getTen_xe());
                row_x.put("Don_gia",ob.getDon_gia());
                row_x.put("So_luong",ob.getSo_luong());
                row_x.put("Thanh_tien",ob.getThanh_tien());
                row_x.put("Tong_tien",ob.getTong_tien());
                datax.add(row_x);
            }
            JRDataSource jrsource=new JRBeanCollectionDataSource(datax);
            String sourceName="src\\Ireport\\xuat_hoa_don.jrxml";
            try {
                JasperReport rp=JasperCompileManager.compileReport(sourceName);
                JasperPrint filledReport=JasperFillManager.fillReport(rp, null,jrsource);
                JasperViewer jw=new JasperViewer(filledReport);
                jw.setVisible(true);
                
                hoadon_entiti hd_x=new hoadon_entiti();
                hd_md.xuat_xe(ma_hd);
                hd_md.xuat_xe_ctx(ma_ctx);
                hoa_don_DT();
                laymaCT_HD(ma_hd);
                nhap_lai_ctActionPerformed(evt);
                nhap_lai_dhActionPerformed(evt);
          
                
            } catch (JRException ex) {
                Logger.getLogger(Hoa_don.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }//GEN-LAST:event_btninhdActionPerformed
    /**
     * Lưu thông tin hóa đơn sau khi thêm hóa đơn
     * 
     * @author : Phan Duy Tuấn
     * 
     * Ngày 15/10/2019
     */
    private void btnluuhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuhdActionPerformed
        /*int sl = Integer.parseInt(this.txtsoluong.getText());
        double dg = Double.parseDouble(this.lbldongia.getText());
        double thanhtien = sl*dg;*/
        DecimalFormat df = new DecimalFormat("#,### VNĐ");
        String value = this.lblngaylap.getText();
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        long day = System.currentTimeMillis();     
        java.sql.Date ngay = new java.sql.Date(day);
        
        if (this.lblmahd.getText()=="Tự động phát sinh") {
            DanhsachHoaDon.ThemHoaDon(maHoaDon, maKhachHang, ngay , this.lblmanv.getText());
            
            DanhsachHoaDon.loadDuLieu1HoaDon(sql, tblHoaDon);       
            //DanhsachHoaDon.ThemChiTiet(this.lblct.getText(), "2", Integer.parseInt(this.txtsoluong.getText()), Double.parseDouble(this.txtdongia.getText()), thanhtien);
        } 
        
    }//GEN-LAST:event_btnluuhdActionPerformed
    /**
     * Hiển thị danh sách hóa đơn
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 7/10/2019
     */
    private void showDuLieu(){
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            Connection connection= Connect.getConnect();
            String query="SELECT ct.maHoaDon,x.tenXe,ct.soLuong,donGia,thanhTien=(ct.soLuong*donGia), ngayLap, h.maKhachHang, h.maNhanVien, tenKhachHang, soDienThoai "
                + "FROM dbo.[ChiTietHoaDon] ct join dbo.[XeMay] x on ct.maXe=x.maXe join dbo.[HoaDon] h on h.maHoaDon=ct.maHoaDon join dbo.[KhachHang] k on k.maKhachHang=h.maKhachHang order by h.maHoaDon asc";
        try {           
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {        
                    this.lblmahd.setText(rs.getString("maHoaDon"));                   
                    this.lblngaylap.setText(sdf.format(rs.getDate("ngayLap")));
                    //this.cmbmakh.addItem(rs.getString("maKhachHang"));
                    this.lblmanv.setText(rs.getString("maNhanVien"));     
                    this.cmbmakh.setSelectedItem(rs.getString("tenKhachHang"));
                    this.cmbsdt.setSelectedItem(rs.getString("soDienThoai"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        String query2 = "Select maXe,donGiaNhap= donGiaNhap + (donGiaNhap * 0.3) from dbo.[XeMay]";
        DecimalFormat df = new DecimalFormat("#,### VNĐ");
        try {           
            PreparedStatement ps = connection.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                                                 
                    this.lbldongia.setText(rs.getString("donGiaNhap"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        try {
               
                /*String sql1="Select h.maHoaDon, h.maKhachHang, ngayLap, maNhanVien, tongTien=sum(thanhTien) from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang join dbo.[ChiTietHoaDon] d"
                        + "on d.maHoaDon=h.maHoaDon where maHoaDon='"+IDrow+"'";*/
                String sql1= "select top 1 thanhTien=sum(thanhTien) from ChiTietHoaDon group by maHoaDon order by maHoaDon desc";
                PreparedStatement ps = connection.prepareStatement(sql1);
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    this.lbltongtien.setText(df.format(rs.getDouble("thanhTien")));
                    
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*String tt = "select top 1 h.maHoaDon, tongTien=SUM(thanhTien)\n" +
                    "from HoaDon h join ChiTietHoaDon c on h.maHoaDon=c.maHoaDon\n" +
                    "group by h.maHoaDon\n" +
                    "order by h.maHoaDon desc";
        try {           
            PreparedStatement ps = connection.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                                                 
                    this.lbltongtien.setText(rs.getString("tongTien"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }*/
    }
    /**
     * Hiển thị thông tin của một hóa đơn
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 11/10/2019
     */
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
                int row= this.tblHoaDon.getSelectedRow();
                Crt(true);
                cmbmakh.setEnabled(false);
                cmbsdt.setEnabled(false);
                btnluuhd.setEnabled(false);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String IDrow = (this.tblHoaDon.getModel().getValueAt(row, 1)).toString();
                /*String sql1="Select h.maHoaDon, h.maKhachHang, ngayLap, maNhanVien, tongTien=sum(thanhTien) from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang join dbo.[ChiTietHoaDon] d"
                        + "on d.maHoaDon=h.maHoaDon where maHoaDon='"+IDrow+"'";*/
                String sql1= "Select * from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang where maHoaDon='"+IDrow+"'";
                ResultSet rs = Dulieubang.ShowTextField(sql1);
                
                if(rs.next()){
                    maHoaDon= rs.getString("maHoaDon");
                    this.lblmahd.setText(rs.getString("maHoaDon"));
                    //this.lblmakh.setText(rs.getString("maKhachHang"));
                    this.cmbmakh.setSelectedItem(rs.getString("tenKhachHang"));
                    this.lblngaylap.setText(sdf.format(rs.getDate("ngayLap")));
                    this.lblmanv.setText(rs.getString("maNhanVien"));    
                    this.cmbsdt.setSelectedItem(rs.getString("soDienThoai"));
                    //DecimalFormat df = new DecimalFormat("#,###.00"); 
                }
                
                String sqlct= "SELECT ct.maHoaDon,tenXe,ct.soLuong,donGia,thanhTien=(ct.soLuong*donGia) "
                    + "FROM dbo.[ChiTietHoaDon] ct join dbo.[XeMay] x on ct.maXe=x.maXe join dbo.[HoaDon] h on"
                    + " h.maHoaDon=ct.maHoaDon where ct.maHoaDon='"+this.lblmahd.getText()+"'";                     
                    //double thanhtien = Double.parseDouble("Select thanhTien where dbo.[ChiTietHoaDon] where maHoaDon=?");
                    
                    DanhsachHoaDon.loadDuLieuChiTiet(sqlct, tblChiTietHoaDon, maHoaDon);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
                int row= this.tblHoaDon.getSelectedRow();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String IDrow = (this.tblHoaDon.getModel().getValueAt(row, 0)).toString();
                /*String sql1="Select h.maHoaDon, h.maKhachHang, ngayLap, maNhanVien, tongTien=sum(thanhTien) from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang join dbo.[ChiTietHoaDon] d"
                        + "on d.maHoaDon=h.maHoaDon where maHoaDon='"+IDrow+"'";*/
                String sql1= "select top 1 thanhTien=sum(thanhTien) from ChiTietHoaDon where maHoaDon='"+IDrow+"' order by maHoaDon desc";
                ResultSet rs = Dulieubang.ShowTextField(sql1);
                DecimalFormat df = new DecimalFormat("#,### VNĐ");
                while(rs.next()){
                    
                    this.lbltongtien.setText(df.format(rs.getDouble("thanhTien")));
                    
                }
                
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked
    /**
     * Hiển thị thông tin chi tiết hóa đơn
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 17/10/2019
     */
    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
        
        try {
            int row= this.tblChiTietHoaDon.getSelectedRow();
                Crt(false);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String IDrow = (this.tblChiTietHoaDon.getModel().getValueAt(row, 0)).toString();
                String sql2="Select maHoaDon, d.maXe, tenXe from dbo.[ChiTietHoaDon] d join dbo.[XeMay] x on d.maXe=x,maXe where d.maXe='"+IDrow+"'";
                ResultSet rs = Dulieubang.ShowTextField(sql2);
                if(rs.next()){
                    maXe= rs.getString("maHoaDon");
                    //this.lblct.setText(rs.getString("maHoaDon"));
                    this.cmbtenxe.setSelectedItem(rs.getString("maXe"));
                    this.txtsoluong.setText(rs.getString("soLuong"));
                    this.lbldongia.setText(rs.getString("donGia"));
                    this.lblthanhtien.setText(rs.getString("thanhTien"));
                }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked

    private void cmbtenxeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbtenxeKeyReleased
        
    }//GEN-LAST:event_cmbtenxeKeyReleased

    private void lblnhaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnhaccMouseClicked
        new GUINhaCungCap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblnhaccMouseClicked

    private void lblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnhanvienMouseClicked
        new GUINhanVien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblnhanvienMouseClicked

    private void lblkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhachhangMouseClicked
        new GUIKhachHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblkhachhangMouseClicked
    /**
     * Thêm chi tiết hóa đơn
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 19/10/2019
     */
    private void btnthemctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemctActionPerformed
        int sl = Integer.parseInt(this.txtsoluong.getText());
        double dg = Double.parseDouble(this.lbldongia.getText());
        double thanhtien = sl*dg;
        DecimalFormat df = new DecimalFormat("###,000 VNĐ");
        if(sl>0){
            DanhsachHoaDon.ThemChiTiet(maHoaDon, maXe ,Integer.parseInt(this.txtsoluong.getText()) ,
                Double.parseDouble(this.lbldongia.getText()) ,thanhtien);
            DanhsachHoaDon.loadDuLieuChiTiet(sql, tblChiTietHoaDon, maHoaDon);
            DanhsachHoaDon.loadDuLieu1HoaDon(sql, tblHoaDon);
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnthemctActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed
    /**
     * Nhập số lượng
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 19/10/2019
     */
    private void txtsoluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsoluongKeyReleased
        try {
            int sl = Integer.parseInt(this.txtsoluong.getText());
            double dg = Double.parseDouble(this.lbldongia.getText());
            double thanhtien = sl*dg;
            DecimalFormat df = new DecimalFormat("#,### VNĐ");
            if(this.txtsoluong.getText()==""){
                this.lblthanhtien.setText("");
            }
            else{
                if(sl>0){
                    this.lblthanhtien.setText(df.format(thanhtien));
                }
                else{
                    this.lblthanhtien.setText("Số lượng không hợp lệ");
                }
            }
            
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_txtsoluongKeyReleased
    /**
     * Tìm số điện thoại dựa vào combobox
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 19/10/2019
     */
    private void cmbsdtPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbsdtPopupMenuWillBecomeInvisible
        Connection connection = Connect.getConnect();
        String sqlma = "Select * from dbo.[KhachHang] where soDienThoai=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlma);
            ps.setString(1, this.cmbsdt.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                //this.lblmakh.setText(rs.getString("maKhachHang"));
                this.cmbmakh.setSelectedItem(rs.getString("tenKhachHang"));
                maKhachHang=rs.getString("maKhachHang");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_cmbsdtPopupMenuWillBecomeInvisible
    /**
     * Tìm tên khách hàng dựa vào combobox
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 19/10/2019
     */
    private void cmbmakhPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbmakhPopupMenuWillBecomeInvisible
        Connection connection = Connect.getConnect();
        String sqlma = "Select * from dbo.[KhachHang] where tenKhachHang=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlma);
            ps.setString(1, this.cmbmakh.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                //this.lblmakh.setText(rs.getString("maKhachHang"));
                this.cmbsdt.setSelectedItem(rs.getString("soDienThoai"));
                maKhachHang= rs.getString("maKhachHang");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmbmakhPopupMenuWillBecomeInvisible

    private void cmbmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmakhActionPerformed
    /**
     * Tính tổng tiền
     * 
     * Giá trị vào: số lượng, đơn giá
     * Giá trị ra: tổng tiền
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 22/10/2019
     */
    private void lbltongtienComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lbltongtienComponentShown
        try {
                int row= this.tblHoaDon.getSelectedRow();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String IDrow = (this.tblHoaDon.getModel().getValueAt(row, 0)).toString();
                /*String sql1="Select h.maHoaDon, h.maKhachHang, ngayLap, maNhanVien, tongTien=sum(thanhTien) from dbo.[HoaDon] h join dbo.[KhachHang] k on h.maKhachHang=k.maKhachHang join dbo.[ChiTietHoaDon] d"
                        + "on d.maHoaDon=h.maHoaDon where maHoaDon='"+IDrow+"'";*/
                String sql1= "Select thanhTien=sum(thanhTien) from dbo.[HoaDon] h join dbo.[ChiTietHoaDon] d on h.maHoaDon=d.maHoaDon where d.maHoaDon='"+IDrow+"'";
                ResultSet rs = Dulieubang.ShowTextField(sql1);
                
                while(rs.next()){
                    maHoaDon= rs.getString("maHoaDon");
                    this.lbltongtien.setText(rs.getString("thanhTien"));
                    
                }
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_lbltongtienComponentShown
    /**
     * Tìm tên khách hàng dựa vào combobox
     * 
     * @author: Phan Duy Tuấn
     * 
     * Ngày 21/10/2019
     */
    private void cmbtenxePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbtenxePopupMenuWillBecomeInvisible
        Connection connection = Connect.getConnect();
        String sqlma = "Select maXe, donGiaNhap=donGiaNhap + (donGiaNhap*0.3) from dbo.[XeMay] where tenXe=?";
        try {
            DecimalFormat df= new DecimalFormat("###,000 VNĐ");
            PreparedStatement ps = connection.prepareStatement(sqlma);
            ps.setString(1, this.cmbtenxe.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                //this.lblmaxe.setText(rs.getString("maXe"));
                this.lbldongia.setText(rs.getString("donGiaNhap"));
                maXe= rs.getString("maXe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmbtenxePopupMenuWillBecomeInvisible

    private void lbldangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangxuatMouseClicked
        new JFrameGiaodien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbldangxuatMouseClicked

    private void lblthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthongkeMouseClicked
        new GUIThongke().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblthongkeMouseClicked

    private void lblthongtinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthongtinMouseClicked
        new GUIThongtin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblthongtinMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninhd;
    private javax.swing.JButton btnluuhd;
    private javax.swing.JButton btnthemct;
    private javax.swing.JPanel btnthemhd;
    private com.toedter.calendar.JDateChooser calender_ngaylap;
    private javax.swing.JComboBox<String> cmbmakh;
    private javax.swing.JComboBox<String> cmbsdt;
    private javax.swing.JComboBox<String> cmbtenxe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel lbldangxuat;
    private javax.swing.JLabel lbldongia;
    private javax.swing.JLabel lblhoadon;
    private javax.swing.JLabel lblkhachhang;
    private javax.swing.JLabel lblmahd;
    private javax.swing.JLabel lblmanv;
    private javax.swing.JLabel lblngaylap;
    private javax.swing.JLabel lblnhacc;
    private javax.swing.JLabel lblnhanvien;
    private javax.swing.JLabel lblthanhtien;
    private javax.swing.JButton lblthemhd;
    private javax.swing.JLabel lblthoat;
    private javax.swing.JLabel lblthongke;
    private javax.swing.JLabel lblthongtin;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JLabel lblxe;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
