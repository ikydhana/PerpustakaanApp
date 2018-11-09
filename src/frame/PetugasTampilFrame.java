
package frame;

import db.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Petugas;


public class PetugasTampilFrame extends javax.swing.JFrame {

    Petugas petugas;
    
  public PetugasTampilFrame() {
        initComponents();
        setLocationRelativeTo(null);
        resetTable("");
    }
public ArrayList<Petugas> getPetugasList(String keyword){
    ArrayList<Petugas> petugasList = new ArrayList<Petugas>();
    Koneksi koneksi = new Koneksi();
    Connection connection = koneksi.getConnection();
    
    String query = "SELECT * FROM petugas "+keyword;
    Statement st;
    ResultSet rs;
    
    try {
        st = connection.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
            petugas = new Petugas(
                rs.getInt("id"),
                rs.getString("nama_petugas"),
                rs.getString("username"),
                rs.getString("password"));
            petugasList.add(petugas);
        }
    } catch (SQLException | NullPointerException ex) {
        System.err.println("Koneksi Null Gagal");
    }
    return petugasList;
    
}

public void selectPetugas(String keyword){
    ArrayList<Petugas> list = getPetugasList(keyword);
    DefaultTableModel model = (DefaultTableModel)tPetugas.getModel();
    Object[] row = new Object[4];
    
    for (int i = 0; i < list.size(); i++) {
        row[0] = list.get(i).getId();
        row[1] = list.get(i).getNamaPetugas();
        row[2] = list.get(i).getUsername();
        row[3] = list.get(i).getPassword();
        
        model.addRow(row);
    }
}
  
public final void resetTable(String keyword){
    DefaultTableModel model = (DefaultTableModel)tPetugas.getModel();
    model.setRowCount(0);
    selectPetugas(keyword);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        eCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bTutup = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        tPetugas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cari Petugas");

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        bTutup.setText("Tutup");
        bTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTutupActionPerformed(evt);
            }
        });

        tPetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Petugas", "Username", "Password"
            }
        ));
        ScrollPane.setViewportView(tPetugas);
        if (tPetugas.getColumnModel().getColumnCount() > 0) {
            tPetugas.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCari))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bTambah)
                        .addGap(23, 23, 23)
                        .addComponent(bUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTutup)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bBatal)
                        .addComponent(bTutup)
                        .addComponent(bUbah)
                        .addComponent(bHapus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        int i = tPetugas.getSelectedRow();
        if(i>=0) {
            TableModel model =tPetugas.getModel();
            petugas = new Petugas();
            petugas.setId(Integer.parseInt(model.getValueAt(i, 0).toString()));
            petugas.setNamaPetugas(model.getValueAt(i, 1).toString());
            petugas.setUsername(model.getValueAt(i, 2).toString());
            petugas.setPassword(model.getValueAt(i, 3).toString());
            PetugasTambahFrame petugasTambahFrame = new PetugasTambahFrame(petugas);
            petugasTambahFrame.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Pilih data ysng ingin diubah");
        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bTutupActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        resetTable("");
        eCari.setText("");
        eCari.requestFocus();
    }//GEN-LAST:event_bBatalActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        resetTable("WHERE nama_petugas like '%"+eCari.getText()+"%' OR"
                          + " username like '%"+eCari.getText()+"%'");
        
    }//GEN-LAST:event_bCariActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int i = tPetugas.getSelectedRow();
            int pilihan = JOptionPane.showConfirmDialog(
                        null,
                        "yakin ingin menghapus ?",
                        "Konfirmasi hapus",
                        JOptionPane.YES_NO_OPTION);
        if(pilihan==0){
            if(i>=0){
            try {
                TableModel model = tPetugas.getModel();
                Koneksi koneksi = new Koneksi();
                Connection con = koneksi.getConnection();
                String executeQuery = "delete from petugas where id =?";
                PreparedStatement ps = con.prepareStatement(executeQuery);
                ps.setString(1, model.getValueAt (i,0).toString());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex);
            }   
            } else {
                JOptionPane.showConfirmDialog(null, "Pilih data yan ingin dihapus");
            }
        }
        resetTable("");
    }//GEN-LAST:event_bHapusActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        PetugasTambahFrame petugasTambahFrame = new PetugasTambahFrame();
        petugasTambahFrame.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        resetTable("");
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(PetugasTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetugasTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetugasTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetugasTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetugasTampilFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bUbah;
    private javax.swing.JTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tPetugas;
    // End of variables declaration//GEN-END:variables
}
