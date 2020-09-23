/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasewsl;


import databasemti.*;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class Keluarwsl extends javax.swing.JFrame {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    /**
     * Creates new form usermti
     */
    public Keluarwsl() {
        initComponents();
        showTableSatuan();
        combobox1 ();
        combobox2 ();
        combobox3 ();
    }
    
    Keluarexport Keluarexport = new Keluarexport();
    NotifLaporanKwsl NotifLaporanKwsl = new NotifLaporanKwsl();
    
    private void clearInputFields(){
        kode.setText("");
        nama.setText("");
        jumlah.setText("");
        blok.setText("");
    }

    public void showTableSatuan(){
        try{
            String sql = "SELECT * FROM `brgkeluar_wsl`";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelsatuan.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }}
    
    private void combobox1 (){
        try{
            String sql = "SELECT * FROM satuan_wsl";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("keterangan");
                satuan.addItem(nama);
            }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
        
    } 

    private void combobox2 (){
        try{
            String sql = "SELECT * FROM kategori_wsl";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("nama");
                kategori.addItem(nama);
            }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    }
    
        private void combobox3 (){
        try{
            String sql = "SELECT * FROM estate_wsl";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("nama");
                estate.addItem(nama);
            }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    }
    
    public ArrayList<Arraykeluar> keluarlist(){
        ArrayList<Arraykeluar> keluarlist = new ArrayList<Arraykeluar>();
        String selectAllQuery ="SELECT * FROM brgkeluar_wsl";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(selectAllQuery);
            
            
            while(rs.next()){
                Arraykeluar arraykeluar = new Arraykeluar();
                arraykeluar.setnomor(rs.getString("tanggal"));
                arraykeluar.setkode(rs.getString("kode"));
                arraykeluar.setnama(rs.getString("nama"));
                arraykeluar.setsatuan(rs.getString("satuan"));
                arraykeluar.setkategori(rs.getString("kategori"));
                arraykeluar.setdepartemen(rs.getString("departemen"));
                arraykeluar.setblok(rs.getString("blok"));
                arraykeluar.setestate(rs.getString("estate"));
                arraykeluar.setjumlah(rs.getString("jumlah"));
                arraykeluar.setharga(rs.getString("harga"));
                keluarlist.add(arraykeluar);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                
                
        return keluarlist;
    }
    
    public void populatetabelsatuan(){
        DefaultTableModel model;
        ArrayList<Arraykeluar> dataArray = keluarlist();
        model = (DefaultTableModel) tabelsatuan.getModel();
        model.setRowCount(0);
        
        Object[] rows = new Object[10];
        for (int i = 0; i<dataArray.size();i++){
            rows[0] = dataArray.get(i).getnomor();
            rows[1] = dataArray.get(i).getkode();
            rows[2] = dataArray.get(i).getnama();
            rows[3] = dataArray.get(i).getsatuan();
            rows[4] = dataArray.get(i).getkategori();
            rows[5] = dataArray.get(i).getdepartemen();
            rows[6] = dataArray.get(i).getblok();
            rows[7] = dataArray.get(i).getestate();
            rows[8] = dataArray.get(i).getjumlah();
            rows[9] = dataArray.get(i).getharga();
          
            model.addRow(rows);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelsatuan = new javax.swing.JTable();
        nomor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        export = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        satuan = new javax.swing.JComboBox<>();
        kategori = new javax.swing.JComboBox<>();
        estate = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        departemen = new javax.swing.JComboBox<>();
        blok = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabel Barang Keluar WSL");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo wsl.JPG")).getImage()
        );

        tabelsatuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "Kode", "Nama", "Satuan", "Kategori", "Departemen", "Blok", "Estate", "Jumlah", "Harga"
            }
        ));
        tabelsatuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsatuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelsatuan);

        jLabel1.setText("Nomor");

        jLabel2.setText("Kode");

        jLabel3.setText("Nama");

        jLabel4.setText("Satuan");

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Search");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel6.setText("Kategori");

        jLabel8.setText("Departemen");

        jLabel9.setText("Blok");

        jLabel10.setText("Estate");

        jLabel11.setText("Jumlah");

        departemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Harga");

        jMenu1.setText("Menu");

        jMenu2.setText("Main menu");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu2);

        jMenu14.setText("Print Report");
        jMenu14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu14MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu14);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Tabel");

        jMenu4.setText("Tabel User");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu4);

        jMenu5.setText("Tabel Satuan");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu5);

        jMenu6.setText("Tabel Kategori");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu6);

        jMenu7.setText("Tabel Barang");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu7);

        jMenu8.setText("Tabel Suplier");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu8);

        jMenu9.setText("Tabel Compartement");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu9);

        jMenu10.setText("Barang Masuk");
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu10);

        jMenu11.setText("Barang Keluar");
        jMenu11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu11MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu11);

        jMenu12.setText("Detail");
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu12);

        jMenu15.setText("Tabel  PO");
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu15);

        jMenu16.setText("Tabel Estate");
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu16);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(export)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(estate, 0, 458, Short.MAX_VALUE)
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kode, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(satuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departemen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(estate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(export)
                    .addComponent(delete))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM `brgkeluar_wsl` WHERE `kode` = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, kode.getText());
            pst.executeUpdate();
            clearInputFields();
            JOptionPane.showMessageDialog(null, "Deleted");
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         //showTableSatuan();
         populatetabelsatuan();
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        /*String s = nomor.getText();
        int angka = Integer.valueOf(s);
        s = Integer.toString(++angka);
        nomor.setText(s);*/
        try{
            String sql = "INSERT INTO `brgkeluar_wsl`(`tanggal`, `kode`, `nama`, `satuan`, `kategori`, `departemen`, `blok`, `estate`, `jumlah`, `harga`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, nomor.getText());
            pst.setString(2, kode.getText());
            pst.setString(3, nama.getText());
            pst.setString(4, (String) satuan.getSelectedItem());
            pst.setString(5, (String) kategori.getSelectedItem());
            pst.setString(6, (String) departemen.getSelectedItem());
            pst.setString(7, blok.getText());
            pst.setString(8, (String) estate.getSelectedItem());
            pst.setString(9, jumlah.getText());
            pst.setString(10, harga.getText());
            pst.executeUpdate();
            clearInputFields();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kode sudah terdaftar, silahkan masukkan kode baru");
        }
        populatetabelsatuan();
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE `brgkeluar_wsl` SET `tanggal`= ?, `nama`= ?, `satuan`= ?, `kategori`= ?, `departemen`= ?, `blok`= ?, `estate`= ?, `jumlah`= ?, `harga`=? WHERE `kode` = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasewsl?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(10, kode.getText());
            pst.setString(1, nomor.getText());
            pst.setString(2, nama.getText());
            pst.setString(3, (String) satuan.getSelectedItem());
            pst.setString(4, (String) kategori.getSelectedItem());
            pst.setString(5, (String) departemen.getSelectedItem());
            pst.setString(6, blok.getText());
            pst.setString(7, (String) estate.getSelectedItem());
            pst.setString(8, jumlah.getText());
            pst.setString(9, harga.getText());
            pst.executeUpdate();
            clearInputFields();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        populatetabelsatuan();
    }//GEN-LAST:event_editActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
        DefaultTableModel satuanmodel = (DefaultTableModel) Keluarexport.tkeluar.getModel();

        DefaultTableModel model = (DefaultTableModel) tabelsatuan.getModel();
        
        satuanmodel.setRowCount(0);
        
        int[] getSelectedJTableRows = tabelsatuan.getSelectedRows();
        Object[] objects = new Object[9];
        
        for (int i = 0; i < getSelectedJTableRows.length; i++){
            objects[0] = model.getValueAt(getSelectedJTableRows[i],0);
            objects[1] = model.getValueAt(getSelectedJTableRows[i],1);
            objects[2] = model.getValueAt(getSelectedJTableRows[i],2);
            objects[3] = model.getValueAt(getSelectedJTableRows[i],3);
            objects[4] = model.getValueAt(getSelectedJTableRows[i],4);
            objects[5] = model.getValueAt(getSelectedJTableRows[i],5);
            objects[6] = model.getValueAt(getSelectedJTableRows[i],6);
            objects[7] = model.getValueAt(getSelectedJTableRows[i],7);
            objects[8] = model.getValueAt(getSelectedJTableRows[i],8);
            objects[9] = model.getValueAt(getSelectedJTableRows[i],9);
            
            satuanmodel.addRow(objects);
        }
        
        Keluarexport.setVisible(true);
        Keluarexport.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_exportActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Adminwsl().setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String query = search.getText().toLowerCase();
        
        filter (query); 
    }//GEN-LAST:event_searchActionPerformed

    private void filter (String query){
        DefaultTableModel model = (DefaultTableModel) tabelsatuan.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<> (model);
        
        tabelsatuan.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    private void tabelsatuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelsatuanMouseClicked
        // TODO add your handling code here:
        int tabelsat = tabelsatuan.getSelectedRow();
        
        nomor.setText(keluarlist().get(tabelsat).getnomor());
        nama.setText(keluarlist().get(tabelsat).getnama());
        kode.setText(keluarlist().get(tabelsat).getkode());
        satuan.setSelectedItem(keluarlist().get(tabelsat).getsatuan());
        kategori.setSelectedItem(keluarlist().get(tabelsat).getkategori());
        departemen.setSelectedItem(keluarlist().get(tabelsat).getdepartemen());
        blok.setText(keluarlist().get(tabelsat).getblok());
        estate.setSelectedItem(keluarlist().get(tabelsat).getestate());
        jumlah.setText(keluarlist().get(tabelsat).getjumlah());
        harga.setText(keluarlist().get(tabelsat).getharga());
        
                
    }//GEN-LAST:event_tabelsatuanMouseClicked

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        // TODO add your handling code here:
        NotifLaporanKwsl.setVisible(true);
        NotifLaporanKwsl.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Userwsl().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Satuanwsl().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Kategoriwsl().setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Barangwsl().setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Suplierwsl().setVisible(true);
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Compartwsl().setVisible(true);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Masukwsl().setVisible(true);
    }//GEN-LAST:event_jMenu10MouseClicked

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Keluarwsl().setVisible(true);
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Detailwsl().setVisible(true);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new POwsl().setVisible(true);
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Estatewsl().setVisible(true);
    }//GEN-LAST:event_jMenu16MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Keluarwsl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keluarwsl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keluarwsl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keluarwsl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keluarwsl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField blok;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> departemen;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> estate;
    private javax.swing.JButton export;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JComboBox<String> satuan;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabelsatuan;
    // End of variables declaration//GEN-END:variables
}
