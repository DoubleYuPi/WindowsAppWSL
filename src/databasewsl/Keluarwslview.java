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
public class Keluarwslview extends javax.swing.JFrame {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    /**
     * Creates new form usermti
     */
    public Keluarwslview() {
        initComponents();
        showTableSatuan();
        
    }
    
    Keluarexport Keluarexport = new Keluarexport();
    NotifLaporanwsl NotifLaporanKwsl = new NotifLaporanwsl();
    
   

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
    
    

    
    
    
    public ArrayList<Arraykeluar> keluarlist(){
        ArrayList<Arraykeluar> keluarlist = new ArrayList<Arraykeluar>();
        String selectAllQuery ="SELECT * FROM brgkeluar_mti";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(selectAllQuery);
            
            
            while(rs.next()){
                Arraykeluar arraykeluar = new Arraykeluar();
                arraykeluar.setnomor(rs.getString("nomor"));
                arraykeluar.setkode(rs.getString("kode"));
                arraykeluar.setnama(rs.getString("nama"));
                arraykeluar.setsatuan(rs.getString("satuan"));
                arraykeluar.setkategori(rs.getString("kategori"));
                arraykeluar.setdepartemen(rs.getString("departemen"));
                arraykeluar.setblok(rs.getString("blok"));
                arraykeluar.setestate(rs.getString("estate"));
                arraykeluar.setjumlah(rs.getString("jumlah"));
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
        
        Object[] rows = new Object[9];
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
        export = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
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

        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        jLabel5.setText("Search");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(export)))
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
                .addGap(18, 18, 18)
                .addComponent(export)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        new Viewwsl().setVisible(true);
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
        
                
    }//GEN-LAST:event_tabelsatuanMouseClicked

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        // TODO add your handling code here:
        NotifLaporanKwsl.setVisible(true);
        NotifLaporanKwsl.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Userwslview().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Satuanwslview().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Kategoriwslview().setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Barangwslview().setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Suplierwslview().setVisible(true);
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Compartwslview().setVisible(true);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Masukwslview().setVisible(true);
    }//GEN-LAST:event_jMenu10MouseClicked

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Keluarwslview().setVisible(true);
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Detailwslview().setVisible(true);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new POwslview().setVisible(true);
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Estatewslview().setVisible(true);
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
            java.util.logging.Logger.getLogger(Keluarwslview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keluarwslview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keluarwslview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keluarwslview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Keluarwslview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTextField search;
    private javax.swing.JTable tabelsatuan;
    // End of variables declaration//GEN-END:variables
}
