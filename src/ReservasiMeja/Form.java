/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservasiMeja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cahya
 */
public class Form extends javax.swing.JFrame {
//    Pembuatan attribut untuk koneksi ke db
    private static Connection koneksi;
    private DefaultTableModel model;
    
    /**
     * Creates new form Form
     */
//    Membuat Tampilan table secara temporary saat aplikasi di compile
    public Form() {
        initComponents();
        model = new DefaultTableModel();
        this.jTableReservasi.setModel(model);
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No.Telpon");
        model.addColumn("Tgl.Pesan");
        model.addColumn("No.Meja");
        model.addColumn("Jenis Meja");
        model.addColumn("Tanggal Datang");
        ambil_data_tabel();
        
    }
    
//    Fungsi untuk koneksi ke database
    private static void buka_koneksi(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/db_reservasi";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            }catch(SQLException t){
                System.out.println("Error membuat koneksi");
            }
        }
    }
    
//    Mengambil data yang di input ke dalam table untuk ditampilkan 
    private void ambil_data_tabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            buka_koneksi();
//            Statement
            Statement s = koneksi.createStatement();
            String sql = "Select * from tb_reservasi";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("id");
                o[1] = r.getString("nama");
                o[2] = r.getString("alamat");
                o[3] = r.getString("no_telp");
                o[4] = r.getString("tgl_pesan");
                o[5] = r.getString("no_meja");
                o[6] = r.getString("jenis_meja");
                o[7] = r.getString("tgl_datang");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi kesalahan " + e.getMessage());
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

        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFNama = new javax.swing.JTextField();
        jTFTglPesan = new javax.swing.JTextField();
        jTFAlamat = new javax.swing.JTextField();
        jTFNoTelp = new javax.swing.JTextField();
        jTFNoMeja = new javax.swing.JTextField();
        jTFTglBrg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservasi = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox();
        jHapus = new javax.swing.JButton();
        jEdit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtfID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSearch = new javax.swing.JTextField();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 52, -1, -1));

        jLabel2.setText("Alamat ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 90, -1, -1));

        jLabel3.setText("No. Telpon");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 133, -1, -1));

        jLabel4.setText("Tanggal Pesanan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 171, -1, -1));

        jLabel5.setText("No. Meja");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 216, -1, -1));

        jLabel6.setText("Jenis Meja");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 254, -1, -1));

        jLabel7.setText("Tanggal Datang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 292, 82, -1));

        jLabel8.setText("Form Booking Customer");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 17, -1, -1));

        jTFNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNamaActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 49, 184, -1));

        jTFTglPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTglPesanActionPerformed(evt);
            }
        });
        getContentPane().add(jTFTglPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 168, 184, -1));

        jTFAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAlamatActionPerformed(evt);
            }
        });
        getContentPane().add(jTFAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 87, 184, -1));

        jTFNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNoTelpActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 130, 184, -1));

        jTFNoMeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNoMejaActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNoMeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 213, 184, -1));

        jTFTglBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTglBrgActionPerformed(evt);
            }
        });
        getContentPane().add(jTFTglBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 289, 184, -1));

        jTableReservasi.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableReservasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReservasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableReservasi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 719, 93));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ReservasiMeja/img/submit.png"))); // NOI18N
        jButton1.setText(" Submit ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 327, -1, -1));

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ReservasiMeja/img/refresh.png"))); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        getContentPane().add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 327, -1, -1));

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 Orang", "4 Orang", "6 Orang", "8 Orang ", "> 8 Orang" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 251, 184, -1));

        jHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ReservasiMeja/img/hapus.png"))); // NOI18N
        jHapus.setText("Hapus");
        jHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHapusActionPerformed(evt);
            }
        });
        getContentPane().add(jHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 368, 89, -1));

        jEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ReservasiMeja/img/edit.png"))); // NOI18N
        jEdit.setText("Edit");
        jEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditActionPerformed(evt);
            }
        });
        getContentPane().add(jEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 368, 85, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ReservasiMeja/img/clear.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 327, 82, -1));
        getContentPane().add(jtfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        jLabel14.setText("Search");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSearchKeyReleased(evt);
            }
        });
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNamaActionPerformed

    private void jTFAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAlamatActionPerformed

    private void jTFNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNoTelpActionPerformed

    private void jTFNoMejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNoMejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNoMejaActionPerformed

//    Button untuk nambah data ke database
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
//        Sertakan nama kolom pada tabel
//        Query untuk input data ke table di db yang disesuaikan dengan nama variable textbox
        String sqlkode="Insert into tb_reservasi (nama,alamat,no_telp,tgl_pesan,no_meja,jenis_meja,tgl_datang) "
