package view.dashboard;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTable;

public class Laporan extends javax.swing.JPanel {
    public Laporan() {
        initComponents();
        rapikanWarnaTabel();
        cmbPilihanLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{"Ringkasan", "Barang Masuk", "Barang Keluar", "Kartu Stok"}
        ));
        isiComboSupplier();
        cmbPilihanLaporan.addActionListener(e -> refreshLaporan());
        cmbSupplier.addActionListener(e -> refreshLaporan());
        dcDari.addPropertyChangeListener("date", e -> refreshLaporan());
        dcSampai.addPropertyChangeListener("date", e -> refreshLaporan());
        setTabAktif(lblRingkasan, "Ringkasan", "Ringkasan");
        tampilRingkasan();
        btnCetakPdf.addActionListener(e -> cetakPdfLangsung());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblRingkasan = new javax.swing.JLabel();
        lblJudulLaporan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBreadcrumbAktif = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblBarangKeluar = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblBarangMasuk = new javax.swing.JLabel();
        lblKartuStok = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        cmbPilihanLaporan = new javax.swing.JComboBox<>();
        cmbCetakBagian = new javax.swing.JComboBox<>();
        cmbPeriodeCetak = new javax.swing.JComboBox<>();
        btnCetakPdf = new javax.swing.JButton();
        dcDari = new com.toedter.calendar.JDateChooser();
        dcSampai = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblLaporanUtama = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblStokTerendah = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblBarangTerlaris = new javax.swing.JTable();
        setLayout(new java.awt.CardLayout());
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        lblRingkasan.setText("RIngkasan");
        lblRingkasan.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRingkasanMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
        .addGap(47, 47, 47)
        .addComponent(lblRingkasan)
        .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblRingkasan)
        .addContainerGap(8, Short.MAX_VALUE))
        );
        lblJudulLaporan.setBackground(new java.awt.Color(204, 204, 204));
        lblJudulLaporan.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblJudulLaporan.setText("Barang Keluar");
        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Dashboard");
        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel3.setText(">");
        lblBreadcrumbAktif.setBackground(new java.awt.Color(255, 255, 255));
        lblBreadcrumbAktif.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblBreadcrumbAktif.setText("Keluar");
        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        lblBarangKeluar.setText("Barang Keluar");
        lblBarangKeluar.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarangKeluarMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
        .addContainerGap(91, Short.MAX_VALUE)
        .addComponent(lblBarangKeluar)
        .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblBarangKeluar)
        .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        lblBarangMasuk.setText("Barang Masuk");
        lblBarangMasuk.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarangMasukMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
        .addGap(44, 44, 44)
        .addComponent(lblBarangMasuk)
        .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblBarangMasuk)
        .addContainerGap(8, Short.MAX_VALUE))
        );
        lblKartuStok.setText("Kartu Stok");
        lblKartuStok.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKartuStokMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lblBreadcrumbAktif))
        .addComponent(lblJudulLaporan)
        .addGroup(jPanel7Layout.createSequentialGroup()
        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(35, 35, 35)
        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lblKartuStok)))
        .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
        .addComponent(lblJudulLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(lblBreadcrumbAktif))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        .addGap(0, 180, Short.MAX_VALUE)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        .addComponent(lblKartuStok)
        .addContainerGap())
        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_START);
        jPanel8.setLayout(new java.awt.CardLayout());
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pilihan Laporan");
        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Dari Tanggal");
        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sampai Tanggal");
        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Supplier");
        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPilihanLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCetakBagian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ringkasan", "Barang Masuk", "Barang Keluar", "Kartu Stok", "Barang Terlaris", "Stok Terendah", "Semua Laporan" }));
        cmbPeriodeCetak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Tanggal", "Daily Report", "Monthly Report", "Custom Tanggal" }));
        btnCetakPdf.setText("Cetak PDF");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(cmbPilihanLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel9)))
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(100, 100, 100)
        .addComponent(cmbCetakBagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(67, 67, 67))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel10)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(cmbPeriodeCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(72, 72, 72)
        .addComponent(btnCetakPdf))
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(dcDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel11)
        .addGap(18, 18, 18)
        .addComponent(dcSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addGap(94, 94, 94)
        .addComponent(jLabel12)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(216, 216, 216))
        );
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel9)
        .addComponent(jLabel10))
        .addComponent(dcDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel12)
        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addComponent(dcSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel11))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(cmbPilihanLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(cmbCetakBagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(cmbPeriodeCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(btnCetakPdf)))
        );
        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Laporan");
        tblLaporanUtama.setForeground(new java.awt.Color(255, 255, 255));
        tblLaporanUtama.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "No", "Keterangan", "Jumblah Transaksi", "Total Qty"
        }
        ));
        tblLaporanUtama.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tblLaporanUtama.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(tblLaporanUtama);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(jLabel13))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(69, 69, 69)
        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel13)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(46, Short.MAX_VALUE))
        );
        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Barang Terlaris (BErdasarkan Qty Keluar");
        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Stok Terendah");
        tblStokTerendah.setForeground(new java.awt.Color(255, 255, 255));
        tblStokTerendah.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "No", "Nama Barang", "Stok Akhir", "Satuan"
        }
        ));
        tblStokTerendah.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tblStokTerendah.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane8.setViewportView(tblStokTerendah);
        tblBarangTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        tblBarangTerlaris.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "No", "Nama Barang", "Total Qty Keluar"
        }
        ));
        tblBarangTerlaris.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tblBarangTerlaris.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane9.setViewportView(tblBarangTerlaris);
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(47, 47, 47)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(80, 80, 80)
        .addComponent(jLabel14)))
        .addGap(175, 175, 175)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel15))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel14)
        .addComponent(jLabel15))
        .addGap(34, 34, 34)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(204, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8.add(jPanel10, "card2");
        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);
        add(jPanel6, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void lblRingkasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRingkasanMouseClicked
        cmbPilihanLaporan.setSelectedItem("Ringkasan");
    }//GEN-LAST:event_lblRingkasanMouseClicked

    private void lblBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangMasukMouseClicked
        cmbPilihanLaporan.setSelectedItem("Barang Masuk");
    }//GEN-LAST:event_lblBarangMasukMouseClicked

    private void lblBarangKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangKeluarMouseClicked
        cmbPilihanLaporan.setSelectedItem("Barang Keluar");
    }//GEN-LAST:event_lblBarangKeluarMouseClicked

    private void lblKartuStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKartuStokMouseClicked
        cmbPilihanLaporan.setSelectedItem("Kartu Stok");
    }//GEN-LAST:event_lblKartuStokMouseClicked

    private void setTabAktif(javax.swing.JLabel labelAktif, String judul, String breadcrumb) {
        java.awt.Color biru = new java.awt.Color(30, 99, 242);
        java.awt.Color abu = new java.awt.Color(242, 244, 247);
        java.awt.Color hitam = new java.awt.Color(0, 0, 0);
        java.awt.Color putih = new java.awt.Color(255, 255, 255);
        javax.swing.JLabel[] semuaTab = {
            lblRingkasan,
            lblBarangMasuk,
            lblBarangKeluar,
            lblKartuStok
        };
        for (javax.swing.JLabel tab : semuaTab) {
            tab.setOpaque(true);
            tab.setBackground(abu);
            tab.setForeground(hitam);
            tab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            tab.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10));
        }
        labelAktif.setBackground(biru);
        labelAktif.setForeground(putih);
        lblJudulLaporan.setText(judul);
        lblBreadcrumbAktif.setText(breadcrumb);
    }

    private java.sql.Date ambilTanggal(com.toedter.calendar.JDateChooser dateChooser) {
        if (dateChooser.getDate() == null) {
            return null;
        }
        return new java.sql.Date(dateChooser.getDate().getTime());
    }

    private String ambilIdSupplier() {
        if (cmbSupplier.getSelectedItem() == null) {
            return "";
        }
        String supplier = cmbSupplier.getSelectedItem().toString();
        if (supplier.equals("Semua Supplier")) {
            return "";
        }
        return supplier.split(" - ")[0];
    }

    private void isiComboSupplier() {
        cmbSupplier.removeAllItems();
        cmbSupplier.addItem("Semua Supplier");
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT id, name FROM supplier ORDER BY name ASC";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbSupplier.addItem(rs.getString("id") + " - " + rs.getString("name"));
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal load supplier: " + e.getMessage());
        }
    }

    private void refreshLaporan() {
        String pilihan = cmbPilihanLaporan.getSelectedItem().toString();
        if (pilihan.equals("Ringkasan")) {
            setTabAktif(lblRingkasan, "Ringkasan", "Ringkasan");
            tampilRingkasan();
        } else if (pilihan.equals("Barang Masuk")) {
            setTabAktif(lblBarangMasuk, "Barang Masuk", "Masuk");
            tampilBarangMasuk();
        } else if (pilihan.equals("Barang Keluar")) {
            setTabAktif(lblBarangKeluar, "Barang Keluar", "Keluar");
            tampilBarangKeluar();
        } else if (pilihan.equals("Kartu Stok")) {
            setTabAktif(lblKartuStok, "Kartu Stok", "Stok");
            tampilKartuStok();
        }
    }

    private void tampilBarangTerlaris() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Barang");
        model.addColumn("Total Qty Keluar");
        tblBarangTerlaris.setModel(model);
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT b.name AS nama_barang, SUM(bk.jumlah) AS total_keluar "
            + "FROM barangkeluar bk "
            + "LEFT JOIN databarang b ON bk.barang_id = b.id "
            + "GROUP BY b.name "
            + "ORDER BY total_keluar DESC "
            + "LIMIT 5";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nama_barang"),
                    rs.getInt("total_keluar")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal tampil barang terlaris: " + e.getMessage());
        }
    }

    private void tampilStokTerendah() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Barang");
        model.addColumn("Stok Akhir");
        model.addColumn("Satuan");
        tblStokTerendah.setModel(model);
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT b.name AS nama_barang, "
            + "(COALESCE(m.total_masuk, 0) - COALESCE(k.total_keluar, 0)) AS stok_akhir "
            + "FROM databarang b "
            + "LEFT JOIN ( "
            + "    SELECT barang_id, SUM(jumlah) AS total_masuk "
            + "    FROM barangmasuk "
            + "    GROUP BY barang_id "
            + ") m ON m.barang_id = b.id "
            + "LEFT JOIN ( "
            + "    SELECT barang_id, SUM(jumlah) AS total_keluar "
            + "    FROM barangkeluar "
            + "    GROUP BY barang_id "
            + ") k ON k.barang_id = b.id "
            + "ORDER BY stok_akhir ASC "
            + "LIMIT 5";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nama_barang"),
                    rs.getInt("stok_akhir"),
                    "-"
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal tampil stok terendah: " + e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetakPdf;
    private javax.swing.JComboBox<String> cmbCetakBagian;
    private javax.swing.JComboBox<String> cmbPeriodeCetak;
    private javax.swing.JComboBox<String> cmbPilihanLaporan;
    private javax.swing.JComboBox<String> cmbSupplier;
    private com.toedter.calendar.JDateChooser dcDari;
    private com.toedter.calendar.JDateChooser dcSampai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblBarangKeluar;
    private javax.swing.JLabel lblBarangMasuk;
    private javax.swing.JLabel lblBreadcrumbAktif;
    private javax.swing.JLabel lblJudulLaporan;
    private javax.swing.JLabel lblKartuStok;
    private javax.swing.JLabel lblRingkasan;
    private javax.swing.JTable tblBarangTerlaris;
    private javax.swing.JTable tblLaporanUtama;
    private javax.swing.JTable tblStokTerendah;
    // End of variables declaration//GEN-END:variables

    private void tampilBarangMasuk() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Tanggal");
        model.addColumn("ID Kategori");
        model.addColumn("Kategori");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        model.addColumn("Total Qty");
        model.addColumn("Total Harga");
        model.addColumn("Keterangan");
        tblLaporanUtama.setModel(model);
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            java.sql.Date dari = ambilTanggal(dcDari);
            java.sql.Date sampai = ambilTanggal(dcSampai);
            String supplierId = ambilIdSupplier();
            String sql = "SELECT bm.*, b.name AS nama_barang, s.name AS nama_supplier, k.name AS nama_kategori "
            + "FROM barangmasuk bm "
            + "LEFT JOIN databarang b ON bm.barang_id = b.id "
            + "LEFT JOIN supplier s ON bm.supplier_id = s.id "
            + "LEFT JOIN kategoribarang k ON bm.kategori_id = k.id "
            + "WHERE 1=1 ";
            if (dari != null) {
                sql += "AND CAST(bm.tanggal AS DATE) >= ? ";
            }
            if (sampai != null) {
                sql += "AND CAST(bm.tanggal AS DATE) <= ? ";
            }
            if (!supplierId.isEmpty()) {
                sql += "AND bm.supplier_id = ? ";
            }
            sql += "ORDER BY bm.tanggal DESC";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            int index = 1;
            if (dari != null) {
                ps.setDate(index++, dari);
            }
            if (sampai != null) {
                ps.setDate(index++, sampai);
            }
            if (!supplierId.isEmpty()) {
                ps.setString(index++, supplierId);
            }
            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                int jumlah = rs.getInt("jumlah");
                double harga = rs.getDouble("harga");
                double totalHarga = jumlah * harga;
                model.addRow(new Object[]{
                    no++,
                    rs.getString("tanggal"),
                    rs.getString("kategori_id"),
                    rs.getString("nama_kategori"),
                    rs.getString("barang_id"),
                    rs.getString("nama_barang"),
                    rs.getString("supplier_id"),
                    rs.getString("nama_supplier"),
                    jumlah,
                    "Rp " + String.format("%,.0f", totalHarga),
                    rs.getString("keterangan")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal tampil Barang Masuk: " + e.getMessage());
        }
    }

    private void tampilRingkasan() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Keterangan");
        model.addColumn("Jumlah Transaksi");
        model.addColumn("Total Qty");
        tblLaporanUtama.setModel(model);
        model.addRow(new Object[]{
            1,
            "Ringkasan laporan berhasil dibuka",
            "-",
            "-"
        });
        tampilBarangTerlaris();
        tampilStokTerendah();
    }

    private void tampilBarangKeluar() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Tanggal");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Qty Keluar");
        model.addColumn("Keterangan");
        tblLaporanUtama.setModel(model);
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT bk.tanggal, bk.barang_id, b.name AS nama_barang, "
            + "bk.jumlah, bk.keterangan "
            + "FROM barangkeluar bk "
            + "JOIN databarang b ON bk.barang_id = b.id "
            + "ORDER BY bk.tanggal DESC";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("tanggal"),
                    rs.getString("barang_id"),
                    rs.getString("nama_barang"),
                    rs.getInt("jumlah"),
                    rs.getString("keterangan")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal tampil Barang Keluar: " + e.getMessage());
        }
    }

    private void tampilKartuStok() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Total Masuk");
        model.addColumn("Total Keluar");
        model.addColumn("Stok Sekarang");
        model.addColumn("Status");
        tblLaporanUtama.setModel(model);
        try {
            java.sql.Connection conn = config.koneksi.getConnection();
            String sql = "SELECT b.id AS barang_id, b.name AS nama_barang, "
            + "COALESCE(m.total_masuk, 0) AS total_masuk, "
            + "COALESCE(k.total_keluar, 0) AS total_keluar, "
            + "(COALESCE(m.total_masuk, 0) - COALESCE(k.total_keluar, 0)) AS stok_sekarang "
            + "FROM databarang b "
            + "LEFT JOIN ( "
            + "    SELECT barang_id, SUM(jumlah) AS total_masuk "
            + "    FROM barangmasuk "
            + "    GROUP BY barang_id "
            + ") m ON m.barang_id = b.id "
            + "LEFT JOIN ( "
            + "    SELECT barang_id, SUM(jumlah) AS total_keluar "
            + "    FROM barangkeluar "
            + "    GROUP BY barang_id "
            + ") k ON k.barang_id = b.id "
            + "ORDER BY b.name ASC";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                int stok = rs.getInt("stok_sekarang");
                String status;
                if (stok <= 0) {
                    status = "Habis";
                } else if (stok <= 5) {
                    status = "Menipis";
                } else {
                    status = "Aman";
                }
                model.addRow(new Object[]{
                    no++,
                    rs.getString("barang_id"),
                    rs.getString("nama_barang"),
                    rs.getInt("total_masuk"),
                    rs.getInt("total_keluar"),
                    stok,
                    status
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal tampil Kartu Stok: " + e.getMessage());
        }
    }

    private String buatPathPdf(String namaLaporan) {
        String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String namaFile = namaLaporan
        .replace(" ", "_")
        .replace("/", "_")
        + "_" + waktu + ".pdf";
        return System.getProperty("user.home")
        + File.separator
        + "Downloads"
        + File.separator
        + namaFile;
    }
    private void tulisTabelKePdf(Document document, String judul, JTable tabel) throws Exception {
        Font fontJudul = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font fontNormal = new Font(Font.HELVETICA, 10, Font.NORMAL);
        document.add(new Paragraph(judul, fontJudul));
        document.add(new Paragraph("Periode: " + teksPeriodeCetak(), fontNormal));
        document.add(new Paragraph(" "));
        int jumlahKolom = tabel.getColumnCount();
        PdfPTable pdfTable = new PdfPTable(jumlahKolom);
        pdfTable.setWidthPercentage(100);
        for (int i = 0; i < jumlahKolom; i++) {
            pdfTable.addCell(tabel.getColumnName(i));
        }
        for (int row = 0; row < tabel.getRowCount(); row++) {
            for (int col = 0; col < jumlahKolom; col++) {
                Object value = tabel.getValueAt(row, col);
                pdfTable.addCell(value == null ? "" : value.toString());
            }
        }
        document.add(pdfTable);
        document.add(new Paragraph(" "));
    }

    private boolean aturPeriodeCetak() {
        String periode = cmbPeriodeCetak.getSelectedItem().toString();
        if (periode.equals("Semua Tanggal")) {
            dcDari.setDate(null);
            dcSampai.setDate(null);
            return true;
        }
        if (periode.equals("Daily Report")) {
            if (dcDari.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Pilih tanggal di Dari Tanggal dulu.");
                return false;
            }
            dcSampai.setDate(dcDari.getDate());
            return true;
        }
        if (periode.equals("Monthly Report")) {
            if (dcDari.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Pilih salah satu tanggal di bulan yang mau dicetak.");
                return false;
            }
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(dcDari.getDate());
            cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
            Date awalBulan = cal.getTime();
            cal.set(java.util.Calendar.DAY_OF_MONTH, cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
            Date akhirBulan = cal.getTime();
            dcDari.setDate(awalBulan);
            dcSampai.setDate(akhirBulan);
            return true;
        }
        if (periode.equals("Custom Tanggal")) {
            if (dcDari.getDate() == null || dcSampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Pilih Dari Tanggal dan Sampai Tanggal dulu.");
                return false;
            }
            return true;
        }
        return true;
    }

    private String teksPeriodeCetak() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (dcDari.getDate() == null && dcSampai.getDate() == null) {
            return "Semua Tanggal";
        }
        if (dcDari.getDate() != null && dcSampai.getDate() != null) {
            return sdf.format(dcDari.getDate()) + " s/d " + sdf.format(dcSampai.getDate());
        }
        if (dcDari.getDate() != null) {
            return "Mulai " + sdf.format(dcDari.getDate());
        }
        return "Sampai " + sdf.format(dcSampai.getDate());
    }

    private void cetakPdfLangsung() {
        if (!aturPeriodeCetak()) {
            return;
        }
        String bagian = cmbCetakBagian.getSelectedItem().toString();
        String pathPdf = buatPathPdf("Laporan_" + bagian);
        try {
            Document document = new Document(PageSize.A4.rotate(), 20, 20, 20, 20);
            PdfWriter.getInstance(document, new FileOutputStream(pathPdf));
            document.open();
            if (bagian.equals("Ringkasan")) {
                tampilRingkasan();
                tulisTabelKePdf(document, "Laporan Ringkasan", tblLaporanUtama);
            } else if (bagian.equals("Barang Masuk")) {
                tampilBarangMasuk();
                tulisTabelKePdf(document, "Laporan Barang Masuk", tblLaporanUtama);
            } else if (bagian.equals("Barang Keluar")) {
                tampilBarangKeluar();
                tulisTabelKePdf(document, "Laporan Barang Keluar", tblLaporanUtama);
            } else if (bagian.equals("Kartu Stok")) {
                tampilKartuStok();
                tulisTabelKePdf(document, "Laporan Kartu Stok", tblLaporanUtama);
            } else if (bagian.equals("Barang Terlaris")) {
                tampilBarangTerlaris();
                tulisTabelKePdf(document, "Laporan Barang Terlaris", tblBarangTerlaris);
            } else if (bagian.equals("Stok Terendah")) {
                tampilStokTerendah();
                tulisTabelKePdf(document, "Laporan Stok Terendah", tblStokTerendah);
            } else if (bagian.equals("Semua Laporan")) {
                tampilRingkasan();
                tulisTabelKePdf(document, "Laporan Ringkasan", tblLaporanUtama);
                tampilBarangMasuk();
                tulisTabelKePdf(document, "Laporan Barang Masuk", tblLaporanUtama);
                tampilBarangKeluar();
                tulisTabelKePdf(document, "Laporan Barang Keluar", tblLaporanUtama);
                tampilKartuStok();
                tulisTabelKePdf(document, "Laporan Kartu Stok", tblLaporanUtama);
                tampilBarangTerlaris();
                tulisTabelKePdf(document, "Laporan Barang Terlaris", tblBarangTerlaris);
                tampilStokTerendah();
                tulisTabelKePdf(document, "Laporan Stok Terendah", tblStokTerendah);
            }
            document.close();
            JOptionPane.showMessageDialog(this, "PDF berhasil disimpan di:\n" + pathPdf);
            java.awt.Desktop.getDesktop().open(new File(pathPdf));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat PDF: " + e.getMessage());
        }
    }

    private void rapikanWarnaTabel() {
        aturWarnaTabel(tblLaporanUtama);
        aturWarnaTabel(tblBarangTerlaris);
        aturWarnaTabel(tblStokTerendah);
    }

    private void aturWarnaTabel(JTable tabel) {
        tabel.setForeground(Color.BLACK);
        tabel.setBackground(Color.WHITE);
        tabel.setSelectionForeground(Color.WHITE);
        tabel.setSelectionBackground(new Color(30, 99, 242));
        tabel.setGridColor(new Color(220, 220, 220));
        tabel.setRowHeight(24);
        tabel.getTableHeader().setForeground(Color.BLACK);
        tabel.getTableHeader().setBackground(new Color(235, 238, 242));
    }
}
