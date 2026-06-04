package view.dashboard;
import chart.ChartBarang;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import view.auth.login;

    public class Dashboard extends javax.swing.JFrame {
        private static final String DASHBOARD_CARD = "card2";
        private Supplier SuplerPanel;
        private BarangKeluar barkerPanel;
        private BarangMasuk barmasPanel;
        private DataBarang datbarPanel;
        private kategori kategoriPanel;
        private Laporan laporanPanel;
        private UserManagement userManagementPanel;
        private javax.swing.JPanel dashboardPanel;
        private javax.swing.JLabel lblBarangMasukValue;
        private javax.swing.JLabel lblBarangKeluarValue;
        private javax.swing.JLabel lblStokMenipisValue;
        private String currentRole = "superadmin";
        private String currentName = "Super Administrator";
        public Dashboard() {
            this("Super Administrator", "superadmin");
        }
        
        public Dashboard(String role) {
            this(null, role);
        }

        public Dashboard(String name, String role) {
            currentName = name == null || name.trim().isEmpty() ? "User" : name;
            currentRole = role == null ? "admin" : role;
            initComponents();
            navbar1.setUserInfo(currentName, currentRole);
            setupDashboardCardValues();
            installDashboardScroll();
            card_totalBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            card_totalBarang.addMouseListener(new java.awt.event.MouseAdapter() {
                
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (!canAccessAllMenus()) {
                        showAccessDenied();
                        return;
                    }
                    datbarPanel.loadTable();
                    CardLayout cl = (CardLayout) pn_content.getLayout();
                    cl.show(pn_content, "DataBarang");
                }   
            });
card_barangMasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
card_barangMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "BarangMasuk");
    }
});
card_barangKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
card_barangKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "BarangKeluar");
    }
});
card_stokMenipis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
card_stokMenipis.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (!canAccessAllMenus()) {
            showAccessDenied();
            return;
        }
        datbarPanel.loadTable();
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "DataBarang");
    }
});
    pn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            pn_laporanMouseClicked(evt);
        }
    });
    pn_usermanagement.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            pn_usermanagementMouseClicked(evt);
        }
    });
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    ChartBarang.tampilChart(pn_Chart);
    pn_Chart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    pn_Chart.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CardLayout cl = (CardLayout) pn_content.getLayout();
            cl.show(pn_content, "Laporan");
        }
    });
    kategoriPanel = new kategori();
    datbarPanel = new DataBarang();
    barmasPanel = new BarangMasuk();
    barkerPanel = new BarangKeluar();
    SuplerPanel = new Supplier();
    laporanPanel = new Laporan();
    userManagementPanel = new UserManagement();
    pn_content.add(kategoriPanel, "kategori");
    pn_content.add(datbarPanel, "DataBarang");
    pn_content.add(barmasPanel, "BarangMasuk");
    pn_content.add(barkerPanel, "BarangKeluar");
    pn_content.add(SuplerPanel, "Supplier");
    pn_content.add(userManagementPanel, "UserManagement");
    JScrollPane scrollLaporan = createInvisibleScrollPane(laporanPanel);
    laporanPanel.setPreferredSize(new java.awt.Dimension(1200, 1200));
    pn_content.add(scrollLaporan, "Laporan");
    execute();
    applyRoleAccess();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pn_sidebar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_dashboard = new javax.swing.JPanel();
        line_dashboard = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pn_datbar = new javax.swing.JPanel();
        line_datbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pn_katger = new javax.swing.JPanel();
        line_katger = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pn_suplier = new javax.swing.JPanel();
        line_suplier = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pn_barmas = new javax.swing.JPanel();
        line_barmas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pn_barker = new javax.swing.JPanel();
        line_barker = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pn_laporan = new javax.swing.JPanel();
        line_laporan = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pn_usermanagement = new javax.swing.JPanel();
        line_usermanagement = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pn_main = new javax.swing.JPanel();
        pn_header = new javax.swing.JPanel();
        navbar1 = new component.Navbar();
        pn_content = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        card_totalBarang = new swing.PanelCard();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        card_barangMasuk = new swing.PanelCard();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        card_barangKeluar = new swing.PanelCard();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        card_stokMenipis = new swing.PanelCard();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pn_Chart = new swing.PanelCard();
        pn_announcementSection = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_pengumuman = new javax.swing.JTextArea();
        lbl_judulPengumuman = new javax.swing.JLabel();
        pn_inputPengumuman = new javax.swing.JPanel();
        btn_kirimPengumuman = new javax.swing.JButton();
        pn_tableSection = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dataBarang = new javax.swing.JTable();
        lbl_judulTabel = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setBackground(new java.awt.Color(248, 250, 252));
        setResizable(false);
        pn_sidebar.setBackground(new java.awt.Color(13, 27, 61));
        jPanel3.setBackground(new java.awt.Color(13, 27, 61));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("App Inventorry");
        jLabel2.setText("jLabel2");
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_dashboard.setBackground(new java.awt.Color(13, 27, 61));
        pn_dashboard.setPreferredSize(new java.awt.Dimension(231, 40));
        pn_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_dashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_dashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_dashboardMouseExited(evt);
            }
        });
        line_dashboard.setBackground(new java.awt.Color(13, 27, 61));
        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-home-24.png")));
        jLabel3.setText("Dashboard");
        javax.swing.GroupLayout pn_dashboardLayout = new javax.swing.GroupLayout(pn_dashboard);
        pn_dashboard.setLayout(pn_dashboardLayout);
        pn_dashboardLayout.setHorizontalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_dashboardLayout.setVerticalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_datbar.setBackground(new java.awt.Color(13, 27, 61));
        pn_datbar.setPreferredSize(new java.awt.Dimension(231, 40));
        pn_datbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_datbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_datbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_datbarMouseExited(evt);
            }
        });
        line_datbar.setBackground(new java.awt.Color(13, 27, 61));
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-box-24.png")));
        jLabel4.setText("Data Barang");
        javax.swing.GroupLayout pn_datbarLayout = new javax.swing.GroupLayout(pn_datbar);
        pn_datbar.setLayout(pn_datbarLayout);
        pn_datbarLayout.setHorizontalGroup(
            pn_datbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_datbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_datbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_datbarLayout.setVerticalGroup(
            pn_datbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_datbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_datbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_datbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_katger.setBackground(new java.awt.Color(13, 27, 61));
        pn_katger.setPreferredSize(new java.awt.Dimension(243, 40));
        pn_katger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_katgerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_katgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_katgerMouseExited(evt);
            }
        });
        line_katger.setBackground(new java.awt.Color(13, 27, 61));
        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-task-list-24.png")));
        jLabel5.setText("Kategori Barang");
        javax.swing.GroupLayout pn_katgerLayout = new javax.swing.GroupLayout(pn_katger);
        pn_katger.setLayout(pn_katgerLayout);
        pn_katgerLayout.setHorizontalGroup(
            pn_katgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_katgerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_katger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_katgerLayout.setVerticalGroup(
            pn_katgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_katgerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_katgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_katger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_suplier.setBackground(new java.awt.Color(13, 27, 61));
        pn_suplier.setPreferredSize(new java.awt.Dimension(243, 40));
        pn_suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_suplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_suplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_suplierMouseExited(evt);
            }
        });
        line_suplier.setBackground(new java.awt.Color(13, 27, 61));
        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Supplier");
        javax.swing.GroupLayout pn_suplierLayout = new javax.swing.GroupLayout(pn_suplier);
        pn_suplier.setLayout(pn_suplierLayout);
        pn_suplierLayout.setHorizontalGroup(
            pn_suplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_suplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_suplierLayout.setVerticalGroup(
            pn_suplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_suplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_suplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_suplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_barmas.setBackground(new java.awt.Color(13, 27, 61));
        pn_barmas.setPreferredSize(new java.awt.Dimension(231, 40));
        pn_barmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_barmasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_barmasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_barmasMouseExited(evt);
            }
        });
        line_barmas.setBackground(new java.awt.Color(13, 27, 61));
        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Barang Masuk");
        javax.swing.GroupLayout pn_barmasLayout = new javax.swing.GroupLayout(pn_barmas);
        pn_barmas.setLayout(pn_barmasLayout);
        pn_barmasLayout.setHorizontalGroup(
            pn_barmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_barmasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_barmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_barmasLayout.setVerticalGroup(
            pn_barmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_barmasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_barmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_barmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_barker.setBackground(new java.awt.Color(13, 27, 61));
        pn_barker.setPreferredSize(new java.awt.Dimension(243, 40));
        pn_barker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_barkerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_barkerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_barkerMouseExited(evt);
            }
        });
        line_barker.setBackground(new java.awt.Color(13, 27, 61));
        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Barang Keluar");
        javax.swing.GroupLayout pn_barkerLayout = new javax.swing.GroupLayout(pn_barker);
        pn_barker.setLayout(pn_barkerLayout);
        pn_barkerLayout.setHorizontalGroup(
            pn_barkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_barkerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_barker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_barkerLayout.setVerticalGroup(
            pn_barkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_barkerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_barkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_barker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_laporan.setBackground(new java.awt.Color(13, 27, 61));
        pn_laporan.setPreferredSize(new java.awt.Dimension(243, 40));
        pn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_laporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_laporanMouseExited(evt);
            }
        });
        line_laporan.setBackground(new java.awt.Color(13, 27, 61));
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Laporan");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        javax.swing.GroupLayout pn_laporanLayout = new javax.swing.GroupLayout(pn_laporan);
        pn_laporan.setLayout(pn_laporanLayout);
        pn_laporanLayout.setHorizontalGroup(
            pn_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_laporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_laporanLayout.setVerticalGroup(
            pn_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_laporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_usermanagement.setBackground(new java.awt.Color(13, 27, 61));
        pn_usermanagement.setPreferredSize(new java.awt.Dimension(231, 40));
        pn_usermanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_usermanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_usermanagementMouseExited(evt);
            }
        });
        line_usermanagement.setBackground(new java.awt.Color(13, 27, 61));
        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Management");
        javax.swing.GroupLayout pn_usermanagementLayout = new javax.swing.GroupLayout(pn_usermanagement);
        pn_usermanagement.setLayout(pn_usermanagementLayout);
        pn_usermanagementLayout.setHorizontalGroup(
            pn_usermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_usermanagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(line_usermanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_usermanagementLayout.setVerticalGroup(
            pn_usermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_usermanagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_usermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line_usermanagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_dashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_datbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_katger, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(pn_suplier, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(pn_barmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_barker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(pn_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(pn_usermanagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_datbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_katger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_barmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_barker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_usermanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(570, Short.MAX_VALUE))
        );
        getContentPane().add(pn_sidebar, java.awt.BorderLayout.LINE_START);
        pn_main.setLayout(new java.awt.BorderLayout());
        pn_header.setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout pn_headerLayout = new javax.swing.GroupLayout(pn_header);
        pn_header.setLayout(pn_headerLayout);
        pn_headerLayout.setHorizontalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navbar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        pn_headerLayout.setVerticalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(navbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_main.add(pn_header, java.awt.BorderLayout.PAGE_START);
        pn_content.setLayout(new java.awt.CardLayout());
        card_totalBarang.setPreferredSize(new java.awt.Dimension(230, 120));
        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Total Barang");
        jLabel12.setText("jLabel12");
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/box (1).png")));
        javax.swing.GroupLayout card_totalBarangLayout = new javax.swing.GroupLayout(card_totalBarang);
        card_totalBarang.setLayout(card_totalBarangLayout);
        card_totalBarangLayout.setHorizontalGroup(
            card_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_totalBarangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(card_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        card_totalBarangLayout.setVerticalGroup(
            card_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_totalBarangLayout.createSequentialGroup()
                .addGroup(card_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_totalBarangLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card_totalBarangLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        card_barangMasuk.setPreferredSize(new java.awt.Dimension(230, 120));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel14.setText("Barang Masuk");
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrow.png")));
        javax.swing.GroupLayout card_barangMasukLayout = new javax.swing.GroupLayout(card_barangMasuk);
        card_barangMasuk.setLayout(card_barangMasukLayout);
        card_barangMasukLayout.setHorizontalGroup(
            card_barangMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_barangMasukLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        card_barangMasukLayout.setVerticalGroup(
            card_barangMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_barangMasukLayout.createSequentialGroup()
                .addGroup(card_barangMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_barangMasukLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel14))
                    .addGroup(card_barangMasukLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        card_barangKeluar.setPreferredSize(new java.awt.Dimension(230, 120));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel15.setText("Barang Keluar");
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/up-loading.png")));
        javax.swing.GroupLayout card_barangKeluarLayout = new javax.swing.GroupLayout(card_barangKeluar);
        card_barangKeluar.setLayout(card_barangKeluarLayout);
        card_barangKeluarLayout.setHorizontalGroup(
            card_barangKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_barangKeluarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        card_barangKeluarLayout.setVerticalGroup(
            card_barangKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_barangKeluarLayout.createSequentialGroup()
                .addGroup(card_barangKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_barangKeluarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15))
                    .addGroup(card_barangKeluarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        card_stokMenipis.setPreferredSize(new java.awt.Dimension(230, 120));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel16.setText("Stok Menipis");
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/error.png")));
        javax.swing.GroupLayout card_stokMenipisLayout = new javax.swing.GroupLayout(card_stokMenipis);
        card_stokMenipis.setLayout(card_stokMenipisLayout);
        card_stokMenipisLayout.setHorizontalGroup(
            card_stokMenipisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_stokMenipisLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        card_stokMenipisLayout.setVerticalGroup(
            card_stokMenipisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_stokMenipisLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_stokMenipisLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout pn_ChartLayout = new javax.swing.GroupLayout(pn_Chart);
        pn_Chart.setLayout(pn_ChartLayout);
        pn_ChartLayout.setHorizontalGroup(
            pn_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        pn_ChartLayout.setVerticalGroup(
            pn_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        ta_pengumuman.setColumns(20);
        ta_pengumuman.setRows(5);
        jScrollPane1.setViewportView(ta_pengumuman);
        lbl_judulPengumuman.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_judulPengumuman.setText("Pengumuman");
        javax.swing.GroupLayout pn_inputPengumumanLayout = new javax.swing.GroupLayout(pn_inputPengumuman);
        pn_inputPengumuman.setLayout(pn_inputPengumumanLayout);
        pn_inputPengumumanLayout.setHorizontalGroup(
            pn_inputPengumumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pn_inputPengumumanLayout.setVerticalGroup(
            pn_inputPengumumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        btn_kirimPengumuman.setText("Kirim");
        javax.swing.GroupLayout pn_announcementSectionLayout = new javax.swing.GroupLayout(pn_announcementSection);
        pn_announcementSection.setLayout(pn_announcementSectionLayout);
        pn_announcementSectionLayout.setHorizontalGroup(
            pn_announcementSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_announcementSectionLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lbl_judulPengumuman)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pn_announcementSectionLayout.createSequentialGroup()
                .addGroup(pn_announcementSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_announcementSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_announcementSectionLayout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addComponent(btn_kirimPengumuman))
                        .addGroup(pn_announcementSectionLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_inputPengumuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 79, Short.MAX_VALUE))
        );
        pn_announcementSectionLayout.setVerticalGroup(
            pn_announcementSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_announcementSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_judulPengumuman)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_kirimPengumuman)
                .addGap(29, 29, 29)
                .addComponent(pn_inputPengumuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        tbl_dataBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_dataBarang);
        lbl_judulTabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_judulTabel.setText("Data Barang");
        javax.swing.GroupLayout pn_tableSectionLayout = new javax.swing.GroupLayout(pn_tableSection);
        pn_tableSection.setLayout(pn_tableSectionLayout);
        pn_tableSectionLayout.setHorizontalGroup(
            pn_tableSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tableSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tableSectionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_judulTabel)
                .addGap(301, 301, 301))
        );
        pn_tableSectionLayout.setVerticalGroup(
            pn_tableSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tableSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_judulTabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(card_totalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(card_barangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(card_barangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(card_stokMenipis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pn_Chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(pn_announcementSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(pn_tableSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card_stokMenipis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_barangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_barangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_totalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_Chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(pn_announcementSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_tableSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_content.add(jPanel1, "card2");
        pn_main.add(pn_content, java.awt.BorderLayout.CENTER);
        getContentPane().add(pn_main, java.awt.BorderLayout.CENTER);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void pn_dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dashboardMouseEntered
        pn_dashboard.setBackground(new Color(30,99,242));
        line_dashboard.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_dashboardMouseEntered
    private void pn_dashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dashboardMouseExited
        pn_dashboard.setBackground(new Color(13,27,61));
        line_dashboard.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_dashboardMouseExited
    private void pn_datbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_datbarMouseEntered
        pn_datbar.setBackground(new Color(30,99,242));
        line_datbar.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_datbarMouseEntered
    private void pn_datbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_datbarMouseExited
        pn_datbar.setBackground(new Color(13,27,61));
        line_datbar.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_datbarMouseExited
    private void pn_katgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_katgerMouseEntered
        pn_katger.setBackground(new Color(30,99,242));
        line_katger.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_katgerMouseEntered
    private void pn_katgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_katgerMouseExited
        pn_katger.setBackground(new Color(13,27,61));
        line_katger.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_katgerMouseExited
    private void pn_suplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_suplierMouseEntered
        pn_suplier.setBackground(new Color(30,99,242));
        line_suplier.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_suplierMouseEntered
    private void pn_suplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_suplierMouseExited
        pn_suplier.setBackground(new Color(13,27,61));
        line_suplier.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_suplierMouseExited
    private void pn_barmasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barmasMouseEntered
        pn_barmas.setBackground(new Color(30,99,242));
        line_barmas.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_barmasMouseEntered
    private void pn_barmasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barmasMouseExited
        pn_barmas.setBackground(new Color(13,27,61));
        line_barmas.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_barmasMouseExited
    private void pn_barkerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barkerMouseEntered
        pn_barker.setBackground(new Color(30,99,242));
        line_barker.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_barkerMouseEntered
    private void pn_barkerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barkerMouseExited
        pn_barker.setBackground(new Color(13,27,61));
        line_barker.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_barkerMouseExited
    private void pn_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_laporanMouseEntered
        pn_laporan.setBackground(new Color(30,99,242));
        line_laporan.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_laporanMouseEntered
    private void pn_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_laporanMouseExited
        pn_laporan.setBackground(new Color(13,27,61));
        line_laporan.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_laporanMouseExited
    private void pn_usermanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_usermanagementMouseEntered
        pn_usermanagement.setBackground(new Color(30,99,242));
        line_usermanagement.setBackground(new Color(27,47,97));
    }//GEN-LAST:event_pn_usermanagementMouseEntered
    private void pn_usermanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_usermanagementMouseExited
        pn_usermanagement.setBackground(new Color(13,27,61));
        line_usermanagement.setBackground(new Color(13,27,61));
    }//GEN-LAST:event_pn_usermanagementMouseExited
    private void pn_katgerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_katgerMouseClicked
    if (!canAccessAllMenus()) {
        showAccessDenied();
        return;
    }
    pn_katger.setBackground(new Color(30,99,242));
    line_katger.setBackground(new Color(27,47,97));
    CardLayout cl = (CardLayout) pn_content.getLayout();
    cl.show(pn_content, "kategori");
    }//GEN-LAST:event_pn_katgerMouseClicked
    private void pn_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dashboardMouseClicked
    if (!canAccessAllMenus()) {
        pn_barmasMouseClicked(evt);
        return;
    }
    pn_dashboard.setBackground(new Color(30,99,242));
    line_dashboard.setBackground(new Color(27,47,97));
    CardLayout cl = (CardLayout) pn_content.getLayout();
    cl.show(pn_content, DASHBOARD_CARD);
    loadDashboardData();
    loadDashboardTable();
    updateNotifBadge();
    }//GEN-LAST:event_pn_dashboardMouseClicked
    private void pn_datbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_datbarMouseClicked
    if (!canAccessAllMenus()) {
        showAccessDenied();
        return;
    }
    pn_datbar.setBackground(new Color(30,99,242));
    line_datbar.setBackground(new Color(27,47,97));
    datbarPanel.loadTable();
    CardLayout cl = (CardLayout) pn_content.getLayout();
    cl.show(pn_content, "DataBarang");
    }//GEN-LAST:event_pn_datbarMouseClicked
    private void pn_barmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barmasMouseClicked
        pn_barmas.setBackground(new Color(30, 99, 242));
        line_barmas.setBackground(new Color(27, 47, 97));
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "BarangMasuk");
    }//GEN-LAST:event_pn_barmasMouseClicked
    private void pn_barkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_barkerMouseClicked
        pn_barker.setBackground(new Color(30, 99, 242));
        line_barker.setBackground(new Color(27, 47, 97));
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "BarangKeluar");
    }//GEN-LAST:event_pn_barkerMouseClicked
    private void pn_suplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_suplierMouseClicked
        if (!canAccessAllMenus()) {
            showAccessDenied();
            return;
        }
        pn_suplier.setBackground(new Color(30, 99, 242));
        line_suplier.setBackground(new Color(27, 47, 97));
        CardLayout cl = (CardLayout) pn_content.getLayout();
        cl.show(pn_content, "Supplier");
    }//GEN-LAST:event_pn_suplierMouseClicked
    private void pn_laporanMouseClicked(java.awt.event.MouseEvent evt) {                                        
            pn_laporan.setBackground(new Color(30, 99, 242));
            line_laporan.setBackground(new Color(27, 47, 97));
            CardLayout cl = (CardLayout) pn_content.getLayout();
            cl.show(pn_content, "Laporan");
    }
    private void pn_usermanagementMouseClicked(java.awt.event.MouseEvent evt) {
            if (!canAccessAllMenus()) {
                showAccessDenied();
                return;
            }
            pn_usermanagement.setBackground(new Color(30, 99, 242));
            line_usermanagement.setBackground(new Color(27, 47, 97));
            userManagementPanel.loadTable();
            CardLayout cl = (CardLayout) pn_content.getLayout();
            cl.show(pn_content, "UserManagement");
    }
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
         pn_laporanMouseClicked(evt);
    }//GEN-LAST:event_jLabel9MouseClicked
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kirimPengumuman;
    private swing.PanelCard card_barangKeluar;
    private swing.PanelCard card_barangMasuk;
    private swing.PanelCard card_stokMenipis;
    private swing.PanelCard card_totalBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_judulPengumuman;
    private javax.swing.JLabel lbl_judulTabel;
    private javax.swing.JPanel line_barker;
    private javax.swing.JPanel line_barmas;
    private javax.swing.JPanel line_dashboard;
    private javax.swing.JPanel line_datbar;
    private javax.swing.JPanel line_katger;
    private javax.swing.JPanel line_laporan;
    private javax.swing.JPanel line_suplier;
    private javax.swing.JPanel line_usermanagement;
    private component.Navbar navbar1;
    private swing.PanelCard pn_Chart;
    private javax.swing.JPanel pn_announcementSection;
    private javax.swing.JPanel pn_barker;
    private javax.swing.JPanel pn_barmas;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_dashboard;
    private javax.swing.JPanel pn_datbar;
    private javax.swing.JPanel pn_header;
    private javax.swing.JPanel pn_inputPengumuman;
    private javax.swing.JPanel pn_katger;
    private javax.swing.JPanel pn_laporan;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_sidebar;
    private javax.swing.JPanel pn_suplier;
    private javax.swing.JPanel pn_tableSection;
    private javax.swing.JPanel pn_usermanagement;
    private javax.swing.JTextArea ta_pengumuman;
    private javax.swing.JTable tbl_dataBarang;
    // End of variables declaration//GEN-END:variables
    private void execute() {
    java.awt.CardLayout cl = (java.awt.CardLayout) pn_content.getLayout();
    cl.show(pn_content, DASHBOARD_CARD);
    ensurePengumumanTable();
    loadDashboardData();
    loadDashboardTable();
    updateNotifBadge();
    pn_content.revalidate();
    pn_content.repaint();
btn_kirimPengumuman.addActionListener(e -> {
    String isi = ta_pengumuman.getText().trim();
    if (!isi.isEmpty()) {
        try (java.sql.Connection conn = config.koneksi.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO pengumuman (isi, tanggal, dibaca) VALUES (?, NOW(), 0)")) {
            ps.setString(1, isi);
            ps.executeUpdate();
            updateNotifBadge();
            ta_pengumuman.setText("");
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Pengumuman berhasil dikirim!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
}
private void installDashboardScroll() {
    pn_content.remove(jPanel1);
    jPanel1.setPreferredSize(new Dimension(1375, 1100));
    JScrollPane scrollDashboard = createInvisibleScrollPane(jPanel1);
    scrollDashboard.getViewport().setViewPosition(new java.awt.Point(0, 0));
    pn_content.add(scrollDashboard, DASHBOARD_CARD);
}
private void setupDashboardCardValues() {
    jLabel12.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
    jLabel12.setForeground(Color.BLACK);
    lblBarangMasukValue = createCardValueLabel();
    lblBarangKeluarValue = createCardValueLabel();
    lblStokMenipisValue = createCardValueLabel();
    configureSummaryCard(card_barangMasuk, jLabel14, lblBarangMasukValue, jLabel17);
    configureSummaryCard(card_barangKeluar, jLabel15, lblBarangKeluarValue, jLabel18);
    configureSummaryCard(card_stokMenipis, jLabel16, lblStokMenipisValue, jLabel19);
}
private javax.swing.JLabel createCardValueLabel() {
    javax.swing.JLabel label = new javax.swing.JLabel("0");
    label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
    label.setForeground(Color.BLACK);
    return label;
}
private void configureSummaryCard(
        javax.swing.JPanel card,
        javax.swing.JLabel title,
        javax.swing.JLabel value,
        javax.swing.JLabel icon) {
    title.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
    title.setForeground(Color.BLACK);
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(card);
    card.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
    );
}
private JScrollPane createInvisibleScrollPane(Component view) {
    JScrollPane scrollPane = new JScrollPane(view);
    scrollPane.setBorder(null);
    scrollPane.setViewportBorder(null);
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    configureInvisibleScrollBar(scrollPane.getVerticalScrollBar());
    configureInvisibleScrollBar(scrollPane.getHorizontalScrollBar());
    scrollPane.addMouseWheelListener(e -> {
        if (e.isShiftDown()) {
            JScrollBar horizontal = scrollPane.getHorizontalScrollBar();
            int amount = e.getWheelRotation() * 36;
            horizontal.setValue(horizontal.getValue() + amount);
            e.consume();
        }
    });
    return scrollPane;
}
private void configureInvisibleScrollBar(JScrollBar scrollBar) {
    scrollBar.setUnitIncrement(24);
    scrollBar.setBlockIncrement(120);
    scrollBar.setPreferredSize(new Dimension(0, 0));
    scrollBar.setOpaque(false);
    scrollBar.setUI(new BasicScrollBarUI() {
        @Override
        protected void configureScrollBarColors() {
            thumbColor = new Color(0, 0, 0, 0);
            trackColor = new Color(0, 0, 0, 0);
        }
        @Override
        protected javax.swing.JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }
        @Override
        protected javax.swing.JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }
        private javax.swing.JButton createZeroButton() {
            javax.swing.JButton button = new javax.swing.JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    });
}
private boolean canAccessAllMenus() {
    return "superadmin".equalsIgnoreCase(currentRole)
            || "masteradmin".equalsIgnoreCase(currentRole);
}
private void applyRoleAccess() {
    boolean fullAccess = canAccessAllMenus();
    pn_dashboard.setVisible(fullAccess);
    pn_datbar.setVisible(fullAccess);
    pn_katger.setVisible(fullAccess);
    pn_suplier.setVisible(fullAccess);
    pn_usermanagement.setVisible(fullAccess);
    if (!fullAccess) {
        java.awt.CardLayout cl = (java.awt.CardLayout) pn_content.getLayout();
        cl.show(pn_content, "BarangMasuk");
    }
    pn_sidebar.revalidate();
    pn_sidebar.repaint();
}
private void showAccessDenied() {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Akses hanya untuk masteradmin/superadmin.",
            "Akses Ditolak",
            javax.swing.JOptionPane.WARNING_MESSAGE
    );
}
    private void loadDashboardData() {
    try (java.sql.Connection conn = config.koneksi.getConnection()) {
        java.sql.ResultSet rs1 = conn.createStatement()
            .executeQuery("SELECT COUNT(*) FROM databarang");
        if (rs1.next()) jLabel12.setText(String.valueOf(rs1.getInt(1)));
        java.sql.ResultSet rs2 = conn.createStatement()
            .executeQuery("SELECT COALESCE(SUM(jumlah), 0) FROM barangmasuk");
        if (rs2.next()) lblBarangMasukValue.setText(String.valueOf(rs2.getInt(1)));
        java.sql.ResultSet rs3 = conn.createStatement()
            .executeQuery("SELECT COALESCE(SUM(COALESCE(jumlah, qty, 0)), 0) FROM barangkeluar");
        if (rs3.next()) lblBarangKeluarValue.setText(String.valueOf(rs3.getInt(1)));
        java.sql.ResultSet rs4 = conn.createStatement()
            .executeQuery("SELECT COUNT(*) FROM databarang WHERE stok < 10");
        if (rs4.next()) lblStokMenipisValue.setText(String.valueOf(rs4.getInt(1)));
        ChartBarang.tampilChart(pn_Chart);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void loadDashboardTable() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Kode");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Stok");
    String sql = "SELECT b.id, b.name, COALESCE(k.name, '-') AS kategori, b.stok "
            + "FROM databarang b "
            + "LEFT JOIN kategoribarang k ON b.kategori_id = k.id "
            + "ORDER BY b.name ASC";
    try (java.sql.Connection conn = config.koneksi.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("kategori"),
                rs.getInt("stok")
            });
        }
        tbl_dataBarang.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void ensurePengumumanTable() {
    String sql = "CREATE TABLE IF NOT EXISTS pengumuman ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "isi TEXT NOT NULL,"
            + "tanggal DATETIME DEFAULT CURRENT_TIMESTAMP,"
            + "dibaca TINYINT(1) DEFAULT 0"
            + ")";
    try (java.sql.Connection conn = config.koneksi.getConnection();
         java.sql.Statement st = conn.createStatement()) {
        st.executeUpdate(sql);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void updateNotifBadge() {
    try (java.sql.Connection conn = config.koneksi.getConnection();
         java.sql.ResultSet rs = conn.createStatement()
            .executeQuery("SELECT COUNT(*) FROM pengumuman WHERE dibaca = 0")) {
        if (rs.next()) {
            int count = rs.getInt(1);
            navbar1.setBadgeCount(count);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
