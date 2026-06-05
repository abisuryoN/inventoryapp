package view.dashboard;

import component.Barmas;

public class BarangMasuk extends javax.swing.JPanel {
    public BarangMasuk() {
        initComponents();
        setupTableStyle();
        loadTable();
    }

    private void setupTableStyle() {
        jTable7.setForeground(java.awt.Color.BLACK);
        jTable7.setSelectionForeground(java.awt.Color.WHITE);
        jTable7.setSelectionBackground(new java.awt.Color(30, 99, 242));
        jTable7.setRowHeight(26);
        jTable7.setShowGrid(false);
        jTable7.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTable7.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        setColumnWidth(0, 60);
        setColumnWidth(1, 150);
        setColumnWidth(2, 120);
        setColumnWidth(3, 160);
        setColumnWidth(4, 120);
        setColumnWidth(5, 170);
        setColumnWidth(6, 100);
        setColumnWidth(7, 150);
        setColumnWidth(8, 260);
    }

    private void setColumnWidth(int columnIndex, int width) {
        javax.swing.table.TableColumn column = jTable7.getColumnModel().getColumn(columnIndex);
        column.setMinWidth(width);
        column.setPreferredWidth(width);
    }

    public void loadTable() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);
        String sql ="SELECT bm.*, b.name AS nama_barang, s.name AS nama_supplier " +
        "FROM barangmasuk bm " +
        "JOIN databarang b ON bm.barang_id = b.id " +
        "JOIN supplier s ON bm.supplier_id = s.id";
        try (java.sql.Connection conn = config.koneksi.getConnection();
        java.sql.Statement st = conn.createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql)) {
            int no = 1;
            while (rs.next()) {
                int jumlah = rs.getInt("jumlah");
                double harga = rs.getDouble("harga");
                double totalHarga = jumlah * harga;
                model.addRow(new Object[]{
                    no++,
                    rs.getString("tanggal"),
                    rs.getString("barang_id"),
                    rs.getString("nama_barang"),
                    rs.getString("supplier_id"),
                    rs.getString("nama_supplier"),
                    jumlah,
                    "Rp " + String.format("%,.0f", totalHarga),
                    rs.getString("keterangan")
                });
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        Barmas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCard7 = new swing.PanelCard();
        jButton_ = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        setLayout(new java.awt.CardLayout());
        Barmas.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Barang Masuk");
        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Dashboard");
        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel3.setText(">");
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel4.setText("Masuk");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(31, 31, 31)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel4))
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(21, Short.MAX_VALUE))
        );
        jButton_.setBackground(new java.awt.Color(0, 51, 255));
        jButton_.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_.setText("+Tambah Barang ");
        jButton_.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActionPerformed(evt);
            }
        });
        jTable7.setForeground(new java.awt.Color(255, 255, 255));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null}
        },
        new String [] {
            "No", "Tanggal", "Kode Barang", "Nama Barang", "ID Supplier", "Nama Supplier", "Total Qty", "Total Harga", "Keterangan"
        }
        ));
        jTable7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTable7.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(jTable7);
        jButton8.setBackground(new java.awt.Color(255, 153, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ringkasan Priode");
        jTextField1.setText("Cari");
        jButton1.setText("Cari");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton1)
        .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        javax.swing.GroupLayout panelCard7Layout = new javax.swing.GroupLayout(panelCard7);
        panelCard7.setLayout(panelCard7Layout);
        panelCard7Layout.setHorizontalGroup(
        panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard7Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        .addGroup(panelCard7Layout.createSequentialGroup()
        .addComponent(jButton_)
        .addGap(12, 12, 12)
        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton9)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(49, Short.MAX_VALUE))
        .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard7Layout.createSequentialGroup()
        .addGap(454, 454, 454)
        .addComponent(jLabel13)
        .addContainerGap(454, Short.MAX_VALUE)))
        );
        panelCard7Layout.setVerticalGroup(
        panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard7Layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jButton_)
        .addComponent(jButton8)
        .addComponent(jButton9))
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(91, Short.MAX_VALUE))
        .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard7Layout.createSequentialGroup()
        .addGap(283, 283, 283)
        .addComponent(jLabel13)
        .addContainerGap(283, Short.MAX_VALUE)))
        );
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(panelCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(10, 10, 10)
        .addComponent(panelCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(46, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout BarmasLayout = new javax.swing.GroupLayout(Barmas);
        Barmas.setLayout(BarmasLayout);
        BarmasLayout.setHorizontalGroup(
        BarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(BarmasLayout.createSequentialGroup()
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
        );
        BarmasLayout.setVerticalGroup(
        BarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        add(Barmas, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActionPerformed
        Barmas tb = new Barmas(null, true);
        tb.setVisible(true);
        loadTable();
    }//GEN-LAST:event_jButton_ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barmas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private swing.PanelCard panelCard7;
    // End of variables declaration//GEN-END:variables
}
