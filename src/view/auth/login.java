package view.auth;

import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.dashboard.Dashboard;

public class login extends javax.swing.JFrame {
    public login() {
        initComponents();
        getRootPane().setDefaultButton(btnLogin);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword.requestFocusInWindow();
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin.doClick();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        pnUtama = new javax.swing.JPanel();
        pnKiri = new javax.swing.JPanel();
        pnKanan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Inventory\n");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());
        pnUtama.setBackground(new java.awt.Color(255, 255, 255));
        pnKiri.setBackground(new java.awt.Color(51, 51, 255));
        pnKiri.setPreferredSize(new java.awt.Dimension(450, 500));
        javax.swing.GroupLayout pnKiriLayout = new javax.swing.GroupLayout(pnKiri);
        pnKiri.setLayout(pnKiriLayout);
        pnKiriLayout.setHorizontalGroup(
        pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 450, Short.MAX_VALUE)
        );
        pnKiriLayout.setVerticalGroup(
        pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        );
        jLabel1.setText("Password");
        jLabel2.setText("Username");
        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout pnKananLayout = new javax.swing.GroupLayout(pnKanan);
        pnKanan.setLayout(pnKananLayout);
        pnKananLayout.setHorizontalGroup(
        pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnKananLayout.createSequentialGroup()
        .addGap(116, 116, 116)
        .addGroup(pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        .addComponent(btnLogin)
        .addGroup(pnKananLayout.createSequentialGroup()
        .addGroup(pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(1, 1, 1)
        .addGroup(pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(45, Short.MAX_VALUE))
        );
        pnKananLayout.setVerticalGroup(
        pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnKananLayout.createSequentialGroup()
        .addGap(216, 216, 216)
        .addGroup(pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel2))
        .addGap(12, 12, 12)
        .addGroup(pnKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1)
        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnLogin)
        .addContainerGap(193, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout pnUtamaLayout = new javax.swing.GroupLayout(pnUtama);
        pnUtama.setLayout(pnUtamaLayout);
        pnUtamaLayout.setHorizontalGroup(
        pnUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnUtamaLayout.createSequentialGroup()
        .addComponent(pnKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(pnKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnUtamaLayout.setVerticalGroup(
        pnUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(pnKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getContentPane().add(pnUtama, "card2");
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            Connection c = koneksi.getConnection();
            String sql = "SELECT * FROM users "
            + "WHERE username=? AND password=? AND status='Aktif'";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, txtUsername.getText());
            p.setString(2, txtPassword.getText());
            ResultSet r = p.executeQuery();
            if (r.next()) {
                JOptionPane.showMessageDialog(null,
                "Login Berhasil");
                String role = r.getString("role");
                String namaLengkap = r.getString("nama_lengkap");
                Dashboard d = new Dashboard(namaLengkap, role);
                d.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                "Username atau Password Salah");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
            e.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnKanan;
    private javax.swing.JPanel pnKiri;
    private javax.swing.JPanel pnUtama;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