//                Sertakan nama variable form input
                + "values("
                + "'"+this.jTFNama.getText()+"',"
                + "'"+this.jTFAlamat.getText()+"',"
                + "'"+this.jTFNoTelp.getText()+"',"
                + "'"+this.jTFTglPesan.getText()+"',"
                + "'"+this.jTFNoMeja.getText()+"',"
                + "'"+this.jComboBox.getSelectedItem()+"',"
                + "'"+this.jTFTglBrg.getText()+"')";
        
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sqlkode);
            mStatement.executeUpdate();
            mStatement.close();
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan "+ex.getMessage());
        }
        ambil_data_tabel();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        ambil_data_tabel();
    }//GEN-LAST:event_RefreshActionPerformed

    private void jHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHapusActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
        
        String sqlkode = "DELETE FROM tb_reservasi where id = '"+jtfID.getText()+"'";
        
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sqlkode);
            mStatement.executeUpdate();
            mStatement.close();
            JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan "+ex.getMessage());
        }
        ambil_data_tabel();
    }//GEN-LAST:event_jHapusActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jTableReservasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservasiMouseClicked
        // Edit Data
        // menampilkan data kedalam form pengisian:
        int baris = jTableReservasi.rowAtPoint(evt.getPoint());
        
        String id =jTableReservasi.getValueAt(baris, 0).toString();
        jtfID.setText(id);
        
        String nama =jTableReservasi.getValueAt(baris, 1).toString();
        jTFNama.setText(nama);
        
        String alamat = jTableReservasi.getValueAt(baris,2).toString();
        jTFAlamat.setText(alamat);
        
        String no_telp = jTableReservasi.getValueAt(baris,3).toString();
        jTFNoTelp.setText(no_telp);
        
        String tgl_pesan = jTableReservasi.getValueAt(baris,4).toString();
        jTFTglPesan.setText(tgl_pesan);
        
        String no_meja = jTableReservasi.getValueAt(baris,5).toString();
        jTFNoMeja.setText(no_meja);
        
        String jenisMeja = jTableReservasi.getValueAt(baris, 6).toString();
        jComboBox.setSelectedItem(jenisMeja);
        
        String tgl_datang = jTableReservasi.getValueAt(baris, 7).toString();
        jTFTglBrg.setText(tgl_datang);
        
        
       
    }//GEN-LAST:event_jTableReservasiMouseClicked

    private void jEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditActionPerformed
        //Edit
        // Edit Data
        
        buka_koneksi();
//      Sertakan nama kolom pada tabel
//      Query untuk input data ke table di db yang disesuaikan dengan nama variable textbox
        String sqlkode="UPDATE tb_reservasi SET nama = '"+this.jTFNama.getText()+
                "',alamat = '"+this.jTFAlamat.getText()+
                "', no_telp = '"+this.jTFNoTelp.getText()+
                "',tgl_pesan = '"+this.jTFTglPesan.getText()+
                "',no_meja = '"+this.jTFNoMeja.getText()+
                "',jenis_meja = '"+this.jComboBox.getSelectedItem()+
                "',tgl_datang = '"+this.jTFTglBrg.getText()+"' where id = '"+jtfID.getText()+"'";
        
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sqlkode);
            mStatement.executeUpdate();
            mStatement.close();
            JOptionPane.showMessageDialog(this,"Data Berhasil Diedit");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan "+ex.getMessage());
        }
        ambil_data_tabel();
        
    }//GEN-LAST:event_jEditActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTFNama.setText("");
        jTFAlamat.setText("");
        jTFNoTelp.setText("");
        jTFTglPesan.setText("");
        jTFNoMeja.setText("");
        jTFTglBrg.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTFTglBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTglBrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTglBrgActionPerformed

    private void jTFTglPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTglPesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTglPesanActionPerformed

    private void jSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyReleased
        // TODO add your handling code here:
        // Sertakan nama table       
       DefaultTableModel table = (DefaultTableModel)jTableReservasi.getModel();
        //Sertakan nama textfield       
       String search = jSearch.getText().toLowerCase();
       TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
       jTableReservasi.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jSearchKeyReleased

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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JButton jEdit;
    private javax.swing.JButton jHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JTextField jTFAlamat;
    private javax.swing.JTextField jTFNama;
    private javax.swing.JTextField jTFNoMeja;
    private javax.swing.JTextField jTFNoTelp;
    private javax.swing.JTextField jTFTglBrg;
    private javax.swing.JTextField jTFTglPesan;
    private javax.swing.JTable jTableReservasi;
    private javax.swing.JTextField jtfID;
    // End of variables declaration//GEN-END:variables
}
