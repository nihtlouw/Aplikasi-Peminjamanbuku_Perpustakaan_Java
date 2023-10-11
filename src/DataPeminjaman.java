/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riama
 */

public class DataPeminjaman extends javax.swing.JFrame {
    /**
     * Creates new form DataPeminjaman
     */
    public DataPeminjaman(){
        initComponents();
        loadPinjam();
         
        try {
            BufferedImage beam = ImageIO.read(getClass().getResource("library.png"));
             setIconImage(beam); 
        } catch (IOException ex) {
            Logger.getLogger(splashscreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Data Peminjaman Buku");
    }
    
    Connection conn = Koneksi.connectDB();
    private void loadPinjam(){
        String sql = "SELECT * FROM pinjaman";
        Object[] kolom = { "ID Pinjam", "NPM", "Nama", "ID Buku", "Judul", "Jumlah", "Tanggal Pinjam", "Tanggal Balik", "Denda", "Status"};
        DefaultTableModel dataModel = new DefaultTableModel(null, kolom);
        tblpinjam.setModel(dataModel);
        tblpinjam.getColumnModel().getColumn(0).setMaxWidth(200);
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_pinjam = rs.getString("id_pinjam");
                String npm = rs.getString("npm");
                String nama = rs.getString("nama");
                String id_buku = rs.getString("id_buku");
                String judul = rs.getString("judul");
                int jumlah = rs.getInt("jumlah");
                String tgl_pinjam = rs.getString("tgl_pinjam");
                String tgl_balik = rs.getString("tgl_balik");
                int denda = rs.getInt("denda");
                String status = rs.getString("status");
                
                Object[] data = {id_pinjam, npm, nama, id_buku, judul, jumlah, tgl_pinjam, tgl_balik, denda, status};
                dataModel.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void loadPinjam(String teks){
        String sql = "SELECT * FROM pinjaman WHERE id_pinjam like '%"+ teks + "%'";
        Object[] kolom = { "ID Pinjam", "NPM", "Nama", "ID Buku", "Judul", "Jumlah", "Tanggal Pinjam", "Tanggal Balik", "Denda", "Status"};
        DefaultTableModel dataModel = new DefaultTableModel(null, kolom);
        tblpinjam.setModel(dataModel);
        tblpinjam.getColumnModel().getColumn(0).setMaxWidth(200);
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_pinjam = rs.getString("id_pinjam");
                String npm = rs.getString("npm");
                String nama = rs.getString("nama");
                String id_buku = rs.getString("id_buku");
                String judul = rs.getString("judul");
                int jumlah = rs.getInt("jumlah");
                String tgl_pinjam = rs.getString("tgl_pinjam");
                String tgl_balik = rs.getString("tgl_balik");
                int denda = rs.getInt("denda");
                String status = rs.getString("status");
                
                Object[] data = {id_pinjam, npm, nama, id_buku, judul, jumlah, tgl_pinjam, tgl_balik, denda, status};
                dataModel.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpinjam = new javax.swing.JTable();
        btInput = new javax.swing.JButton();
        btKembali = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblpinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpinjam);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 800, 320));

        btInput.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        btInput.setText("Input");
        btInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputActionPerformed(evt);
            }
        });
        jPanel1.add(btInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, -1));

        btKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Backk.png"))); // NOI18N
        btKembali.setBorderPainted(false);
        btKembali.setContentAreaFilled(false);
        btKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 500, 140, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setForeground(new java.awt.Color(23, 179, 237));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("DATA PEMINJAMAN BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 510, 60));

        txtCari.setText("Cari ID Pinjam");
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("BACK");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 690, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputActionPerformed
        new InputPeminjaman().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btInputActionPerformed

    private void btKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKembaliActionPerformed
        new halamanUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btKembaliActionPerformed

    private void tblpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpinjamMouseClicked
        int dialogResult = JOptionPane.showConfirmDialog (null, "Yakin ingin menghapus?","",YES_NO_OPTION);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            int baris = tblpinjam.getSelectedRow();
            String id= tblpinjam.getValueAt(baris, 0).toString();
            String id_buku = tblpinjam.getValueAt(baris, 3).toString();
        
            try {
                String sql ="DELETE FROM pinjaman where id_pinjam = '"+id+"'"; 
                Connection conn = Koneksi.connectDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update gagal"+e.getMessage());
            }       
 
            String status= tblpinjam.getValueAt(baris, 9).toString();
        
            if(status.equals("Sudah Kembali")){
                loadPinjam();
            } else{
                try{
                    String query1 = "SELECT*FROM buku where id_buku = '"+id_buku+"'";
                    Connection conn2 = Koneksi.connectDB();
                    Statement st = conn2.createStatement();
                    ResultSet data1 = st.executeQuery(query1);

                    while(data1.next()){
                        String jmlh= tblpinjam.getValueAt(baris, 5).toString();
                        int jumlah= Integer.parseInt(data1.getString(7));
                        int jumlahpinjam = Integer.parseInt(jmlh);
                        int total = jumlah+jumlahpinjam;

                        try {
                            String sql1 ="UPDATE buku SET stok = '"+ total
                                    +"' WHERE id_buku = '"+id_buku+"'";
                            Connection conn3 = Koneksi.connectDB();
                            PreparedStatement pst=conn3.prepareStatement(sql1);
                            pst.execute();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Gagal update"+e.getMessage());
                        }
                    }
                }catch(Exception b){
                    JOptionPane.showMessageDialog(null, b.getMessage());
                }
            }
            loadPinjam();
        } else if(dialogResult == JOptionPane.NO_OPTION){
            loadPinjam();
        }
    }//GEN-LAST:event_tblpinjamMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText(null);
    }//GEN-LAST:event_txtCariMouseClicked

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String teks = txtCari.getText();
            loadPinjam(teks);
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        if(txtCari.getText().equals("")){
            loadPinjam();
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInput;
    private javax.swing.JButton btKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpinjam;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
