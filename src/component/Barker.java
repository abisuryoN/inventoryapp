package component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import config.koneksi;

public class Barker extends javax.swing.JDialog {
    public Barker(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kosongkanForm();
        jButton_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        setLocationRelativeTo(null);
        loadKodeBarang();
    }

    private void kosongkanForm() {
        txt_namabarang.setText("");
        txt_kuantitas.setText("");
        txt_hargaSatuan.setText("");
        txt_total.setText("");
        txt_total.setEditable(false);
        txt_transaksi.setText("TRX-" + System.currentTimeMillis());
        txt_penerima.setText("");
        txt_keterangan.setText("");
    }

    private void hitungTotalHarga() {
        try {
            double harga = parseHargaInput(txt_hargaSatuan.getText());
            int qty = Integer.parseInt(txt_kuantitas.getText().trim());
            txt_total.setText(formatRupiah(harga * qty));
        } catch (NumberFormatException e) {
            txt_total.setText("");
        }
    }

    private String formatRupiah(double value) {
        return "Rp " + String.format("%,.0f", value).replace(",", ".");
    }

    private double parseHargaInput(String input) {
        String text = input.trim().toLowerCase().replace("rp", "").replace(" ", "");
        boolean ribuan = text.endsWith("k");
        if (ribuan) {
            text = text.substring(0, text.length() - 1);
        }
        if (text.contains(",")) {
            text = text.replace(".", "").replace(",", ".");
        } else if (text.matches(".*\\.\\d{3}(\\.\\d{3})*$")) {
            text = text.replace(".", "");
        }
        double value = Double.parseDouble(text);
        return ribuan ? value * 1000 : value;
    }

