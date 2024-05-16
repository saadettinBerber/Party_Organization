/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package party;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author homek
 */
public class UserInterface extends javax.swing.JFrame {
        DefaultTableModel model;
        DefaultTableModel UrunlerModel;
        DefaultTableModel sepetModel;
        DefaultTableModel gecmisorgModel;
        DefaultTableModel gecmisSiparislerModel;
        DefaultTableModel siparisDetayModel;
        
        
    CallableStatement callableStatement;    
    Connection con;
    PreparedStatement preparedStatement = null;
    
    String orgName;
    String personcount;
    String season;
    String location;
    String timeofday;
    int userID;
    int sepetID;
    Double totalCost;
    
    String Urunname;
    String Urunmiktari;
    
    public UserInterface(int ID) {
        
         initComponents();
       
        this.userID = ID;//duzelecek
        model = (DefaultTableModel)Sirkettable.getModel();
        UrunlerModel = (DefaultTableModel)UrunlerTable.getModel();
        sepetModel = (DefaultTableModel)Sepettable.getModel();
        gecmisorgModel = (DefaultTableModel)gecmisorgTable.getModel();
        gecmisorgModel.setRowCount(0);
        gecmisSiparislerModel =(DefaultTableModel)gecmisSiparislerTable.getModel();
        siparisDetayModel = (DefaultTableModel)siparisDetaylariTable.getModel();
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Party", "postgres", "123456");
            
           String sorgu = "select* from sepet s where s.userid = ? and s.status = 0";
               preparedStatement = con.prepareStatement(sorgu);
               preparedStatement.setInt(1, userID);
                
                
                ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                 sepetID = rs.getInt("sepetid");
                 totalCost = rs.getDouble("sepettotalcost");
                
            }
            System.out.println("Baglanti basarili");
            
        }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
      sepetiGoruntule();
      gecmisOrganizasyonlariGoruntule();
      gecmisSiparisleriGoruntule();
        System.out.println(userID);
        System.out.println(sepetID);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        orgTypeNamebox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        personCount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Locationbox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        Seasonbox = new javax.swing.JComboBox<>();
        Filtrele = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Sirkettable = new javax.swing.JTable();
        Siparisverbutton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        timeOfDaybox = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        UrunNametf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        UrunAdettf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        UrunlerTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Sepettable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        UrunListelebutton = new javax.swing.JButton();
        Sepeteeklebutton = new javax.swing.JButton();
        urunSatınAlbutton = new javax.swing.JButton();
        sepettensilbutton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comIDSepetimTextArea = new javax.swing.JLabel();
        productNameSepetTextArea = new javax.swing.JLabel();
        quantityjtextfield = new javax.swing.JTextField();
        urunguncellebutton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gecmisorgTable = new javax.swing.JTable();
        orgListeleComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        orgListelebutton = new javax.swing.JButton();
        orgToplamMaliyet = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        orgOrtMaliyet = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        orgToplamKişi = new javax.swing.JLabel();
        orgOrtKişi = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        gecmisSiparislerTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        siparisDetaylariTable = new javax.swing.JTable();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Organizasyon Tipi");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Engagement", "Wedding", "Birthday" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Kişi Sayısı");

        jTextField1.setText(".......");

        jLabel3.setText("Lokasyon");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Istanbul", "Izmir", "Ankara", "Sakarya", "Batman", "Balıkesir", "Kocaeli", " ", " " }));

        jLabel4.setText("Mevsim");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Summer", "Winter", "Spring", "Autumn" }));

        jButton1.setText("Filtrele");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Offer Count", "Location", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Sipariş Ver");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Organizasyon", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ürün", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setAutoscrolls(true);
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jLabel9.setText("Organizasyon Tipi");

        orgTypeNamebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Engagement", "Wedding", "Birthday" }));
        orgTypeNamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgTypeNameboxActionPerformed(evt);
            }
        });

        jLabel10.setText("Kişi Sayısı");

        jLabel11.setText("Lokasyon");

        Locationbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Istanbul", "Izmir", "Ankara", "Sakarya", "Batman", "Balıkesir", "Kocaeli", " ", " " }));

        jLabel12.setText("Mevsim");

        Seasonbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Summer", "Winter", "Spring", "Autumn" }));

        Filtrele.setText("Filtrele");
        Filtrele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltreleActionPerformed(evt);
            }
        });

        Sirkettable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ComID", "Name", "Type", "Price", "Offer Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Sirkettable);
        if (Sirkettable.getColumnModel().getColumnCount() > 0) {
            Sirkettable.getColumnModel().getColumn(0).setResizable(false);
            Sirkettable.getColumnModel().getColumn(1).setResizable(false);
            Sirkettable.getColumnModel().getColumn(2).setResizable(false);
            Sirkettable.getColumnModel().getColumn(3).setResizable(false);
            Sirkettable.getColumnModel().getColumn(4).setResizable(false);
        }

        Siparisverbutton.setText("Sipariş Ver");
        Siparisverbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiparisverbuttonActionPerformed(evt);
            }
        });

        jLabel5.setText("Gün Dilimi");

        timeOfDaybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Morning", "Afternoon", "Evening" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(orgTypeNamebox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(personCount)
                            .addComponent(Seasonbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(Filtrele)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Locationbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Siparisverbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(timeOfDaybox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(orgTypeNamebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(timeOfDaybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(personCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(Locationbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Seasonbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filtrele)
                    .addComponent(Siparisverbutton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Organizasyon", jPanel5);

        jLabel6.setText("Ürün İsmi :");

        UrunNametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UrunNametfActionPerformed(evt);
            }
        });

        jLabel7.setText("Ürün adeti:");

        UrunAdettf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UrunAdettfActionPerformed(evt);
            }
        });

        UrunlerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ComID", "ProductName", "Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(UrunlerTable);
        if (UrunlerTable.getColumnModel().getColumnCount() > 0) {
            UrunlerTable.getColumnModel().getColumn(0).setResizable(false);
            UrunlerTable.getColumnModel().getColumn(1).setResizable(false);
            UrunlerTable.getColumnModel().getColumn(2).setResizable(false);
            UrunlerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        Sepettable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SepetID", "ComID", "Product Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sepettable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SepettableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Sepettable);
        if (Sepettable.getColumnModel().getColumnCount() > 0) {
            Sepettable.getColumnModel().getColumn(0).setResizable(false);
            Sepettable.getColumnModel().getColumn(1).setResizable(false);
            Sepettable.getColumnModel().getColumn(2).setResizable(false);
            Sepettable.getColumnModel().getColumn(3).setResizable(false);
            Sepettable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel8.setText("Ürünler");

        jLabel13.setText("Sepetim");

        UrunListelebutton.setText("Ürünleri Listele");
        UrunListelebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UrunListelebuttonActionPerformed(evt);
            }
        });

        Sepeteeklebutton.setText("Sepete Ekle");
        Sepeteeklebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SepeteeklebuttonActionPerformed(evt);
            }
        });

        urunSatınAlbutton.setText("Sipariş Ver");
        urunSatınAlbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunSatınAlbuttonActionPerformed(evt);
            }
        });

        sepettensilbutton.setText("Sepetten sil");
        sepettensilbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepettensilbuttonActionPerformed(evt);
            }
        });

        jLabel14.setText("comID:");

        jLabel15.setText("Product Name:");

        jLabel16.setText("Quantity:");

        comIDSepetimTextArea.setText("....");

        productNameSepetTextArea.setText("...");

        quantityjtextfield.setText("...");

        urunguncellebutton.setText("Miktarı Güncelle");
        urunguncellebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunguncellebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UrunListelebutton)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UrunNametf, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UrunAdettf, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(urunSatınAlbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sepettensilbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sepeteeklebutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(urunguncellebutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comIDSepetimTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productNameSepetTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityjtextfield))))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(comIDSepetimTextArea)
                            .addComponent(urunguncellebutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sepeteeklebutton)
                            .addComponent(jLabel15)
                            .addComponent(productNameSepetTextArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sepettensilbutton)
                            .addComponent(jLabel16)
                            .addComponent(quantityjtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urunSatınAlbutton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UrunNametf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(UrunAdettf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(UrunListelebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        jTabbedPane2.addTab("Ürün", jPanel6);

        gecmisorgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event", "Company Name", "Season", "Timeofday", "Person Count", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(gecmisorgTable);
        if (gecmisorgTable.getColumnModel().getColumnCount() > 0) {
            gecmisorgTable.getColumnModel().getColumn(0).setResizable(false);
            gecmisorgTable.getColumnModel().getColumn(1).setResizable(false);
            gecmisorgTable.getColumnModel().getColumn(2).setResizable(false);
            gecmisorgTable.getColumnModel().getColumn(3).setResizable(false);
            gecmisorgTable.getColumnModel().getColumn(4).setResizable(false);
            gecmisorgTable.getColumnModel().getColumn(5).setResizable(false);
        }

        orgListeleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wedding", "Engagement", "Birthday" }));

        jLabel17.setText("Toplam Maliyet ");

        orgListelebutton.setText("Listele");
        orgListelebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgListelebuttonActionPerformed(evt);
            }
        });

        orgToplamMaliyet.setText("...");

        jLabel19.setText("Ortalama Maliyeti");

        orgOrtMaliyet.setText("...");

        jLabel21.setText("Toplam Kişi Sayısı");

        jLabel22.setText("Ortalama Kişi Sayısı");

        orgToplamKişi.setText("...");

        orgOrtKişi.setText("...");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orgListeleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orgListelebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orgToplamMaliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orgToplamKişi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orgOrtKişi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(orgOrtMaliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(orgListeleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orgListelebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orgToplamKişi))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orgToplamMaliyet)
                            .addComponent(orgOrtMaliyet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orgOrtKişi)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Geçmiş Organizasyonlarım", jPanel7);

        gecmisSiparislerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SepetID", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gecmisSiparislerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gecmisSiparislerTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(gecmisSiparislerTable);

        siparisDetaylariTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sepet ID", "Product Name", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(siparisDetaylariTable);
        if (siparisDetaylariTable.getColumnModel().getColumnCount() > 0) {
            siparisDetaylariTable.getColumnModel().getColumn(0).setResizable(false);
            siparisDetaylariTable.getColumnModel().getColumn(1).setResizable(false);
            siparisDetaylariTable.getColumnModel().getColumn(2).setResizable(false);
            siparisDetaylariTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Geçmiş Siparişlerim", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // gecmisOrganizasyonlariGoruntule();
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void gecmisSiparislerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gecmisSiparislerTableMouseClicked
        siparisDetayModel.setRowCount(0);
        int selectedRow = gecmisSiparislerTable.getSelectedRow();
        int sepID =Integer.valueOf(gecmisSiparislerTable.getValueAt(selectedRow,0).toString());
        sepetDetayGoruntule(sepID);

    }//GEN-LAST:event_gecmisSiparislerTableMouseClicked

    private void orgListelebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgListelebuttonActionPerformed
        orgToplamKişi.setText(" ");
        orgToplamMaliyet.setText(" ");
        orgOrtKişi.setText(" ");
        orgOrtMaliyet.setText(" ");

        String serviceType = orgListeleComboBox.getItemAt(orgListeleComboBox.getSelectedIndex());
        String sorgu ="Select servicetype, count(*) , sum(totalPriceEtkinlik) as tmaliyet, avg(totalPriceEtkinlik) as ortmaliyet,\n" +
        "sum(totalperson) as tkisi, avg(totalperson) as ortkisi\n" +
        "From (Select servicetype, totalperson, totalperson * priceperperson as totalPriceEtkinlik \n" +
        "	 From sirket s, etkinlik e, pricing pr\n" +
        "	 where s.companyid = e.comid and pr.comid = e.comid and ? = userid)\n" +
        "	 \n" +
        "Group by servicetype\n" +
        "having servicetype = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,userID);
            preparedStatement.setString(2,serviceType);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                orgToplamKişi.setText(rs.getString("tkisi"));
                orgToplamMaliyet.setText(String.valueOf(rs.getInt("tmaliyet")));
                orgOrtKişi.setText(String.valueOf(rs.getInt("ortkisi")));
                orgOrtMaliyet.setText(String.valueOf(rs.getInt("ortmaliyet")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_orgListelebuttonActionPerformed

    private void urunguncellebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunguncellebuttonActionPerformed
        int selectedRow = Sepettable.getSelectedRow();
        if(selectedRow ==-1){
            if(UrunlerTable.getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Sepetiniz Boş!");
            }
            else
            JOptionPane.showMessageDialog(null,"Sepetten ürün seçmediniz!");
            return;
        }

        String sorgu ="Update sepeticindekiler set adet = ? where comid = ? and productname = ? and sepid = ?;";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,Integer.valueOf(quantityjtextfield.getText()));
            preparedStatement.setInt(2,Integer.valueOf(Sepettable.getValueAt(selectedRow,1).toString()));
            preparedStatement.setString(3,Sepettable.getValueAt(selectedRow,2).toString());
            preparedStatement.setInt(4,sepetID);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Ürün miktarı güncellendi");

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        sepetiGoruntule();
    }//GEN-LAST:event_urunguncellebuttonActionPerformed

    private void sepettensilbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepettensilbuttonActionPerformed
        int selectedRow = Sepettable.getSelectedRow();
        if(selectedRow ==-1){
            if(UrunlerTable.getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Sepetiniz Boş!");
            }
            else
            JOptionPane.showMessageDialog(null,"Sepetten ürün seçmediniz!");
            return;
        }
        String sorgu ="Delete From sepeticindekiler where comid = ? and productname = ? and sepid = ?;";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,Integer.valueOf(Sepettable.getValueAt(selectedRow,1).toString()));
            preparedStatement.setString(2,Sepettable.getValueAt(selectedRow,2).toString());
            preparedStatement.setInt(3,sepetID);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Ürün sepetten silindi");

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        sepetiGoruntule();

    }//GEN-LAST:event_sepettensilbuttonActionPerformed

    private void urunSatınAlbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunSatınAlbuttonActionPerformed

        if(Sepettable.getRowCount() == 0){
            JOptionPane.showMessageDialog(null,"Sepetiniz Boş!");
            return;
        }

        String sorgu ="Update sepet set status = 1 where userid = ? and sepetid = ?;";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,userID);
            preparedStatement.setInt(2,sepetID);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Siparişiniz alındı");

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            sorgu = "select* from sepet s where s.userid = ? and s.status = 0";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, userID);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                sepetID = rs.getInt("sepetid");

            }
            System.out.println("Baglanti basarili");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        sepetiGoruntule();
        gecmisSiparisleriGoruntule();

    }//GEN-LAST:event_urunSatınAlbuttonActionPerformed

    private void SepeteeklebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SepeteeklebuttonActionPerformed
        int selectedRow = UrunlerTable.getSelectedRow();
        if(selectedRow ==-1){
            if(UrunlerTable.getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Listelenen ürün yok!");
            }
            else
            JOptionPane.showMessageDialog(null,"Listeden ürün seçmediniz!");
            return;
        }

        String sorgu ="Insert Into sepeticindekiler (sepid, comid, productname, adet, productprice) values (?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,sepetID);
            preparedStatement.setInt(2,Integer.valueOf(UrunlerTable.getValueAt(selectedRow,0).toString()));
            preparedStatement.setString(3,UrunlerTable.getValueAt(selectedRow,1).toString());
            preparedStatement.setInt(4,Integer.valueOf(UrunAdettf.getText()));
            preparedStatement.setFloat(5,Float.valueOf(UrunlerTable.getValueAt(selectedRow,2).toString()));
            
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Ürün sepete eklendi");

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        sepetiGoruntule();

    }//GEN-LAST:event_SepeteeklebuttonActionPerformed

    private void UrunListelebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UrunListelebuttonActionPerformed

        String sorgu;

        Urunname = UrunNametf.getText();
        Urunmiktari = UrunAdettf.getText();

        if(Urunname == ""){
            JOptionPane.showMessageDialog(null,"Ürün ismi girmediniz!");
            return;
        }
        if(Urunmiktari == ""){
            JOptionPane.showMessageDialog(null,"Ürün miktarını girmediniz!");
            return;
        }

        try {
            UrunlerModel.setRowCount(0);

            sorgu = "SELECT * FROM unnest(list_urun(?,?))";
            callableStatement = con.prepareCall(sorgu);
            callableStatement.setString(1, Urunname);
            callableStatement.setInt(2, Integer.valueOf(Urunmiktari));
            ResultSet rs = callableStatement.executeQuery();

            while(rs.next()){
                Object[] ekle = {rs.getInt("comID") ,rs.getString("pro_name") ,rs.getDouble("productprice"), rs.getInt("stockQuantity")};
                UrunlerModel.addRow(ekle);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_UrunListelebuttonActionPerformed

    private void SepettableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SepettableMouseClicked
        int selectedRow = Sepettable.getSelectedRow();
        comIDSepetimTextArea.setText(Sepettable.getValueAt(selectedRow,1).toString());
        productNameSepetTextArea.setText(Sepettable.getValueAt(selectedRow,2).toString());
        quantityjtextfield.setText(Sepettable.getValueAt(selectedRow,3).toString());
    }//GEN-LAST:event_SepettableMouseClicked

    private void UrunAdettfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UrunAdettfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UrunAdettfActionPerformed

    private void UrunNametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UrunNametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UrunNametfActionPerformed

    private void SiparisverbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiparisverbuttonActionPerformed
        int selectedRow = Sirkettable.getSelectedRow();
        if (selectedRow == -1){
            if(Sirkettable.getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Listelenen organizasyon yok!");
            }
            else
            JOptionPane.showMessageDialog(null,"Listeden organizasyon seçmediniz!");
        }
        String comId = Sirkettable.getValueAt(selectedRow,0).toString();
        String perPersonPrice = Sirkettable.getValueAt(selectedRow, 3).toString();
        double totalprice = Double.valueOf(perPersonPrice)*Double.valueOf(personcount);

        String sorgu ="Insert Into etkinlik (comid,userid,season,timeofday,totalperson) values (?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setInt(1,Integer.valueOf(comId));
            preparedStatement.setInt(2, userID);
            preparedStatement.setString(3,season);
            preparedStatement.setString(4,timeofday);
            preparedStatement.setInt(5,Integer.valueOf(personcount));

            preparedStatement.executeUpdate();
            model.setRowCount(0);
            JOptionPane.showMessageDialog(null,"Etkinlik siparişiniz alındı!");

        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        gecmisOrganizasyonlariGoruntule();
    }//GEN-LAST:event_SiparisverbuttonActionPerformed

    private void FiltreleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltreleActionPerformed
        String sorgu;
        orgName = orgTypeNamebox.getItemAt(orgTypeNamebox.getSelectedIndex());
        personcount = this.personCount.getText();
        season = Seasonbox.getItemAt(Seasonbox.getSelectedIndex());
        location = Locationbox.getItemAt(Locationbox.getSelectedIndex());
        timeofday = timeOfDaybox.getItemAt(timeOfDaybox.getSelectedIndex());
        if(orgName == "Seçiniz..."){
            JOptionPane.showMessageDialog(null,"Organizasyon seçmediniz!");
            return;
        }
        if(personcount == null ){
            JOptionPane.showMessageDialog(null,"Kişi sayısı girmediniz!");
            return;
        }
        if(season == "Seçiniz..."){
            JOptionPane.showMessageDialog(null,"Sezon seçmediniz!");
            return;
        }
        if(timeofday == "Seçiniz..."){
            JOptionPane.showMessageDialog(null,"Gün dilimi seçmediniz!");
            return;
        }

        try {
            model.setRowCount(0);
            if(location != "Seçiniz..."){
                sorgu = "SELECT * FROM unnest(list_sirket(?,?,?,?,?))";
                callableStatement = con.prepareCall(sorgu);
                callableStatement.setString(1, orgName);
                callableStatement.setInt(2, Integer.valueOf(personcount));
                callableStatement.setString(3, season);
                callableStatement.setString(4, timeofday);
                callableStatement.setString(5, location);
                ResultSet rs = callableStatement.executeQuery();

                while(rs.next()){

                    Object[] ekle = {rs.getInt("comid") ,rs.getString("comname") ,orgName, rs.getInt("priceperperson"), rs.getInt("offercount")};
                    model.addRow(ekle);
                }
            }
            else{
                sorgu = "select companyid, companyname, priceperperson, offercount from sirket s, pricing p\n" +
                "						   where s.companyid = comid and ? = s.servicetype and ? = p.season\n" +
                "						   and ? between s.minimumguest and s.maximumguest";
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setString(1, orgName);
                preparedStatement.setInt(3, Integer.valueOf(personcount));
                preparedStatement.setString(2, season);

                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){
                    Object[] ekle = {rs.getInt("companyid"),rs.getString("companyname"), orgName,rs.getInt("priceperperson"), rs.getInt("offercount")};
                    model.addRow(ekle);
                }
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_FiltreleActionPerformed

    private void orgTypeNameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgTypeNameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgTypeNameboxActionPerformed

    void sepetiGoruntule(){
        gecmisSiparislerModel.setRowCount(0);
        String sorgu ="Select * from user_uruns";
            try {
                sepetModel.setRowCount(0);
                Statement statement = con.createStatement();
                
                ResultSet rs = statement.executeQuery(sorgu);
                
                while(rs.next()){
                    if(rs.getInt("sepid") == sepetID){
                        Object[] ekle = {sepetID,rs.getInt("comid"),rs.getString("productname"),rs.getInt("adet"),rs.getInt("cost")};
                sepetModel.addRow(ekle);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    void gecmisOrganizasyonlariGoruntule(){
        gecmisorgModel.setRowCount(0);
        String sorgu1 ="Select servicetype,companyname,season,timeofday,totalperson,e.comid from sirket s,etkinlik e,kullanici k where"
                + " s.companyid = e.comid  and k.userid = e.userid and e.userid = ?";
        String sorgu2 = "Select * from totalPriceEvent(?,?,?,?)";
            try {
                
                preparedStatement = con.prepareStatement(sorgu1);
                preparedStatement.setInt(1, userID);
                
                ResultSet rs = preparedStatement.executeQuery();
                
                
                
                while(rs.next()){
                callableStatement = con.prepareCall(sorgu2);
                callableStatement.setInt(1, rs.getInt("comid"));
                callableStatement.setString(2,rs.getString("season"));
                callableStatement.setString(3,rs.getString("timeofday"));
                callableStatement.setInt(4, rs.getInt("totalperson"));
                ResultSet rs2 = callableStatement.executeQuery();
                if(rs2.next()){
                    Object[] ekle = {rs.getString("servicetype"),rs.getString("companyname"),rs.getString("season"),rs.getString("timeofday"),rs.getString("totalperson"),rs2.getFloat(1)};
                    gecmisorgModel.addRow(ekle);
                }
                
                
                    
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    void gecmisSiparisleriGoruntule(){
        
        String sorgu ="select sepetid,sepettotalcost from sepet where userid = ? and status = 1";
        
            try {
                
               preparedStatement = con.prepareStatement(sorgu);
               preparedStatement.setInt(1, userID);
               
               ResultSet rs = preparedStatement.executeQuery();
                
                
                while(rs.next()){
                Object[] ekle = {rs.getInt("sepetid"),rs.getFloat("sepettotalcost")};
                    gecmisSiparislerModel.addRow(ekle);
   
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    void sepetDetayGoruntule(int sepetID){
        String sorgu ="Select * from user_uruns";
            try {
                siparisDetayModel.setRowCount(0);
                Statement statement = con.createStatement();
                
                ResultSet rs = statement.executeQuery(sorgu);
                
                while(rs.next()){
                    if(rs.getInt("sepid") == sepetID){
                        Object[] ekle = {sepetID,rs.getString("productname"),rs.getInt("adet"),rs.getInt("cost")};
                siparisDetayModel.addRow(ekle);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        int userid = new Kullanicigirisi().getUserID();
        System.out.println(userid);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface(userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filtrele;
    private javax.swing.JComboBox<String> Locationbox;
    private javax.swing.JComboBox<String> Seasonbox;
    private javax.swing.JButton Sepeteeklebutton;
    private javax.swing.JTable Sepettable;
    private javax.swing.JButton Siparisverbutton;
    private javax.swing.JTable Sirkettable;
    private javax.swing.JTextField UrunAdettf;
    private javax.swing.JButton UrunListelebutton;
    private javax.swing.JTextField UrunNametf;
    private javax.swing.JTable UrunlerTable;
    private javax.swing.JLabel comIDSepetimTextArea;
    private javax.swing.JTable gecmisSiparislerTable;
    private javax.swing.JTable gecmisorgTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> orgListeleComboBox;
    private javax.swing.JButton orgListelebutton;
    private javax.swing.JLabel orgOrtKişi;
    private javax.swing.JLabel orgOrtMaliyet;
    private javax.swing.JLabel orgToplamKişi;
    private javax.swing.JLabel orgToplamMaliyet;
    private javax.swing.JComboBox<String> orgTypeNamebox;
    private javax.swing.JTextField personCount;
    private javax.swing.JLabel productNameSepetTextArea;
    private javax.swing.JTextField quantityjtextfield;
    private javax.swing.JButton sepettensilbutton;
    private javax.swing.JTable siparisDetaylariTable;
    private javax.swing.JComboBox<String> timeOfDaybox;
    private javax.swing.JButton urunSatınAlbutton;
    private javax.swing.JButton urunguncellebutton;
    // End of variables declaration//GEN-END:variables
}
