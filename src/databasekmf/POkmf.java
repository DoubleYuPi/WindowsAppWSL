/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasekmf;


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
public class POkmf extends javax.swing.JFrame {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    /**
     * Creates new form usermti
     */
    public POkmf() {
        initComponents();
        showTableSatuan();
        combobox1();
        combobox2();
    }
    
    POexport Satuanexport = new POexport();
    NotifLaporanPOkmf NotifLaporanPOkmf = new NotifLaporanPOkmf();
    
    private void clearInputFields(){
        harga.setText("");
        nama.setText("");
        jumlah.setText("");
        qty.setText("");
    }

    
    private void combobox1 (){
        try{
            String sql = "SELECT * FROM satuan_kmf";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("keterangan");
                satuan.addItem(nama);
                //csat1.addItem(nama);
                //csat2.addItem(nama);
            }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
        
    } 
    
        private void combobox2 (){
        try{
            String sql = "SELECT * FROM suplier_kmf";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("nama");
                suplier.addItem(nama);
                //csat1.addItem(nama);
                //csat2.addItem(nama);
            }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
        
    }
    
    public void showTableSatuan(){
        try{
            String sql = "SELECT * FROM `po_kmf`";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelsatuan.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }}
    
    public ArrayList<ArrayPO> satuanlist(){
        ArrayList<ArrayPO> POlist = new ArrayList<ArrayPO>();
        String selectAllQuery ="SELECT * FROM po_kmf";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(selectAllQuery);
            
            
            while(rs.next()){
                ArrayPO arrayPO = new ArrayPO();
                arrayPO.setnomor(rs.getString("nomor"));
                arrayPO.setpo(rs.getString("po"));
                arrayPO.setnama(rs.getString("nama"));
                arrayPO.setsuplier(rs.getString("suplier"));
                arrayPO.setalamat(rs.getString("alamat"));
                arrayPO.setsatuan(rs.getString("satuan"));
                arrayPO.setharga(rs.getString("harga"));
                arrayPO.setppn(rs.getString("discount"));
                arrayPO.setqty(rs.getString("qty"));
                arrayPO.setjumlah(rs.getString("jumlah"));
              
                POlist.add(arrayPO);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                
                
        return POlist;
    }
    
    public void populatetabelsatuan(){
        DefaultTableModel model;
        ArrayList<ArrayPO> dataArray = satuanlist();
        model = (DefaultTableModel) tabelsatuan.getModel();
        model.setRowCount(0);
        
        Object[] rows = new Object[10];
        for (int i = 0; i<dataArray.size();i++){
            rows[0] = dataArray.get(i).getnomor();
            rows[1] = dataArray.get(i).getpo();
            rows[2] = dataArray.get(i).getnama();
            rows[3] = dataArray.get(i).getsuplier();
            rows[4] = dataArray.get(i).getalamat();
            rows[5] = dataArray.get(i).getsatuan();
            rows[6] = dataArray.get(i).getharga();
            rows[7] = dataArray.get(i).getqty();
            rows[8] = dataArray.get(i).getjumlah();
            rows[9] = dataArray.get(i).getppn();
            model.addRow(rows);
        }
    }
    
    public int simpan(){
        DefaultTableModel model = (DefaultTableModel) tabelsatuan.getModel();
        for(int a=0;a<=model.getRowCount();a++){
            String sql = "INSERT INTO 'satuan_mti'"+
        "VALUES"+
        "('"+model.getValueAt(a,0).toString() +"', "+
        "'"+model.getValueAt(a,1).toString() +"', "+
        "'"+model.getValueAt(a,2).toString() +"', "+
        "'"+model.getValueAt(a,3).toString() +"' )";;
            
}
return 0;
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
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        export = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        satuan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        add1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        suplier = new javax.swing.JComboBox<>();
        alamat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        po = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ppn = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
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
        setTitle("Tabel PO KMF");

        tabelsatuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "No.PO", "Nama", "Satuan", "Harga Satuan", "Qty", "Jumlah"
            }
        ));
        tabelsatuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsatuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelsatuan);

        jLabel1.setText("Nomor");

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

        jLabel2.setText("Harga");

        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKeyTyped(evt);
            }
        });

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });

        jLabel6.setText("Qty");

        jLabel7.setText("Jumlah");

        add1.setText("Total");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Suplier");

        jLabel9.setText("Alamat");

        jLabel10.setText("No.PO");

        jLabel11.setText("Discount");

        ppn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ppnKeyTyped(evt);
            }
        });

        jLabel12.setText("*Ditulis dalam bentuk desimal");

        jMenu1.setText("Menu");

        jMenu2.setText("Main menu");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu2);

        jMenu14.setText("Print PO");
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

        jMenu15.setText("Tabel PO");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(export)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ppn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(harga, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(satuan, javax.swing.GroupLayout.Alignment.LEADING, 0, 247, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(po, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(suplier, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(add1)
                                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 351, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(suplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ppn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(export)
                    .addComponent(delete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM `po_kmf` WHERE `nomor` = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, nomor.getText());
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
            String sql = "INSERT INTO `po_kmf`(`nomor`, `po`, `nama`, `suplier`, `alamat`, `satuan`, `harga`, `qty`, `jumlah`, `discount`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, nomor.getText());
            pst.setString(2, po.getText());
            pst.setString(3, nama.getText());
            pst.setString(4, (String)suplier.getSelectedItem());
            pst.setString(5, alamat.getText());
            pst.setString(6, (String)satuan.getSelectedItem());
            pst.setString(7, harga.getText());
            pst.setString(9, qty.getText());
            pst.setString(10, jumlah.getText());
            pst.setString(8, ppn.getText());
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
            String sql = "UPDATE `po_kmf` SET `po`=?, `nama`= ?, `suplier`=?, `alamat`=?, `satuan`= ?, `harga`= ?, `qty`= ?, `jumlah`= ?, `discount`=? WHERE `nomor` = ?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/databasekmf?useTimezone=true&serverTimezone=UTC", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(10, nomor.getText());
            pst.setString(1, po.getText());
            pst.setString(2, nama.getText());
            pst.setString(3, (String)suplier.getSelectedItem());
            pst.setString(4, alamat.getText());
            pst.setString(5, (String)satuan.getSelectedItem());
            pst.setString(6, harga.getText());
            pst.setString(8, qty.getText());
            pst.setString(9, jumlah.getText());
            pst.setString(7, ppn.getText());
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
        DefaultTableModel satuanmodel = (DefaultTableModel) Satuanexport.tpo.getModel();

        DefaultTableModel model = (DefaultTableModel) tabelsatuan.getModel();
        
        satuanmodel.setRowCount(0);
        
        int[] getSelectedJTableRows = tabelsatuan.getSelectedRows();
        Object[] objects = new Object[10];
        
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
        
        Satuanexport.setVisible(true);
        Satuanexport.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_exportActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Adminkmf().setVisible(true);
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
        
        nomor.setText(satuanlist().get(tabelsat).getnomor());
        po.setText(satuanlist().get(tabelsat).getpo());
        suplier.setSelectedItem(satuanlist().get(tabelsat).getsuplier());
        alamat.setText(satuanlist().get(tabelsat).getalamat());
        nama.setText(satuanlist().get(tabelsat).getnama());
        satuan.setSelectedItem(satuanlist().get(tabelsat).getsatuan());
        harga.setText(satuanlist().get(tabelsat).getharga());
        qty.setText(satuanlist().get(tabelsat).getqty());
        jumlah.setText(satuanlist().get(tabelsat).getjumlah());
        ppn.setText(satuanlist().get(tabelsat).getppn());
                
    }//GEN-LAST:event_tabelsatuanMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Userkmf().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Satuankmf().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Kategorikmf().setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Barangkmf().setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Suplierkmf().setVisible(true);
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Compartkmf().setVisible(true);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Masukkmf().setVisible(true);
    }//GEN-LAST:event_jMenu10MouseClicked

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Keluarkmf().setVisible(true);
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        // TODO add your handling code here:\
        this.setVisible(false);
        new Detailkmf().setVisible(true);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_qtyKeyTyped

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        try{

            int hrga  = Integer.parseInt(harga.getText()); 

            int q = Integer.parseInt(qty.getText()); 

            float dc = Float.parseFloat(ppn.getText());

            float ttl = (hrga-(hrga*dc))*q;

            

            jumlah.setText(Float.toString(ttl));

        }

        catch (Exception  e){

            JOptionPane.showMessageDialog(this, "ERROR");

        }

    }//GEN-LAST:event_add1ActionPerformed

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        // TODO add your handling code here:
        NotifLaporanPOkmf.setVisible(true);
        NotifLaporanPOkmf.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu14MouseClicked

    private void hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_hargaKeyTyped

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new POkmf().setVisible(true);
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Estatekmf().setVisible(true);
    }//GEN-LAST:event_jMenu16MouseClicked

    private void ppnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ppnKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ppnKeyTyped

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
            java.util.logging.Logger.getLogger(POkmf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POkmf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POkmf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POkmf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new POkmf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JTextField alamat;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
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
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JTextField po;
    private javax.swing.JTextField ppn;
    private javax.swing.JTextField qty;
    private javax.swing.JComboBox<String> satuan;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> suplier;
    private javax.swing.JTable tabelsatuan;
    // End of variables declaration//GEN-END:variables
}