    private void loadKodeBarang(){
        try {
            Connection c = koneksi.getConnection();
            String sql = "SELECT id FROM databarang ORDER BY id";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            cb_kodebarang.removeAllItems();
            cb_kodebarang.addItem("-- Pilih Kode --");
            while(r.next()){
                cb_kodebarang.addItem(
                r.getString("id")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
            null,
            e.getMessage()
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_transaksi = new javax.swing.JTextField();
        jButton_simpan = new javax.swing.JButton();
        jButton_batal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_kuantitas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_hargaSatuan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        cb_kodebarang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_penerima = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_keterangan = new javax.swing.JTextArea();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Tambah Barang Keluar");
        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Tanggal");
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Nama Barang");
        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("No. Transaksi");
        jButton_simpan.setBackground(new java.awt.Color(0, 0, 255));
        jButton_simpan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_simpan.setText("Simpan");
        jButton_simpan.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_simpanActionPerformed(evt);
            }
        });
        jButton_batal.setText("Batal");
        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setText("Total Harga");
        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setText("Kuantitas");
        txt_kuantitas.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kuantitasActionPerformed(evt);
            }
        });
        txt_kuantitas.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_kuantitasKeyReleased(evt);
            }
        });
        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel10.setText("Harga Satuan");
        txt_hargaSatuan.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                hitungTotalHarga();
            }
        });
        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Kode Barang");
        cb_kodebarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_kodebarang.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kodebarangActionPerformed(evt);
            }
        });
        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Keterangan");
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nama Penerima");
        txt_keterangan.setColumns(20);
        txt_keterangan.setRows(5);
        jScrollPane1.setViewportView(txt_keterangan);
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
        panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2)
        .addComponent(jLabel5)
        .addComponent(jLabel4)
        .addComponent(jLabel6)
        .addComponent(jLabel7)
        .addComponent(jLabel10)
        .addComponent(jLabel3)
        .addComponent(jLabel8)
        .addComponent(jLabel9))
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGap(39, 39, 39)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        .addComponent(txt_transaksi)
        .addComponent(txt_total)
        .addComponent(txt_kuantitas, javax.swing.GroupLayout.Alignment.TRAILING)
        .addComponent(txt_hargaSatuan)
        .addComponent(txt_namabarang)
        .addComponent(cb_kodebarang, 0, 234, Short.MAX_VALUE)
        .addComponent(txt_penerima)))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGap(47, 47, 47)
        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jButton_simpan)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton_batal)
        .addGap(21, 21, 21))
        );
        panelBorder1Layout.setVerticalGroup(
        panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(16, 16, 16)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2)
        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(16, 16, 16)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel3)
        .addComponent(cb_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel4)
        .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel7)
        .addComponent(txt_kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel10)
        .addComponent(txt_hargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel6)
        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel5)
        .addComponent(txt_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(txt_penerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addComponent(jLabel9))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel8)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(60, 60, 60)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jButton_simpan)
        .addComponent(jButton_batal))
        .addContainerGap(36, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_kodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kodebarangActionPerformed
        if (cb_kodebarang.getSelectedIndex() <= 0) {
            txt_namabarang.setText("");
            return;
        }
        try {
            Connection c = koneksi.getConnection();
            String sql =
            "SELECT name FROM databarang WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, cb_kodebarang.getSelectedItem().toString());
            ResultSet r = p.executeQuery();
            while(r.next()){
                txt_namabarang.setText(
                r.getString("name")
                );
            }
            String hargaSql = "SELECT harga FROM barangmasuk WHERE barang_id = ? ORDER BY tanggal DESC, id DESC LIMIT 1";
            PreparedStatement psHarga = c.prepareStatement(hargaSql);
            psHarga.setString(1, cb_kodebarang.getSelectedItem().toString());
            ResultSet rsHarga = psHarga.executeQuery();
            if (rsHarga.next()) {
                txt_hargaSatuan.setText(formatRupiah(rsHarga.getDouble("harga")));
                hitungTotalHarga();
            } else {
                txt_hargaSatuan.setText("");
                txt_total.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
            null,
            e.getMessage()
            );
        }
    }//GEN-LAST:event_cb_kodebarangActionPerformed

    private void txt_kuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kuantitasActionPerformed
    }//GEN-LAST:event_txt_kuantitasActionPerformed

    private void txt_kuantitasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kuantitasKeyReleased
        hitungTotalHarga();
    }//GEN-LAST:event_txt_kuantitasKeyReleased

    private void jButton_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_simpanActionPerformed
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Pilih tanggal!");
            return;
        }
        if (cb_kodebarang.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Pilih kode barang!");
            return;
        }
        int qty;
        double totalHarga;
        try {
            qty = Integer.parseInt(txt_kuantitas.getText().trim());
            totalHarga = parseHargaInput(txt_total.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kuantitas dan total harga harus berupa angka!");
            return;
        }
        if (qty <= 0) {
            JOptionPane.showMessageDialog(this, "Kuantitas harus lebih dari 0!");
            return;
        }

        Connection c = null;
        try {
            c = koneksi.getConnection();
            c.setAutoCommit(false);
            String kodeBarang = cb_kodebarang.getSelectedItem().toString();
            String cekStokSql = "SELECT stok FROM databarang WHERE id = ?";
            PreparedStatement psCek = c.prepareStatement(cekStokSql);
            psCek.setString(1, kodeBarang);
            ResultSet rs = psCek.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Barang tidak ditemukan!");
                c.rollback();
                return;
            }
            int stok = rs.getInt("stok");
            if (stok < qty) {
                JOptionPane.showMessageDialog(this, "Stok tidak mencukupi. Stok tersedia: " + stok);
                c.rollback();
                return;
            }

            String noTransaksi = txt_transaksi.getText().trim();
            if (noTransaksi.isEmpty()) {
                noTransaksi = "TRX-" + System.currentTimeMillis();
            }
            String sql =
            "INSERT INTO barangkeluar "
            + "(tanggal, barang_id, nama_barang, jumlah, qty, total_harga, no_transaksi, penerima, keterangan, kode_barang) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setTimestamp(1, new java.sql.Timestamp(jDateChooser1.getDate().getTime()));
            p.setString(2, kodeBarang);
            p.setString(3, txt_namabarang.getText());
            p.setInt(4, qty);
            p.setInt(5, qty);
            p.setDouble(6, totalHarga);
            p.setString(7, noTransaksi);
            p.setString(8, txt_penerima.getText());
            p.setString(9, txt_keterangan.getText());
            p.setString(10, kodeBarang);
            p.executeUpdate();

            String updateStokSql = "UPDATE databarang SET stok = stok - ? WHERE id = ?";
            PreparedStatement psUpdate = c.prepareStatement(updateStokSql);
            psUpdate.setInt(1, qty);
            psUpdate.setString(2, kodeBarang);
            psUpdate.executeUpdate();

            c.commit();
            JOptionPane.showMessageDialog(
            null,
            "Berhasil disimpan"
            );
            dispose();
        } catch (Exception e) {
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(
            null,
            e.getMessage()
            );
        }
    }//GEN-LAST:event_jButton_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(Barker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Barker dialog = new Barker(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_kodebarang;
    private javax.swing.JButton jButton_batal;
    private javax.swing.JButton jButton_simpan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextArea txt_keterangan;
    private javax.swing.JTextField txt_kuantitas;
    private javax.swing.JTextField txt_hargaSatuan;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_penerima;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_transaksi;
    // End of variables declaration//GEN-END:variables
}
