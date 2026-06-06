package component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Barmas extends javax.swing.JDialog {
    public Barmas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kosongkanPlaceholder();
        loadKategori();
        loadSupplier();
        setLocationRelativeTo(null);
    }

    private void kosongkanPlaceholder() {
        txt_namaBarang.setText("");
        txt_namaBarang1.setText("");
        txt_namaBarang2.setText("");
        txt_namaBarang3.setText("");
        txt_namaBarang4.setText("");
        txt_harga.setText("");
        txt_totalHarga.setText("");
        txt_totalHarga.setEditable(false);
    }

    private void hitungTotalHarga() {
        try {
            double harga = parseHargaInput(txt_harga.getText());
            int qty = Integer.parseInt(txt_namaBarang3.getText().trim());
            txt_totalHarga.setText(formatRupiah(harga * qty));
        } catch (NumberFormatException e) {
            txt_totalHarga.setText("");
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

    private void loadKategori() {
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT id FROM kategoribarang WHERE status = 'Aktif' ORDER BY id";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            box_satuan2.removeAllItems();
            box_satuan2.addItem("-- Pilih ID --");
            while (rs.next()) {
                box_satuan2.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load kategori: " + e.getMessage());
        }
    }

    private void loadSupplier() {
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT id FROM supplier";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            box_satuan1.removeAllItems();
            box_satuan1.addItem("-- Pilih ID --");
            while (rs.next()) {
                box_satuan1.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load supplier: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_namaBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton_simpan = new javax.swing.JButton();
        jButton_batal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txt_namaBarang1 = new javax.swing.JTextField();
        box_satuan1 = new javax.swing.JComboBox<>();
        txt_namaBarang2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_namaBarang3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txt_namaBarang4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        box_satuan2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_totalHarga = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Tambah Barang Masuk");
        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Tanggal");
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Kode Barang");
        txt_namaBarang.setText("jTextField2");
        txt_namaBarang.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarangActionPerformed(evt);
            }
        });
        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nama Barang");
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
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID Pemasok");
        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Nama Pemasok");
        txt_namaBarang1.setText("jTextField2");
        txt_namaBarang1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarang1ActionPerformed(evt);
            }
        });
        box_satuan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        box_satuan1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_satuan1ActionPerformed(evt);
            }
        });
        txt_namaBarang2.setText("jTextField2");
        txt_namaBarang2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarang2ActionPerformed(evt);
            }
        });
        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Kuantitas");
        txt_namaBarang3.setText("jTextField2");
        txt_namaBarang3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarang3ActionPerformed(evt);
            }
        });
        txt_namaBarang3.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                hitungTotalHarga();
            }
        });
        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Harga Satuan");
        txt_harga.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                hitungTotalHarga();
            }
        });
        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Total Harga");
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Keterangan");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        txt_namaBarang4.setText("jTextField2");
        txt_namaBarang4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarang4ActionPerformed(evt);
            }
        });
        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Kategori Barang");
        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Nama Kategori");
        box_satuan2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        box_satuan2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_satuan2ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
        panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addComponent(jLabel9)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addComponent(jLabel1)
        .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2)
        .addComponent(jLabel5)
        .addComponent(jLabel6)
        .addComponent(jLabel7)
        .addComponent(jLabel4)
        .addComponent(jLabel8)
        .addComponent(jLabel12)
        .addComponent(jLabel13)
        .addComponent(jLabel10)
        .addComponent(jLabel11))
        .addGap(39, 39, 39)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(txt_namaBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        .addComponent(txt_harga)
        .addComponent(txt_totalHarga)
        .addComponent(txt_namaBarang)
        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(txt_namaBarang1)
        .addComponent(box_satuan1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(txt_namaBarang2)
        .addComponent(txt_namaBarang4)
        .addComponent(box_satuan2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addGap(28, 28, 28))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jButton_simpan)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton_batal)
        .addGap(24, 24, 24))
        );
        panelBorder1Layout.setVerticalGroup(
        panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2)
        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(txt_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel4))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel5)
        .addComponent(txt_namaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel10)
        .addComponent(box_satuan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(txt_namaBarang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel11))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel6)
        .addComponent(box_satuan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel7)
        .addComponent(txt_namaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel8)
        .addComponent(txt_namaBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel12)
        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel13)
        .addComponent(txt_totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addComponent(jLabel9)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(panelBorder1Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jButton_simpan)
        .addComponent(jButton_batal))
        .addGap(19, 19, 19))))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarangActionPerformed
    }//GEN-LAST:event_txt_namaBarangActionPerformed

    private void jButton_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_simpanActionPerformed
        String kodeBarang = txt_namaBarang.getText();
        String namaBarang = txt_namaBarang1.getText();
        String idSupplier = box_satuan1.getSelectedItem().toString();
        String idKategori = box_satuan2.getSelectedItem().toString();
        String keterangan = jTextArea1.getText();
        int qty;
        double harga;
        try {
            qty = Integer.parseInt(txt_namaBarang3.getText());
            harga = parseHargaInput(txt_harga.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kuantitas dan harga satuan harus berupa angka!");
            return;
        }
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Pilih tanggal!");
            return;
        }
        if (kodeBarang.trim().isEmpty() || namaBarang.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kode dan nama barang wajib diisi!");
            return;
        }
        if (box_satuan2.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Pilih kategori barang!");
            return;
        }
        if (box_satuan1.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Pilih supplier!");
            return;
        }
        Connection conn = null;
        try {
            conn = config.koneksi.getConnection();
            conn.setAutoCommit(false);
            String cekSql = "SELECT kategori_id FROM databarang WHERE id = ?";
            PreparedStatement psCek = conn.prepareStatement(cekSql);
            psCek.setString(1, kodeBarang);
            java.sql.ResultSet rs = psCek.executeQuery();
            if (!rs.next()) {
                String sqlBaru = "INSERT INTO databarang (id, kategori_id, name, stok) VALUES (?, ?, ?, ?)";
                PreparedStatement psBaru = conn.prepareStatement(sqlBaru);
                psBaru.setString(1, kodeBarang);
                psBaru.setString(2, idKategori);
                psBaru.setString(3, namaBarang);
                psBaru.setInt(4, 0);
                psBaru.executeUpdate();
            } else if (!idKategori.equals(rs.getString("kategori_id"))) {
                JOptionPane.showMessageDialog(this, "Kategori tidak sesuai dengan data barang yang sudah ada!");
                conn.rollback();
                return;
            }
            String sqlMasuk = "INSERT INTO barangmasuk (barang_id, kategori_id, supplier_id, tanggal, jumlah, harga, keterangan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psMasuk = conn.prepareStatement(sqlMasuk);
            psMasuk.setString(1, kodeBarang);
            psMasuk.setString(2, idKategori);
            psMasuk.setString(3, idSupplier);
            psMasuk.setTimestamp(4, new java.sql.Timestamp(jDateChooser1.getDate().getTime()));
            psMasuk.setInt(5, qty);
            psMasuk.setDouble(6, harga);
            psMasuk.setString(7, keterangan);
            psMasuk.executeUpdate();
            String sqlUpdateStok = "UPDATE databarang SET stok = stok + ? WHERE id = ?";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdateStok);
            psUpdate.setInt(1, qty);
            psUpdate.setString(2, kodeBarang);
            psUpdate.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            this.dispose();
        } catch (Exception e) {
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) {}
            JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_simpanActionPerformed

    private void txt_namaBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarang1ActionPerformed
    }//GEN-LAST:event_txt_namaBarang1ActionPerformed

    private void txt_namaBarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarang2ActionPerformed
    }//GEN-LAST:event_txt_namaBarang2ActionPerformed

    private void txt_namaBarang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarang3ActionPerformed
    }//GEN-LAST:event_txt_namaBarang3ActionPerformed

    private void box_satuan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_satuan1ActionPerformed
        if (box_satuan1.getSelectedIndex() > 0) {
            try {
                java.sql.Connection conn = config.koneksi.getConnection();
                String sql = "SELECT name FROM supplier WHERE id = ?";
                java.sql.PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, box_satuan1.getSelectedItem().toString());
                java.sql.ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    txt_namaBarang2.setText(rs.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            txt_namaBarang2.setText("");
        }
    }//GEN-LAST:event_box_satuan1ActionPerformed

    private void txt_namaBarang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarang4ActionPerformed
    }//GEN-LAST:event_txt_namaBarang4ActionPerformed

    private void box_satuan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_satuan2ActionPerformed
        if (box_satuan2.getSelectedIndex() > 0) {
            try {
                java.sql.Connection conn = config.koneksi.getConnection();
                String sql = "SELECT name FROM kategoribarang WHERE id = ?";
                java.sql.PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, box_satuan2.getSelectedItem().toString());
                java.sql.ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    txt_namaBarang4.setText(rs.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            txt_namaBarang4.setText("");
        }
    }//GEN-LAST:event_box_satuan2ActionPerformed

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
            java.util.logging.Logger.getLogger(Barmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Barmas dialog = new Barmas(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> box_satuan1;
    private javax.swing.JComboBox<String> box_satuan2;
    private javax.swing.JButton jButton_batal;
    private javax.swing.JButton jButton_simpan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextField txt_namaBarang;
    private javax.swing.JTextField txt_namaBarang1;
    private javax.swing.JTextField txt_namaBarang2;
    private javax.swing.JTextField txt_namaBarang3;
    private javax.swing.JTextField txt_namaBarang4;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_totalHarga;
    // End of variables declaration//GEN-END:variables
}
